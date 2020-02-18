package com.aoflus.rover.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.aoflus.rover.model.Mars;
import com.aoflus.rover.support.Coordinate;

public class CoordinatesTest {
	
	private Coordinate coordinate;
	private Mars mars;
	
	@Before
	public void init() {
		coordinate = Coordinate.createCoordinate(10, 15);
		mars = new Mars (Coordinate.createCoordinate(10, 15));
	}
	
	@Test
	public void WeWantToDisplayCoordinatesPosition() {
		// Assert
		assertThat("The display is incorrect", coordinate.toString().equals("x:10,0, y:15,0"));
	}

	@Test
	public void WeWantToAssureTheXValueOfTheCoordinateIsCorrect() {
		// Assert
		assertThat("The coordinates are incorrect", coordinate.getX() == 10.0);
	}
	
	@Test
	public void WeWantToAssureTheYValueOfTheCoordinateIsCorrect() {
		// Assert
		assertThat("The coordinates are incorrect", coordinate.getY() == 15.0);

	}
	
	@Test
	public void WeWantToIncreaseTheValueOfXTakingInCareMarsSphere() {
		// Arrange & Act
		Coordinate incX = coordinate.increaseX(mars.getMarsSize());
		
		// Assert
		assertThat("The X coordinate is incorrect.", incX.getX() == 1.0);
	}
	
	@Test
	public void WeWantToDecreaseTheValueOfXTakingInCareMarsSphere() {
		// Arrange & Act
		Coordinate decX = coordinate.decreaseX(mars.getMarsSize());
		
		// Assert
		assertThat("The X coordinate is incorrect", decX.getX() == 9.0);
	}
	
	@Test
	public void WeWantToIncreaseTheYValueTakingInCareMarsSphere() {
		// Arrange & Act
		Coordinate incY = coordinate.increaseY(mars.getMarsSize());
		
		// Assert
		assertThat("The Y coordinate is incorrect.", incY.getY() == 1.0);
	}
	
	@Test
	public void WeWantToDecreaseTheYValuTakingInCareMarsSphere() {
		// Arrange & Act
		Coordinate decY = coordinate.decreaseY(mars.getMarsSize());
		
		// Assert
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
