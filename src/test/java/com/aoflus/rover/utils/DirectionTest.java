package com.aoflus.rover.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.aoflus.rover.model.Mars;
import com.aoflus.rover.model.Rover;
import com.aoflus.rover.support.Coordinate;
import com.aoflus.rover.support.Direction;

public class DirectionTest {
	
	private Mars mars;
	private Rover rover;
	
	@Before
	public void init() {
		mars = new Mars(Coordinate.createCoordinate(10, 15));
		rover = new Rover(mars, Coordinate.createCoordinate(5, 5), Direction.NORTH);
	}

	@Test
	public void WeWantToCheckThatIncreaseNorthIsCorrect() {
		// Arrange & Act
		Coordinate incNorth = Direction.NORTH.moveForward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				incNorth.equals(Coordinate.createCoordinate(5, 6)));
	}
	
	@Test
	public void WeWantToCheckThatDecreaseNorthIsCorrect() {
		// Arrange & Act
		Coordinate decNorth = Direction.NORTH.moveBackward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				decNorth.equals(Coordinate.createCoordinate(5, 4)));
	}
	
	@Test
	public void WeWantToCheckThatIncreaseSouthIsCorrect() {
		// Arrange & Act
		Coordinate incSouth = Direction.SOUTH.moveForward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				incSouth.equals(Coordinate.createCoordinate(5, 4)));
	}
	
	@Test
	public void WeWantToCheckThatDecreaseSouthIsCorrect() {
		// Arrange & Act
		Coordinate decSouth = Direction.SOUTH.moveBackward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				decSouth.equals(Coordinate.createCoordinate(5, 6)));
	}
	
	@Test
	public void WeWantToCheckThatIncreaseEastIsCorrect() {
		// Arrange & Act
		Coordinate incEast = Direction.EAST.moveForward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				incEast.equals(Coordinate.createCoordinate(6, 5)));
	}
	
	@Test
	public void WeWantToCheckThatDecreaseEastIsCorrect() {
		// Arrange & Act
		Coordinate decEast = Direction.EAST.moveBackward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				decEast.equals(Coordinate.createCoordinate(4, 5)));
	}
	
	@Test
	public void WeWantToCheckThatIncreaseWestIsCorrect() {
		// Arrange & Act
		Coordinate incWest = Direction.WEST.moveForward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				incWest.equals(Coordinate.createCoordinate(4, 5)));
	}
	
	@Test
	public void WeWantToCheckThatDecreaseWestIsCorrect() {
		// Arrange & Act
		Coordinate decWest = Direction.WEST.moveBackward(rover);
		
		// Assert
		assertThat("The coordinate is incorrect",
				decWest.equals(Coordinate.createCoordinate(6, 5)));
	}
	
	@Test
	public void WeWantToCheckRotateNorthLeftIsCorrect() {
		// Arrange & Act
		Direction rotateNorthLeft = Direction.NORTH.rotateLeft();
		
		// Assert
		assertThat("The direction is incorrect", rotateNorthLeft.equals(Direction.WEST));
	}
	
	@Test
	public void WeWantToCheckRotateNorthRightIsCorrect() {
		// Arrange & Act
		Direction rotateNorthRight = Direction.NORTH.rotateRight();
		
		// Assert
		assertThat("The direction is incorrect", rotateNorthRight.equals(Direction.EAST));
	}
	
	@Test
	public void WeWantToCheckRotateSouthLeftIsCorrect() {
		// Arrange & Act
		Direction rotateSouthLeft = Direction.SOUTH.rotateLeft();
		
		// Assert
		assertThat("The direction is incorrect", rotateSouthLeft.equals(Direction.EAST));
	}
	
	@Test
	public void WeWantToCheckRotateSouthRightIsCorrect() {
		// Arrange & Act
		Direction rotateSouthRight = Direction.SOUTH.rotateRight();
		
		// Assert
		assertThat("The direction is incorrect", rotateSouthRight.equals(Direction.WEST));
	}
	
	@Test
	public void WeWantToCheckRotateEastLeftIsCorrect() {
		// Arrange & Act
		Direction rotateEastLeft = Direction.EAST.rotateLeft();
		
		// Assert
		assertThat("The direction is incorrect", rotateEastLeft.equals(Direction.NORTH));
	}
	
	@Test
	public void WeWantToCheckRotateEastRightIsCorrect() {
		// Arrange & Act
		Direction rotateEastRight = Direction.EAST.rotateRight();
		
		// Assert
		assertThat("The direction is incorrect", rotateEastRight.equals(Direction.SOUTH));
	}
	
	@Test
	public void WeWantToCheckRotateWestLeftIsCorrect() {
		// Arrange & Act
		Direction rotateWestLeft = Direction.WEST.rotateLeft();
		
		// Assert
		assertThat("The direction is incorrect", rotateWestLeft.equals(Direction.SOUTH));
	}
	
	@Test
	public void WeWantToCheckRotateWestRightIsCorrect() {
		// Arrange & Act
		Direction rotateWestRight = Direction.WEST.rotateRight();
		
		// Assert
		assertThat("The direction is incorrect", rotateWestRight.equals(Direction.NORTH));
	}

}
