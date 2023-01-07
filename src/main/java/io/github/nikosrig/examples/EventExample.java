package io.github.nikosrig.examples;

import io.github.nikosrig.Event;

import java.util.ArrayList;

public class EventExample implements Event {

	private final ArrayList<String> data = new ArrayList<>();

	public EventExample(String exampleParam) {
		this.data.add(exampleParam);
	}

	public ArrayList<String> getData() {
		return this.data;
	}

	@Override
	public String getName() {
		return "example-event";
	}
}
