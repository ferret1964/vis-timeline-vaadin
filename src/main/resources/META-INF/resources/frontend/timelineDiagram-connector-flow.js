window.Vaadin.Flow.timelineDiagramConnector = {
	initLazy : function(theTimeLine, initialItems, initialGroups, options) {

		// Check whether the connector was already initialized for the Iron list
		if (theTimeLine.$connector) {
			return;
		}
		console.log('init timelineDiagramConnector');

		theTimeLine.$connector = {};

		theTimeLine.items = new visTL.DataSet(JSON.parse(initialItems));
		theTimeLine.groups = new visTL.DataSet(JSON.parse(initialGroups));


		var self = this;
		var customNodeifAdded = false;
		var customNodeID;
		var customNodeLabel;
		var customEdgeifAdded = false;
		var customEdgeID;
		var customEdgeLabel;

		theTimeLine.options = JSON.parse(options);

		theTimeLine.$connector.diagram = new visTL.Timeline(theTimeLine, theTimeLine.items,
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
