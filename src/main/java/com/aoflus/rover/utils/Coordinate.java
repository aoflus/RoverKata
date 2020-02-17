package com.aoflus.rover.utils;

import java.awt.geom.Point2D;

public class Coordinate extends Point2D {
	
	private double x;
	private double y;

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x = y;
		this.y = y;
	}
	
}
