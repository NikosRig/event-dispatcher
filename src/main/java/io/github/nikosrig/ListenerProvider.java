package io.github.nikosrig;

import java.util.ArrayList;
import java.util.Map;

public interface ListenerProvider {
	ArrayList<EventListener> getListenersForEvent(Event event);
}
