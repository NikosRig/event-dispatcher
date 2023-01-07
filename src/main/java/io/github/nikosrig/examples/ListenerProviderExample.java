package io.github.nikosrig.examples;

import io.github.nikosrig.Event;
import io.github.nikosrig.EventListener;
import io.github.nikosrig.ListenerProvider;

import java.util.ArrayList;

public class ListenerProviderExample implements ListenerProvider {

	@Override
	public ArrayList<EventListener> getListenersForEvent(Event event) {
		ArrayList<EventListener> eventListeners = new ArrayList<>();

		if (!(event instanceof EventExample)) {
			return eventListeners;
		}

		eventListeners.add(new EventListenerExample());
		return eventListeners;
	}
}
