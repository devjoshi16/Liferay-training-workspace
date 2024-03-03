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

package com.aixtor.employee.service.persistence.impl;

import com.aixtor.employee.model.StateTable;
import com.aixtor.employee.model.impl.StateImpl;
import com.aixtor.employee.model.impl.StateModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from State.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ArgumentsResolver.class)
public class StateModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		StateModelImpl stateModelImpl = (StateModelImpl)baseModel;

		long columnBitmask = stateModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(stateModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= stateModelImpl.getColumnBitmask(
					columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(StatePersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(stateModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return StateImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return StateTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		StateModelImpl stateModelImpl, String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = stateModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = stateModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= StateModelImpl.getColumnBitmask("stateName");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}