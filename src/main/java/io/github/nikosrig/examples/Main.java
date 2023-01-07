package io.github.nikosrig.examples;

import io.github.nikosrig.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Event event = new EventExample("example parameter");
		EventListener eventListener = new EventListenerExample();
		ListenerProvider listenerProvider = new ListenerProviderExample();

		AsyncEventDispatcher asyncEventDispatcher = new AsyncEventDispatcher();
		asyncEventDispatcher.addListener("testEvent", eventListener);
		asyncEventDispatcher.addListenerProvider(listenerProvider);
		asyncEventDispatcher.dispatch(event);

		SyncEventDispatcher syncEventDispatcher = new SyncEventDispatcher();
		syncEventDispatcher.addListener("testEvent", eventListener);
		syncEventDispatcher.addListenerProvider(listenerProvider);
		syncEventDispatcher.dispatch(event);
	}
}