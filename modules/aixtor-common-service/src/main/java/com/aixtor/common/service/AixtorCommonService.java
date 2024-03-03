package com.aixtor.common.service;

import com.aixtor.common.api.AixtorCommonApi;
import com.aixtor.common.constants.AixtorCommonConstants;
import com.aixtor.employee.logs.model.Auditlogs;
import com.aixtor.employee.logs.service.AuditlogsLocalService;
import com.aixtor.employee.model.Employee;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author dev.joshi
 */
@Component(immediate = true, property = {

}, service = AixtorCommonApi.class)
public class AixtorCommonService implements AixtorCommonApi {
	@Reference
	AuditlogsLocalService auditlogsLocalService;
	@Reference
	EmployeeLocalService employeeLocalService;

	@Override
	public void addEmployeeWithLogs(Employee employee, ThemeDisplay themeDisplay, String PortletName, long createdById,
			long modifiedById) {
		employeeLocalService.addEmployee(employee);
		Auditlogs auditlogs = auditlogsLocalService
				.createAuditlogs(CounterLocalServiceUtil.increment(Auditlogs.class.getName()));
		auditlogs.setAction(AixtorCommonConstants.ADD);
		auditlogs.setCreatedBy(createdById);
		auditlogs.setModifiedBy(modifiedById);
		auditlogs.setModuleName(PortletName);
		auditlogs.setCompanyId(themeDisplay.getCompanyId());
		auditlogs.setGroupId(themeDisplay.getSiteGroupId());
		auditlogs.setCompanyId(themeDisplay.getCompanyId());
		auditlogs.setUserId(themeDisplay.getUserId());
		auditlogs.setUserName(themeDisplay.getUser().getFullName());
		auditlogsLocalService.addAuditlogs(auditlogs);

	}

	@Override
	public boolean deleteEmployeeWithLogs(long employeeId, String PortletName, long createdById, long modifiedById,
			ThemeDisplay themeDisplay) {
		try {
			employeeLocalService.deleteEmployee(employeeId);
			Auditlogs auditlogs = auditlogsLocalService
					.createAuditlogs(CounterLocalServiceUtil.increment(Auditlogs.class.getName()));
			auditlogs.setAction(AixtorCommonConstants.DELETE);
			auditlogs.setCreatedBy(createdById);
			auditlogs.setModifiedBy(modifiedById);
			auditlogs.setModuleName(PortletName);
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setGroupId(themeDisplay.getSiteGroupId());
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setUserId(themeDisplay.getUserId());
			auditlogs.setUserName(themeDisplay.getUser().getFullName());
			auditlogsLocalService.addAuditlogs(auditlogs);
			return true;
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateEmployeeWithLogs(Employee employee, ThemeDisplay themeDisplay, String PortletName,
			long createdById, long modifiedById) {
		employeeLocalService.updateEmployee(employee);
		Auditlogs auditlogs = auditlogsLocalService
				.createAuditlogs(CounterLocalServiceUtil.increment(Auditlogs.class.getName()));
		auditlogs.setAction(AixtorCommonConstants.UPDATE);
		auditlogs.setCreatedBy(createdById);
		auditlogs.setModifiedBy(modifiedById);
		auditlogs.setModuleName(PortletName);
		auditlogs.setCompanyId(themeDisplay.getCompanyId());
		auditlogs.setGroupId(themeDisplay.getSiteGroupId());
		auditlogs.setCompanyId(themeDisplay.getCompanyId());
		auditlogs.setUserId(themeDisplay.getUserId());
		auditlogs.setUserName(themeDisplay.getUser().getFullName());
		auditlogsLocalService.addAuditlogs(auditlogs);
	}

}