package com.aixtor.employee.service.persistence.impl;

import com.aixtor.employee.model.Branch;
import com.aixtor.employee.model.BranchCustom;
import com.aixtor.employee.model.Department;
import com.aixtor.employee.model.EmployeeCustom;
import com.aixtor.employee.service.persistence.EmployeeFinder;
import com.aixtor.employee.service.persistence.impl.constants.EmployeePersistenceConstants;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder {
	@Reference
	private CustomSQL customSQL;

	public List<EmployeeCustom> searchInEmployees(String keyWord) {
		Session session = null;

		try {
			session = openSession();

			String sql = customSQL.get(getClass(), "customSqlQueryXmlForSearch");

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);

			String searchName="%"+keyWord+"%";
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(searchName);
			qPos.add(searchName);
			qPos.add(searchName);
			qPos.add(searchName);
			qPos.add(searchName);
			qPos.add(searchName);
			qPos.add(searchName);
			qPos.add(searchName);
			qPos.add(searchName);

			List<Object> resultObjList = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);
			System.out.println(resultObjList);

			List<EmployeeCustom> employeeList = new ArrayList<EmployeeCustom>();
			for (int i = 0; i < resultObjList.size(); i++) {
				Object[] current = (Object[]) resultObjList.get(i);
				EmployeeCustom employeeCustom = new EmployeeCustom(
						(BigInteger) current[0], 
						current[1].toString(),
						current[2].toString(),
						current[3].toString(),
						(BigInteger) current[4],
						current[5].toString(),
						current[6].toString(),
						current[7].toString(), 
						current[8].toString(), 
						(BigInteger) current[9],
						(BigInteger) current[10], 
						(BigInteger) current[11]
								);
				employeeList.add(employeeCustom);

			}
			return employeeList;
		} catch (Exception e) {

			System.err.println("error in execption");
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;

	}

	public List<EmployeeCustom> searchInEmployeesByBranchName(String branchName) {
		Session session = null;

		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "customSqlQueryWhereBranchId");
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			String searchName="%"+branchName+"%";
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(searchName);

			List<Object> resultObjList = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);
			List<EmployeeCustom> employeeList = new ArrayList<EmployeeCustom>();
			for (int i = 0; i < resultObjList.size(); i++) {
				Object[] current = (Object[]) resultObjList.get(i);
				EmployeeCustom employeeCustom = new EmployeeCustom(
						(BigInteger) current[0],
						current[1].toString(),
						current[2].toString(),
						current[3].toString(),
						(BigInteger) current[4],
						current[5].toString(),
						current[6].toString(),
						current[7].toString(),
						current[8].toString(),
						(BigInteger) current[9],
						(BigInteger) current[10],
						(BigInteger) current[11]
				);
				employeeList.add(employeeCustom);

			}
			return employeeList;
		} catch (Exception e) {

			System.err.println("error in execption");
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;

	}
	public List<EmployeeCustom> searchInEmployeesByDepartmentName(String departmentName) {
		Session session = null;

		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "customSqlQueryWhereDepartmentId");
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			String searchName="%"+departmentName+"%";
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(searchName);

			List<Object> resultObjList = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);
			List<EmployeeCustom> employeeList = new ArrayList<EmployeeCustom>();
			for (int i = 0; i < resultObjList.size(); i++) {
				Object[] current = (Object[]) resultObjList.get(i);
				EmployeeCustom employeeCustom = new EmployeeCustom(
						(BigInteger) current[0],
						current[1].toString(),
						current[2].toString(),
						current[3].toString(),
						(BigInteger) current[4],
						current[5].toString(),
						current[6].toString(),
						current[7].toString(),
						current[8].toString(),
						(BigInteger) current[9],
						(BigInteger) current[10],
						(BigInteger) current[11]
				);
				employeeList.add(employeeCustom);

			}
			return employeeList;
		} catch (Exception e) {

			System.err.println("error in execption");
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;

	}
	public List<BranchCustom> CustomBranchByName(String branchName) {
		Session session = null;

		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "CustomBranchSqlQuery");
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			String searchName="%"+branchName+"%";
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(searchName);
			List<Object> resultObjList = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);

			System.out.println(resultObjList);

			List<BranchCustom> employeeList = new ArrayList<BranchCustom>();


			for (int i = 0; i < resultObjList.size(); i++) {
				Object[] current = (Object[]) resultObjList.get(i);
				BranchCustom employeeCustom = new BranchCustom(
						(BigInteger) current[0],
						current[1].toString(),
						current[2].toString(),
						current[3].toString(),
						current[4].toString()

				);
				employeeList.add(employeeCustom);

			}
			return employeeList;
		} catch (Exception e) {

			System.err.println("error in execption");
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;

	}


}
