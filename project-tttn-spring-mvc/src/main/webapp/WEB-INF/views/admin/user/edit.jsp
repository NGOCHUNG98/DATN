<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userAPI" value="/api/user"/>
<c:url var="userURL" value="/quan-tri/nguoi-dung/danh-sach"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Forms</a>
							</li>
							<li class="active">Form Elements</li>
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<form:form id="formSubmit" role="form" class="form-horizontal" modelAttribute="model">
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="fullName"> Họ và tên: </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="fullName" placeholder="Nhập họ và tên người dùng" id="fullName"/>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="userName"> Tài khoản:  </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="userName" placeholder="Nhập tài khoản người dùng" id="userName"/>
										</div>
									</div>
									<div class="space-4"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="password"> Mật khẩu:  </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="password" placeholder="Nhập mật khẩu người dùng" id="password"/>
										</div>
									</div>
									<div class="space-4"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="status"> Tình trạng:  </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="status" placeholder="tình trạng người dùng" id="status"/>
										</div>
									</div>
									<div class="space-4"></div>
							
									

									<div class="space-4"></div>
									<form:hidden path="id" id="userId"/>
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id}">
											<button class="btn btn-info" type="button" id="btnAddOrEdit">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Cập nhật người dùng
											</button>
										</c:if>
										<%-- <c:if test="${empty model.id}">
											<button class="btn btn-info" type="button" id="btnAddOrEdit">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Thêm bài viết
											</button>
										</c:if> --%>
											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="ace-icon fa fa-times-circle"></i>
												Hủy bỏ
											</button>
										</div>
									</div>
									</form:form>
									</div>
						</div><!-- /.row -->
					</div><!-- /.page-content -->
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
				    	addNew(data);
				    } else {
				    	 editNew(data);
				    }
				});
				
				function addNew(data){
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
            				window.location.href = "${userURL}?page=1&limit=4&message=insert_success";
           			 	},
						error: function (error) {
							window.location.href = "${userURL}?page=1&limit=4&message=error_system";
						}
					});
				}

				function editNew(data){
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
            				window.location.href = "${userURL}?page=1&limit=4&message=update_success";
           			 	},
						error: function (error) {
							window.location.href = "${userURL}?page=1&limit=4&message=error_system";
						}
					});
				}
			</script>
</body>
</html>
