create index IX_7E16E69 on Employee_Auditlogs (action[$COLUMN_LENGTH:75$]);
create index IX_769E928A on Employee_Auditlogs (moduleName[$COLUMN_LENGTH:75$]);
create index IX_FE1C0173 on Employee_Auditlogs (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_698C48B5 on Employee_Auditlogs (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D74E9269 on employee_auditlogs (action[$COLUMN_LENGTH:75$]);
create index IX_C2D9B68A on employee_auditlogs (moduleName[$COLUMN_LENGTH:75$]);
create index IX_526C2573 on employee_auditlogs (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1B956CB5 on employee_auditlogs (uuid_[$COLUMN_LENGTH:75$], groupId);