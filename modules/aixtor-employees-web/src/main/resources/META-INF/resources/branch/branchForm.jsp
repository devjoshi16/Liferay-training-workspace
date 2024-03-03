<%@ include file="init.jsp"%>
<%@ page import =" com.aixtor.employee.portlet.AixtorBranchPortlet" %>


<portlet:actionURL name="/add-branch" var="addBranchURL" />
<portlet:resourceURL var="getCountryStatesCityURL" id="/getState" />


<p>Branch Form</p>


<form action="${addBranchURL}" method="post">
	<div class="form-group">
		<label class="" for="0">Branch Name</label> <input id="0"
			placeholder="Enter Branch Name" class="form-control" type="text"
			name="<portlet:namespace/>branchName" value="">
	</div>
	<div class="form-group">
		<label class="" for="country">Country</label> <select aria-label="Label"
			id="countryDropdown" name="<portlet:namespace/>country" class="form-control">
			<option value="">Select Country</option>
			<c:forEach var="country" items="${countries}">
				<option value="${country.getPrimaryKey()}">${country.getName()}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="form-group">
		<label class="" for="state">State</label> <select aria-label="Label"
			id="stateDropdown" name="<portlet:namespace/>state" class="form-control">
			<option value="1">Select State</option>
		</select>
	</div>
	
	<div class="form-group">
		<label class="" for="city">City</label> <select aria-label="Label"
			id="city" name="<portlet:namespace/>city" class="form-control">
			<option value="1">Select City</option>
		</select>
	</div>
	

	<div class="form-group">
		<button class="btn btn-primary" type="submit">Submit</button>
	</div>
</form>
<script>
    $(document).ready(function() {
    	
    	
    	
        $('#stateDropdown').on('change', function() {
            var selectedValue = $(this).val();
            $.ajax({
                url: '${getCountryStatesCityURL}',
                type: 'POST',
                data: {
                    '<portlet:namespace/>state': $(this).val()
                },
                success: function(data, textStatus, jqXHR) {
                    if (data) {
                        const resObj = JSON.parse(data);
                        if (resObj.citystatus == 'success') {
                            const cityName = resObj.cityNameList;
                            const cityId = resObj.cityIdList;
                            var cityEle = $('#city').empty();
                            cityEle.append('<option value="1">Select City</option>');
                            for (var i = 0; i < cityName.length; i++) {
                                var itemName = cityName[i];
                                var itemId = cityId[i];
                                cityEle.append('<option value="' + itemId + '">' + itemName + '</option>');
                            }

                        }
                    }
                },
                error: function(jqXHR, status, error) {
                    console.log("error in ajax");
                }
            });
        });
    	
    	
    	
    	
        $('#countryDropdown').on('change', function() {
            var selectedValue = $(this).val();
            console.log(selectedValue);
            $.ajax({
                url: '${getCountryStatesCityURL}',
                type: 'POST',
                data: {
                    '<portlet:namespace/>country': $(this).val()
                    cmd=getstate
                },
                success: function(data, textStatus, jqXHR) {
                    if (data) {
                        const resObj = JSON.parse(data);
                        console.log(resObj);
                        if (resObj.statestatus == 'success') {
                            const statesName = resObj.stateNameList;
                            const statesId = resObj.stateIdList;
                            console.log(statesName);
                            var cityEle = $('#city').empty();
                            cityEle.append('<option value="1">Select City</option>');
                            var stateEle = $('#stateDropdown').empty();
                            stateEle.append('<option value="1">Select State</option>');
                            for (var i = 0; i < statesName.length; i++) {
                                var itemName = statesName[i];
                                var itemId = statesId[i];
                                stateEle.append('<option value="' + itemId + '">' + itemName + '</option>');
                            }

                        }
                    }
                },
                error: function(jqXHR, status, error) {
                    console.log("error in ajax");
                }
            });
        });
    });
        
</script>
