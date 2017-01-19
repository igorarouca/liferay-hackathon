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

package com.liferay.portal.hackathon.raspberrypi.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portal.hackathon.raspberrypi.service.http.RaspberryPiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.hackathon.raspberrypi.service.http.RaspberryPiServiceSoap
 * @generated
 */
@ProviderType
public class RaspberryPiSoap implements Serializable {
	public static RaspberryPiSoap toSoapModel(RaspberryPi model) {
		RaspberryPiSoap soapModel = new RaspberryPiSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRaspberryId(model.getRaspberryId());

		return soapModel;
	}

	public static RaspberryPiSoap[] toSoapModels(RaspberryPi[] models) {
		RaspberryPiSoap[] soapModels = new RaspberryPiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RaspberryPiSoap[][] toSoapModels(RaspberryPi[][] models) {
		RaspberryPiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RaspberryPiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RaspberryPiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RaspberryPiSoap[] toSoapModels(List<RaspberryPi> models) {
		List<RaspberryPiSoap> soapModels = new ArrayList<RaspberryPiSoap>(models.size());

		for (RaspberryPi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RaspberryPiSoap[soapModels.size()]);
	}

	public RaspberryPiSoap() {
	}

	public long getPrimaryKey() {
		return _raspberryId;
	}

	public void setPrimaryKey(long pk) {
		setRaspberryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRaspberryId() {
		return _raspberryId;
	}

	public void setRaspberryId(long raspberryId) {
		_raspberryId = raspberryId;
	}

	private String _uuid;
	private long _raspberryId;
}