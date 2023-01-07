package io.github.nikosrig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SyncEventDispatcher extends AbstractEventDispatcher implements EventDispatcher {

	@Override
	public void dispatch(Event event) throws Exception {
		this.dispatchEventToEventListeners(event);
		this.dispatchEventToListenerProviders(event);
	}

	private void dispatchEventToEventListeners(Event event) throws Exception {
		if (!this.eventListeners.containsKey(event.getName())) {
			return;
		}

		for (EventListener eventListener : this.eventListeners.get(event.getName())) {
			eventListener.handle(event);
		}
	}

	private void dispatchEventToListenerProviders(Event event) throws Exception {
		for (ListenerProvider listenerProvider : this.listenerProviders) {
			for (EventListener eventListener : listenerProvider.getListenersForEvent(event)) {
				eventListener.handle(event);
			}
		}
	}
}

