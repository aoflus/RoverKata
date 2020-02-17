package com.aoflus.rover.model;

import com.aoflus.rover.utils.Coordinate;

public class Mars {
	
	private Coordinate marsSize;
	
	public Mars(Coordinate marsSize) {
		this.marsSize = marsSize;
	}
	
	public Coordinate getMarsSize() {
		return this.marsSize;
	}
	
	public void setMarsSize(Coordinate marsSize) {
		this.marsSize = marsSize;
	}
}
