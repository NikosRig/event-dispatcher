package io.github.nikosrig;

public interface EventDispatcher {

	void dispatch(Event event) throws Exception;

	void addListener(String eventName, EventListener listener);

	void addListenerProvider(ListenerProvider listenerProvider);
}
