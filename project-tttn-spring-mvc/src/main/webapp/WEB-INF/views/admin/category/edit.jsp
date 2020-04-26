<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="categoryAPI" value="/api/category"/>
<c:url var="categoryURL" value="/quan-tri/hang-san-xuat/danh-sach"/>
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
										<label class="col-sm-3 control-label no-padding-right" for="name"> Hãng sản xuất: </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="name" placeholder="Nhập hãng xe máy" id="name"/>
										</div>
									</div>
									<div class="space-4"></div>

				<%-- 					<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="description"> Mô tả ngắn:  </label>

										<div class="col-sm-9">
											<form:textarea path="description" class="col-xs-10 col-sm-5" rows="5" placeholder="Nhập mô tả ngắn" id="description"/>
										</div>
									</div>
									
									<div class="space-4"></div>

									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for=thumnail> Ảnh: </label>
											<form:input type="file" path="thumnail" id="thumnail" class="col-xs-10 col-sm-5"/>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="amount"> Số lượng:  </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="amount" placeholder="Nhập số lượng xe máy" id="amount"/>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="price"> Giá:  </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="price" placeholder="Nhập giá xe máy" id="price"/>
										</div>
									</div>
									<div class="space-4"></div>
									
									<div class="form-group">
										  <label class="col-sm-3 control-label no-padding-right" for="categoeyId"> Hãng sản xuất: </label>
											<form:select path="categoeyId" id="categoeyId">
												<form:option value="" label="---Chọn thể loại---"/>
												<form:options items="${categories}"/>
											</form:select>
										</div>
									
									 --%>

									<div class="space-4"></div>
									<form:hidden path="id" id="categoryId"/>
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
				    var id = $('#categoryId').val();
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
						url: '${categoryAPI}',
						// kiểu dữ liệu để thêm/sửa/xóa
						type: 'POST',
						// kiểu dữ liệu khi client gửi tới server
						contentType: 'application/json',
						// đẩy dữ liệu về chuỗi jon
						data: JSON.stringify(data),
						// server respone cho client
						dataType: 'json',
						success: function (result) {
            				window.location.href = "${categoryURL}?page=1&limit=4&message=insert_success";
           			 	},
						error: function (error) {
							window.location.href = "${categoryURL}?page=1&limit=4&message=error_system";
						}
					});
				}

				function editNew(data){
					$.ajax({
						// cần phải nhập url
						url:'${categoryAPI}',
						// kiểu dữ liệu để thêm/sửa/xóa
						type: 'PUT',
						// kiểu dữ liệu khi client gửi tới server
						contentType: 'application/json',
						// đẩy dữ liệu về chuỗi jon
						data: JSON.stringify(data),
						// server respone cho client
						dataType: 'json',
						success: function (result) {
            				window.location.href = "${categoryURL}?page=1&limit=4&message=update_success";
           			 	},
						error: function (error) {
							window.location.href = "${categoryURL}?page=1&limit=4&message=error_system";
						}
					});
				}
			</script>
</body>
</html>
