package com.aoflus.rover.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.aoflus.rover.model.Obstacles;
import com.aoflus.rover.support.Coordinate;

public class ObstaclesTest {
	
	private List<Coordinate> obstaclesList;
	
	@Before
	public void init() {
		obstaclesList = new ArrayList<>();
		obstaclesList.add(Coordinate.createCoordinate(1, 1));
		obstaclesList.add(Coordinate.createCoordinate(3, 7));
	}
	
	@Test
	public void WeWantToCreateAListOfObstacles() {
		// Arrange & act
		Obstacles obstacles = Obstacles.generateObstacles(obstaclesList);
		
		// Assert
		assertThat("The obstacle cannot be found.",
				obstacles.getObstaclesList().get(0).equals(Coordinate.createCoordinate(1, 1)));
	}
	
	@Test
	public void WeWantToCheckThatACollisionIsFound() {
		// Arrange
		Coordinate coord = Coordinate.createCoordinate(1, 1);
		Obstacles obstacles = Obstacles.generateObstacles(obstaclesList);
		
		// Act
		boolean collision = obstacles.checkCollision(coord);
		
		// Assert
		assertThat("Expected collision, but found none.", collision);
	}
	
	@Test
	public void WeWantToCheckACollisionIsNotFound() {
		// Arrange
		Coordinate coord = Coordinate.createCoordinate(5, 6);
		Obstacles obstacles = Obstacles.generateObstacles(obstaclesList);
		
		// Act
		boolean collision = obstacles.checkCollision(coord);
		
		// Assert
		assertThat("No collision was expected, found one.", !collision);
	}

}
