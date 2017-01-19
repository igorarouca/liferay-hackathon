package com.liferay.portal.hackathon.raspberrypi;

import com.liferay.portal.hackathon.raspberrypi.constants.RaspberryPiServiceConstants.Color;

/**
 * @author Igor Arouca
 */
public interface RaspberryPiService {

	public void turnOff(Color color);

	public void turnOn(Color color);

}