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

package com.liferay.portal.hackathon.raspberrypi.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RaspberryPiService}.
 *
 * @author Brian Wing Shun Chan
 * @see RaspberryPiService
 * @generated
 */
@ProviderType
public class RaspberryPiServiceWrapper implements RaspberryPiService,
	ServiceWrapper<RaspberryPiService> {
	public RaspberryPiServiceWrapper(RaspberryPiService raspberryPiService) {
		_raspberryPiService = raspberryPiService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _raspberryPiService.getOSGiServiceIdentifier();
	}

	@Override
	public void turnOff(java.lang.String color) {
		_raspberryPiService.turnOff(color);
	}

	@Override
	public void turnOn(java.lang.String color) {
		_raspberryPiService.turnOn(color);
	}

	@Override
	public RaspberryPiService getWrappedService() {
		return _raspberryPiService;
	}

	@Override
	public void setWrappedService(RaspberryPiService raspberryPiService) {
		_raspberryPiService = raspberryPiService;
	}

	private RaspberryPiService _raspberryPiService;
}