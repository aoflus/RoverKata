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
			return rover.getPosition().increaseX(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	EAST {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().increaseX(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	,WEST {
		public Coordinate moveForward(Rover rover) {
			return rover.getPosition().increaseX(rover.getMars().getMarsSize());
		}

		public Coordinate moveBackward(Rover rover) {
			// TODO Auto-generated method stub
			return null;
		}
	};

}
