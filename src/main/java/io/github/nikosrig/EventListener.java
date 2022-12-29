package io.github.nikosrig;

public interface EventListener {
	void handle(Event event) throws Exception;
}
