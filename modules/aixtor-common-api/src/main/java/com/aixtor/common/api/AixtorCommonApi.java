package com.aixtor.common.api;

import com.aixtor.employee.model.Employee;
import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * @author dev.joshi
 */
public interface AixtorCommonApi {
	public void addEmployeeWithLogs(Employee employee, ThemeDisplay themeDisplay, String PortletName, long createdById,
			long modifiedById);

	public void updateEmployeeWithLogs(Employee employee, ThemeDisplay themeDisplay, String PortletName,
			long createdById,
			long modifiedById);

	public boolean deleteEmployeeWithLogs(long employeeId, String PortletName, long createdById, long modifiedById,
			ThemeDisplay themeDisplay);

}