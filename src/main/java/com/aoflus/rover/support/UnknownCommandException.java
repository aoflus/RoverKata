package com.aoflus.rover.support;

@SuppressWarnings("serial")
public class UnknownCommandException extends Exception {

	public UnknownCommandException(String command) {
		super(String.format("The command %s is unknown", command));
	}
	
}
