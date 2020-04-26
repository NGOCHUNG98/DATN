<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" id="bootstrap-css">
  
    
    
    <link href='<c:url value="/template/hung/img/core-img/favicon.ico"/>' rel="icon">
	<link href="<c:url value='/template/hung/css/core-style.css' />" rel="stylesheet" type="text/css" media="all" />
	<link href="<c:url value='/template/hung/style.css' />" rel="stylesheet" type="text/css" media="all" />
	<link href="<c:url value='/template/hung/css/responsive.css' />" rel="stylesheet" type="text/css" media="all" />
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   
   
	<!------ Include the above in your HEAD tag ---------->
	

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
                    <c:forEach var="item" items="${menu.listResult}">
                    	<c:url var="motocrycleById" value="/danh-sach-xe-may-theo-hang-san-xuat">
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
    <script type="text/javascript" src="<c:url value='/template/hung/js/plugins.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/hung/js/active.js' />"></script>
</body>
</html>