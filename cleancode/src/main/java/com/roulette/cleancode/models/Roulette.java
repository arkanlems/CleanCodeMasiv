package com.roulette.cleancode.models;

public class Roulette {

	private String id;
	private boolean open;
	
	public Roulette() {
		this.open = false;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
