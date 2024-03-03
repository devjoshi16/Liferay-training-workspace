package com.aixtor.employee.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountryListPOJO {

	public static List<String> countryList;
	public static Map<String, ArrayList<String>> stateListMap;

	public static Map<String, ArrayList<String>> getStateListMap() {
		return stateListMap;
	}

	public static void setStateListMap(Map<String, ArrayList<String>> stateListMap) {
		CountryListPOJO.stateListMap = stateListMap;
	}

	public static List<String> getCountryList() {
		return countryList;
	}

	public static void setCountryList(List<String> countryList) {
		CountryListPOJO.countryList = countryList;
	}
}
