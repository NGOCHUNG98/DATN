<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thao tác</title>
</head>
<body>
	<main class="mdl-layout__content ui-form-components">

        <div class="mdl-grid mdl-cell mdl-cell--12-col-desktop mdl-cell--12-col-tablet mdl-cell--4-col-phone mdl-cell--top">

            <div class="mdl-cell mdl-cell--5-col-desktop mdl-cell--5-col-tablet mdl-cell--4-col-phone">
                <div class="mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title">
                        <h5 class="mdl-card__title-text text-color--white">PROFILE INFO</h5>
                    </div>
                    <div class="mdl-card__supporting-text">
                        <form action="<c:url value="/admin/action/employee" />" class="form form--basic" method="post">
                            <div class="mdl-grid">
                                <div class="mdl-cell mdl-cell--3-col-desktop mdl-cell--3-col-tablet mdl-cell--1-col-phone">
                                    <div class="profile-image color--smooth-gray profile-image--round">
                                        <img src="">
                                    </div>
                                </div>
                                <div class="mdl-cell mdl-cell--8-col-desktop mdl-cell--8-col-tablet mdl-cell--4-col-phone form__article">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size is-dirty is-upgraded" data-upgraded=",MaterialTextfield">
                                        <input class="mdl-textfield__input" type="text" name="fullName" value="<c:url value="${model.fullName}"/>" id="fullName">
                                        <label class="mdl-textfield__label" for="profile-floating-first-name">Họ và tên</label>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size is-dirty is-upgraded" data-upgraded=",MaterialTextfield">
                                        <input class="mdl-textfield__input" type="text" name="userName" value="<c:url value="${model.userName}"/>" id="userName">
                                        <label class="mdl-textfield__label" for="profile-floating-last-name">Tên đăng nhập</label>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size is-dirty is-upgraded" data-upgraded=",MaterialTextfield">
                                        <input class="mdl-textfield__input" type="password" name="password" value="<c:url value="${model.password}"/>"  id="password">
                                        <label class="mdl-textfield__label" for="floating-e-mail">Mật khẩu</label>
                                    </div>
                                    <div class="form-group">
					       			<label for="customerAddress">Quyền</label>
                                    	<select class="form-control" id="roleId" name="roleId">
										  <c:forEach var="pr" items="${role}">
											    <option value="<c:url value="${pr.key}"/>">${pr.value}</option>
											</c:forEach>
										 </select> 
									</div>
									<input type="hidden" name="id" value="<c:url value="${model.id}"/>">
									<input type="hidden" name="status" value="<c:url value="${model.status}"/>">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select full-size is-upgraded" data-upgraded=",MaterialTextfield" style="width: 124px;">
                                    
                                	</div>
                                <div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id}">
											<!-- <button class="btn btn-info" type="submit" id="btnAddOrEdit">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Cập nhật bài viết
											</button> -->
											<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect button--colored-teal" data-upgraded=",MaterialButton,MaterialRipple">
			                                    <i class="material-icons">create</i>
			                                    Cập nhật
			                                <span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></button>
														
										</c:if>
										<c:if test="${empty model.id}">
											<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect button--colored-green" data-upgraded=",MaterialButton,MaterialRipple">
			                                    <i class="material-icons">create</i>
			                                    Thêm
			                                <span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></button>
										</c:if>
											&nbsp; &nbsp; &nbsp;
											<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect button--colored-red" data-upgraded=",MaterialButton,MaterialRipple">
			                                    <i class="material-icons">forward</i>
			                                    Hủy bỏ
			                                <span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></button>
										</div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </main>
</body>
</html>