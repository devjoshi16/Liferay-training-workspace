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

package com.aixtor.employee.logs.service;

import com.aixtor.employee.logs.model.Auditlogs;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Auditlogs. This utility wraps
 * <code>com.aixtor.employee.logs.service.impl.AuditlogsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuditlogsLocalService
 * @generated
 */
public class AuditlogsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.aixtor.employee.logs.service.impl.AuditlogsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the auditlogs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditlogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditlogs the auditlogs
	 * @return the auditlogs that was added
	 */
	public static Auditlogs addAuditlogs(Auditlogs auditlogs) {
		return getService().addAuditlogs(auditlogs);
	}

	/**
	 * Creates a new auditlogs with the primary key. Does not add the auditlogs to the database.
	 *
	 * @param auditLogsId the primary key for the new auditlogs
	 * @return the new auditlogs
	 */
	public static Auditlogs createAuditlogs(long auditLogsId) {
		return getService().createAuditlogs(auditLogsId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the auditlogs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditlogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditlogs the auditlogs
	 * @return the auditlogs that was removed
	 */
	public static Auditlogs deleteAuditlogs(Auditlogs auditlogs) {
		return getService().deleteAuditlogs(auditlogs);
	}

	/**
	 * Deletes the auditlogs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditlogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs that was removed
	 * @throws PortalException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs deleteAuditlogs(long auditLogsId)
		throws PortalException {

		return getService().deleteAuditlogs(auditLogsId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.employee.logs.model.impl.AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.employee.logs.model.impl.AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Auditlogs fetchAuditlogs(long auditLogsId) {
		return getService().fetchAuditlogs(auditLogsId);
	}

	/**
	 * Returns the auditlogs matching the UUID and group.
	 *
	 * @param uuid the auditlogs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	public static Auditlogs fetchAuditlogsByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAuditlogsByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the auditlogs with the primary key.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs
	 * @throws PortalException if a auditlogs with the primary key could not be found
	 */
	public static Auditlogs getAuditlogs(long auditLogsId)
		throws PortalException {

		return getService().getAuditlogs(auditLogsId);
	}

	/**
	 * Returns the auditlogs matching the UUID and group.
	 *
	 * @param uuid the auditlogs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auditlogs
	 * @throws PortalException if a matching auditlogs could not be found
	 */
	public static Auditlogs getAuditlogsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAuditlogsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the auditlogses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.employee.logs.model.impl.AuditlogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @return the range of auditlogses
	 */
	public static List<Auditlogs> getAuditlogses(int start, int end) {
		return getService().getAuditlogses(start, end);
	}

	/**
	 * Returns all the auditlogses matching the UUID and company.
	 *
	 * @param uuid the UUID of the auditlogses
	 * @param companyId the primary key of the company
	 * @return the matching auditlogses, or an empty list if no matches were found
	 */
	public static List<Auditlogs> getAuditlogsesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAuditlogsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of auditlogses matching the UUID and company.
	 *
	 * @param uuid the UUID of the auditlogses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of auditlogses
	 * @param end the upper bound of the range of auditlogses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching auditlogses, or an empty list if no matches were found
	 */
	public static List<Auditlogs> getAuditlogsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Auditlogs> orderByComparator) {

		return getService().getAuditlogsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of auditlogses.
	 *
	 * @return the number of auditlogses
	 */
	public static int getAuditlogsesCount() {
		return getService().getAuditlogsesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the auditlogs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditlogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditlogs the auditlogs
	 * @return the auditlogs that was updated
	 */
	public static Auditlogs updateAuditlogs(Auditlogs auditlogs) {
		return getService().updateAuditlogs(auditlogs);
	}

	public static AuditlogsLocalService getService() {
		return _service;
	}

	private static volatile AuditlogsLocalService _service;

}