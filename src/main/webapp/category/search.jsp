
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>shoppet.com </title>
    <link rel="shortcut icon" href="assets/images/anhshop.jpg">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../layoutHomeAndList/link.jsp"></jsp:include>
</head>
<body class="home page-template-default page page-id-1276 theme-haustiere woocommerce-no-js preload theme-ver-2.7 wpb-js-composer js-comp-ver-6.0.4 vc_responsive">

<div class="wrap">
    <jsp:include page="../layoutHomeAndList/header.jsp"></jsp:include>
    <div class="wrap-bread-crumb ">
        <div class="container">
            <div class="bread-crumb ">
                <a href="http://localhost:8080//">Trang chủ</a><span>Danh mục sản phẩm</span>
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
                                                            <a href="http://localhost:8080/"><strong>SEARCH</strong></a>
                                                        </h2>

                                                    </div>
                                                </div>
                                                <div class="row justify-content-around">
                                                <c:forEach var="sanpham" items='${requestScope["productList"]}'>
                                                    <div class="col-3">
                                                        <div class="product-thumb">
                                                            <a href="?action=infop&id=${sanpham.getId()}"
                                                               class="product-thumb-link zoom-thumb">
                                                                <img src="${sanpham.getHinhanh()}" style="width: 300px; height: 300px"
                                                                     class="attachment-270x270 size-270x270 wp-post-image"
                                                                     alt="Product Name" />
                                                            </a>
                                                        </div>
                                                        <div class="product-info">
                                                            <span class="title12 text-uppercase color font-bold">ID:${sanpham.getId()}</span>
                                                            <h3 class="title18 text-uppercase product-title dosis-font font-bold">
                                                                <a title="dd"  href="?action=infop&id=${sanpham.getId()}" class="black">${sanpham.getTensp()}</a>
                                                            </h3>
                                                            <div class="product-price simple">
                                                                <span
                                                                        class="woocommerce-Price-amount amount">${sanpham.getGia()}
                                                                    <span
                                                                            class="woocommerce-Price-currencySymbol">&#8363;
                                                                    </span>
                                                                    <a style="margin-left: 75px" href="/?action=addtocartInHome&id=${sanpham.getId()}">Buy</a>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
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
