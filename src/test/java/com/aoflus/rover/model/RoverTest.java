package com.aoflus.rover.model;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.aoflus.rover.utils.Coordinate;
import com.aoflus.rover.utils.Direction;

public class RoverTest {
	
	private Rover rover;
	private Mars mars;
	
	@Before
	public void init() {
		mars = new Mars(Coordinate.createCoordinate(10, 10));
		rover = new Rover(mars, Coordinate.createCoordinate(5, 5), Direction.NORTH);
	}
	
	@Test
	public void WeWantToMoveImplementTheRoverMovement() {	
		// Arrange & Act
		// Move the rover
		rover.moveForward();
		
		// Assert
		assertThat("The rover position does not match", rover.getPosition().getX() == 6.0);
		//assertThat(roverLocation.increaseX(mars.getMarsSize()).equals(rover.getPosition()));
	}
	
	@Test
	public void WeWantToCheckThatTheWorldIsSpheric() {
		// Arrange
		// Change mars size to adjust the test case
		mars.setMarsSize(Coordinate.createCoordinate(5,5));
		
		// Act
		//Move the rover
		rover.moveForward();
		
		// Assert
		assertThat("The rover is on an plane planet! Call the earthplanists!",
				rover.getPosition().getX() == 1);
	}

}
