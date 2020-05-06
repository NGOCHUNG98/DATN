<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin home</title>
</head>
<body>
	<main class="mdl-layout__content ">

        <div class="mdl-grid ui-tables">

            <div class="mdl-cell mdl-cell--12-col-desktop mdl-cell--12-col-tablet mdl-cell--4-col-phone">
                <div class="mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title">
                        <h1 class="mdl-card__title-text">Danh sách nhân viên</h1>
                    </div>
                    <div class="mdl-card__supporting-text no-padding">
                        <table class="mdl-data-table mdl-js-data-table" data-upgraded=",MaterialDataTable">
                            <thead>
                            <tr>
                                <th class="mdl-data-table__cell--non-numeric">Họ và tên</th>
                                <th class="mdl-data-table__cell--non-numeric">Tên đăng nhập</th>
                                <th class="mdl-data-table__cell--non-numeric">Mật khẩu</th>
                                <th class="mdl-data-table__cell--non-numeric">Tình trạng</th>
                                <th class="mdl-data-table__cell--non-numeric">Quyền</th>
                                <th class="mdl-data-table__cell--non-numeric">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="item" items="${model.listResult}">
                                <tr>
                                    <td class="mdl-data-table__cell--non-numeric">${item.fullName}</td>
                                    <td class="mdl-data-table__cell--non-numeric">${item.userName}</td>
                                    <td class="mdl-data-table__cell--non-numeric">${item.password}</td>
                                    <c:if test="${item.status==1}">
                                    	<td class="mdl-data-table__cell--non-numeric"><span class="label label--mini color--green">Active</span> </td>
                                    </c:if>
                                    <c:if test="${item.status==0}">
                                    	<td class="mdl-data-table__cell--non-numeric"><span class="label label--mini color--red">Inactive</span> </td>
                                    </c:if>
                                    <td class="mdl-data-table__cell--non-numeric">${item.role.name}</td>
                                    <td class="mdl-data-table__cell--non-numeric"><a href="<c:url value="/admin/action?id=${item.id}"/>" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect button--colored-teal" data-upgraded=",MaterialButton,MaterialRipple">Edit<span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></a></td>
                             	</tr>
                             	</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </main>
</body>
</html>