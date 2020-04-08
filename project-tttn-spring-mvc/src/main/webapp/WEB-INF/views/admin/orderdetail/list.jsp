<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách hóa đơn</title>
</head>

<body>
	<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
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
													<th>Tên xe máy</th>
													<th>Hình Ảnh</th>
													<th>Giá bán</th>
													<th>Hóa đơn</th>
													<th>Số lượng đặt</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td>${motor}</td>
														<%-- <c:forEach var="itemmotor" items="${motor}">
															<td>${itemmotor.name}</td>
															<td><img class="card-img-top thumnail-image" style="width: 300px; height: 187.5px"
															src='<c:url value="/resources/images/${itemmotor.thumbnail}"/>' /></td>
														<td><fmt:formatNumber type="number"
																maxFractionDigits="3" value="${itemmotor.price}" />
															<small class="text-muted">đ</small></td>
														</c:forEach> --%>
														<td>${item.orderId}</td>
														<td>${item.quantity}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
</body>

</html>