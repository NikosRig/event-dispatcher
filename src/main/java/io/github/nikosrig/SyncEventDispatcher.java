package io.github.nikosrig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SyncEventDispatcher extends AbstractEventDispatcher implements EventDispatcher {

	@Override
	public void dispatch(Event event) throws Exception {
		if (!this.eventListeners.containsKey(event.getName())) {
			return;
		}

		for (EventListener eventListener : this.eventListeners.get(event.getName())) {
			eventListener.handle(event);
		}
	}
}

