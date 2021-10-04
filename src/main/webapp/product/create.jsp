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
                                    <li class="breadcrumb-item active">Quản lý pet</li>
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
                                <h4 class="m-b-30 m-t-0">Create</h4>
                                <h4>
                                    <a href="product">List All Pets</a>
                                </h4>
                                <div class="message">
                                    <c:if test='${requestScope["success"] != null}'>
                                        <div id="div1" class="alert alert-success" role="alert">
                                                ${requestScope["success"]}
                                        </div>
                                    </c:if>
                                    <c:if test='${requestScope["error"] != null}'>
                                        <div id="div1" class="alert alert-danger" role="alert">
                                                ${requestScope["error"]}
                                        </div>
                                    </c:if>
                                </div>
                                <form class="row g-3 needs-validation" novalidate method="post">
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip01" class="form-label">Tên sản phẩm</label>
                                        <input type="text" class="form-control" name="tensp" id="validationTooltip01"  required>
                                        <div class="invalid-tooltip">
                                            Hãy Nhập tên sản phẩm
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip02" class="form-label">Gía sản phảm</label>
                                        <input type="text" class="form-control" name="gia" id="validationTooltip02" required>
                                        <div class="invalid-tooltip">
                                            Hãy nhập giá
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip03" class="form-label">Hình ảnh </label>
                                        <input type="text" class="form-control" name="hinhanh" id="validationTooltip03" required>
                                        <div class="invalid-tooltip">
                                            Hãy nhập hình ảnh
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip05" class="form-label">Mô tả</label>
                                        <input type="text" class="form-control" name="mota" id="validationTooltip04" required>
                                        <div class="invalid-tooltip">
                                            Hãy nhập mô tả
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip01" class="form-label">Gía nhập</label>
                                        <input type="text" class="form-control" name="gianhap" id="validationTooltip05" required>
                                        <div class="invalid-tooltip">
                                            Hãy nhập giá nhập
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip02" class="form-label">Loại</label><br>
                                        <select name="category">--%>
                                            <c:forEach var="country" items='${requestScope["data"]}'>
                                                <option value="${country.id}" class="form-control">${country.getName()}</option>
                                            </c:forEach>
                                        </select>
                                        <div class="invalid-tooltip">
                                            Nhập loại
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip03" class="form-label">Ngày nhập</label>
                                        <input type="date" class="form-control" name="ngaynhap" id="validationTooltip07" required>
                                        <div class="invalid-tooltip">
                                            Hãy nhập ngày nhập
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip05" class="form-label">Số lượng</label>
                                        <input type="text" class="form-control"name="soluong" id="validationTooltip08" required>
                                        <div class="invalid-tooltip">
                                            Hãy nhập số lượng
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <br>
                                        <button class="btn btn-primary" type="submit">Save</button>
                                    </div>
                                </form>

<%--                                <form id="create" method="post">--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label  class="col-form-label">Tên sản phẩm</label>--%>
<%--                                        <input type="text" name="tensp" id="tensp" class="form-control" size="45" />--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label  class="col-form-label">Gía</label>--%>
<%--                                        <input type="text" name="gia" id="gia" class="form-control" size="45" />--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label  class="col-form-label">Số lượng</label>--%>
<%--                                        <input type="text" name="soluong" id="soluong" class="form-control" size="45" />--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label  class="col-form-label">Hình ảnh</label>--%>
<%--                                        <input type="text" name="hinhanh" id="hinhanh" class="form-control" size="45" />                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label  class="col-form-label">Loại</label>--%>
<%--                                        <select name="category">--%>
<%--                                            <c:forEach var="country" items='${requestScope["data"]}'>--%>
<%--                                                <option value="${country.id}" class="form-control">${country.getName()}</option>--%>
<%--                                            </c:forEach>--%>
<%--                                        </select>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label class="col-form-label">Mô tả</label>--%>
<%--                                        <input type="text" name="mota" id="mota" class="form-control" size="45" />                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label  class="col-form-label">Gía nhập</label>--%>
<%--                                        <input type="text" name="gianhap" id="gianhap" class="form-control" size="45" />--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label  class="col-form-label">Ngày nhập</label>--%>
<%--                                        <<input type="date" name="ngaynhap" id="ngaynhap" class="form-control" size="45" />--%>
<%--                                    </div>--%>

<%--                                    <button type="submit" class="btn btn-primary">Save</button>--%>
<%--                                </form>--%>

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
