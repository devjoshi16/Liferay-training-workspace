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

package com.aixtor.employee.service.base;

import com.aixtor.employee.model.Department;
import com.aixtor.employee.service.DepartmentService;
import com.aixtor.employee.service.DepartmentServiceUtil;
import com.aixtor.employee.service.persistence.BranchPersistence;
import com.aixtor.employee.service.persistence.CityPersistence;
import com.aixtor.employee.service.persistence.DepartmentPersistence;
import com.aixtor.employee.service.persistence.DesignationPersistence;
import com.aixtor.employee.service.persistence.EmployeeFinder;
import com.aixtor.employee.service.persistence.EmployeePersistence;
import com.aixtor.employee.service.persistence.StatePersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the department remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.aixtor.employee.service.impl.DepartmentServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.aixtor.employee.service.impl.DepartmentServiceImpl
 * @generated
 */
public abstract class DepartmentServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, DepartmentService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DepartmentService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DepartmentServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DepartmentService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		departmentService = (DepartmentService)aopProxy;

		_setServiceUtilService(departmentService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DepartmentService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Department.class;
	}

	protected String getModelClassName() {
		return Department.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = departmentPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(DepartmentService departmentService) {
		try {
			Field field = DepartmentServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, departmentService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected BranchPersistence branchPersistence;

	@Reference
	protected CityPersistence cityPersistence;

	@Reference
	protected com.aixtor.employee.service.DepartmentLocalService
		departmentLocalService;

	protected DepartmentService departmentService;

	@Reference
	protected DepartmentPersistence departmentPersistence;

	@Reference
	protected DesignationPersistence designationPersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeeFinder employeeFinder;

	@Reference
	protected StatePersistence statePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	private static final Log _log = LogFactoryUtil.getLog(
		DepartmentServiceBaseImpl.class);

}