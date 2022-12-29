package io.github.nikosrig;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class SyncEventDispatcherTest {

	@Test
	public void testShouldDispatchEventToAllListeners() {
		SyncEventDispatcher dispatcher = new SyncEventDispatcher();
		EventListener eventListener = mock(EventListener.class);
		Event event = mock(Event.class);
		when(event.getName()).thenReturn("test");
		dispatcher.addListener(event.getName(), eventListener);
		dispatcher.addListener(event.getName(), eventListener);

		dispatcher.dispatch(event);
		verify(eventListener, times(2)).handle(any());
	}


}
