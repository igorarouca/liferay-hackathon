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

import com.liferay.portal.hackathon.raspberrypi.exception.NoSuchRaspberryPiException;
import com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the raspberry pi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.hackathon.raspberrypi.service.persistence.impl.RaspberryPiPersistenceImpl
 * @see RaspberryPiUtil
 * @generated
 */
@ProviderType
public interface RaspberryPiPersistence extends BasePersistence<RaspberryPi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RaspberryPiUtil} to access the raspberry pi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the raspberry pis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching raspberry pis
	*/
	public java.util.List<RaspberryPi> findByUuid(java.lang.String uuid);

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
	public java.util.List<RaspberryPi> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<RaspberryPi> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator);

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
	public java.util.List<RaspberryPi> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching raspberry pi
	* @throws NoSuchRaspberryPiException if a matching raspberry pi could not be found
	*/
	public RaspberryPi findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator)
		throws NoSuchRaspberryPiException;

	/**
	* Returns the first raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching raspberry pi, or <code>null</code> if a matching raspberry pi could not be found
	*/
	public RaspberryPi fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator);

	/**
	* Returns the last raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching raspberry pi
	* @throws NoSuchRaspberryPiException if a matching raspberry pi could not be found
	*/
	public RaspberryPi findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator)
		throws NoSuchRaspberryPiException;

	/**
	* Returns the last raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching raspberry pi, or <code>null</code> if a matching raspberry pi could not be found
	*/
	public RaspberryPi fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator);

	/**
	* Returns the raspberry pis before and after the current raspberry pi in the ordered set where uuid = &#63;.
	*
	* @param raspberryId the primary key of the current raspberry pi
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next raspberry pi
	* @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	*/
	public RaspberryPi[] findByUuid_PrevAndNext(long raspberryId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator)
		throws NoSuchRaspberryPiException;

	/**
	* Removes all the raspberry pis where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of raspberry pis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching raspberry pis
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the raspberry pi in the entity cache if it is enabled.
	*
	* @param raspberryPi the raspberry pi
	*/
	public void cacheResult(RaspberryPi raspberryPi);

	/**
	* Caches the raspberry pis in the entity cache if it is enabled.
	*
	* @param raspberryPis the raspberry pis
	*/
	public void cacheResult(java.util.List<RaspberryPi> raspberryPis);

	/**
	* Creates a new raspberry pi with the primary key. Does not add the raspberry pi to the database.
	*
	* @param raspberryId the primary key for the new raspberry pi
	* @return the new raspberry pi
	*/
	public RaspberryPi create(long raspberryId);

	/**
	* Removes the raspberry pi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi that was removed
	* @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	*/
	public RaspberryPi remove(long raspberryId)
		throws NoSuchRaspberryPiException;

	public RaspberryPi updateImpl(RaspberryPi raspberryPi);

	/**
	* Returns the raspberry pi with the primary key or throws a {@link NoSuchRaspberryPiException} if it could not be found.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi
	* @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	*/
	public RaspberryPi findByPrimaryKey(long raspberryId)
		throws NoSuchRaspberryPiException;

	/**
	* Returns the raspberry pi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param raspberryId the primary key of the raspberry pi
	* @return the raspberry pi, or <code>null</code> if a raspberry pi with the primary key could not be found
	*/
	public RaspberryPi fetchByPrimaryKey(long raspberryId);

	@Override
	public java.util.Map<java.io.Serializable, RaspberryPi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the raspberry pis.
	*
	* @return the raspberry pis
	*/
	public java.util.List<RaspberryPi> findAll();

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
	public java.util.List<RaspberryPi> findAll(int start, int end);

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
	public java.util.List<RaspberryPi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator);

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
	public java.util.List<RaspberryPi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RaspberryPi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the raspberry pis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of raspberry pis.
	*
	* @return the number of raspberry pis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}