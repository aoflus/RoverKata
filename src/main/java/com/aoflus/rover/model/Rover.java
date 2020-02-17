package com.aoflus.rover.model;

import com.aoflus.rover.utils.Coordinate;
import com.aoflus.rover.utils.Direction;

public class Rover {

	private Coordinate position;
	private Direction direction;
	private Mars mars;
	
	public Rover(Mars mars, Coordinate position, Direction direction) {
		this.position = position;
		this.direction = direction;
		this.mars = mars;
	}
	
	public Mars getMars() {
		return this.mars;
	}

	public Coordinate getPosition() {
		return this.position;
	}
	
	public void moveForward() {
		this.position = this.direction.moveForward(this);
	}
	
	public void moveBackward() {
		this.position = this.direction.moveBackward(this);
	}
	
	public void changeDirection(Direction direction) {
		this.direction = direction;
	}
	
}
