package com.aoflus.rover.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.aoflus.rover.model.Mars;

public class CoordinatesTest {
	
	private Coordinate coordinate;
	private Mars mars;
	
	@Before
	public void init() {
		coordinate = Coordinate.createCoordinate(10, 15);
		mars = new Mars (Coordinate.createCoordinate(10, 15));
	}

	@Test
	public void WeWantToCheckThatCoordinatesAreGeneratedCorrectly() {
		// Assert
		assertThat("The coordinates are incorrect", coordinate.getX() == 10.0);
		assertThat("The coordinates are incorrect", coordinate.getY() == 15.0);
	}

	@Test
	public void WeWantToCheckThatIncreaseAndDecreaseWorkCorrectly() {
		// Arrange & Act
		Coordinate incX = coordinate.increaseX(mars.getMarsSize());
		Coordinate incY = coordinate.increaseY(mars.getMarsSize());
		Coordinate decX = coordinate.decreaseX(mars.getMarsSize());
		Coordinate decY = coordinate.decreaseY(mars.getMarsSize());
		
		// Assert
		assertThat("The X coordinate is incorrect.", incX.getX() == 1.0);
		assertThat("The X coordinate is incorrect.", incY.getY() == 1.0);
		assertThat("The Y coordinate is incorrect", decX.getX() == 9.0);
		assertThat("The Y coordinate is incorrect", decY.getY() == 14.0);
	}
	
	@Test
	public void WeWantToCheckTheEqualsFunctionIsCorrect() {
		// Arrange
		Coordinate coord2 = Coordinate.createCoordinate(10, 15);
		
		// Assert
		assertThat("The coordinates are not equal.", coordinate.equals(coord2));
	}
}
