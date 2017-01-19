package com.liferay.portal.hackathon.raspberrypi.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Tran Hoang
 */
@ExtendedObjectClassDefinition(category = "Hackathon")
@Meta.OCD(
	id = "com.liferay.portal.hackathon.raspberrypi.service.configuration.RaspberryPiConfiguration",
	localization = "content/Language", name = "Raspberry Pi Configuration"
)
public interface RaspberryPiServiceConfiguration {

	@Meta.AD(deflt = DEFAULT_HOST_NAME, required = false)
	public String hostName();

	@Meta.AD(deflt = DEFAULT_PORT, required = false)
	public int port();

	public static final String DEFAULT_HOST_NAME = "localhost";

	public static final String DEFAULT_PORT = "12000";

}