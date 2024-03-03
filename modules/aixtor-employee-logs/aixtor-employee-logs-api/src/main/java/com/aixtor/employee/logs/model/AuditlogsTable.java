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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Employee_Auditlogs&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Auditlogs
 * @generated
 */
public class AuditlogsTable extends BaseTable<AuditlogsTable> {

	public static final AuditlogsTable INSTANCE = new AuditlogsTable();

	public final Column<AuditlogsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, Long> auditLogsId = createColumn(
		"auditLogsId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AuditlogsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, String> action = createColumn(
		"action", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, String> moduleName = createColumn(
		"moduleName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditlogsTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AuditlogsTable() {
		super("Employee_Auditlogs", AuditlogsTable::new);
	}

}