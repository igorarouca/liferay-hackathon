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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link RaspberryPi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RaspberryPi
 * @generated
 */
@ProviderType
public class RaspberryPiWrapper implements RaspberryPi,
	ModelWrapper<RaspberryPi> {
	public RaspberryPiWrapper(RaspberryPi raspberryPi) {
		_raspberryPi = raspberryPi;
	}

	@Override
	public Class<?> getModelClass() {
		return RaspberryPi.class;
	}

	@Override
	public String getModelClassName() {
		return RaspberryPi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("raspberryId", getRaspberryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long raspberryId = (Long)attributes.get("raspberryId");

		if (raspberryId != null) {
			setRaspberryId(raspberryId);
		}
	}

	@Override
	public RaspberryPi toEscapedModel() {
		return new RaspberryPiWrapper(_raspberryPi.toEscapedModel());
	}

	@Override
	public RaspberryPi toUnescapedModel() {
		return new RaspberryPiWrapper(_raspberryPi.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _raspberryPi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _raspberryPi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _raspberryPi.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _raspberryPi.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<RaspberryPi> toCacheModel() {
		return _raspberryPi.toCacheModel();
	}

	@Override
	public int compareTo(RaspberryPi raspberryPi) {
		return _raspberryPi.compareTo(raspberryPi);
	}

	@Override
	public int hashCode() {
		return _raspberryPi.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _raspberryPi.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RaspberryPiWrapper((RaspberryPi)_raspberryPi.clone());
	}

	/**
	* Returns the uuid of this raspberry pi.
	*
	* @return the uuid of this raspberry pi
	*/
	@Override
	public java.lang.String getUuid() {
		return _raspberryPi.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _raspberryPi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _raspberryPi.toXmlString();
	}

	/**
	* Returns the primary key of this raspberry pi.
	*
	* @return the primary key of this raspberry pi
	*/
	@Override
	public long getPrimaryKey() {
		return _raspberryPi.getPrimaryKey();
	}

	/**
	* Returns the raspberry ID of this raspberry pi.
	*
	* @return the raspberry ID of this raspberry pi
	*/
	@Override
	public long getRaspberryId() {
		return _raspberryPi.getRaspberryId();
	}

	@Override
	public void persist() {
		_raspberryPi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_raspberryPi.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_raspberryPi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_raspberryPi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_raspberryPi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_raspberryPi.setNew(n);
	}

	/**
	* Sets the primary key of this raspberry pi.
	*
	* @param primaryKey the primary key of this raspberry pi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_raspberryPi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_raspberryPi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the raspberry ID of this raspberry pi.
	*
	* @param raspberryId the raspberry ID of this raspberry pi
	*/
	@Override
	public void setRaspberryId(long raspberryId) {
		_raspberryPi.setRaspberryId(raspberryId);
	}

	/**
	* Sets the uuid of this raspberry pi.
	*
	* @param uuid the uuid of this raspberry pi
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_raspberryPi.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RaspberryPiWrapper)) {
			return false;
		}

		RaspberryPiWrapper raspberryPiWrapper = (RaspberryPiWrapper)obj;

		if (Objects.equals(_raspberryPi, raspberryPiWrapper._raspberryPi)) {
			return true;
		}

		return false;
	}

	@Override
	public RaspberryPi getWrappedModel() {
		return _raspberryPi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _raspberryPi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _raspberryPi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_raspberryPi.resetOriginalValues();
	}

	private final RaspberryPi _raspberryPi;
}