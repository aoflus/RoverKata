package com.aoflus.rover.utils;

public class InvalidObstaclesException extends Exception {
	
	public InvalidObstaclesException(Coordinate coordinate) {
		super(String.format("Invalid coordinate at position %s", coordinate.toString()));
	}

}
