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
	public void WeWantToAssertTheRoverIsCorrectlyCreated() {
		// Arrange & Assert
		assertThat("The rover direction is incorrect",
				rover.getRoverDirection().equals(Direction.NORTH));
		assertThat("The rover position is incorrect",
				rover.getPosition().equals(Coordinate.createCoordinate(5, 5)));
	}
	
	@Test
	public void WeWantToMoveImplementTheRoverMovement() {	
		// Arrange & Act
		// Move the rover
		rover.moveForward();
		
		// Assert
		assertThat("The rover position does not match", rover.getPosition().getX() == 6.0);
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
	
	@Test
	public void WeWantToMoveBackwardsWithTheRover() {
		// Arrange & Act
		rover.moveBackward();
		
		// Assert
		assertThat("The rover did not move backwards!",
				rover.getPosition().getX() == 4.0);
	}

	@Test
	public void WeWantToChangeDirectionsAndMoveForward() {
		// Arrange & Act
		rover.changeDirection(Direction.EAST);
		rover.moveForward();
		
		// Assert
		assertThat("The rover did not move itself to the right position.",
				rover.getPosition().getY() == 6.0);
	}
}
