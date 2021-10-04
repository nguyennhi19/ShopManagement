
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>shoppet.com </title>
    <link rel="shortcut icon" href="../assets/images/anhshop.jpg">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../layoutHomeAndList/link.jsp"></jsp:include>
</head>
<body class="home page-template-default page page-id-1276 theme-haustiere woocommerce-no-js preload theme-ver-2.7 wpb-js-composer js-comp-ver-6.0.4 vc_responsive">

<div class="wrap">
    <jsp:include page="../layoutHomeAndList/headerhome.jsp"></jsp:include>
    <div class="wrap-bread-crumb ">
        <div class="container">
            <div class="bread-crumb ">
                <a href="/homes">Trang chủ</a><span>Danh mục sản phẩm</span>
            </div>
        </div>
    </div>
    <div id="main-content" class="main-page-default">
        <div class="container">
            <div class="row">
                <div class="content-wrap col-md-12 col-sm-12 col-xs-12">
                    <article id="post-1276" class="post-1276 page type-page status-publish hentry">
                        <div class="entry-content clearfix">
                            <div class="clearfix">
                                <div class="vc_row wpb_row">
                                    <div class="wpb_column column_container col-sm-12">
                                        <div class="vc_column-inner vc_custom_1576307249231">
                                            <div class="wpb_wrapper">
                                                <div class="wpb_text_column wpb_content_element ">
                                                    <div class="wpb_wrapper">
                                                        <h2 class="font-coiny" style="text-align: center;">
                                                            <a href="http://localhost:8080/"><strong>Info</strong></a>
                                                        </h2>

                                                    </div>
                                                </div>
                                                <div class="row justify-content-around">

                                                    <div class="col-3">
                                                        <div class="preview_image">
                                                            <div class="preview-small">
                                                                <a>
                                                                    <img src="${sanpham.getHinhanh()}"
                                                                         style="max-height: 260px; max-width: 300px; display: block; margin-left: auto; margin-right: auto;"
                                                                         alt="">
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-8 product-info"  >
                                                        <form id="formDetail" action="/login"
                                                              method="post">
                                                            <div class="products-description">
                                                                <h5 class="title18 text-uppercase product-title dosis-font font-bold" style="font-size: 25px;">
                                                                    ${sanpham.getTensp()}
                                                                </h5>
                                                                <p class="description-detail">
                                                                    Mô tả: <span>${sanpham.getMieuta()}</span>
                                                                </p>
                                                                <hr class="border">
                                                                <div class="price">
                                                                    Giá :
                                                                    <span class="new_price" style="margin-left: 10px;"><fmt:formatNumber type="number"
                                                                                                                                         maxFractionDigits="3"
                                                                                                                                         value="${sanpham.getGia()}"/> VNĐ</span>
                                                                </div>
                                                                <hr class="border">
                                                                <div class="wided">
                                                                    <div class="qty">
                                                                        Số lượng &nbsp;&nbsp;: <input type="number" min="1" name="soluong" id="soluong"
                                                                                                      value="1" style="width: 100px;" required>
                                                                    </div>
                                                                    <div class="button_group">
                                                                        <a href="/">
                                                                            <button type="button" class="btn-cart btn-primary"><i class="fa fa-exchange"></i></button>
                                                                        </a>
                                                                        <button type="submit" class="btn-cart btn-success">+ Giỏ Hàng</button>
                                                                        <a href="/login">
                                                                            <button type="button" class="btn-cart btn-danger">Mua Ngay</button>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </form>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </article>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../layoutHomeAndList/footer.jsp"></jsp:include>
</div>
</body>
</html>
