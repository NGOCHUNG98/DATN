<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>

<%-- <!-- css -->
<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/style.css' />"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/web.css' />"
	rel="stylesheet" type="text/css" /> --%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
  
    
    
    <link href='<c:url value="/template/hung/img/core-img/favicon.ico"/>' rel="icon">
	<link href="<c:url value='/template/hung/css/core-style.css' />" rel="stylesheet" type="text/css" media="all" />
	<link href="<c:url value='/template/hung/style.css' />" rel="stylesheet" type="text/css" media="all" />
	<link href="<c:url value='/template/hung/css/responsive.css' />" rel="stylesheet" type="text/css" media="all" />
	
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	

</head>
<body>
<div class="catagories-side-menu">
        <!-- Close Icon -->
        <div id="sideMenuClose">
            <i class="ti-close"></i>
        </div>
        <!--  Side Nav  -->
        <div class="nav-side-menu">
            <div class="menu-list">
                <h6>Categories</h6>
                <ul id="menu-content" class="menu-content collapse out">
                    <!-- Single Item -->
                    <c:forEach var="item" items="${category.listResult}">
                    	<c:url var="motocrycleById" value="/danh-sach/xe-may">
							<c:param name="id" value="${item.id}"></c:param>
						</c:url>
	                    <li data-toggle="collapse" data-target="#women" class="collapsed active">
	                        <a href="${motocrycleById}">${item.name}<span class="arrow"></span></a>
	                    </li>
                    </c:forEach>
                    
                </ul>
            </div>
        </div>
    </div>
    <div id="wrapper">
	    <!-- header -->
		<%@ include file="/common/web/header.jsp"%>
		<!-- header -->
    
    	<dec:body />
    
	    <!-- footer -->
		<%@ include file="/common/web/footer.jsp"%>
		<!-- footer -->
    </div>
    
    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/hung/js/jquery/jquery-2.2.4.min.js' />"></script>
    <%-- <script type="text/javascript" src="<c:url value='/template/hung/js/popper.min.js' />"></script> --%>
   <%--  <script type="text/javascript" src="<c:url value='/template/hung/js/bootstrap.min.js' />"></script> --%>
    <script type="text/javascript" src="<c:url value='/template/hung/js/plugins.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/hung/js/active.js' />"></script>

<%-- 	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<div class="container">
		
		<div class="row">
			<div class="col-lg-3">

				<h1 class="my-4">Motocrycle</h1>
				<div class="list-group">

					<c:forEach var="item" items="${category.listResult}">
						<c:url var="motocrycleById" value="/danh-sach/xe-may">
							<c:param name="id" value="${item.id}"></c:param>
						</c:url>
						<a href="${motocrycleById}" class="list-group-item">${item.name}</a>
					</c:forEach>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid"
								src="https://xemayhoanghiep.com.vn/wp-content/uploads/2017/05/20141026191051244.jpg"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid"
								src="https://xemayhoanghiep.com.vn/wp-content/uploads/2017/05/banner_honda_LEAD_940x250.jpg"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid"
								src="https://xemayhoanghiep.com.vn/wp-content/uploads/2017/05/banner3.png"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
				<dec:body />
			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<script type="text/javascript"
		src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
 --%>
</body>
</html>