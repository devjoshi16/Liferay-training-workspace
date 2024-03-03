create table Employee_Branch (
	uuid_ VARCHAR(75) null,
	branchId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	countryId LONG,
	stateId LONG,
	cityId LONG
);

create table Employee_City (
	uuid_ VARCHAR(75) null,
	cityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	cityName VARCHAR(75) null,
	stateId LONG
);

create table Employee_Department (
	uuid_ VARCHAR(75) null,
	departmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	departmentHead VARCHAR(75) null
);

create table Employee_Designation (
	uuid_ VARCHAR(75) null,
	designationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);

create table Employee_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	mobileNumber LONG,
	departmentId LONG,
	branchId LONG,
	designationId LONG,
	address VARCHAR(75) null
);

create table Employee_State (
	uuid_ VARCHAR(75) null,
	stateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stateName VARCHAR(75) null,
	countryId LONG
);