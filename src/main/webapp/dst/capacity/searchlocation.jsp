<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script language="Javascript">
function val(){
	document.onkeydown=function(){
	    if(window.event.keyCode=='13'){
	    	searchVal = document.getElementById("location").value;
	    	if(searchVal == null || searchVal == '' ){
	    		alert('Please enter search criteria');
	    		return;
	    	}
	        form.submit();
	    }
	};
}
</script>
<div id="ibm-pcon">
	<div id="ibm-content">
		<div id="ibm-content-body">
			<div id="ibm-content-main">
				<div class="ibm-columns">
				    <form method="post" action="processlocationsearch.wss">
						<div class="ibm-col-1-1">
					        <p>
						        <label for="location">Search by location:</label>
						        <input type="location" name="location" id="location" placeholder="Search by location...." onclick="javascript: val()">
					    	</p>
					    	<p>
					        	<a class="ibm-back-link" href="javascript: history.go(-1)">Go Back</a>
					        </p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>