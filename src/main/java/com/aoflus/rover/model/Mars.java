package com.aoflus.rover.model;

import java.util.ArrayList;
import java.util.List;

import com.aoflus.rover.utils.Coordinate;
import com.aoflus.rover.utils.InvalidObstaclesException;

public class Mars {
	
	private Coordinate marsSize;
	private Obstacles obstacles;
	
	public Mars(Coordinate marsSize) {
		this.marsSize = marsSize;
		this.obstacles = Obstacles.generateObstacles(new ArrayList<Coordinate>());
	}
	
	public Coordinate getMarsSize() {
		return this.marsSize;
	}
	
	public void setMarsSize(Coordinate marsSize) {
		this.marsSize = marsSize;
	}
	
	private boolean obstacleIsWorldCompliant(Coordinate obstacle) {
		return obstacle.getX() < marsSize.getX()
				&& obstacle.getY() < marsSize.getY()
				&& obstacle.getX() > 0 && obstacle.getY() > 0;
	}
	
	public void generateObstacles(List<Coordinate> obstaclesList) throws InvalidObstaclesException {
		for (Coordinate obstacle : obstaclesList) {
			if (!obstacleIsWorldCompliant(obstacle)) {
				throw new InvalidObstaclesException(obstacle);
			}
		}
			obstacles = Obstacles.generateObstacles(obstaclesList);
	}
	
	public Obstacles getObstacles() {
		return this.obstacles;
	}
}
