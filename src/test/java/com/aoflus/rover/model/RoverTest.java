package com.aoflus.rover.model;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.aoflus.rover.utils.Coordinate;
import com.aoflus.rover.utils.Direction;
import com.aoflus.rover.utils.UnknownCommandException;

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
	public void WeWantToDisplayCoordinatesPosition() {
		
	}
	
	@Test
	public void WeWantToMoveImplementTheRoverMovement() {	
		// Arrange & Act
		// Move the rover
		rover.moveForward();
		
		// Assert
		assertThat("The rover position does not match", rover.getPosition().getY() == 6.0);
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
				rover.getPosition().getY() == 1);
	}
	
	@Test
	public void WeWantToMoveBackwardsWithTheRover() {
		// Arrange & Act
		rover.moveBackward();
		
		// Assert
		assertThat("The rover did not move backwards!",
				rover.getPosition().getY() == 4.0);
	}
	
	@Test
	public void WeWantToMoveTheRoverWhenItReceivesACommand() throws UnknownCommandException {
		// Arrange
		Character commandForward = 'F';
		Character commandBackWard = 'B';
		
		// Act
		rover.readCommand(commandForward);
		Coordinate moveForward = rover.getPosition();
		rover.readCommand(commandBackWard);
		Coordinate moveBackward = rover.getPosition();
		
		// Assert
		assertThat("The rover did not move itself forward.",
				moveForward.getY() == 6.0);
		assertThat("The rover did not move itself backwards.",
				moveBackward.getY() == 5.0);
	}
	
	@Test
	public void WeWantToRotateTheRoverWhenItReceivesACommand() throws UnknownCommandException {
		// Arrange
		Character commandLeft = 'L';
		Character commandRight = 'R';
		
		// Act
		rover.readCommand(commandLeft);
		Direction leftDirection = rover.getRoverDirection();
		rover.readCommand(commandRight);
		Direction rightDirection = rover.getRoverDirection();
		
		// Assert
		assertThat("The rover did not rotate left",
				leftDirection.equals(Direction.WEST));
		assertThat("The rover did not rotate right",
				rightDirection.equals(Direction.NORTH));
	}
	
	@Test(expected = UnknownCommandException.class)
	public void WeWantToHandleWhenReceivingAWrongCommand() throws UnknownCommandException {
		// Arrange
		Character wrongCommand = 'T';
		
		// Arrange
		rover.readCommand(wrongCommand);
		
		// Assert
		assertThat("The rover position is incorrect.",
				rover.getPosition().equals(Coordinate.createCoordinate(5, 5)));
		assertThat("The rover direction is incorrect.",
				rover.getRoverDirection().equals(Direction.NORTH));
	}
	
	@Test
	public void WeWantTheRoverToHandleAListOfCommands() throws UnknownCommandException {
		// Arrange
		// Create array of commands with position destination (2,4)
		Character[] commands = {'L', 'F', 'F', 'F', 'R', 'B'};
		
		// Act
		// Read the commands
		rover.readCommands(commands);
		
		// Assert
		assertThat("The rover position is incorrect",
				rover.getPosition().equals(Coordinate.createCoordinate(2, 4)));
		assertThat("The rover direction is incorrect",
				rover.getRoverDirection().equals(Direction.NORTH));
	}
	
}
