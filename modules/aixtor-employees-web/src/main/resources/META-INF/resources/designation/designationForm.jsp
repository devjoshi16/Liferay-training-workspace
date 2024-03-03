<%@ include file="init.jsp"%>


<portlet:actionURL name="/add-designation" var="addDesignationURL" />


<p>Designation Form</p>


<form action="${addDesignationURL}" method="post">
	<div class="form-group">
		<label class="" for="0">Name</label> <input id="0"
			placeholder="Enter Name" class="form-control" type="text"
			name="<portlet:namespace/>name" value="">
	</div>

	<div class="form-group">
		<button class="btn btn-primary" type="submit">Submit</button>
	</div>
</form>
