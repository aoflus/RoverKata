package com.aoflus.rover.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aoflus.rover.utils.Command;
import com.aoflus.rover.utils.Coordinate;
import com.aoflus.rover.utils.Direction;
import com.aoflus.rover.utils.UnknownCommandException;
import com.google.common.base.Enums;

public class Rover {
	
	private static final Logger LOG = LoggerFactory.getLogger(Rover.class);

	private Coordinate position;
	private Direction direction;
	private Mars mars;
	private boolean collided;
	
	public Rover(Mars mars, Coordinate position, Direction direction) {
		this.position = position;
		this.direction = direction;
		this.mars = mars;
		this.collided = false;
	}
	
	public Mars getMars() {
		return this.mars;
	}

	public Coordinate getPosition() {
		return this.position;
	}
	
	public void moveForward() {
		if (mars.getObstacles().checkCollision(this.direction.moveForward(this))) {
			this.collided = true;
			LOG.info("Collision detected at coordinate: {}",
					this.direction.moveForward(this));
		} else {
			this.position = this.direction.moveForward(this);
		}
	}
	
	public void moveBackward() {
		if (mars.getObstacles().checkCollision(this.direction.moveBackward(this))) {
			this.collided = true;
			LOG.info("Collision detected at coordinate: {}",
					this.direction.moveBackward(this));
		} else {
			this.position = this.direction.moveBackward(this);
		}
	}

	public Direction getRoverDirection() {
		return this.direction;
	}
	
	public void rotateLeft() {
		this.direction = this.direction.rotateLeft();
	}
	
	public void rotateRight() {
		this.direction = this.direction.rotateRight();
	}
	
	public void readCommand(Character characterCommand) throws UnknownCommandException {
		String stringCommand = characterCommand.toString();
		Command command = Enums.getIfPresent(Command.class, stringCommand).orNull();
		if (command != null) {
			switch (command) {
				case F:
					moveForward();
				break;
				case B:
					moveBackward();
				break;
				case L:
					rotateLeft();
				break;
				case R:
					rotateRight();
				break;
			}
		} else {
			throw new UnknownCommandException(stringCommand);
		}
	}
	
	public void readCommands(Character[] commands) throws UnknownCommandException {
		for (Character c : commands) {
			if (!collided) {
				readCommand(c);
			}
			else break;
		}
	}
}
