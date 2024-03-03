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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Auditlogs service. Represents a row in the &quot;Employee_Auditlogs&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AuditlogsModel
 * @generated
 */
@ImplementationClassName("com.aixtor.employee.logs.model.impl.AuditlogsImpl")
@ProviderType
public interface Auditlogs extends AuditlogsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.aixtor.employee.logs.model.impl.AuditlogsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Auditlogs, Long> AUDIT_LOGS_ID_ACCESSOR =
		new Accessor<Auditlogs, Long>() {

			@Override
			public Long get(Auditlogs auditlogs) {
				return auditlogs.getAuditLogsId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Auditlogs> getTypeClass() {
				return Auditlogs.class;
			}

		};

}