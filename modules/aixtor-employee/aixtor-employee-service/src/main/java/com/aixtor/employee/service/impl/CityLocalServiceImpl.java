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

package com.aixtor.employee.service.impl;

import com.aixtor.employee.model.City;
import com.aixtor.employee.service.base.CityLocalServiceBaseImpl;
import com.aixtor.employee.service.persistence.CityPersistence;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.aixtor.employee.model.City",
	service = AopService.class
)
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {
	
	
	public List<City> findBystateId(long stateId){
		return cityPersistence.findBystateId(stateId);
	}
	
	
	
}