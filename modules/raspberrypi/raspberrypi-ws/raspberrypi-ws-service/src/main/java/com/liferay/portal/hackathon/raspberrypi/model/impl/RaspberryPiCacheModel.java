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

package com.liferay.portal.hackathon.raspberrypi.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RaspberryPi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RaspberryPi
 * @generated
 */
@ProviderType
public class RaspberryPiCacheModel implements CacheModel<RaspberryPi>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RaspberryPiCacheModel)) {
			return false;
		}

		RaspberryPiCacheModel raspberryPiCacheModel = (RaspberryPiCacheModel)obj;

		if (raspberryId == raspberryPiCacheModel.raspberryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, raspberryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", raspberryId=");
		sb.append(raspberryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RaspberryPi toEntityModel() {
		RaspberryPiImpl raspberryPiImpl = new RaspberryPiImpl();

		if (uuid == null) {
			raspberryPiImpl.setUuid(StringPool.BLANK);
		}
		else {
			raspberryPiImpl.setUuid(uuid);
		}

		raspberryPiImpl.setRaspberryId(raspberryId);

		raspberryPiImpl.resetOriginalValues();

		return raspberryPiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		raspberryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(raspberryId);
	}

	public String uuid;
	public long raspberryId;
}