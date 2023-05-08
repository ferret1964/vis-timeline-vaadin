window.Vaadin.Flow.timelineDiagramConnector = {
	initLazy : function(theTimeLine, initialDataSet, initialGroups, options) {

		// Check whether the connector was already initialized for the Iron list
		if (theTimeLine.$connector) {
			return;
		}
		console.log('init networkDiagramConnector');

		theTimeLine.$connector = {};

		console.log(initDataSet);
		theTimeLine.items = new vis.itemsSet(JSON.parse(initialDataSet));
		theTimeLine.groups = new vis.itemsSet(JSON.parse(initialGroups));


		var self = this;
		var customNodeifAdded = false;
		var customNodeID;
		var customNodeLabel;
		var customEdgeifAdded = false;
		var customEdgeID;
		var customEdgeLabel;

		theTimeLine.options = JSON.parse(options);

		theTimeLine.options.manipulation.addNode = function(nodeData, callback) {
			if (customNodeifAdded == true) {
				nodeData.label = customNodeLabel;
				nodeData.id = customNodeID;
			}
			self.onManipulationNodeAdded(nodeData);
			callback(nodeData);
		};

		theTimeLine.options.manipulation.addEdge = function(edgeData, callback) {
			if (customEdgeifAdded == true) {
				edgeData.label = customEdgeLabel;
				edgeData.id = customEdgeID;
			}
			self.onManipulationEdgeAdded(edgeData);
			callback(edgeData);
		};

		theTimeLine.options.manipulation.deleteNode = function(nodeData, callback) {
			self.onManipulationNodeDeleted(nodeData);
			callback(nodeData);
		};

		theTimeLine.options.manipulation.deleteEdge = function(edgeData, callback) {
			self.onManipulationEdgeDeleted(edgeData);
			callback(edgeData);
		};

		theTimeLine.options.manipulation.editEdge = function(edgeData, callback) {
			self.onManipulationEdgeEdited(edgeData);
			callback(edgeData);
		};

		console.log("networkdiagram options: " + JSON.stringify(theTimeLine.options));

		theTimeLine.$connector.diagram = new vis.Timeline(theTimeLine, theTimeLine.items,
			theTimeLine.groups, theTimeLine.options);

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
														if (key === 'previousSelection') {
															// map object arrays to id for deselect event
															params[key]['nodes'] = params[key]['nodes'].map(obj => obj.id);
															params[key]['edges'] = params[key]['edges'].map(obj => obj.id);
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

		theTimeLine.$connector.addEdges = function(edges) {
			let edgesObject = JSON.parse(edges);
			theTimeLine.edges.add(edgesObject);
		}

		theTimeLine.$connector.updateEdges = function(edges) {
			alert('updateEdges: ' + edges);
		}

		theTimeLine.$connector.setNodes = function(index, nodes) {
			console.log("setNodes " + JSON.stringify(nodes));
			for (let i = 0; i < theTimeLine.items.length; i++) {
				// const itemsIndex = index + i;
				// console.log(typeof nodes[i])
				// console.log(typeof nodes[i].items)
				const node = JSON.parse(nodes[i].items);
				// console.log(JSON.stringify(node));
				theTimeLine.items.add(node);
			}
		}

		theTimeLine.$connector.addNodes = function(nodes) {
			// console.log("addNodes: " + typeof nodes + "=" +
			// JSON.stringify(nodes));
			let nodesObject = JSON.parse(nodes);
			// console.log("addNodesParsed: " + typeof nodesObject + "=" +
			// JSON.stringify(nodesObject));
			theTimeLine.items.add(nodesObject);
		}

		theTimeLine.$connector.updateNodes = function(nodes) {
			alert('updateNodes: ' + nodes);
		}

		theTimeLine.$connector.clearNodes = function() {
			theTimeLine.items.clear();
		};

		theTimeLine.$connector.clearEdges = function() {
			theTimeLine.edges.clear();
		};

		theTimeLine.$connector.updateNodesSize = function(newSize) {
			const delta = newSize - theTimeLine.items.length;
			if (delta > 0) {
				theTimeLine.items.length = newSize;

				// theTimeLine.notifySplices("nodes", [{index: newSize - delta,
				// removed: [], addedCount : delta, object: theTimeLine.items, type:
				// "splice"}]);
			} else if (delta < 0) {
				const removed = theTimeLine.items.slice(newSize, theTimeLine.items.length);
				theTimeLine.items.splice(newSize);
				// theTimeLine.notifySplices("nodes", [{index: newSize, removed:
				// removed, addedCount : 0, object: theTimeLine.items, type:
				// "splice"}]);
			}
		};

		theTimeLine.$connector.updateEdgesSize = function(newSize) {
			const delta = newSize - theTimeLine.edges.length;
			if (delta > 0) {
				theTimeLine.edges.length = newSize;

				// theTimeLine.notifySplices("edges", [{index: newSize - delta,
				// removed: [], addedCount : delta, object: theTimeLine.edges, type:
				// "splice"}]);
			} else if (delta < 0) {
				const removed = theTimeLine.edges.slice(newSize, theTimeLine.edges.length);
				theTimeLine.edges.splice(newSize);
				// theTimeLine.notifySplices("edges", [{index: newSize, removed:
				// removed, addedCount : 0, object: theTimeLine.edges, type:
				// "splice"}]);
			}
		};
	}
}
