package com.aoflus.rover.model;

import org.junit.Before;
import org.junit.Test;

import com.aoflus.rover.utils.Coordinate;
import com.aoflus.rover.utils.InvalidObstaclesException;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class MarsTest {
	
	private Mars mars;
	
	@Before
	public void setUp() {
		mars = new Mars(Coordinate.createCoordinate(10, 10));
	}
	
	@Test
	public void WeWantToMakeSureMarsSizeIsCorrectlySet() {
		// Assert
		assertThat("The coordinates do not match",
				mars.getMarsSize().equals(Coordinate.createCoordinate(10, 10)));
	}
	
	@Test
	public void WeWantToGenerateObstaclesWithinMarsSize() throws InvalidObstaclesException {
		// Arrange
		List<Coordinate> obstacles = new ArrayList<>();
		obstacles.add(Coordinate.createCoordinate(1, 6));
		obstacles.add(Coordinate.createCoordinate(3, 5));
		
		// Act
		mars.generateObstacles(obstacles);
		
		// Assert
		assertThat("The coordinates do not match",
				mars.getObstacles().getObstaclesList().get(0).equals(Coordinate.createCoordinate(1, 1)));
	}
	
	@Test(expected = InvalidObstaclesException.class)
	public void WeWantToAssertErrorIsThrownWhenAddingOverValuedCoordinate() throws InvalidObstaclesException {
		// Arrange
		List<Coordinate> obstacles = new ArrayList<>();
		obstacles.add(Coordinate.createCoordinate(1, 30));
		
		// Act
		mars.generateObstacles(obstacles);
		
		// Assert
		assertThat("The coordinates do not match",
				mars.getObstacles().getObstaclesList().get(0).equals(Coordinate.createCoordinate(1, 30)));
	}
	
	@Test(expected = InvalidObstaclesException.class)
	public void WeWantToAssertAnErrorIsThrownWhenAddingANegativeValueCoordinate() throws InvalidObstaclesException {
		// Arrange
		List<Coordinate> obstacles = new ArrayList<>();
		obstacles.add(Coordinate.createCoordinate(-1, 8));
		
		// Act
		mars.generateObstacles(obstacles);
		
		// Assert
		assertThat("The coordinates do not match",
				mars.getObstacles().getObstaclesList().get(0).equals(Coordinate.createCoordinate(-1, 8)));
	}
}
