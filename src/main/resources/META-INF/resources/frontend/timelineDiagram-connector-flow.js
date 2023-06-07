window.Vaadin.Flow.timelineDiagramConnector = {
	initLazy : function(theTimeLine, initialItems, initialGroups, options) {

		// Check whether the connector was already initialized for the Iron list
		if (theTimeLine.$connector) {
			return;
		}
		console.log('init timelineDiagramConnector');

		theTimeLine.$connector = {};

		theTimeLine.$connector.itemContent = function (item) {
			return item.content;
		}

		theTimeLine.$connector.templateFunction = function (item, element, data) {
			return "<div class=\"card\"><div class=\"card-title\">"+item.title+"</div><div class=\"card-content\"></div>"+theTimeLine.$connector.itemContent(item)+"</div></div><div class=\"network-node\" id=\"tl" + item.id + "\"></div>";
		}

		theTimeLine.items = new visTL.DataSet(JSON.parse(initialItems));
		theTimeLine.groups = new visTL.DataSet(JSON.parse(initialGroups));

		console.log(theTimeLine.groups.length);
		var self = this;
		var customNodeifAdded = false;
		var customNodeID;
		var customNodeLabel;
		var customEdgeifAdded = false;
		var customEdgeID;
		var customEdgeLabel;

		theTimeLine.options = JSON.parse(options);
		//TODO: This must be removed once we can receive the template on Option from Java
		//Adding manually the the template
		theTimeLine.options['template'] = theTimeLine.$connector.templateFunction;
		console.log(theTimeLine.options);
		if (theTimeLine.groups.length === 0) {
			theTimeLine.$connector.diagram = new visTL.Timeline(theTimeLine, theTimeLine.items,
				theTimeLine.options);
		} else {
			theTimeLine.$connector.diagram = new visTL.Timeline(theTimeLine, theTimeLine.items, theTimeLine.groups,
				theTimeLine.options);
		}
		// Network Graph ... Using the network vis project
		theTimeLine.$connector.network = {}
		theTimeLine.$connector.nodes = {};
		theTimeLine.$connector.edges = {};
		theTimeLine.$connector.savedNodes = {};
		theTimeLine.$connector.nodeId=1;
		theTimeLine.$connector.lastNumber = -1;
        //Select a node on timeline
		theTimeLine.$connector.onSelectTL = async function(properties) {
            if  (properties!==undefined && properties.event.target.nodeName === 'CANVAS') return;
			theTimeLine.$connector.deselectAllTMItems();
			if (properties.items === undefined || properties.items.length == 0 ) return;
			const itemId = properties.items[0];
			let item  = theTimeLine.items.get(itemId);
            // Draw network
			theTimeLine.$connector.network = await theTimeLine.$connector.drawNetwork(properties, item);
       }


		theTimeLine.$connector.deselectAllTMItems = function () {
			var timelineNodes = document.getElementsByClassName("network-node");
			for (var i = 0; i < timelineNodes.length; i++) {
				timelineNodes.item(i).classList.remove('tooltip', 'tooltip-left');
			}
			try {
				if (theTimeLine.$connector.network !== undefined && theTimeLine.$connector.network instanceof vis.Network) {
					theTimeLine.$connector.network.off('click', theTimeLine.$connector.onClickNetwork);
					theTimeLine.$connector.nodeId = 1;
					theTimeLine.$connector.nodes = {};
					theTimeLine.$connector.edges = {};
					theTimeLine.$connector.network.destroy();
				}
			} catch {
				console.log('Was not possible tpo destroy the network object');
			}

		}

  		// add event listener for Timeline
		theTimeLine.$connector.diagram.on('select', theTimeLine.$connector.onSelectTL);

		theTimeLine.$connector.drawNetwork = async function (properties, item) {
			//const json = await receiveJSON();
			const json = JSON.parse(item.networkJSON);
			if (json === undefined || Object.keys(json).length === 0) return;
			let id = 1;


			// create an array with nodes
			theTimeLine.$connector.nodes = new vis.DataSet();
			// create an array with edges
			theTimeLine.$connector.edges = new vis.DataSet();
			// Create from json Obj  a DataSet
			let lastNumber = -1;
			let prevParent = -1;
			theTimeLine.$connector.createNodesRecursively(json, id, id);

			// TODO: Remove all seeds that the root has, update and modify edges to be expanded=false on creation time. Remove and restore should be also based on this attribute

			// create a network
			let network_container = document.getElementById("tl" + properties.items);
			network_container.classList.add('tooltip', 'tooltip-left');
			let data = {
				nodes: theTimeLine.$connector.nodes,
				edges: theTimeLine.$connector.edges
			};
			let optionsNetwork = {
				width: '600px',
				height: '380px',
				physics: {
					enabled: false,
					//solver: 'forceAtlas2Based',
					//solver: 'barnesHut',
					//solver: 'hierarchicalRepulsion',
					//solver: 'barnesHut',
					//wind: { x: 15, y: 0},
					hierarchicalRepulsion: {
						avoidOverlap:0.2,
					},
				},
				layout: {
					hierarchical: {
						direction: 'LR', //'UD', 'DU', 'RL'
						nodeSpacing: 45,
						levelSeparation: 250,
						edgeMinimization: true,
						sortMethod: 'directed', // 'hubsize'
						shakeTowards: 'roots',  // 'leaves'
						blockShifting: false,
						parentCentralization: false
					},
				}
			};
			let network = new vis.Network(network_container, data, optionsNetwork);
			// add event listener for Network
			network.on('click', theTimeLine.$connector.onClickNetwork);
			network.on('drag', theTimeLine.$connector.onDragNetwork);
			network.on('dragging', theTimeLine.$connector.onDragNetwork);
			network_container.addEventListener("wheel", function(e){
				if (e.stopPropagation) e.stopPropagation();
				return false;
			});
			network_container.addEventListener("drag", function(e){
				if (e.stopPropagation) e.stopPropagation();
				return false;
			});
			network_container.addEventListener("dragging", function(e){
				if (e.stopPropagation) e.stopPropagation();
				return false;
			});
			network_container.addEventListener("dragOver", function(e){
				if (e.stopPropagation) e.stopPropagation();
				return false;
			});
			network_container.addEventListener("dragStart", function(e){
				if (e.stopPropagation) e.stopPropagation();
				return false;
			});
			network_container.addEventListener("drop", function(e){
				if (e.stopPropagation) e.stopPropagation();
				return false;
			});
			return network;
		}
		//On Drag network
		theTimeLine.$connector.onDragNetwork = function(properties) {
			properties.event.srcEvent.stopPropagation();
			return false;
		}

		theTimeLine.$connector.removeNodesAndEdgesFrom = function(id){
			existingNodes = network.getConnectedNodes(id, 'to');
			existingEdges = network.getConnectedEdges(id);
			if (existingNodes.length > 0) {
				existingNodes.forEach(n => {
					theTimeLine.$connector.removeNodesAndEdgesFrom(n);
					theTimeLine.$connector.nodes.remove(n);
					existingEdges.forEach(e => {
						theTimeLine.$connector.edges.remove(e);
					});
				})
			}
		}
		theTimeLine.$connector.removeNodesAndSave = function(id){
			let existingNodes = theTimeLine.$connector.network.getConnectedNodes(id, 'to');
			//existingEdges = network.getConnectedEdges(id); // Edges keep untouched since if there is no edge the node is not rendered
			theTimeLine.$connector.savedNodes[id] = [];
			if (existingNodes.length > 0) {
				existingNodes.forEach(n => {
					theTimeLine.$connector.removeNodesAndSave(n);
					theTimeLine.$connector.savedNodes[id].push(theTimeLine.$connector.nodes.get(n));
					theTimeLine.$connector.nodes.remove(n);
				})
			}
		}

		theTimeLine.$connector.restoreNodes = function(id) {
			if (theTimeLine.$connector.savedNodes[id] !== undefined && theTimeLine.$connector.savedNodes[id].length > 0) {
				theTimeLine.$connector.savedNodes[id].forEach(node => {
					theTimeLine.$connector.restoreNodes(node.id);
					theTimeLine.$connector.nodes.add(theTimeLine.$connector.savedNodes[node.id]);
					theTimeLine.$connector.savedNodes[node.id] = [];
				})
				theTimeLine.$connector.nodes.add(theTimeLine.$connector.savedNodes[id]);
				theTimeLine.$connector.savedNodes[id] = [];
			}
		}


		//This makes a node be collapsible using property hidden, but unfortunately it do not compact the tree when
		// the amount of information on each branch is big. Unused until a fix in the library is provided.
		// Actual version used is @version 7.1.6
		theTimeLine.$connector.updateNodesAndEdgesFrom = function(id, hide){
			let existingNodes = theTimeLine.$connector.network.getConnectedNodes(id, 'to');
			let existingEdges = theTimeLine.$connector.network.getConnectedEdges(id);
			if (existingNodes.length > 0) {
				existingNodes.forEach(n => {
					theTimeLine.$connector.updateNodesAndEdgesFrom(n, hide);
					theTimeLine.$connector.nodes.update([{id:n, hidden: hide}]);
					existingEdges.forEach(e => {
						theTimeLine.$connector.edges.update([{id:e, hidden: hide}]);
					});
				})
			}
		}

		//Select a network node on timeline
		theTimeLine.$connector.onClickNetwork = function(properties) {
			properties.event.srcEvent.stopPropagation();
			if (properties=== undefined || properties.nodes===undefined && properties.nodes.length===0) return;
			const node = theTimeLine.$connector.nodes.get(properties.nodes[0]);
			if (node.expanded === true) {
				// hide all children
				theTimeLine.$connector.removeNodesAndSave(node.id);
			}  else {
				theTimeLine.$connector.restoreNodes(node.id);
				//updateNodesAndEdgesFrom(node.id, false);
			}
			// removeNodesAndEdgesFrom(node.id);
			node.expanded = !node.expanded;
			setTimeout(theTimeLine.$connector.networkFit, 20);
		}

		theTimeLine.$connector.networkFit = function(){
			theTimeLine.$connector.network.fit();
		}

		theTimeLine.$connector.createNodesRecursively = function(json, number, parent) {
			console.log(json.name + ' with id ' + number);
			console.log(json.children);
			if (number < theTimeLine.$connector.lastNumber) {
				number = theTimeLine.$connector.lastNumber + 1;
			}
			theTimeLine.$connector.prevParent = number; // PrevParent should have the latest node.
			theTimeLine.$connector.nodes.add({ id: number, label: json.name, shape: "box", expanded: true});
			const previousParent = parent;
			if (json.children !== undefined) {
				parent = number;
				json.children.forEach(child => {
					theTimeLine.$connector.createNodesRecursively(child, ++number, parent); //here we had parent
					//Create edge from parent to this child
					if (number === theTimeLine.$connector.lastNumber) {
						console.log("Edge from: "+ parent + " to: " + number + " (On leaves)");
						theTimeLine.$connector.edges.add({ from: parent, to: number});
					} else { // first back action
						console.log("Edge from: "+ parent + " to: " + theTimeLine.$connector.prevParent);
						theTimeLine.$connector.edges.add({ from: parent, to: theTimeLine.$connector.prevParent});
					}
				});
				theTimeLine.$connector.prevParent = parent; // the parent before be a seed
			}
			else {
				parent = theTimeLine.$connector.prevParent; // when no child the parent to specify is previous one
			}
			if (theTimeLine.$connector.lastNumber < number) theTimeLine.$connector.lastNumber = number;
		}


		// Enable event dispatching to vaadin only for registered eventTypes to
		// avoid to much overhead.
		theTimeLine.$connector.enableEventDispatching = function(vaadinEventType) {
			const eventType = vaadinEventType.substring(7);
			theTimeLine.$connector.diagram
					.on(
							eventType,
							function(params) {
								if (params != null) {
									// removing dom nodes from params cause they
									// can't send back to server.
									if (params.hasOwnProperty('event')) {
										// source of click event
										delete params.event.firstTarget;
										delete params.event.target;
									}
									JSON
											.stringify(
													params,
													function(key, value) {
														if (value instanceof Node) {
															console
																	.log("Message JsonObject contained a dom node reference  "
																			+ key
																			+ "  which "
																			+ "should not be sent to the server and can cause a cyclic dependecy.");
															delete params[key];
														}
														return value;
													});
								}
								theTimeLine.dispatchEvent(new CustomEvent(
										vaadinEventType, {
											detail : params
										}));
							});
		}

		// not used yet
		theTimeLine.$connector.disableEventDispatching = function(vaadinEventType) {
			const eventType = vaadinEventType.substring(7);
			console.log("disable registered eventType " + eventType);
			theTimeLine.diagram.off(eventType, function(params) {
				theTimeLine.dispatchEvent(new Event(vaadinEventType));
			});
		}

		theTimeLine.$connector.addGroups = function(groups) {
			let groupsObject = JSON.parse(groups);
			theTimeLine.groups.add(groupsObject);
		}

		theTimeLine.$connector.updateGroups = function(groups) {
			alert('updateGroups: ' + groups);
		}


		theTimeLine.$connector.setItems = function(index, items) {
			console.log("setItems " + JSON.stringify(items));
			for (let i = 0; i < theTimeLine.items.length; i++) {
				const item = JSON.parse(nodes[i].items);
				theTimeLine.items.add(item);
			}
		}

		theTimeLine.$connector.addItems = function(items) {
			// console.log("addItems: " + typeof items + "=" +
			// JSON.stringify(items));
			let itemsObject = JSON.parse(items);
			// console.log("addItemsParsed: " + typeof itemsObject + "=" +
			// JSON.stringify(itemssObject));
			theTimeLine.items.add(itemsObject);
		}

		theTimeLine.$connector.updateItems = function(items) {
			alert('updateItems: ' + items);
		}

		theTimeLine.$connector.clearItems = function() {
			theTimeLine.items.clear();
		};

		theTimeLine.$connector.clearGroups = function() {
			theTimeLine.groups.clear();
		};
	}
}
