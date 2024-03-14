package com.aixtor.employee.headless.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author dev.joshi
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/aixtor-employee-headless",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=AixtorEmployeeHeadless"
	},
	service = Application.class
)
@Generated("")
public class AixtorEmployeeHeadlessApplication extends Application {
}