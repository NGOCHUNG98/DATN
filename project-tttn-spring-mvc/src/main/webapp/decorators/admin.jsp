<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title><dec:title default="Trang chủ" /></title>
	
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,100,700,900' rel='stylesheet'
          type='text/css'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- inject:css -->
    <link rel="stylesheet" href="<c:url value='/template/admin/css/lib/getmdl-select.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/css/lib/nv.d3.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/css/application.min.css' />" />
    <!-- endinject -->
	
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header is-small-screen">
	
		<!-- header -->
    	<%@ include file="/common/admin/header.jsp" %>
    	<!-- header -->
    	
    	<!-- header -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- header -->
    	
    	<dec:body/>
	</div>
	
	
	
	<!-- inject:js -->
	<script src="<c:url value='/template/admin/js/d3.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/getmdl-select.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/material.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/nv.d3.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/layout/layout.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/scroll/scroll.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/charts/discreteBarChart.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/charts/linePlusBarChart.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/charts/stackedBarChart.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/employer-form/employer-form.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/line-chart/line-charts-nvd3.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/pie-chart/pie-charts-nvd3.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/table/table.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/widgets/todo/todo.min.js' />"></script>
	
	
	<!-- endinject -->
</body>
</html>