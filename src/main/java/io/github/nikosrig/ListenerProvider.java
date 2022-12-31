package io.github.nikosrig;

import java.util.ArrayList;
import java.util.Map;

public interface ListenerProvider {
	Map<String, ArrayList<EventListener>> getListenersForEvent(Event event);
}
