<div align="center">

  <h1>Event Dispatcher</h1>
  <p align="center">
    <span>Lightweight library for dispatching async and sync events</span>
  </p>
  
<!-- Badges -->
  <p>
    <a href="https://www.linkedin.com/in/nick-rigas/">
      <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="linkedin" />
    </a>
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" alt="Java" />
  </p>
</div>

### Installation

```bash
<dependency>
  <groupId>io.github.nikosrig</groupId>
  <artifactId>event-dispatcher</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Events
Events are objects that act as the unit of communication between an emitter and the appropriate event listeners. 

```
public class EventExample implements Event {

	private final ArrayList<String> data = new ArrayList<>();

	public EventExample(String exampleParam) {
		this.data.add(exampleParam);
	}

	public ArrayList<String> getData() {
		return this.data;
	}

	public String getName() {
		return "example-event";
	}
}
```

### Event Listeners
Event listeners are classes that handle the events and are triggered by event dispatchers.

```
public class EventListenerExample implements EventListener {
	public void handle(Event event) {
		if (!(event instanceof EventExample)) {
			return;
		}

		System.out.println("Event handling");
	}
}
```

### Listener Providers
Listener providers act as groups of event listeners. 

```
public class ListenerProviderExample implements ListenerProvider {

	@Override
	public ArrayList<EventListener> getListenersForEvent(Event event) {
		ArrayList<EventListener> eventListeners = new ArrayList<>();

		if (!(event instanceof EventExample)) {
			return eventListeners;
		}

		eventListeners.add(new EventListenerExample());
		return eventListeners;
	}
}
```

### Event dispatchers
Event dispatchers are a service objects implementing EventDispatcher. They are responsible for retrieving event listeners from a listener providers for the  dispatched event, and invoking each event listener with that Event.

#### SyncEventDispatcher example

```
		SyncEventDispatcher syncEventDispatcher = new SyncEventDispatcher();
		syncEventDispatcher.addListener("testEvent", eventListener);
		syncEventDispatcher.addListenerProvider(listenerProvider);
		syncEventDispatcher.dispatch(event);
```

#### AsyncEventDispatcher example

```
		AsyncEventDispatcher asyncEventDispatcher = new AsyncEventDispatcher();
		asyncEventDispatcher.addListener("testEvent", eventListener);
		asyncEventDispatcher.addListenerProvider(listenerProvider);
		asyncEventDispatcher.dispatch(event);
```

### :handshake: Contact

Nikos Rigas - nikosrigas95@gmail.com

### Licence

Distributed under the MIT License

