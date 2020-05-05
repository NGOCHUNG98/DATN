<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userAPI" value="/api/admin/user"/>
<c:url var="userURL" value="/admin/home"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thao tác</title>
</head>
<body>
<main class="mdl-layout__content ui-form-components">

        <div class="mdl-grid mdl-cell mdl-cell--12-col-desktop mdl-cell--12-col-tablet mdl-cell--4-col-phone mdl-cell--top">

            <div class="mdl-cell mdl-cell--5-col-desktop mdl-cell--5-col-tablet mdl-cell--4-col-phone">
                <div class="mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title">
                        <h5 class="mdl-card__title-text text-color--white">PROFILE INFO</h5>
                    </div>
                    <div class="mdl-card__supporting-text">
                        <form class="form form--basic">
                            <div class="mdl-grid">
                                <div class="mdl-cell mdl-cell--3-col-desktop mdl-cell--3-col-tablet mdl-cell--1-col-phone">
                                    <div class="profile-image color--smooth-gray profile-image--round">
                                        <img src="images/Bobby.PNG">
                                    </div>
                                </div>
                                <form:form id="formSubmit" role="form" class="form-horizontal" modelAttribute="model">
                                <div class="mdl-cell mdl-cell--8-col-desktop mdl-cell--8-col-tablet mdl-cell--4-col-phone form__article">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size is-dirty is-upgraded" data-upgraded=",MaterialTextfield">
                                        <form:input class="mdl-textfield__input" type="text" path="fullName" id="fullName" />
                                        <label class="mdl-textfield__label" for="fullName">Họ và tên</label>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size is-dirty is-upgraded" data-upgraded=",MaterialTextfield">
                                        <form:input class="mdl-textfield__input" type="text" path="userName" id="userName" />
                                        <label class="mdl-textfield__label" for="userName">Tên đăng nhập</label>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size is-dirty is-upgraded" data-upgraded=",MaterialTextfield">
                                        <form:input class="mdl-textfield__input" type="password" path="password" id="password" />
                                        <label class="mdl-textfield__label" for="password">Mật khẩu</label>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select full-size is-upgraded" data-upgraded=",MaterialTextfield" style="width: 124px;">

											<form:select path="role" id="role">
												<form:option value="" label="---Chọn quyền---"/>
												<form:options items="${role}"/>
											</form:select>


                                        <label for="location">
                                            <i class="mdl-icon-toggle__label material-icons">arrow_drop_down</i>
                                        </label>
                                    </div>
	                                    <form:hidden path="id" id="userId"/>
										<div class="clearfix form-actions">
											<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrEdit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật bài viết
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrEdit">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm bài viết
												</button>
											</c:if>
												&nbsp; &nbsp; &nbsp;
												<button class="btn" type="reset">
													<i class="ace-icon fa fa-times-circle"></i>
													Hủy bỏ
												</button>
											</div>
										</div>
	                                </div>
                                </form:form>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
		<script>
				$('#btnAddOrEdit').click(function(e){
					e.preventDefault();
				    var data = {};
				    var formData = $('#formSubmit').serializeArray();
				    $.each(formData, function (i, v) {
			            data[""+v.name+""] = v.value;
			        });
				    var id = $('#userId').val();
				    if (id == "") {
				    	addUser(data);
				    } else {
				    	editUser(data);
				    }
				});
				
				function addUser(data){
					//sử dụng ajax để call api
					$.ajax({
						// cần phải nhập url
						url: '${userAPI}',
						// kiểu dữ liệu để thêm/sửa/xóa
						type: 'POST',
						// kiểu dữ liệu khi client gửi tới server
						contentType: 'application/json',
						// đẩy dữ liệu về chuỗi jon
						data: JSON.stringify(data),
						// server respone cho client
						dataType: 'json',
						success: function (result) {
            				window.location.href = "${userURL}";
           			 	},
						error: function (error) {
							window.location.href = "${userURL}";
						}
					});
				}

				function editUser(data){
					$.ajax({
						// cần phải nhập url
						url:'${userAPI}',
						// kiểu dữ liệu để thêm/sửa/xóa
						type: 'PUT',
						// kiểu dữ liệu khi client gửi tới server
						contentType: 'application/json',
						// đẩy dữ liệu về chuỗi jon
						data: JSON.stringify(data),
						// server respone cho client
						dataType: 'json',
						success: function (result) {
            				window.location.href = "${userURL}";
           			 	},
						error: function (error) {
							window.location.href = "${userURL}";
						}
					});
				}
			</script>
    </main>
    		
</body>
</html>