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

package com.aixtor.employee.logs.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Auditlogs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Auditlogs
 * @generated
 */
public class AuditlogsWrapper
	extends BaseModelWrapper<Auditlogs>
	implements Auditlogs, ModelWrapper<Auditlogs> {

	public AuditlogsWrapper(Auditlogs auditlogs) {
		super(auditlogs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("auditLogsId", getAuditLogsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("action", getAction());
		attributes.put("moduleName", getModuleName());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long auditLogsId = (Long)attributes.get("auditLogsId");

		if (auditLogsId != null) {
			setAuditLogsId(auditLogsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public Auditlogs cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the action of this auditlogs.
	 *
	 * @return the action of this auditlogs
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the audit logs ID of this auditlogs.
	 *
	 * @return the audit logs ID of this auditlogs
	 */
	@Override
	public long getAuditLogsId() {
		return model.getAuditLogsId();
	}

	/**
	 * Returns the company ID of this auditlogs.
	 *
	 * @return the company ID of this auditlogs
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this auditlogs.
	 *
	 * @return the create date of this auditlogs
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this auditlogs.
	 *
	 * @return the created by of this auditlogs
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this auditlogs.
	 *
	 * @return the group ID of this auditlogs
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this auditlogs.
	 *
	 * @return the modified by of this auditlogs
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this auditlogs.
	 *
	 * @return the modified date of this auditlogs
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the module name of this auditlogs.
	 *
	 * @return the module name of this auditlogs
	 */
	@Override
	public String getModuleName() {
		return model.getModuleName();
	}

	/**
	 * Returns the primary key of this auditlogs.
	 *
	 * @return the primary key of this auditlogs
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this auditlogs.
	 *
	 * @return the user ID of this auditlogs
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this auditlogs.
	 *
	 * @return the user name of this auditlogs
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this auditlogs.
	 *
	 * @return the user uuid of this auditlogs
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this auditlogs.
	 *
	 * @return the uuid of this auditlogs
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action of this auditlogs.
	 *
	 * @param action the action of this auditlogs
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the audit logs ID of this auditlogs.
	 *
	 * @param auditLogsId the audit logs ID of this auditlogs
	 */
	@Override
	public void setAuditLogsId(long auditLogsId) {
		model.setAuditLogsId(auditLogsId);
	}

	/**
	 * Sets the company ID of this auditlogs.
	 *
	 * @param companyId the company ID of this auditlogs
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this auditlogs.
	 *
	 * @param createDate the create date of this auditlogs
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this auditlogs.
	 *
	 * @param createdBy the created by of this auditlogs
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this auditlogs.
	 *
	 * @param groupId the group ID of this auditlogs
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this auditlogs.
	 *
	 * @param modifiedBy the modified by of this auditlogs
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this auditlogs.
	 *
	 * @param modifiedDate the modified date of this auditlogs
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the module name of this auditlogs.
	 *
	 * @param moduleName the module name of this auditlogs
	 */
	@Override
	public void setModuleName(String moduleName) {
		model.setModuleName(moduleName);
	}

	/**
	 * Sets the primary key of this auditlogs.
	 *
	 * @param primaryKey the primary key of this auditlogs
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this auditlogs.
	 *
	 * @param userId the user ID of this auditlogs
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this auditlogs.
	 *
	 * @param userName the user name of this auditlogs
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this auditlogs.
	 *
	 * @param userUuid the user uuid of this auditlogs
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this auditlogs.
	 *
	 * @param uuid the uuid of this auditlogs
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AuditlogsWrapper wrap(Auditlogs auditlogs) {
		return new AuditlogsWrapper(auditlogs);
	}

}