<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
		
</head>

<body>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<br>
<br>
<br>
<br>
	<div class="container">
  
        <div class="row">

            <div class="col-md-3">
                <ul class="nav nav-pills nav-stacked admin-menu" >
                    <li class="active"><a href="" data-target-id="profile"><i class="glyphicon glyphicon-user"></i> Profile</a></li>
                    <li><a href="" data-target-id="change-password"><i class="glyphicon glyphicon-lock"></i> Change Password</a></li>
                    <li><a href="" data-target-id="settings"><i class="glyphicon glyphicon-cog"></i> Settings</a></li>
                    <li><a href="" data-target-id="logout"><i class="glyphicon glyphicon-log-out"></i> Logout</a></li>
                </ul>
            </div>

            <div class="col-md-9  admin-content" id="profile">
                <div class="panel panel-info" style="margin: 1em;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Name</h3>
                    </div>
                    <div class="panel-body">
                        ${user.fullName}
                    </div>
                </div>
                <div class="panel panel-info" style="margin: 1em;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Email</h3>
                    </div>
                    <div class="panel-body">
                        ashishpatel0720@gmail.com
                    </div>
                </div>
                <div class="panel panel-info" style="margin: 1em;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Last Password Change</h3>

                    </div>
                    <div class="panel-body">
                        4 days Ago
                    </div>
                </div>

            </div>
   <div class="col-md-9  admin-content" id="settings">
                <div class="panel panel-info" style="margin: 1em;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Notification</h3>
                    </div>
                    <div class="panel-body">
                        <div class="label label-success">allowed</div>
                    </div>
                </div>
                <div class="panel panel-info" style="margin: 1em;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Newsletter</h3>
                    </div>
                    <div class="panel-body">
                        <div class="badge">Monthly</div>
                    </div>
                </div>
                <div class="panel panel-info" style="margin: 1em;">
                    <div class="panel-heading">
                        <h3 class="panel-title">User</h3>

                    </div>
                    <div class="panel-body">
                         <div class="label label-success">yes</div>
                    </div>
                </div>

            </div>

            <div class="col-md-9  admin-content" id="change-password">
                <form  method="post" action="<c:url value="/thay-doi-mat-khau" />"  id="submitForm" name="submitForm">
					
           			<input type="hidden" value="${user.id}">
           			
                    <div class="panel panel-info" style="margin: 1em;">
                        <div class="panel-heading">
                            <h3 class="panel-title"><label for="new_password" class="control-label panel-title">New Password</label></h3>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" name="password" required="required" value='<c:url value="${model.password}" />' id="password" placeholder="Enter new password"> 
                                </div>
                            </div>

                        </div>
                    </div>

             
                    <div class="panel panel-info" style="margin: 1em;">
                        <div class="panel-heading">
                            <h3 class="panel-title"><label for="confirm_password"  class="control-label panel-title">Confirm password</label></h3>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-sm-10">
                                     <input type="password" class="form-control" value="" name="passwordConf" required="required" id="passwordConf" placeholder="Confirm password">
                                     <div id="msg"></div>
                                </div>
                            </div>
                        </div>
                    </div>

           
                    <div class="panel panel-info border" style="margin: 1em;">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="pull-left">
                                    <input type="submit" class="form-control btn btn-primary" name="submit" id="submit" value="Submit" >
                                </div>
                            </div>
                        </div>
                    </div>

                </form>
            </div>

            <div class="col-md-9  admin-content" id="settings"></div>

            <div class="col-md-9  admin-content" id="logout">
                <div class="panel panel-info" style="margin: 1em;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Confirm Logout</h3>
                    </div>
                    <div class="panel-body">
                        Do you really want to logout ?  
                        <a  href="#" class="label label-danger"
                            onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">
                            <span >   Yes   </span>
                        </a>    
                        <a href='<c:url value="/thong-tin-ca-nhan?username=${name}"/>' class="label label-success"> <span >  No   </span></a>
                    </div>
                    <form id="logout-form" action='<c:url value="/thoat"/>' method="GET" style="display: none;">
                    </form>



                </div>
            </div>
        </div>
</div> 
<br>
<br>
<br>
<br>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
		$(document).ready(function()
	    {
	       var navItems = $('.admin-menu li > a');
	       var navListItems = $('.admin-menu li');
	       var allWells = $('.admin-content');
	       var allWellsExceptFirst = $('.admin-content:not(:first)');
           allWellsExceptFirst.hide();
	       navItems.click(function(e)
	       {
	           e.preventDefault();
	           navListItems.removeClass('active');
	           $(this).closest('li').addClass('active');
	           allWells.hide();
	           var target = $(this).attr('data-target-id');
	           $('#' + target).show();
	       });
        });

		var allowsubmit = false;
		$(function(){
			//on keypress 
			$('#passwordConf').keyup(function(e){
				//get values 
				var pass = $('#password').val();
				var confpass = $(this).val();
				
				//check the strings
				if(pass == confpass){
					//if both are same remove the error and allow to submit
					$("#msg").html("Password matched").css("color","green");
					allowsubmit = true;
				}else{
					//if not matching show error and not allow to submit
					$("#msg").html("Password do not match").css("color","red");
					allowsubmit = false;
				}
			});
			
			//jquery form submit
			$('#submitForm').submit(function(){
			
				var pass = $('#password').val();
				var confpass = $('#passwordConf').val();
 
				//just to make sure once again during submit
				//if both are true then only allow submit
				if(pass == confpass){
					allowsubmit = true;
				}
				if(allowsubmit){
					return true;
				}else{
					return false;
				}
			});
		});
</script>
</body>
</html>

