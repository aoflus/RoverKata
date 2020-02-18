package com.aoflus.rover.support;

public class InvalidObstaclesException extends Exception {
	
	public InvalidObstaclesException(Coordinate coordinate) {
		super(String.format("Invalid coordinate at position %s", coordinate.toString()));
	}

}
