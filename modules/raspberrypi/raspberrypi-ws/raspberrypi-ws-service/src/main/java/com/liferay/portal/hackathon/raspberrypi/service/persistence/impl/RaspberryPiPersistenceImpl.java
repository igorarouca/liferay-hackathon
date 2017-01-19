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

package com.liferay.portal.hackathon.raspberrypi.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.hackathon.raspberrypi.exception.NoSuchRaspberryPiException;
import com.liferay.portal.hackathon.raspberrypi.model.RaspberryPi;
import com.liferay.portal.hackathon.raspberrypi.model.impl.RaspberryPiImpl;
import com.liferay.portal.hackathon.raspberrypi.model.impl.RaspberryPiModelImpl;
import com.liferay.portal.hackathon.raspberrypi.service.persistence.RaspberryPiPersistence;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the raspberry pi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RaspberryPiPersistence
 * @see com.liferay.portal.hackathon.raspberrypi.service.persistence.RaspberryPiUtil
 * @generated
 */
@ProviderType
public class RaspberryPiPersistenceImpl extends BasePersistenceImpl<RaspberryPi>
	implements RaspberryPiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RaspberryPiUtil} to access the raspberry pi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RaspberryPiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiModelImpl.FINDER_CACHE_ENABLED, RaspberryPiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiModelImpl.FINDER_CACHE_ENABLED, RaspberryPiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiModelImpl.FINDER_CACHE_ENABLED, RaspberryPiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiModelImpl.FINDER_CACHE_ENABLED, RaspberryPiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RaspberryPiModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the raspberry pis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching raspberry pis
	 */
	@Override
	public List<RaspberryPi> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RaspberryPi> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<RaspberryPi> findByUuid(String uuid, int start, int end,
		OrderByComparator<RaspberryPi> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<RaspberryPi> findByUuid(String uuid, int start, int end,
		OrderByComparator<RaspberryPi> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<RaspberryPi> list = null;

		if (retrieveFromCache) {
			list = (List<RaspberryPi>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RaspberryPi raspberryPi : list) {
					if (!Objects.equals(uuid, raspberryPi.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RASPBERRYPI_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RaspberryPiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<RaspberryPi>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RaspberryPi>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first raspberry pi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching raspberry pi
	 * @throws NoSuchRaspberryPiException if a matching raspberry pi could not be found
	 */
	@Override
	public RaspberryPi findByUuid_First(String uuid,
		OrderByComparator<RaspberryPi> orderByComparator)
		throws NoSuchRaspberryPiException {
		RaspberryPi raspberryPi = fetchByUuid_First(uuid, orderByComparator);

		if (raspberryPi != null) {
			return raspberryPi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRaspberryPiException(msg.toString());
	}

	/**
	 * Returns the first raspberry pi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching raspberry pi, or <code>null</code> if a matching raspberry pi could not be found
	 */
	@Override
	public RaspberryPi fetchByUuid_First(String uuid,
		OrderByComparator<RaspberryPi> orderByComparator) {
		List<RaspberryPi> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last raspberry pi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching raspberry pi
	 * @throws NoSuchRaspberryPiException if a matching raspberry pi could not be found
	 */
	@Override
	public RaspberryPi findByUuid_Last(String uuid,
		OrderByComparator<RaspberryPi> orderByComparator)
		throws NoSuchRaspberryPiException {
		RaspberryPi raspberryPi = fetchByUuid_Last(uuid, orderByComparator);

		if (raspberryPi != null) {
			return raspberryPi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRaspberryPiException(msg.toString());
	}

	/**
	 * Returns the last raspberry pi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching raspberry pi, or <code>null</code> if a matching raspberry pi could not be found
	 */
	@Override
	public RaspberryPi fetchByUuid_Last(String uuid,
		OrderByComparator<RaspberryPi> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RaspberryPi> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RaspberryPi[] findByUuid_PrevAndNext(long raspberryId, String uuid,
		OrderByComparator<RaspberryPi> orderByComparator)
		throws NoSuchRaspberryPiException {
		RaspberryPi raspberryPi = findByPrimaryKey(raspberryId);

		Session session = null;

		try {
			session = openSession();

			RaspberryPi[] array = new RaspberryPiImpl[3];

			array[0] = getByUuid_PrevAndNext(session, raspberryPi, uuid,
					orderByComparator, true);

			array[1] = raspberryPi;

			array[2] = getByUuid_PrevAndNext(session, raspberryPi, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RaspberryPi getByUuid_PrevAndNext(Session session,
		RaspberryPi raspberryPi, String uuid,
		OrderByComparator<RaspberryPi> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RASPBERRYPI_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(RaspberryPiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(raspberryPi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RaspberryPi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the raspberry pis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RaspberryPi raspberryPi : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(raspberryPi);
		}
	}

	/**
	 * Returns the number of raspberry pis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching raspberry pis
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RASPBERRYPI_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "raspberryPi.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "raspberryPi.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(raspberryPi.uuid IS NULL OR raspberryPi.uuid = '')";

	public RaspberryPiPersistenceImpl() {
		setModelClass(RaspberryPi.class);
	}

	/**
	 * Caches the raspberry pi in the entity cache if it is enabled.
	 *
	 * @param raspberryPi the raspberry pi
	 */
	@Override
	public void cacheResult(RaspberryPi raspberryPi) {
		entityCache.putResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiImpl.class, raspberryPi.getPrimaryKey(), raspberryPi);

		raspberryPi.resetOriginalValues();
	}

	/**
	 * Caches the raspberry pis in the entity cache if it is enabled.
	 *
	 * @param raspberryPis the raspberry pis
	 */
	@Override
	public void cacheResult(List<RaspberryPi> raspberryPis) {
		for (RaspberryPi raspberryPi : raspberryPis) {
			if (entityCache.getResult(
						RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
						RaspberryPiImpl.class, raspberryPi.getPrimaryKey()) == null) {
				cacheResult(raspberryPi);
			}
			else {
				raspberryPi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all raspberry pis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RaspberryPiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the raspberry pi.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RaspberryPi raspberryPi) {
		entityCache.removeResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiImpl.class, raspberryPi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RaspberryPi> raspberryPis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RaspberryPi raspberryPi : raspberryPis) {
			entityCache.removeResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
				RaspberryPiImpl.class, raspberryPi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new raspberry pi with the primary key. Does not add the raspberry pi to the database.
	 *
	 * @param raspberryId the primary key for the new raspberry pi
	 * @return the new raspberry pi
	 */
	@Override
	public RaspberryPi create(long raspberryId) {
		RaspberryPi raspberryPi = new RaspberryPiImpl();

		raspberryPi.setNew(true);
		raspberryPi.setPrimaryKey(raspberryId);

		String uuid = PortalUUIDUtil.generate();

		raspberryPi.setUuid(uuid);

		return raspberryPi;
	}

	/**
	 * Removes the raspberry pi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param raspberryId the primary key of the raspberry pi
	 * @return the raspberry pi that was removed
	 * @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	 */
	@Override
	public RaspberryPi remove(long raspberryId)
		throws NoSuchRaspberryPiException {
		return remove((Serializable)raspberryId);
	}

	/**
	 * Removes the raspberry pi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the raspberry pi
	 * @return the raspberry pi that was removed
	 * @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	 */
	@Override
	public RaspberryPi remove(Serializable primaryKey)
		throws NoSuchRaspberryPiException {
		Session session = null;

		try {
			session = openSession();

			RaspberryPi raspberryPi = (RaspberryPi)session.get(RaspberryPiImpl.class,
					primaryKey);

			if (raspberryPi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRaspberryPiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(raspberryPi);
		}
		catch (NoSuchRaspberryPiException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected RaspberryPi removeImpl(RaspberryPi raspberryPi) {
		raspberryPi = toUnwrappedModel(raspberryPi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(raspberryPi)) {
				raspberryPi = (RaspberryPi)session.get(RaspberryPiImpl.class,
						raspberryPi.getPrimaryKeyObj());
			}

			if (raspberryPi != null) {
				session.delete(raspberryPi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (raspberryPi != null) {
			clearCache(raspberryPi);
		}

		return raspberryPi;
	}

	@Override
	public RaspberryPi updateImpl(RaspberryPi raspberryPi) {
		raspberryPi = toUnwrappedModel(raspberryPi);

		boolean isNew = raspberryPi.isNew();

		RaspberryPiModelImpl raspberryPiModelImpl = (RaspberryPiModelImpl)raspberryPi;

		if (Validator.isNull(raspberryPi.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			raspberryPi.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (raspberryPi.isNew()) {
				session.save(raspberryPi);

				raspberryPi.setNew(false);
			}
			else {
				raspberryPi = (RaspberryPi)session.merge(raspberryPi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RaspberryPiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((raspberryPiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						raspberryPiModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { raspberryPiModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
			RaspberryPiImpl.class, raspberryPi.getPrimaryKey(), raspberryPi,
			false);

		raspberryPi.resetOriginalValues();

		return raspberryPi;
	}

	protected RaspberryPi toUnwrappedModel(RaspberryPi raspberryPi) {
		if (raspberryPi instanceof RaspberryPiImpl) {
			return raspberryPi;
		}

		RaspberryPiImpl raspberryPiImpl = new RaspberryPiImpl();

		raspberryPiImpl.setNew(raspberryPi.isNew());
		raspberryPiImpl.setPrimaryKey(raspberryPi.getPrimaryKey());

		raspberryPiImpl.setUuid(raspberryPi.getUuid());
		raspberryPiImpl.setRaspberryId(raspberryPi.getRaspberryId());

		return raspberryPiImpl;
	}

	/**
	 * Returns the raspberry pi with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the raspberry pi
	 * @return the raspberry pi
	 * @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	 */
	@Override
	public RaspberryPi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRaspberryPiException {
		RaspberryPi raspberryPi = fetchByPrimaryKey(primaryKey);

		if (raspberryPi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRaspberryPiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return raspberryPi;
	}

	/**
	 * Returns the raspberry pi with the primary key or throws a {@link NoSuchRaspberryPiException} if it could not be found.
	 *
	 * @param raspberryId the primary key of the raspberry pi
	 * @return the raspberry pi
	 * @throws NoSuchRaspberryPiException if a raspberry pi with the primary key could not be found
	 */
	@Override
	public RaspberryPi findByPrimaryKey(long raspberryId)
		throws NoSuchRaspberryPiException {
		return findByPrimaryKey((Serializable)raspberryId);
	}

	/**
	 * Returns the raspberry pi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the raspberry pi
	 * @return the raspberry pi, or <code>null</code> if a raspberry pi with the primary key could not be found
	 */
	@Override
	public RaspberryPi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
				RaspberryPiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RaspberryPi raspberryPi = (RaspberryPi)serializable;

		if (raspberryPi == null) {
			Session session = null;

			try {
				session = openSession();

				raspberryPi = (RaspberryPi)session.get(RaspberryPiImpl.class,
						primaryKey);

				if (raspberryPi != null) {
					cacheResult(raspberryPi);
				}
				else {
					entityCache.putResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
						RaspberryPiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
					RaspberryPiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return raspberryPi;
	}

	/**
	 * Returns the raspberry pi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param raspberryId the primary key of the raspberry pi
	 * @return the raspberry pi, or <code>null</code> if a raspberry pi with the primary key could not be found
	 */
	@Override
	public RaspberryPi fetchByPrimaryKey(long raspberryId) {
		return fetchByPrimaryKey((Serializable)raspberryId);
	}

	@Override
	public Map<Serializable, RaspberryPi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RaspberryPi> map = new HashMap<Serializable, RaspberryPi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RaspberryPi raspberryPi = fetchByPrimaryKey(primaryKey);

			if (raspberryPi != null) {
				map.put(primaryKey, raspberryPi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
					RaspberryPiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RaspberryPi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RASPBERRYPI_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (RaspberryPi raspberryPi : (List<RaspberryPi>)q.list()) {
				map.put(raspberryPi.getPrimaryKeyObj(), raspberryPi);

				cacheResult(raspberryPi);

				uncachedPrimaryKeys.remove(raspberryPi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RaspberryPiModelImpl.ENTITY_CACHE_ENABLED,
					RaspberryPiImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the raspberry pis.
	 *
	 * @return the raspberry pis
	 */
	@Override
	public List<RaspberryPi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RaspberryPi> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<RaspberryPi> findAll(int start, int end,
		OrderByComparator<RaspberryPi> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<RaspberryPi> findAll(int start, int end,
		OrderByComparator<RaspberryPi> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<RaspberryPi> list = null;

		if (retrieveFromCache) {
			list = (List<RaspberryPi>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RASPBERRYPI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RASPBERRYPI;

				if (pagination) {
					sql = sql.concat(RaspberryPiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RaspberryPi>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RaspberryPi>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the raspberry pis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RaspberryPi raspberryPi : findAll()) {
			remove(raspberryPi);
		}
	}

	/**
	 * Returns the number of raspberry pis.
	 *
	 * @return the number of raspberry pis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RASPBERRYPI);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RaspberryPiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the raspberry pi persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RaspberryPiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RASPBERRYPI = "SELECT raspberryPi FROM RaspberryPi raspberryPi";
	private static final String _SQL_SELECT_RASPBERRYPI_WHERE_PKS_IN = "SELECT raspberryPi FROM RaspberryPi raspberryPi WHERE raspberryId IN (";
	private static final String _SQL_SELECT_RASPBERRYPI_WHERE = "SELECT raspberryPi FROM RaspberryPi raspberryPi WHERE ";
	private static final String _SQL_COUNT_RASPBERRYPI = "SELECT COUNT(raspberryPi) FROM RaspberryPi raspberryPi";
	private static final String _SQL_COUNT_RASPBERRYPI_WHERE = "SELECT COUNT(raspberryPi) FROM RaspberryPi raspberryPi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "raspberryPi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RaspberryPi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RaspberryPi exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RaspberryPiPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}