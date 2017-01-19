/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.hackathon.raspberrypi.service.impl;

import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.hackathon.raspberrypi.RaspberryPiService;
import com.liferay.portal.hackathon.raspberrypi.service.base.RaspberryPiLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public class RaspberryPiLocalServiceImpl extends RaspberryPiLocalServiceBaseImpl {

	public void turnOn(String color) {
		_raspberryPiService.turnOn(color);
	}

	public void turnOff(String color) {
		_raspberryPiService.turnOff(color);
	}

	@Reference
	private RaspberryPiService _raspberryPiService;

}