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

	public Coordinate increaseX(Coordinate marsLimit) {
		return Coordinate.createCoordinate((x + 1) % marsLimit.getX(), this.y);
	}

	public Coordinate decreaseX(Coordinate marsLimit) {
		return Coordinate.createCoordinate((x - 1) % marsLimit.getX(), this.y);
	}

	public Coordinate increaseY(Coordinate marsLimit) {
		return Coordinate.createCoordinate(x, (y + 1) % marsLimit.getY());
	}
	
	public Coordinate decreaseY(Coordinate marsLimit) {
		return Coordinate.createCoordinate(x, (y - 1) % marsLimit.getY());
	}

	@Override
	public boolean equals(Object otherCoordinate) {
		if (!(otherCoordinate instanceof Coordinate)) {
			return false;
		} else {
			return ((Coordinate) otherCoordinate).getX() == this.x
				&& ((Coordinate) otherCoordinate).getY() == this.y;
		}
	}
}
