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

package com.aixtor.employee.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Branch service. Represents a row in the &quot;Employee_Branch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.aixtor.employee.model.impl.BranchModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.aixtor.employee.model.impl.BranchImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Branch
 * @generated
 */
@ProviderType
public interface BranchModel
	extends BaseModel<Branch>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a branch model instance should use the {@link Branch} interface instead.
	 */

	/**
	 * Returns the primary key of this branch.
	 *
	 * @return the primary key of this branch
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this branch.
	 *
	 * @param primaryKey the primary key of this branch
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this branch.
	 *
	 * @return the uuid of this branch
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this branch.
	 *
	 * @param uuid the uuid of this branch
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the branch ID of this branch.
	 *
	 * @return the branch ID of this branch
	 */
	public long getBranchId();

	/**
	 * Sets the branch ID of this branch.
	 *
	 * @param branchId the branch ID of this branch
	 */
	public void setBranchId(long branchId);

	/**
	 * Returns the group ID of this branch.
	 *
	 * @return the group ID of this branch
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this branch.
	 *
	 * @param groupId the group ID of this branch
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this branch.
	 *
	 * @return the company ID of this branch
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this branch.
	 *
	 * @param companyId the company ID of this branch
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this branch.
	 *
	 * @return the user ID of this branch
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this branch.
	 *
	 * @param userId the user ID of this branch
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this branch.
	 *
	 * @return the user uuid of this branch
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this branch.
	 *
	 * @param userUuid the user uuid of this branch
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this branch.
	 *
	 * @return the user name of this branch
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this branch.
	 *
	 * @param userName the user name of this branch
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this branch.
	 *
	 * @return the create date of this branch
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this branch.
	 *
	 * @param createDate the create date of this branch
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this branch.
	 *
	 * @return the modified date of this branch
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this branch.
	 *
	 * @param modifiedDate the modified date of this branch
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this branch.
	 *
	 * @return the name of this branch
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this branch.
	 *
	 * @param name the name of this branch
	 */
	public void setName(String name);

	/**
	 * Returns the country ID of this branch.
	 *
	 * @return the country ID of this branch
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this branch.
	 *
	 * @param countryId the country ID of this branch
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the state ID of this branch.
	 *
	 * @return the state ID of this branch
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this branch.
	 *
	 * @param stateId the state ID of this branch
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the city ID of this branch.
	 *
	 * @return the city ID of this branch
	 */
	public long getCityId();

	/**
	 * Sets the city ID of this branch.
	 *
	 * @param cityId the city ID of this branch
	 */
	public void setCityId(long cityId);

	@Override
	public Branch cloneWithOriginalValues();

}