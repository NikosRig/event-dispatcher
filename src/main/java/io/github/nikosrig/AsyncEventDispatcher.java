package io.github.nikosrig;

public class AsyncEventDispatcher extends AbstractEventDispatcher implements EventDispatcher {
	@Override
	public void dispatch(Event event) {
		this.dispatchEventAsyncToEventListeners(event);
		this.dispatchEventAsyncToListenerProviders(event);
	}

	private void dispatchEventAsyncToListenerProviders(Event event) {
		for (ListenerProvider listenerProvider : this.listenerProviders) {
			for (EventListener eventListener : listenerProvider.getListenersForEvent(event)) {
				this.dispatchAsyncEventToEventListener(event, eventListener);
			}
		}
	}

	private void dispatchEventAsyncToEventListeners(Event event) {
		if (!this.eventListeners.containsKey(event.getName())) {
			return;
		}

		for (EventListener eventListener : this.eventListeners.get(event.getName())) {
			this.dispatchAsyncEventToEventListener(event, eventListener);
		}
	}

	private void dispatchAsyncEventToEventListener(Event event, EventListener eventListener) {
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
