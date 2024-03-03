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

package com.aixtor.employee.logs.service.persistence;

import com.aixtor.employee.logs.model.Auditlogs;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the auditlogs service. This utility wraps <code>com.aixtor.employee.logs.service.persistence.impl.AuditlogsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditlogsPersistence
 * @generated
 */
public class AuditlogsUtil {

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
	public static void clearCache(Auditlogs auditlogs) {
		getPersistence().clearCache(auditlogs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Auditlogs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Auditlogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Auditlogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Auditlogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Auditlogs update(Auditlogs auditlogs) {
		return getPersistence().update(auditlogs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Auditlogs update(
		Auditlogs auditlogs, ServiceContext serviceContext) {

		return getPersistence().update(auditlogs, serviceContext);
	}

	/**
	 * Returns all the auditlogses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditlogses
	 */
	public static List<Auditlogs> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the auditlogses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @return the range of matching auditlogses
	 */
	public static List<Auditlogs> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the auditlogses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditlogses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByUuid_First(
			String uuid, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByUuid_First(
		String uuid, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByUuid_Last(
			String uuid, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByUuid_Last(
		String uuid, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the auditlogses before and after the current auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param auditLogsId the primary key of the current auditlogs
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs[] findByUuid_PrevAndNext(
			long auditLogsId, String uuid,
			OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByUuid_PrevAndNext(
			auditLogsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the auditlogses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of auditlogses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditlogses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the auditlogs where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditlogsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByUUID_G(String uuid, long groupId)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the auditlogs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the auditlogs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the auditlogs where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the auditlogs that was removed
	 */
	public static Auditlogs removeByUUID_G(String uuid, long groupId)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of auditlogses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching auditlogses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the auditlogses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching auditlogses
	 */
	public static List<Auditlogs> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the auditlogses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @return the range of matching auditlogses
	 */
	public static List<Auditlogs> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the auditlogses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditlogses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the auditlogses before and after the current auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param auditLogsId the primary key of the current auditlogs
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs[] findByUuid_C_PrevAndNext(
			long auditLogsId, String uuid, long companyId,
			OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			auditLogsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the auditlogses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of auditlogses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching auditlogses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the auditlogses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId) {

		return getPersistence().findByGetAuditDataByAuditLogId(auditLogsId);
	}

	/**
	 * Returns a range of all the auditlogses where auditLogsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param auditLogsId the audit logs ID
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @return the range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end) {

		return getPersistence().findByGetAuditDataByAuditLogId(
			auditLogsId, start, end);
	}

	/**
	 * Returns an ordered range of all the auditlogses where auditLogsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param auditLogsId the audit logs ID
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().findByGetAuditDataByAuditLogId(
			auditLogsId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditlogses where auditLogsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param auditLogsId the audit logs ID
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGetAuditDataByAuditLogId(
			auditLogsId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByGetAuditDataByAuditLogId_First(
			long auditLogsId, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByAuditLogId_First(
			auditLogsId, orderByComparator);
	}

	/**
	 * Returns the first auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByGetAuditDataByAuditLogId_First(
		long auditLogsId, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAuditLogId_First(
			auditLogsId, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByGetAuditDataByAuditLogId_Last(
			long auditLogsId, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByAuditLogId_Last(
			auditLogsId, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByGetAuditDataByAuditLogId_Last(
		long auditLogsId, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAuditLogId_Last(
			auditLogsId, orderByComparator);
	}

	/**
	 * Removes all the auditlogses where auditLogsId = &#63; from the database.
	 *
	 * @param auditLogsId the audit logs ID
	 */
	public static void removeByGetAuditDataByAuditLogId(long auditLogsId) {
		getPersistence().removeByGetAuditDataByAuditLogId(auditLogsId);
	}

	/**
	 * Returns the number of auditlogses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the number of matching auditlogses
	 */
	public static int countByGetAuditDataByAuditLogId(long auditLogsId) {
		return getPersistence().countByGetAuditDataByAuditLogId(auditLogsId);
	}

	/**
	 * Returns all the auditlogses where action = &#63;.
	 *
	 * @param action the action
	 * @return the matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAction(String action) {
		return getPersistence().findByGetAuditDataByAction(action);
	}

	/**
	 * Returns a range of all the auditlogses where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @return the range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAction(
		String action, int start, int end) {

		return getPersistence().findByGetAuditDataByAction(action, start, end);
	}

	/**
	 * Returns an ordered range of all the auditlogses where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAction(
		String action, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().findByGetAuditDataByAction(
			action, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditlogses where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByAction(
		String action, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGetAuditDataByAction(
			action, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByGetAuditDataByAction_First(
			String action, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByAction_First(
			action, orderByComparator);
	}

	/**
	 * Returns the first auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByGetAuditDataByAction_First(
		String action, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAction_First(
			action, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByGetAuditDataByAction_Last(
			String action, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByAction_Last(
			action, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByGetAuditDataByAction_Last(
		String action, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAction_Last(
			action, orderByComparator);
	}

	/**
	 * Returns the auditlogses before and after the current auditlogs in the ordered set where action = &#63;.
	 *
	 * @param auditLogsId the primary key of the current auditlogs
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs[] findByGetAuditDataByAction_PrevAndNext(
			long auditLogsId, String action,
			OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByAction_PrevAndNext(
			auditLogsId, action, orderByComparator);
	}

	/**
	 * Removes all the auditlogses where action = &#63; from the database.
	 *
	 * @param action the action
	 */
	public static void removeByGetAuditDataByAction(String action) {
		getPersistence().removeByGetAuditDataByAction(action);
	}

	/**
	 * Returns the number of auditlogses where action = &#63;.
	 *
	 * @param action the action
	 * @return the number of matching auditlogses
	 */
	public static int countByGetAuditDataByAction(String action) {
		return getPersistence().countByGetAuditDataByAction(action);
	}

	/**
	 * Returns all the auditlogses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName) {

		return getPersistence().findByGetAuditDataByModuleName(moduleName);
	}

	/**
	 * Returns a range of all the auditlogses where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @return the range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end) {

		return getPersistence().findByGetAuditDataByModuleName(
			moduleName, start, end);
	}

	/**
	 * Returns an ordered range of all the auditlogses where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().findByGetAuditDataByModuleName(
			moduleName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditlogses where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auditlogses
	 */
	public static List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGetAuditDataByModuleName(
			moduleName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByGetAuditDataByModuleName_First(
			String moduleName, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByModuleName_First(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the first auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByGetAuditDataByModuleName_First(
		String moduleName, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByModuleName_First(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public static Auditlogs findByGetAuditDataByModuleName_Last(
			String moduleName, OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByModuleName_Last(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the last auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchByGetAuditDataByModuleName_Last(
		String moduleName, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByModuleName_Last(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the auditlogses before and after the current auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param auditLogsId the primary key of the current auditlogs
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs[] findByGetAuditDataByModuleName_PrevAndNext(
			long auditLogsId, String moduleName,
			OrderByComparator<Auditlogs> orderByComparator)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByGetAuditDataByModuleName_PrevAndNext(
			auditLogsId, moduleName, orderByComparator);
	}

	/**
	 * Removes all the auditlogses where moduleName = &#63; from the database.
	 *
	 * @param moduleName the module name
	 */
	public static void removeByGetAuditDataByModuleName(String moduleName) {
		getPersistence().removeByGetAuditDataByModuleName(moduleName);
	}

	/**
	 * Returns the number of auditlogses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the number of matching auditlogses
	 */
	public static int countByGetAuditDataByModuleName(String moduleName) {
		return getPersistence().countByGetAuditDataByModuleName(moduleName);
	}

	/**
	 * Caches the auditlogs in the entity cache if it is enabled.
	 *
	 * @param auditlogs the auditlogs
	 */
	public static void cacheResult(Auditlogs auditlogs) {
		getPersistence().cacheResult(auditlogs);
	}

	/**
	 * Caches the auditlogses in the entity cache if it is enabled.
	 *
	 * @param auditlogses the auditlogses
	 */
	public static void cacheResult(List<Auditlogs> auditlogses) {
		getPersistence().cacheResult(auditlogses);
	}

	/**
	 * Creates a new auditlogs with the primary key. Does not add the auditlogs to the database.
	 *
	 * @param auditLogsId the primary key for the new auditlogs
	 * @return the new auditlogs
	 */
	public static Auditlogs create(long auditLogsId) {
		return getPersistence().create(auditLogsId);
	}

	/**
	 * Removes the auditlogs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs that was removed
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs remove(long auditLogsId)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().remove(auditLogsId);
	}

	public static Auditlogs updateImpl(Auditlogs auditlogs) {
		return getPersistence().updateImpl(auditlogs);
	}

	/**
	 * Returns the auditlogs with the primary key or throws a <code>NoSuchAuditlogsException</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs findByPrimaryKey(long auditLogsId)
		throws com.aixtor.employee.logs.exception.NoSuchAuditlogsException {

		return getPersistence().findByPrimaryKey(auditLogsId);
	}

	/**
	 * Returns the auditlogs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs, or <code>null</code> if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs fetchByPrimaryKey(long auditLogsId) {
		return getPersistence().fetchByPrimaryKey(auditLogsId);
	}

	/**
	 * Returns all the auditlogses.
	 *
	 * @return the auditlogses
	 */
	public static List<Auditlogs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the auditlogses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @return the range of auditlogses
	 */
	public static List<Auditlogs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the auditlogses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditlogses
	 */
	public static List<Auditlogs> findAll(
		int start, int end, OrderByComparator<Auditlogs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auditlogses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auditlogses
	 */
	public static List<Auditlogs> findAll(
		int start, int end, OrderByComparator<Auditlogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the auditlogses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of auditlogses.
	 *
	 * @return the number of auditlogses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuditlogsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AuditlogsPersistence _persistence;

}