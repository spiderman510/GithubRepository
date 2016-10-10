<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Staff Evaluation</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">

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
	<!-- modify navbar-brand-->
	.navbar-brand-logo {
		float: left;
		height: 50px;
		font-size: 18px;
		line-height: 20px;
	}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script> 
	$(document).ready(function(){
		$("#logo").load('Logo.html');
		$("#logoFooter").load('Logo.html');
		$("#navbar").load('Navibar.html');
		$("#menu").load('Menu.html');
		$("#footer").load('Footer.html');
	});
	</script>
  </head>
  <body>
	<div class="container-fluid">
		<div class="row" style="margin-top:1%">
		  <div class="col-md-12">
		   <div id="logo"></div>
		  </div>
		</div>
		<div class="row" style="margin-top:1%">
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
					<div class="row" style="margin-top: 1%">
						<div class="col-md-12">
							<div class="table-responsive">
								<table class="table table-bordered">
									<tr>
									  <td><label for="usr">Name</label></td>
									  <td><input type="text" class="form-control" id="name"/></td>
									</tr>
									<tr>
									  <td><label for="usr">Status</label></td>
									  <td><select class="combobox input-large form-control" name="normal">
												<option value="planning" selected="selected">Planning</option>
												<option value="inprogress">In Progress</option>
												<option value="completed">Completed</option>
											</select></td>
									</tr>
									<tr>
									  <td><label for="usr">Scope</label></td>
									  <td><select class="combobox input-large form-control" name="normal">
												<option value="offshore" selected="selected">Offshore</option>
												<option value="local">Local</option>
												<option value="onside">Onside</option>
											</select></td>
									</tr>
									<tr>
									  <td><label for="usr">Start Date</label></td>
									  <td><input type="text" class="form-control" id="startDate"></td>
									</tr>
									<tr>
									  <td><label for="usr">End Date</label></td>
									  <td><input type="text" class="form-control" id="endDate"></td>
									</tr>
									<tr>
									  <td><label for="usr">Type</label></td>
									  <td><select class="combobox input-large form-control" name="normal">
												<option value="mut" selected="selected">Make/UT</option>
												<option value="test">Testing</option>
											</select></td>
									</tr>
									<tr>
									  <td><label for="usr">Method</label></td>
									  <td><select class="combobox input-large form-control" name="normal">
												<option value="rd" selected="selected">R&ampD</option>
												<option value="bd">BD</option>
												<option value="dd">DD</option>
												<option value="pd">PD</option>
											</select></td>
									</tr>
									<tr>
									  <td><label for="usr">Technical</label></td>
									  <td><select class="combobox input-large form-control" name="normal">
												<option value="tera" selected="selected">Terasoluna</option>
												<option value="visc">Visc</option>
												<option value="intramart">Intramart</option>
												<option value="other">Other</option>
											</select></td>
									</tr>
									<tr>
									  <td><label for="usr">Cost</label></td>
									  <td><input type="text" class="form-control" id="cost"></td>
									</tr>
									<tr>
									  <td><label for="usr">Update SVN Link</label></td>
									  <td ><input type="text" class="form-control" id="svnLink" style="display: inline-block;"/>
									  </td>
									</tr>									
								</table>
							</div>
							<div>
								<h4>Team members</h4>
							</div>
							<div class="table-responsive">
								<table class="table table-striped table-hover table-bordered">
									<!-- On cells (`td` or `th`) -->
									<tr  class="info">
									  <th>Name</th>
									  <th>Role</th>
									  <th>Join Date</th>
									  <th>Leave Date</th>
									</tr>
									<tr>
									  <td><input type="text" class="form-control" id="user" value="DanhLT"></td>
									  <td>PG</td>
									  <td>01/01/2016</td>
									  <td>01/02/2016</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<button type="button" class="btn btn-info">
						  <a href="NewProject.html">Save</a>
						</button>
					</div>
				</div>
				
			  </div>
		</div>
		<div class="row">
		  <div class="col-md-offset-2 col-md-3">
			  <div id="footer"></div>
			</div>
			<div class="col-md-offset-5 col-md-2">
				<div id="logoFooter"></div>
			</div>
		</div>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
  </body>
</html>