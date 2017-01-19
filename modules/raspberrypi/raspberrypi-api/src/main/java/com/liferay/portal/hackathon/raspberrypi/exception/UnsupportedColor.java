package com.liferay.portal.hackathon.raspberrypi.exception;

public class UnsupportedColor extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsupportedColor(String message) {
		super(message);
	}

	public UnsupportedColor(String message, Throwable t) {
		super(message, t);
	}

	public UnsupportedColor(Throwable t) {
		super(t);
	}

}
