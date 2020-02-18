package com.aoflus.rover.support;

import com.aoflus.rover.model.Rover;

public enum Direction implements MovementBehaviour {
	
	NORTH {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().increaseY(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().decreaseY(rover.getMars().getMarsSize());
		}

		public Direction rotateLeft() {return WEST;}

		public Direction rotateRight() {return EAST;}
	},
	
	SOUTH {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().decreaseY(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().increaseY(rover.getMars().getMarsSize());
		}

		public Direction rotateLeft() {return EAST;}

		public Direction rotateRight() {return WEST;}
	},
	EAST {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().increaseX(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().decreaseX(rover.getMars().getMarsSize());
		}

		public Direction rotateLeft() {return NORTH;}

		public Direction rotateRight() {return SOUTH;}
	}
	,WEST {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().decreaseX(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().increaseX(rover.getMars().getMarsSize());
		}

		public Direction rotateLeft() {return SOUTH;}

		public Direction rotateRight() {return NORTH;}
	};

}
