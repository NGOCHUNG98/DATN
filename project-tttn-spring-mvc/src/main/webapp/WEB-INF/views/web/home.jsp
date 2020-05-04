<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<!-- ****** Welcome Slides Area Start ****** -->
	<section class="welcome_area">
		<div class="welcome_slides owl-carousel">
			<!-- Single Slide Start -->
			<div class="single_slide height-800 bg-img background-overlay"
				style="background-image: url('https://wallpaperset.com/w/full/1/d/4/104369.jpg');">
				<div class="container h-100">
					<div class="row h-100 align-items-center">
						<div class="col-12">
							<div class="welcome_slide_text">
								<h6 data-animation="bounceInDown" data-delay="0"
									data-duration="500ms">* Only today we offer free shipping</h6>
								<h2 data-animation="fadeInUp" data-delay="500ms"
									data-duration="500ms">Passion Trends</h2>
								<a href="#" class="btn karl-btn" data-animation="fadeInUp"
									data-delay="1s" data-duration="500ms">Shop Now</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Single Slide Start -->
			<div class="single_slide height-800 bg-img background-overlay"
				style="background-image: url('https://wallpaperset.com/w/full/6/9/9/104121.jpg');">
				<div class="container h-100">
					<div class="row h-100 align-items-center">
						<div class="col-12">
							<div class="welcome_slide_text">
								<h6 data-animation="fadeInDown" data-delay="0"
									data-duration="500ms">* Only today we offer free shipping</h6>
								<h2 data-animation="fadeInUp" data-delay="500ms"
									data-duration="500ms">Passion Meets</h2>
								<a href="#" class="btn karl-btn" data-animation="fadeInLeftBig"
									data-delay="1s" data-duration="500ms">Check now</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Single Slide Start -->
			<div class="single_slide height-800 bg-img background-overlay"
				style="background-image: url('https://wallpaperset.com/w/full/1/c/6/104033.jpg');">
				<div class="container h-100">
					<div class="row h-100 align-items-center">
						<div class="col-12">
							<div class="welcome_slide_text">
								<h6 data-animation="fadeInDown" data-delay="0"
									data-duration="500ms">* Only today we offer free shipping</h6>
								<h2 data-animation="bounceInDown" data-delay="500ms"
									data-duration="500ms">Cool tyle for Women </h2>
								<a href="#" class="btn karl-btn" data-animation="fadeInRightBig"
									data-delay="1s" data-duration="500ms">Check now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ****** Welcome Slides Area End ****** -->
	<!-- ****** Top Catagory Area Start ****** -->
	<section class="top_catagory_area d-md-flex clearfix">
		<!-- Single Catagory -->
		<div class="single_catagory_area d-flex align-items-center bg-img"
			style="background-image: url('https://wallpaperset.com/w/full/1/2/4/104191.jpg');">
			<div class="catagory-content">
				<h6>On Accesories</h6>
				<h2>Sale 30%</h2>
				<a href="#" class="btn karl-btn">SHOP NOW</a>
			</div>
		</div>
		<!-- Single Catagory -->
		<div class="single_catagory_area d-flex align-items-center bg-img"
			style="background-image: url('https://wallpaperset.com/w/full/d/6/e/104379.jpg');">
			<div class="catagory-content">
				<h6>in Bags excepting the new collection</h6>
				<h2>Designer bags</h2>
				<a href="#" class="btn karl-btn">SHOP NOW</a>
			</div>
		</div>
	</section>
	<!-- ****** Top Catagory Area End ****** -->
	<!-- ****** Quick View Modal Area Start ****** -->

	
	<!-- ****** Quick View Modal Area End ****** -->
	<!-- ****** New Arrivals Area Start ****** -->
	<form action='<c:url value="/trang-chu?page=1&limit=6"/>' method="get" id="formSubmit">
	<section class="new_arrivals_area section_padding_100_0 clearfix">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section_heading text-center">
						<h2>New Motorcycle</h2>
					</div>
				</div>
			</div>
		</div>

		<div class="karl-projects-menu mb-100">
			<div class="text-center portfolio-menu">
				<a class="btn active" href='<c:url value="/trang-chu?page=1&limit=6"/>'>ALL</a>
                    <c:forEach var="item" items="${menu.listResult}">
                    	<c:url var="motocrycleById" value="/danh-sach-xe-may-theo-hang-san-xuat">
							<c:param name="id" value="${item.id}"></c:param>
						</c:url>
						<%-- <button class="btn">${item.name}</button> --%>
						<a class="btn" href="${motocrycleById}">${item.name}</a>
                	</c:forEach>
			</div>
		</div>
		
		<div class="container">
			<div class="row karl-new-arrivals">
				<c:forEach var="item" items="${model.listResult}">
					<c:url var="findDetailMotocrycleById" value="/chi-tiet-xe-may">
						<c:param name="id" value="${item.id}"></c:param>
					</c:url>
					<!-- Single gallery Item Start -->
					<div class="col-12 col-sm-6 col-md-4 single_gallery_item women wow fadeInUpBig" data-wow-delay="0.2s">
						<!-- Product Image -->
						<div class="product-img">
							<a href="${findDetailMotocrycleById}"><img style="width: 400px; height: 250px;"
								src='<c:url value="/resources/images/${item.thumbnail}"/>'
								alt=""></a>
							<%-- <div class="product-quicview">
	                                <a href='<c:url value="/thong-tin-xe-may?id=${item.id}"/>' data-toggle="modal" data-target="#quickview"><i class="ti-plus"></i></a>
	                            </div> --%>
						</div>
						<!-- Product Description -->
						<div class="product-description">
							<h3>${item.name}</h3>
							<h4 class="product-price">
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${item.price}" />
								<small class="text-muted">đ</small>
							</h4>
							<p>${item.description}</p>
							<!-- Add to Cart -->
							<a href='<c:url value="/mua-hang?id=${item.id}"/>'
								class="add-to-cart-btn">ADD TO CART</a>
						</div>
						
					</div>
					</c:forEach>
					
			</div>
		</div>
	</section>
	</form>
	<!-- ****** New Arrivals Area End ****** -->
	<!-- ****** Offer Area Start ****** -->
	<section class="offer_area height-700 section_padding_100 bg-img"
		style="background-image: url('https://wallpaperset.com/w/full/0/f/b/104269.jpg');">
		<div class="container h-100">
			<div class="row h-100 align-items-end justify-content-end">
				<div class="col-12 col-md-8 col-lg-6">
					<div class="offer-content-area wow fadeInUp" data-wow-delay="1s">
						<h2>
							Speed enthusiasts <span class="karl-level">Hot</span>
						</h2>
						<p>* Free shipping until 25 Dec 2017</p>
						<div class="offer-product-price">
							<h3>
								<span class="regular-price">$9700.00</span> $8500.90
							</h3>
						</div>
						<a href="#" class="btn karl-btn mt-30">Shop Now</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ****** Offer Area End ****** -->
	<!-- ****** Popular Brands Area Start ****** -->
	<section class="karl-testimonials-area section_padding_100">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section_heading text-center">
						<h2>Testimonials</h2>
					</div>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-12 col-md-8">
					<div class="karl-testimonials-slides owl-carousel">

						<!-- Single Testimonial Area -->
						<div class="single-testimonial-area text-center">
							<span class="quote">"</span>
							<h6>Nunc pulvinar molestie sem id blandit. Nunc venenatis
								interdum mollis. Aliquam finibus nulla quam, a iaculis justo
								finibus non. Suspendisse in fermentum nunc.Nunc pulvinar
								molestie sem id blandit. Nunc venenatis interdum mollis.</h6>
							<div
								class="testimonial-info d-flex align-items-center justify-content-center">
								<div class="tes-thumbnail">
									<img src="" alt="">
								</div>
								<div class="testi-data">
									<p>Michelle Williams</p>
									<span>Client, Los Angeles</span>
								</div>
							</div>
						</div>

						<!-- Single Testimonial Area -->
						<div class="single-testimonial-area text-center">
							<span class="quote">"</span>
							<h6>Nunc pulvinar molestie sem id blandit. Nunc venenatis
								interdum mollis. Aliquam finibus nulla quam, a iaculis justo
								finibus non. Suspendisse in fermentum nunc.Nunc pulvinar
								molestie sem id blandit. Nunc venenatis interdum mollis.</h6>
							<div
								class="testimonial-info d-flex align-items-center justify-content-center">
								<div class="tes-thumbnail">
									<img src="" alt="">
								</div>
								<div class="testi-data">
									<p>Michelle Williams</p>
									<span>Client, Los Angeles</span>
								</div>
							</div>
						</div>

						<!-- Single Testimonial Area -->
						<div class="single-testimonial-area text-center">
							<span class="quote">"</span>
							<h6>Nunc pulvinar molestie sem id blandit. Nunc venenatis
								interdum mollis. Aliquam finibus nulla quam, a iaculis justo
								finibus non. Suspendisse in fermentum nunc.Nunc pulvinar
								molestie sem id blandit. Nunc venenatis interdum mollis.</h6>
							<div
								class="testimonial-info d-flex align-items-center justify-content-center">
								<div class="tes-thumbnail">
									<img src="" alt="">
								</div>
								<div class="testi-data">
									<p>Michelle Williams</p>
									<span>Client, Los Angeles</span>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</section>
	
	<!-- ****** Popular Brands Area End ****** -->
</body>
</html>