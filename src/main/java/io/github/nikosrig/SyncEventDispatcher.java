package io.github.nikosrig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SyncEventDispatcher implements EventDispatcher {

	private final Map<String, ArrayList<EventListener>> eventListeners = new HashMap<>();

	@Override
	public void dispatch(Event event) {
		if (!this.eventListeners.containsKey(event.getName())) {
			return;
		}

		this.eventListeners.get(event.getName()).forEach(
				eventListener -> eventListener.handle(event)
		);
	}

	@Override
	public void addListener(String eventName, EventListener listener) {
		if (!this.eventListeners.containsKey(eventName)) {
			this.eventListeners.put(eventName, new ArrayList<>());
		}

		ArrayList<EventListener> eventListeners = this.eventListeners.get(eventName);
		eventListeners.add(listener);
	}
}
