create table Employee_Auditlogs (
	uuid_ VARCHAR(75) null,
	auditLogsId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	action VARCHAR(75) null,
	moduleName VARCHAR(75) null,
	createdBy LONG,
	modifiedBy LONG
);

create table employee_auditlogs (
	uuid_ VARCHAR(75) null,
	auditLogsId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	action VARCHAR(75) null,
	moduleName VARCHAR(75) null,
	createdBy LONG,
	modifiedBy LONG
);