package io.github.nikosrig;

public class AsyncEventDispatcher extends AbstractEventDispatcher implements EventDispatcher {
	@Override
	public void dispatch(Event event) {
		for (EventListener eventListener : this.eventListeners.get(event.getName())) {
			this.dispatchEventAsyncToEventListener(event, eventListener);
		}

		for (ListenerProvider listenerProvider : this.listenerProviders) {
			for (EventListener eventListener : listenerProvider.getListenersForEvent(event)) {
				this.dispatchEventAsyncToEventListener(event, eventListener);
			}
		}
	}

	private void dispatchEventAsyncToEventListener(Event event, EventListener eventListener) {
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
