<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/8/2021
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Shop Pet</title>
    <jsp:include page="../layoutDashboard/link.jsp"></jsp:include>

</head>

<body>

<!-- Begin page -->
<div id="wrapper">

    <!-- Topbar Start -->
    <jsp:include page="../layoutDashboard/nav-cus.jsp"></jsp:include>
    <!-- end Topbar -->

    <!-- ========== Left Sidebar Start ========== -->
    <jsp:include page="../layoutDashboard/leftSidebar.jsp"></jsp:include>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Shop Mập</a></li>
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">quản lý shop</a></li>
<%--                                    <li class="breadcrumb-item active">Quản lý pet</li>--%>
                                </ol>
                            </div>
                            <h4 class="page-title">Quản lý shop</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">

                                <h4 class="m-b-30 m-t-0">List Product</h4>
                                <h4>
                                    <a href="products?action=create">Add New Product</a>
                                    <a href="/products?action=show">showlist</a>
                                </h4>
                                <div class="block-element block-search-element main-search-form vc_custom_1582939942088" style="text-align: right; padding: 8px;">
                                    <form class="search-form  main-search-form vc_custom_1582939942088 live-search-on">
                                        <input placeholder="Tìm kiếm..." type="text" style="width: 500px">
                                        <%--                                            <div class="submit-form">--%>
                                        <a href="/products?action=search&id=${product.getId()}"><i class="fas fa-search"></i></a>
                                        <%--                                            </div>--%>
                                    </form>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12 col-sm-12 col-12">
                                        <div class="table-responsive">
                                            <table id="basic-datatable" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                                                <div style="text-align: center; clear: both;">
                                                    <c:if test="${delete !=null}">
                                                        <span style="color: green;"><c:out value="${delete}"/></span>
                                                    </c:if>
                                                </div>
                                                <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Tên sản phẩm</th>
                                                    <th>Gía</th>
                                                    <th>Số lượng</th>
                                                    <th>Hình ảnh</th>
                                                    <th>Loại</th>
                                                    <th>Mô tả</th>
                                                    <th>Actions</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="product" items="${list}">
                                                    <tr>
                                                        <td><c:out value="${product.id}"/></td>
                                                        <td><c:out value="${product.tensp}"/></td>
                                                        <td><c:out value="${product.gia}"/></td>
                                                        <td><c:out value="${product.soluong}"/></td>
                                                        <td><img src="${product.hinhanh}" style="width:70px; height:auto"></td>
                                                        <c:if test="${product.idLoai == 1}">
                                                            <td>
                                                                <span class="badge badge-primary">Thú cưng</span>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${product.idLoai == 2}">
                                                            <td>
                                                                <span class="badge badge-primary">Phụ kiện</span>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${product.idLoai == 3}">
                                                            <td>
                                                                <span class="badge badge-primary">Dịch vụ</span>
                                                            </td>
                                                        </c:if>
                                                        <td><c:out value="${product.mieuta}"/></td>
                                                        <td width="120px">
                                                            <a href="/product?action=edit&id=${product.id}" class="btn-sm btn-primary" title="Edit" size="30"><i class="fa fa-edit"></i></a>
                                                            <a href="/product?action=delete&id=${product.id}" class="btn-sm btn-danger " title="Delete" size="30"><i class="fa fa-trash"></i></a>
                                                            <a href="/product?action=info&id=${product.id}" title="Information" class="btn-me"><i class="fas fa-info-circle"></i></a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>
                                </div>
                            </div> <!-- end card body-->
                        </div> <!-- end card -->
                    </div><!-- end col-->
                </div>
                <!-- end row-->
            </div> <!-- container -->

        </div> <!-- content -->

        <!-- Footer Start -->
        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        2016 - 2019 &copy; Shoppet theme by <a href="">Coderthemes</a>
                    </div>
                    <div class="col-md-6">
                        <div class="text-md-right footer-links d-none d-sm-block">
                            <a href="javascript:void(0);">About Us</a>
                            <a href="javascript:void(0);">Help</a>
                            <a href="javascript:void(0);">Contact Us</a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- end Footer -->

    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->


</div>
<!-- END wrapper -->

<!-- Right Sidebar -->
<jsp:include page="../layoutDashboard/right.jsp"></jsp:include>
<!-- /Right-bar -->

<!-- Right bar overlay-->
<div class="rightbar-overlay"></div>

<!-- Vendor js -->
<jsp:include page="../layoutDashboard/script.jsp"></jsp:include>

</body>
</html>
