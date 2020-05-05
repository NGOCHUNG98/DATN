<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@include file="/common/taglib.jsp"%>
<c:url var="motoAPI" value="/api/motocrycle" />
<c:url var="motoURL" value="/nhan-vien-quan-tri/xe-may/danh-sach" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div class="main-content">
		<form:form id="formSubmit" method="get" modelAttribute="model">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href='<c:url value="/nhan-vien-quan-tri/trang-chu"/>'>Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty message}">
								<div class="alert alert-${alert}">${message}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<c:url var="createUserUrl"
												value="/nhan-vien-quan-tri/xe-may/danh-sach/chinh-sua" />
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm bài viết'
												href='${createUserUrl}'> <span> <i
													class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
												onclick="warningBeforeDelete()"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa bài viết'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll" /></th>
													<th>Tên xe máy</th>
													<th>Mô tả</th>
													<th>Hình ảnh</th>
													<th>Giá</th>
													<th>Số lượng</th>
													<th>Hãng sản xuất</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox" id="checkbox_${item.id}"
															value="${item.id}" /></td>
														<td>${item.name}</td>
														<td>${item.description}</td>
														<td><img class="card-img-top thumnail-image" style="width: 300px; height: 187.5px"
															src='<c:url value="/resources/images/${item.thumbnail}"/>' /></td>
														<td><fmt:formatNumber type="number"
																maxFractionDigits="3" value="${item.price}" />
															<small class="text-muted">đ</small></td>
														<td>${item.quantity}</td>
														<td>${item.categoryEntity.name}</td>
														<td><c:url var="updateMotocrycleUrl"
																value="/nhan-vien-quan-tri/xe-may/danh-sach/chinh-sua">
																<c:param name="id" value="${item.id}"></c:param>
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật bài viết"
															href="${updateMotocrycleUrl}"><i
																class="fa fa-pencil-square-o" aria-hidden="true"></i> </a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" /> <input
											type="hidden" value="" id="limit" name="limit" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.main-content -->
	<script>
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(5);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
		function warningBeforeDelete() {
			swal({
				title : "Xác nhận!",
				text : "Bạn có chắc chắn muốn xóa không?",
				type : "warning",
				showCancelButton : true,
				confirmButtonClass : "btn-danger",
				confirmButtonText : "Yes, delete it!",
				cancelButtonText : "No, cancel plx!",
				closeOnConfirm : false,
				closeOnCancel : false
			}).then(
					function(isConfirm) {
						if (isConfirm) {
							var ids = $('tbody input[type=checkbox]:checked')
									.map(function() {
										return $(this).val();
									}).get();
							deleteNew(ids);
						}
					});
		}
		function deleteNew(data) {
			$.ajax({
				url : '${motoAPI}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : function(result) {
				window.location.href = "${motoURL}?page=1&limit=5&message=delete_success";
				window.location.href = "${motoURL}?page=1&limit=5&message=import_success";
				},
				error : function(error) {
				window.location.href = "${motoURL}?page=1&limit=5&message=error_system";
				}
			});
		}
	</script>
</body>

</html>