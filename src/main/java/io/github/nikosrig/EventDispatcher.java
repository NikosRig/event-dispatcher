package io.github.nikosrig;

public interface EventDispatcher {

	void dispatch(Event event);

	void addListener(String eventName, EventListener listener);
}
