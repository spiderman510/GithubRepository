<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
.footerTitle {
	font-weight: bold;
	font-size: 14px;
	line-height: 24px;
}

<!--
modify navbar-brand-->.navbar-brand-logo {
	float: left;
	height: 50px;
	font-size: 18px;
	line-height: 20px;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#logo").load('${contextPath}/resource/common/Logo.jsp');
		$("#logoFooter").load('${contextPath}/resource/common/Logo.jsp');
		$("#navbar").load('${contextPath}/resource/common/Navibar.jsp');
		$("#menu").load('${contextPath}/resource/common/Menu.jsp');
		$("#footer").load('${contextPath}/resource/common/Footer.jsp');
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="margin-top: 1%">
			<div class="col-md-12">
				<div id="logo"></div>
			</div>
		</div>
		<div class="row" style="margin-top: 1%">
			<div class="col-md-12">
				<div id="navbar"></div>
			</div>

		</div>
		<div class="row">
			<div class="col-md-2">
				<div id="menu"></div>
			</div>
			<div class="col-md-10">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
								<table
									class="table table-striped table-hover table-bordered table-responsive">
									<!-- On cells (`td` or `th`) -->
									<tr class="info">
										<th>Project Name</th>
										<th>Status</th>
										<th>Duration</th>
										<th>Scope</th>
										<th>Type</th>
										<th>Method</th>
										<th>Technical</th>
										<th>Performance</th>
									</tr>
									<c:forEach items="${projectList}" var="project">
										<tr>
										<td><a href="Project.html"><c:out value="${project.projectName}" /></a></td>
										<td><c:out value="${project.status}" /></td>
										<td><c:out value="${project.duration}" /></td>
										<td><c:out value="${project.scope}" /></td>
										<td><c:out value="${project.type}" /></td>
										<td><c:out value="${project.method}" /></td>
										<td><c:out value="${project.technical}" /></td>
										<td><c:out value="${project.performance}" />%</td>
									</tr>
										
									</c:forEach>									
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-2 col-md-3">
				<div id="footer"></div>
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