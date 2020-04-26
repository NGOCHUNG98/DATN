<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết xe máy</title>
</head>
<body>
	<form:form id="formSubmit" role="form" modelAttribute="model"
		enctype="multipart/form-data">
		<div class="cart_area section_padding_100 clearfix">
			<div class="container">
				<div class="row">
					<c:forEach var="item" items="${model.listResult}">
						<div class="card mt-4 img-magnifier-container">
							<img class="card-img-top img-fluid " id="myimage"
								src='<c:url value="/resources/images/${item.thumbnail}"/>'
								alt="">
							<div class="card-body">
								<h3 class="card-title">${item.name}</h3>

								<h4>
									<fmt:formatNumber type="number" maxFractionDigits="3"
										value="${item.price}" />
									<small class="text-muted">đ</small>
								</h4>
								<p class="card-text">${item.description}</p>
								<span class="text-warning">★ ★ ★ ★ ☆</span> 4.0 stars
							</div>
						</div>
						<!-- /.card -->

						<div class="card card-outline-secondary my-4">
							<div class="card-header">Product Reviews</div>
							<div class="card-body">
								<p>${item.context}</p>
								<small class="text-muted">Posted by Anonymous on 3/1/17</small>
								<hr>
								<a href='<c:url value="/mua-hang?id=${item.id}"/>'
									class="btn btn-success">Thêm vào giỏ hàng</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>