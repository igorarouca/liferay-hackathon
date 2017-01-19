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

package com.liferay.portal.hackathon.raspberrypi.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the raspberry pi service. This utility wraps {@link com.liferay.portal.hackathon.raspberrypi.service.persistence.impl.RaspberryPiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RaspberryPiPersistence
 * @see com.liferay.portal.hackathon.raspberrypi.service.persistence.impl.RaspberryPiPersistenceImpl
 * @generated
 */
@ProviderType
public class RaspberryPiUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(RaspberryPi raspberryPi) {
		getPersistence().clearCache(raspberryPi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RaspberryPi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RaspberryPi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RaspberryPi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RaspberryPi> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RaspberryPi update(RaspberryPi raspberryPi) {
		return getPersistence().update(raspberryPi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RaspberryPi update(RaspberryPi raspberryPi,
		ServiceContext serviceContext) {
		return getPersistence().update(raspberryPi, serviceContext);
	}

	/**
	* Returns all the raspberry pis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching raspberry pis
	*/
	public static List<RaspberryPi> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the raspberry pis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of raspberry pis
	* @param end the upper bound of the range of raspberry pis (not inclusive)
	* @return the range of matching raspberry pis
	*/
	public static List<RaspberryPi> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the raspberry pis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of raspberry pis
	* @param end the upper bound of the range of raspberry pis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching raspberry pis
	*/
	public static List<RaspberryPi> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<RaspberryPi> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the raspberry pis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of raspberry pis
	* @param end the upper bound of the range of raspberry pis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching raspberry pis
	*/
	public static List<RaspberryPi> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<RaspberryPi> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching raspberry pi
	* @throws NoSuchRaspberryPiException if a matching raspberry pi could not be found
	*/
	public static RaspberryPi findByUuid_First(java.lang.String uuid,
		OrderByComparator<RaspberryPi> orderByComparator)
		throws com.liferay.portal.hackathon.raspberrypi.exception.NoSuchRaspberryPiException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching raspberry pi, or <code>null</code> if a matching raspberry pi could not be found
	*/
	public static RaspberryPi fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<RaspberryPi> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching raspberry pi
	* @throws NoSuchRaspberryPiException if a matching raspberry pi could not be found
	*/
	public static RaspberryPi findByUuid_Last(java.lang.String uuid,
		OrderByComparator<RaspberryPi> orderByComparator)
		throws com.liferay.portal.hackathon.raspberrypi.exception.NoSuchRaspberryPiException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching raspberry pi, or <code>null</code> if a matching raspberry pi could not be found
	*/
	public static RaspberryPi fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<RaspberryPi> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the raspberry pis before and after the current raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param raspberryId the primary key of the current raspberry pi
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next raspberry pi
	* @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	*/
	public static RaspberryPi[] findByUuid_PrevAndNext(long raspberryId,
		java.lang.String uuid, OrderByComparator<RaspberryPi> orderByComparator)
		throws com.liferay.portal.hackathon.raspberrypi.exception.NoSuchRaspberryPiException {
		return getPersistence()
				   .findByUuid_PrevAndNext(raspberryId, uuid, orderByComparator);
	}

	/**
	* Removes all the raspberry pis where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of raspberry pis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching raspberry pis
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the raspberry pi in the entity cache if it is enabled.
	*
	* @param raspberryPi the raspberry pi
	*/
	public static void cacheResult(RaspberryPi raspberryPi) {
		getPersistence().cacheResult(raspberryPi);
	}

	/**
	* Caches the raspberry pis in the entity cache if it is enabled.
	*
	* @param raspberryPis the raspberry pis
	*/
	public static void cacheResult(List<RaspberryPi> raspberryPis) {
		getPersistence().cacheResult(raspberryPis);
	}

	/**
	* Creates a new raspberry pi with the primary key. Does not add the raspberry pi to the database.
	*
	* @param raspberryId the primary key for the new raspberry pi
	* @return the new raspberry pi
	*/
	public static RaspberryPi create(long raspberryId) {
		return getPersistence().create(raspberryId);
	}

	/**
	* Removes the raspberry pi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi that was removed
	* @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	*/
	public static RaspberryPi remove(long raspberryId)
		throws com.liferay.portal.hackathon.raspberrypi.exception.NoSuchRaspberryPiException {
		return getPersistence().remove(raspberryId);
	}

	public static RaspberryPi updateImpl(RaspberryPi raspberryPi) {
		return getPersistence().updateImpl(raspberryPi);
	}

	/**
	* Returns the raspberry pi with the primary key or throws a {@link NoSuchRaspberryPiException} if it could not be found.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi
	* @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	*/
	public static RaspberryPi findByPrimaryKey(long raspberryId)
		throws com.liferay.portal.hackathon.raspberrypi.exception.NoSuchRaspberryPiException {
		return getPersistence().findByPrimaryKey(raspberryId);
	}

	/**
	* Returns the raspberry pi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi, or <code>null</code> if a raspberry pi with the primary key could not be found
	*/
	public static RaspberryPi fetchByPrimaryKey(long raspberryId) {
		return getPersistence().fetchByPrimaryKey(raspberryId);
	}

	public static java.util.Map<java.io.Serializable, RaspberryPi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the raspberry pis.
	*
	* @return the raspberry pis
	*/
	public static List<RaspberryPi> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the raspberry pis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of raspberry pis
	* @param end the upper bound of the range of raspberry pis (not inclusive)
	* @return the range of raspberry pis
	*/
	public static List<RaspberryPi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the raspberry pis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of raspberry pis
	* @param end the upper bound of the range of raspberry pis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of raspberry pis
	*/
	public static List<RaspberryPi> findAll(int start, int end,
		OrderByComparator<RaspberryPi> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the raspberry pis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RaspberryPiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of raspberry pis
	* @param end the upper bound of the range of raspberry pis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of raspberry pis
	*/
	public static List<RaspberryPi> findAll(int start, int end,
		OrderByComparator<RaspberryPi> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the raspberry pis from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of raspberry pis.
	*
	* @return the number of raspberry pis
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RaspberryPiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RaspberryPiPersistence, RaspberryPiPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RaspberryPiPersistence.class);
}