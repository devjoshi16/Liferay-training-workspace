create index IX_CCFF8458 on Employee_Branch (name[$COLUMN_LENGTH:75$]);
create index IX_2300990D on Employee_Branch (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C605FECF on Employee_Branch (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CEED8EAC on Employee_City (cityName[$COLUMN_LENGTH:75$]);
create index IX_936CA6DA on Employee_City (stateId);
create index IX_D583A696 on Employee_City (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BFD0DA98 on Employee_City (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6AF7B188 on Employee_Department (name[$COLUMN_LENGTH:75$]);
create index IX_4DAE7E3D on Employee_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6C4B6FFF on Employee_Department (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_EEAF0CEB on Employee_Designation (name[$COLUMN_LENGTH:75$]);
create index IX_C6E0DD20 on Employee_Designation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D73E2BA2 on Employee_Designation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6EF3C06 on Employee_Employee (firstName[$COLUMN_LENGTH:75$]);
create index IX_B14813D9 on Employee_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2545BC9B on Employee_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_10E0D77B on Employee_State (countryId);
create index IX_A65BD826 on Employee_State (stateName[$COLUMN_LENGTH:75$]);
create index IX_BDF7AFFA on Employee_State (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E7BFECFC on Employee_State (uuid_[$COLUMN_LENGTH:75$], groupId);