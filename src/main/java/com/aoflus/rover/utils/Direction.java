package com.aoflus.rover.utils;

import com.aoflus.rover.model.Rover;

public enum Direction implements MovementBehaviour {
	
	NORTH {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().increaseX(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().decreaseX(rover.getMars().getMarsSize());
		}
	},
	
	SOUTH {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().decreaseX(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().increaseX(rover.getMars().getMarsSize());
		}
	},
	EAST {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().increaseY(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().decreaseY(rover.getMars().getMarsSize());
		}
	}
	,WEST {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().decreaseY(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			return rover.getPosition().increaseY(rover.getMars().getMarsSize());
		}
	};

}
