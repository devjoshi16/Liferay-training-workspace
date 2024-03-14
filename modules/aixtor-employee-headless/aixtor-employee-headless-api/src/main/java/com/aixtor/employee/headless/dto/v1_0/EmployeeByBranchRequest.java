package com.aixtor.employee.headless.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dev.joshi
 * @generated
 */
@Generated("")
@GraphQLName("EmployeeByBranchRequest")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "EmployeeByBranchRequest")
public class EmployeeByBranchRequest implements Serializable {

	public static EmployeeByBranchRequest toDTO(String json) {
		return ObjectMapperUtil.readValue(EmployeeByBranchRequest.class, json);
	}

	public static EmployeeByBranchRequest unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			EmployeeByBranchRequest.class, json);
	}

	@Schema(description = "The Branch Ids.")
	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	@JsonIgnore
	public void setBranchId(
		UnsafeSupplier<Long, Exception> branchIdUnsafeSupplier) {

		try {
			branchId = branchIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Branch Ids.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long branchId;

	@Schema(description = "The Branch Name.")
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@JsonIgnore
	public void setBranchName(
		UnsafeSupplier<String, Exception> branchNameUnsafeSupplier) {

		try {
			branchName = branchNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Branch Name.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String branchName;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeByBranchRequest)) {
			return false;
		}

		EmployeeByBranchRequest employeeByBranchRequest =
			(EmployeeByBranchRequest)object;

		return Objects.equals(toString(), employeeByBranchRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (branchId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchId\": ");

			sb.append(branchId);
		}

		if (branchName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchName\": ");

			sb.append("\"");

			sb.append(_escape(branchName));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.aixtor.employee.headless.dto.v1_0.EmployeeByBranchRequest",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}