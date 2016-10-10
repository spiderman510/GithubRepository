<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Staff Evaluation</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
body {
	background-image: url("${contextPath}/resource/img/background-login.jpg");
	font-size: 80%;
	padding: 20px;
}

#loginBox {
	background: white;
	float: left;
	margin: 0 auto;
	padding: 20px;
	resize: both;
	overflow: auto;
	transform: translate(-50%, -50%);
	position: absolute;
	top: 50%;
	left: 50%;
	overflow: auto;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>

</script>	
</head>
<body>
	<div class="container-fluid">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-offset-4 col-md-4" id="loginBox">
				<h4 style="text-align: center">
					<b>PROJECT KNOWLEDGE BASE SYSTEM</b>
				</h4>
				<form:form action="login" commandName="loginForm">
					<div class="form-group">
						<label>Username</label> <FONT color="red"><form:errors
								path="username" /></FONT> <form:input path="username" class="form-control" id="username"/>
					</div>
					<div class="form-group">
						<label>Password</label> <FONT color="red"><form:errors
										path="password" /></FONT><form:password path="password" class="form-control" id="password"/>
					</div>
					
						<input type="submit" value="Submit" class="btn btn-default"/>
				</form:form>

				
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
</body>
</html>