package com.aoflus.rover.model;

import java.util.List;

import com.aoflus.rover.support.Coordinate;

public class Obstacles {
	
	private List<Coordinate> obstaclesList;
	
	private Obstacles(List<Coordinate> obstaclesList) {
		this.obstaclesList = obstaclesList;
	}
	
	public static Obstacles generateObstacles(List<Coordinate> obstaclesList) {
		return new Obstacles(obstaclesList);
	}
	
	public boolean checkCollision(Coordinate coord) {
		return obstaclesList.contains(coord);
	}
	
	public List<Coordinate> getObstaclesList() { 
		return this.obstaclesList;
	}

}
