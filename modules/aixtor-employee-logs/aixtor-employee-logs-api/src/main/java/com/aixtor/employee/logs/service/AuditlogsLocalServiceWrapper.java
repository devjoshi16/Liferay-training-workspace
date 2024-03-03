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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditlogsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditlogsLocalService
 * @generated
 */
public class AuditlogsLocalServiceWrapper
	implements AuditlogsLocalService, ServiceWrapper<AuditlogsLocalService> {

	public AuditlogsLocalServiceWrapper() {
		this(null);
	}

	public AuditlogsLocalServiceWrapper(
		AuditlogsLocalService auditlogsLocalService) {

		_auditlogsLocalService = auditlogsLocalService;
	}

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
	@Override
	public com.aixtor.employee.logs.model.Auditlogs addAuditlogs(
		com.aixtor.employee.logs.model.Auditlogs auditlogs) {

		return _auditlogsLocalService.addAuditlogs(auditlogs);
	}

	/**
	 * Creates a new auditlogs with the primary key. Does not add the auditlogs to the database.
	 *
	 * @param auditLogsId the primary key for the new auditlogs
	 * @return the new auditlogs
	 */
	@Override
	public com.aixtor.employee.logs.model.Auditlogs createAuditlogs(
		long auditLogsId) {

		return _auditlogsLocalService.createAuditlogs(auditLogsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditlogsLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.aixtor.employee.logs.model.Auditlogs deleteAuditlogs(
		com.aixtor.employee.logs.model.Auditlogs auditlogs) {

		return _auditlogsLocalService.deleteAuditlogs(auditlogs);
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
	@Override
	public com.aixtor.employee.logs.model.Auditlogs deleteAuditlogs(
			long auditLogsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditlogsLocalService.deleteAuditlogs(auditLogsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditlogsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _auditlogsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _auditlogsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _auditlogsLocalService.dynamicQuery();
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

		return _auditlogsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _auditlogsLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _auditlogsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
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

		return _auditlogsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _auditlogsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.aixtor.employee.logs.model.Auditlogs fetchAuditlogs(
		long auditLogsId) {

		return _auditlogsLocalService.fetchAuditlogs(auditLogsId);
	}

	/**
	 * Returns the auditlogs matching the UUID and group.
	 *
	 * @param uuid the auditlogs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auditlogs, or <code>null</code> if a matching auditlogs could not be found
	 */
	@Override
	public com.aixtor.employee.logs.model.Auditlogs
		fetchAuditlogsByUuidAndGroupId(String uuid, long groupId) {

		return _auditlogsLocalService.fetchAuditlogsByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _auditlogsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the auditlogs with the primary key.
	 *
	 * @param auditLogsId the primary key of the auditlogs
	 * @return the auditlogs
	 * @throws PortalException if a auditlogs with the primary key could not be found
	 */
	@Override
	public com.aixtor.employee.logs.model.Auditlogs getAuditlogs(
			long auditLogsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditlogsLocalService.getAuditlogs(auditLogsId);
	}

	/**
	 * Returns the auditlogs matching the UUID and group.
	 *
	 * @param uuid the auditlogs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching auditlogs
	 * @throws PortalException if a matching auditlogs could not be found
	 */
	@Override
	public com.aixtor.employee.logs.model.Auditlogs
			getAuditlogsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditlogsLocalService.getAuditlogsByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.aixtor.employee.logs.model.Auditlogs>
		getAuditlogses(int start, int end) {

		return _auditlogsLocalService.getAuditlogses(start, end);
	}

	/**
	 * Returns all the auditlogses matching the UUID and company.
	 *
	 * @param uuid the UUID of the auditlogses
	 * @param companyId the primary key of the company
	 * @return the matching auditlogses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.employee.logs.model.Auditlogs>
		getAuditlogsesByUuidAndCompanyId(String uuid, long companyId) {

		return _auditlogsLocalService.getAuditlogsesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.aixtor.employee.logs.model.Auditlogs>
		getAuditlogsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.aixtor.employee.logs.model.Auditlogs> orderByComparator) {

		return _auditlogsLocalService.getAuditlogsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of auditlogses.
	 *
	 * @return the number of auditlogses
	 */
	@Override
	public int getAuditlogsesCount() {
		return _auditlogsLocalService.getAuditlogsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _auditlogsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _auditlogsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditlogsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditlogsLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.aixtor.employee.logs.model.Auditlogs updateAuditlogs(
		com.aixtor.employee.logs.model.Auditlogs auditlogs) {

		return _auditlogsLocalService.updateAuditlogs(auditlogs);
	}

	@Override
	public AuditlogsLocalService getWrappedService() {
		return _auditlogsLocalService;
	}

	@Override
	public void setWrappedService(AuditlogsLocalService auditlogsLocalService) {
		_auditlogsLocalService = auditlogsLocalService;
	}

	private AuditlogsLocalService _auditlogsLocalService;

}