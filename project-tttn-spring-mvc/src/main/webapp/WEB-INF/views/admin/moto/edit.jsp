<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="motoURL" value="/quan-tri/xe-may/danh-sach"/>
<c:url var="motoAPI" value="/api/motocrycle"/>
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
								<form:form id="formSubmit" role="form" class="form-horizontal" modelAttribute="model" enctype="multipart/form-data">
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name"> Tên xe máy: </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="name" placeholder="Nhập tên xe máy" id="name"/>
										</div>
									</div>
									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="description"> Mô tả ngắn:  </label>

										<div class="col-sm-9">
											<form:textarea path="description" class="col-xs-10 col-sm-5" rows="5" placeholder="Nhập mô tả ngắn" id="description"/>
										</div>
									</div>
									
									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="context"> Nội dung chi tiết:  </label>

										<div class="col-sm-9">
											<form:textarea path="context" class="col-xs-10 col-sm-5" rows="5" placeholder="Nhập nội dung chi tiết" id="context"/>
										</div>
									</div>
									
									<div class="space-4"></div>

									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="thumbnail"> Ảnh: </label>
											<form:input type="file" path="thumbnail" id="thumbnail" class="col-xs-10 col-sm-5"/>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="quantity"> Số lượng:  </label>

										<div class="col-sm-9">
											<form:input cssClass="col-xs-10 col-sm-5" path="quantity" placeholder="Nhập số lượng xe máy" id="quantity"/>
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
										  <label class="col-sm-3 control-label no-padding-right" for="categoryId"> Hãng sản xuất: </label>
											<form:select path="categoryId" id="categoryId">
												<form:option value="" label="---Chọn thể loại---"/>
												<form:options items="${categories}"/>
											</form:select>
										</div>
									
									

									<div class="space-4"></div>
									<form:hidden path="id" id="motoId"/>
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
				    var id = $('#motoId').val();
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
						url: '${motoAPI}',
						// kiểu dữ liệu để thêm/sửa/xóa
						type: 'POST',
						// kiểu dữ liệu khi client gửi tới server
						contentType: 'application/json',
						// đẩy dữ liệu về chuỗi jon
						data: JSON.stringify(data),
						// server respone cho client
						dataType: 'json',
						success: function (result) {
            				window.location.href = "${motoURL}?page=1&limit=4&message=insert_success";
           			 	},
						error: function (error) {
							window.location.href = "${motoURL}?page=1&limit=4&message=error_system";
						}
					});
				}

				function editNew(data){
					$.ajax({
						// cần phải nhập url
						url:'${motoAPI}',
						// kiểu dữ liệu để thêm/sửa/xóa
						type: 'PUT',
						// kiểu dữ liệu khi client gửi tới server
						contentType: 'application/json',
						// đẩy dữ liệu về chuỗi jon
						data: JSON.stringify(data),
						// server respone cho client
						dataType: 'json',
						success: function (result) {
            				window.location.href = "${motoURL}?page=1&limit=4&message=update_success";
           			 	},
						error: function (error) {
							window.location.href = "${motoURL}?page=1&limit=4&message=error_system";
						}
					});
				}
			</script>
</body>
</html>
