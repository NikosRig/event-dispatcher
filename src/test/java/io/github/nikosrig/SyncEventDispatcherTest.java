package io.github.nikosrig;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class SyncEventDispatcherTest {

	@Test
	public void testShouldDispatchEventToAllListeners() throws Exception {
		SyncEventDispatcher dispatcher = new SyncEventDispatcher();
		EventListener eventListener = mock(EventListener.class);
		Event event = mock(Event.class);
		when(event.getName()).thenReturn("test");
		dispatcher.addListener(event.getName(), eventListener);
		dispatcher.addListener(event.getName(), eventListener);

		dispatcher.dispatch(event);
		verify(eventListener, times(2)).handle(any());
	}

	@Test
	public void testShouldDispatchEventToAllListenerProviders() throws Exception {
		SyncEventDispatcher dispatcher = new SyncEventDispatcher();
		ListenerProvider listenerProvider = mock(ListenerProvider.class);
		EventListener eventListener = mock(EventListener.class);
		ArrayList<EventListener> eventListenersList = new ArrayList<>();
		eventListenersList.add(eventListener);
		eventListenersList.add(eventListener);
		when(listenerProvider.getListenersForEvent(any())).thenReturn(eventListenersList);
		Event event = mock(Event.class);
		dispatcher.addListenerProvider(listenerProvider);

		dispatcher.dispatch(event);
		verify(eventListener, times(2)).handle(any());
	}
}
