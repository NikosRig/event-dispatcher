package io.github.nikosrig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEventDispatcher implements EventDispatcher {

	protected final Map<String, ArrayList<EventListener>> eventListeners = new HashMap<>();

	public void addListener(String eventName, EventListener listener) {
		if (!this.eventListeners.containsKey(eventName)) {
			this.eventListeners.put(eventName, new ArrayList<>());
		}

		ArrayList<EventListener> eventListeners = this.eventListeners.get(eventName);
		eventListeners.add(listener);
	}
}
