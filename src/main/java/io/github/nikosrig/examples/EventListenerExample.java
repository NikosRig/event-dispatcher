package io.github.nikosrig.examples;

import io.github.nikosrig.Event;
import io.github.nikosrig.EventListener;

public class EventListenerExample implements EventListener {
	public void handle(Event event) {
		if (!(event instanceof EventExample)) {
			return;
		}

		System.out.println("Event triggered");
	}
}
