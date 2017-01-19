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
 * Provides a wrapper for {@link RaspberryPiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RaspberryPiLocalService
 * @generated
 */
@ProviderType
public class RaspberryPiLocalServiceWrapper implements RaspberryPiLocalService,
	ServiceWrapper<RaspberryPiLocalService> {
	public RaspberryPiLocalServiceWrapper(
		RaspberryPiLocalService raspberryPiLocalService) {
		_raspberryPiLocalService = raspberryPiLocalService;
	}

	/**
	* Adds the raspberry pi to the database. Also notifies the appropriate model listeners.
	*
	* @param raspberryPi the raspberry pi
	* @return the raspberry pi that was added
	*/
	@Override
	public com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi addRaspberryPi(
		com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi raspberryPi) {
		return _raspberryPiLocalService.addRaspberryPi(raspberryPi);
	}

	/**
	* Creates a new raspberry pi with the primary key. Does not add the raspberry pi to the database.
	*
	* @param raspberryId the primary key for the new raspberry pi
	* @return the new raspberry pi
	*/
	@Override
	public com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi createRaspberryPi(
		long raspberryId) {
		return _raspberryPiLocalService.createRaspberryPi(raspberryId);
	}

	/**
	* Deletes the raspberry pi from the database. Also notifies the appropriate model listeners.
	*
	* @param raspberryPi the raspberry pi
	* @return the raspberry pi that was removed
	*/
	@Override
	public com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi deleteRaspberryPi(
		com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi raspberryPi) {
		return _raspberryPiLocalService.deleteRaspberryPi(raspberryPi);
	}

	/**
	* Deletes the raspberry pi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi that was removed
	* @throws PortalException if a raspberry pi with the primary key could not be found
	*/
	@Override
	public com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi deleteRaspberryPi(
		long raspberryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _raspberryPiLocalService.deleteRaspberryPi(raspberryId);
	}

	@Override
	public com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi fetchRaspberryPi(
		long raspberryId) {
		return _raspberryPiLocalService.fetchRaspberryPi(raspberryId);
	}

	/**
	* Returns the raspberry pi with the primary key.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi
	* @throws PortalException if a raspberry pi with the primary key could not be found
	*/
	@Override
	public com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi getRaspberryPi(
		long raspberryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _raspberryPiLocalService.getRaspberryPi(raspberryId);
	}

	/**
	* Updates the raspberry pi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param raspberryPi the raspberry pi
	* @return the raspberry pi that was updated
	*/
	@Override
	public com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi updateRaspberryPi(
		com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi raspberryPi) {
		return _raspberryPiLocalService.updateRaspberryPi(raspberryPi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _raspberryPiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _raspberryPiLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _raspberryPiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _raspberryPiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _raspberryPiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of raspberry pis.
	*
	* @return the number of raspberry pis
	*/
	@Override
	public int getRaspberryPisCount() {
		return _raspberryPiLocalService.getRaspberryPisCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _raspberryPiLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _raspberryPiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.hackathon.raspberrypi.model.impl.RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _raspberryPiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.hackathon.raspberrypi.model.impl.RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _raspberryPiLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the raspberry pis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.hackathon.raspberrypi.model.impl.RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of raspberry pis
	* @param end the upper bound of the range of raspberry pis (not inclusive)
	* @return the range of raspberry pis
	*/
	@Override
	public java.util.List<com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi> getRaspberryPis(
		int start, int end) {
		return _raspberryPiLocalService.getRaspberryPis(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _raspberryPiLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _raspberryPiLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public void turnOff(java.lang.String color) {
		_raspberryPiLocalService.turnOff(color);
	}

	@Override
	public void turnOn(java.lang.String color) {
		_raspberryPiLocalService.turnOn(color);
	}

	@Override
	public RaspberryPiLocalService getWrappedService() {
		return _raspberryPiLocalService;
	}

	@Override
	public void setWrappedService(
		RaspberryPiLocalService raspberryPiLocalService) {
		_raspberryPiLocalService = raspberryPiLocalService;
	}

	private RaspberryPiLocalService _raspberryPiLocalService;
}