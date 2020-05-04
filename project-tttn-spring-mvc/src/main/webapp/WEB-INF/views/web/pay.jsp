<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglib.jsp"%>
   <%@ page import="com.laptrinhjavaweb.util.SecurityUtils"%>
   <c:url var="city" value="/city.json"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>
</head>
<body>
 <form action='<c:url value="/dat-hang"/>' method="post">
	<div class="cart_area section_padding_100 clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-12">
					    <div class="form-group">
					        <label for="customerName">Họ và tên</label>
					        <input type="text" class="form-control" id="customerName" name="customerName" value="<%=SecurityUtils.getPrincipal().getFullname()%>" placeholder="Nhập họ và tên">
					    </div>
					
					    <div class="form-group">
					        <label for="customerPhone">Số điện thoại</label>
					        <input type="text" class="form-control" id="customerPhone" name="customerPhone" value="<c:url value="${order.customerPhone}"/>" placeholder="Nhập số điện thoại">
					    </div>
					    
					    <div class="form-group">
					        <label for="customerAddress">Địa chỉ nhận hàng</label>
					       <select class="form-control" id="customerAddress" name="customerAddress">
					       	<c:forEach var="pr" items="${title}">
						       		<option value="<c:url value="${pr}"/>">${pr}</option>
						    </c:forEach>
					       </select>
					    </div>
					    
					    <div class="form-group">
					        <label for="note">Ghi chú</label>
					        <input type="text" class="form-control" id="note" name="note" value="<c:url value="${order.note}"/>" placeholder="Nhập ghi chú">
					    </div>
					    
                        <div class="cart-table clearfix">
                            <table class="table table-responsive">
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th style="text-align: center;">Price</th>
                                        <th style="text-align: center;">Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="pr" items="${sessionScope.cart}">
									<c:set var="s" value="${s+ pr.value.motocrycle.price * pr.value.quantity}"></c:set>
                                    <tr>
                                        <td class="cart_product_img d-flex align-items-center">
                                            <a href="#">
                                            	<img class="card-img-top thumnail-image" src='<c:url value="/resources/images/${pr.value.motocrycle.thumbnail}"/>' />
                                            </a>
                                            <h6>${pr.value.motocrycle.name}</h6>
                                        </td>
                                        <td class="price">
                                        	<span>
                                        		<fmt:formatNumber type="number" maxFractionDigits="3" value="${pr.value.motocrycle.price}" />
												<small class="text-muted">đ</small>
											</span>
                                        </td>
                                        <td class="cart_product_img">
                                                <!-- <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty > 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span> -->
                                               <!--  <input type="number" class="qty-text" id="qty" step="1" min="1" max="99" name="quantity" value="1">
                                                <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span> -->
                                            	<%-- <input type="text" value="${pr.value.quantity}" readonly="readonly"> --%>
                                            	<h6 style="text-align: center;">${pr.value.quantity}</h6>
                                        </td>
                                    </tr>
                                   </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-lg-4">
                        <div class="cart-total-area mt-70">
                            <div class="cart-page-heading">
                                <h5>Cart total</h5>
                                <p>Final info</p>
                            </div>

                            <ul class="cart-total-chart">
                                <li><span>Subtotal</span> <span><fmt:formatNumber type="number" maxFractionDigits="3" value="${s}" />
												<small class="text-muted">đ</small></span></li>
                                <li><span>Shipping</span> <span>Free</span></li>
                                <li><span><strong>Total</strong></span> <span><strong><fmt:formatNumber type="number" maxFractionDigits="3" value="${s}" />
												<small class="text-muted">đ</small></strong></span></li>
                            </ul>
                            <button type="submit" class="btn karl-checkout-btn">Mua hàng</button>
                           <%--  <a href='<c:url value="/dat-hang"/>' class="btn karl-checkout-btn">Đặt hàng</a> --%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  </form>
</body>
</html>