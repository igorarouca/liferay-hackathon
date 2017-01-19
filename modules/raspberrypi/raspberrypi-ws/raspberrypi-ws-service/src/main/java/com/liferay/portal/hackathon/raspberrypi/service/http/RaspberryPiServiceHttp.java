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

package com.liferay.portal.hackathon.raspberrypi.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.hackathon.raspberrypi.service.RaspberryPiServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link RaspberryPiServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RaspberryPiServiceSoap
 * @see HttpPrincipal
 * @see RaspberryPiServiceUtil
 * @generated
 */
@ProviderType
public class RaspberryPiServiceHttp {
	public static void turnOn(HttpPrincipal httpPrincipal,
		java.lang.String color) {
		try {
			MethodKey methodKey = new MethodKey(RaspberryPiServiceUtil.class,
					"turnOn", _turnOnParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, color);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void turnOff(HttpPrincipal httpPrincipal,
		java.lang.String color) {
		try {
			MethodKey methodKey = new MethodKey(RaspberryPiServiceUtil.class,
					"turnOff", _turnOffParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, color);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RaspberryPiServiceHttp.class);
	private static final Class<?>[] _turnOnParameterTypes0 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _turnOffParameterTypes1 = new Class[] {
			java.lang.String.class
		};
}