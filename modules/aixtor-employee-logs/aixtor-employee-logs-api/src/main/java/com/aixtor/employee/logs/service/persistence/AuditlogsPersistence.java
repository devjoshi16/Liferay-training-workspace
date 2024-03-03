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

import com.aixtor.employee.logs.exception.NoSuchAuditlogsException;
import com.aixtor.employee.logs.model.Auditlogs;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the auditlogs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditlogsUtil
 * @generated
 */
@ProviderType
public interface AuditlogsPersistence extends BasePersistence<Auditlogs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditlogsUtil} to access the auditlogs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the auditlogses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching auditlogses
	 */
	public java.util.List<Auditlogs> findByUuid(String uuid);

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
	public java.util.List<Auditlogs> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Auditlogs> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

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
	public java.util.List<Auditlogs> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the auditlogses before and after the current auditlogs in the ordered set where uuid = &#63;.
	 *
	 * @param auditLogsId the primary key of the current auditlogs
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public Auditlogs[] findByUuid_PrevAndNext(
			long auditLogsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Removes all the auditlogses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of auditlogses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching auditlogses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the auditlogs where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditlogsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByUUID_G(String uuid, long groupId)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the auditlogs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the auditlogs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the auditlogs where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the auditlogs that was removed
	 */
	public Auditlogs removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the number of auditlogses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching auditlogses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the auditlogses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching auditlogses
	 */
	public java.util.List<Auditlogs> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Auditlogs> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Auditlogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

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
	public java.util.List<Auditlogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the first auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the last auditlogs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

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
	public Auditlogs[] findByUuid_C_PrevAndNext(
			long auditLogsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Removes all the auditlogses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of auditlogses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching auditlogses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the auditlogses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the matching auditlogses
	 */
	public java.util.List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId);

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
	public java.util.List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end);

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
	public java.util.List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

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
	public java.util.List<Auditlogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByGetAuditDataByAuditLogId_First(
			long auditLogsId,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the first auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByGetAuditDataByAuditLogId_First(
		long auditLogsId,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the last auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByGetAuditDataByAuditLogId_Last(
			long auditLogsId,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the last auditlogs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByGetAuditDataByAuditLogId_Last(
		long auditLogsId,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Removes all the auditlogses where auditLogsId = &#63; from the database.
	 *
	 * @param auditLogsId the audit logs ID
	 */
	public void removeByGetAuditDataByAuditLogId(long auditLogsId);

	/**
	 * Returns the number of auditlogses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the number of matching auditlogses
	 */
	public int countByGetAuditDataByAuditLogId(long auditLogsId);

	/**
	 * Returns all the auditlogses where action = &#63;.
	 *
	 * @param action the action
	 * @return the matching auditlogses
	 */
	public java.util.List<Auditlogs> findByGetAuditDataByAction(String action);

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
	public java.util.List<Auditlogs> findByGetAuditDataByAction(
		String action, int start, int end);

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
	public java.util.List<Auditlogs> findByGetAuditDataByAction(
		String action, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

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
	public java.util.List<Auditlogs> findByGetAuditDataByAction(
		String action, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByGetAuditDataByAction_First(
			String action,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the first auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByGetAuditDataByAction_First(
		String action,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the last auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByGetAuditDataByAction_Last(
			String action,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the last auditlogs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByGetAuditDataByAction_Last(
		String action,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the auditlogses before and after the current auditlogs in the ordered set where action = &#63;.
	 *
	 * @param auditLogsId the primary key of the current auditlogs
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public Auditlogs[] findByGetAuditDataByAction_PrevAndNext(
			long auditLogsId, String action,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Removes all the auditlogses where action = &#63; from the database.
	 *
	 * @param action the action
	 */
	public void removeByGetAuditDataByAction(String action);

	/**
	 * Returns the number of auditlogses where action = &#63;.
	 *
	 * @param action the action
	 * @return the number of matching auditlogses
	 */
	public int countByGetAuditDataByAction(String action);

	/**
	 * Returns all the auditlogses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the matching auditlogses
	 */
	public java.util.List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName);

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
	public java.util.List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end);

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
	public java.util.List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

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
	public java.util.List<Auditlogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByGetAuditDataByModuleName_First(
			String moduleName,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the first auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByGetAuditDataByModuleName_First(
		String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the last auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs
	 * @throws NoSuchAuditlogsException if a matching auditlogs could not be found
	 */
	public Auditlogs findByGetAuditDataByModuleName_Last(
			String moduleName,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the last auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public Auditlogs fetchByGetAuditDataByModuleName_Last(
		String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

	/**
	 * Returns the auditlogses before and after the current auditlogs in the ordered set where moduleName = &#63;.
	 *
	 * @param auditLogsId the primary key of the current auditlogs
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public Auditlogs[] findByGetAuditDataByModuleName_PrevAndNext(
			long auditLogsId, String moduleName,
			com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
				orderByComparator)
		throws NoSuchAuditlogsException;

	/**
	 * Removes all the auditlogses where moduleName = &#63; from the database.
	 *
	 * @param moduleName the module name
	 */
	public void removeByGetAuditDataByModuleName(String moduleName);

	/**
	 * Returns the number of auditlogses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the number of matching auditlogses
	 */
	public int countByGetAuditDataByModuleName(String moduleName);

	/**
	 * Caches the auditlogs in the entity cache if it is enabled.
	 *
	 * @param auditlogs the auditlogs
	 */
	public void cacheResult(Auditlogs auditlogs);

	/**
	 * Caches the auditlogses in the entity cache if it is enabled.
	 *
	 * @param auditlogses the auditlogses
	 */
	public void cacheResult(java.util.List<Auditlogs> auditlogses);

	/**
	 * Creates a new auditlogs with the primary key. Does not add the auditlogs to the database.
	 *
	 * @param auditLogsId the primary key for the new auditlogs
	 * @return the new auditlogs
	 */
	public Auditlogs create(long auditLogsId);

	/**
	 * Removes the auditlogs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs that was removed
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public Auditlogs remove(long auditLogsId) throws NoSuchAuditlogsException;

	public Auditlogs updateImpl(Auditlogs auditlogs);

	/**
	 * Returns the auditlogs with the primary key or throws a <code>NoSuchAuditlogsException</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs
	 * @throws NoSuchAuditlogsException if a auditlogs with the primary key could not be found
	 */
	public Auditlogs findByPrimaryKey(long auditLogsId)
		throws NoSuchAuditlogsException;

	/**
	 * Returns the auditlogs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs, or <code>null</code> if a auditlogs with the primary key could not be found
	 */
	public Auditlogs fetchByPrimaryKey(long auditLogsId);

	/**
	 * Returns all the auditlogses.
	 *
	 * @return the auditlogses
	 */
	public java.util.List<Auditlogs> findAll();

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
	public java.util.List<Auditlogs> findAll(int start, int end);

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
	public java.util.List<Auditlogs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator);

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
	public java.util.List<Auditlogs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Auditlogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the auditlogses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of auditlogses.
	 *
	 * @return the number of auditlogses
	 */
	public int countAll();

}