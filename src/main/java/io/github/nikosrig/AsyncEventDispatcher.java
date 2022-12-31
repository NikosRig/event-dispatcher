package io.github.nikosrig;

public class AsyncEventDispatcher extends AbstractEventDispatcher implements EventDispatcher {
	@Override
	public void dispatch(Event event) {
		if (!this.eventListeners.containsKey(event.getName())) {
			return;
		}

		for (EventListener eventListener : this.eventListeners.get(event.getName())) {
			Thread thread = new Thread(() -> {
				try {
					eventListener.handle(event);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
			thread.start();
		}
	}
}
