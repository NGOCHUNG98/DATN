<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
	<div class="cart_area section_padding_100 clearfix">
            <div class="container">
                <div class="row">
                
                    <div class="col-12">
                    <form action='<c:url value="/cap-nhap-so-luong"/>' method="post">
                        <div class="cart-table clearfix">
                            <table class="table table-responsive">
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Thao tác</th>
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
                                        <td class="qty">
                                            <div class="quantity">
                                                <%-- <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty > 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                                <input type="number" class="qty-text" id="qty" step="1" min="1" max="99" name="quantity" value="${pr.value.quantity}">
                                                <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span> --%>
                                            	<input type="text" name="quantity" value="${pr.value.quantity}">
                                            </div>
                                        </td>
                                        
                                        <td>
											<a href='<c:url value="/gio-hang/xoa-hang?id=${pr.value.motocrycle.id}"/>'>Remove</a>
										</td>
                                    </tr>
                                   </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="cart-footer d-flex mt-30">
                            <div class="back-to-shop w-50">
                                <a href='<c:url value="/trang-chu?page=1&limit=6"/>'>Continue shooping</a>
                            </div>
                            <div class="update-checkout w-50 text-right">
                                <button type="submit" class="btn karl-btn">Clear cart</button>
                                <button type="submit" class="btn karl-btn">Update cart</button>
                                
                            </div>
                        </div>
                        </form>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="coupon-code-area mt-70">
                            <div class="cart-page-heading">
                                <h5>Cupon code</h5>
                                <p>Enter your cupone code</p>
                            </div>
                            <form action="#">
                                <input type="search" name="search" placeholder="#569ab15">
                                <button type="submit">Apply</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="shipping-method-area mt-70">
                            <div class="cart-page-heading">
                                <h5>Shipping method</h5>
                                <p>Select the one you want</p>
                            </div>

                            <div class="custom-control custom-radio mb-30">
                                <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input">
                                <label class="custom-control-label d-flex align-items-center justify-content-between" for="customRadio1"><span>Next day delivery</span><span>$4.99</span></label>
                            </div>

                            <div class="custom-control custom-radio mb-30">
                                <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input">
                                <label class="custom-control-label d-flex align-items-center justify-content-between" for="customRadio2"><span>Standard delivery</span><span>$1.99</span></label>
                            </div>

                            <div class="custom-control custom-radio">
                                <input type="radio" id="customRadio3" name="customRadio" class="custom-control-input">
                                <label class="custom-control-label d-flex align-items-center justify-content-between" for="customRadio3"><span>Personal Pickup</span><span>Free</span></label>
                            </div>
                        </div>
                    </div>
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
                            <a href='<c:url value="/thanh-toan"/>' class="btn karl-checkout-btn">Thanh toán</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>