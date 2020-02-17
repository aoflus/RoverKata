package com.aoflus.rover.utils;

import com.aoflus.rover.model.Rover;

public interface MovementBehaviour {
	
	public Coordinate moveForward(Rover rover);
	
	public Coordinate moveBackward(Rover rover);

}
