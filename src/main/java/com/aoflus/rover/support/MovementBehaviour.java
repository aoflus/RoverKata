package com.aoflus.rover.support;

import com.aoflus.rover.model.Rover;

public interface MovementBehaviour {
	
	public Coordinate moveForward(Rover rover);
	
	public Coordinate moveBackward(Rover rover);
	
	public Direction rotateLeft();
	
	public Direction rotateRight();

}
