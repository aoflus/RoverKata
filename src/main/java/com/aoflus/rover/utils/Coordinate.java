package com.aoflus.rover.utils;

public class Coordinate {
	
	private double x;
	private double y;
	
	private Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static Coordinate createCoordinate(double x, double y) {
		return new Coordinate(x, y);
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Coordinate increaseX(Coordinate worldLimit) {
		return Coordinate.createCoordinate((x + 1) % worldLimit.getX(), this.y);
	}

	public Coordinate decreaseX(Coordinate worldLimit) {
		return Coordinate.createCoordinate((x - 1) % worldLimit.getX(), this.y);
	}
	
	
}
