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
                                <h4 class="m-b-30 m-t-0">Delete </h4>
                                <h4>
                                    <a href="product">List All Product</a>
                                </h4>
                                <div style="text-align: center; clear: both;">
                                    <c:if test="${success !=null}">
                                                    <span style="color: green;">
                                                        <c:out value="${success}" />
                                                    </span>
                                    </c:if>
                                    <c:if test="${error !=null}">
                                                    <span style="color: red;">
                                                        <c:out value="${error}" />
                                                    </span>
                                    </c:if>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12 col-sm-12 col-12">
                                        <div class="table-responsive">
                                            <form method="post">
                                                <h3>Are you sure?</h3>
                                                <table id="datatable"
                                                       class="table table-striped table-bordered dt-responsive nowrap"
                                                       cellspacing="0" width="100%">
                                                    <tr>
                                                        <th>Tên sản phẩm:</th>
                                                        <td>
                                                            <input type="text" name="name" size="45" required
                                                                   value="<c:out value='${data_product.tensp}' />" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>Gía:</th>
                                                        <td>
                                                            <input type="number" name="price" size="15" required
                                                                   value="<c:out value='${data_product.gia}' />" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>Số lượng:</th>
                                                        <td>
                                                            <input type="number" name="quantity" size="45" required
                                                                   value="<c:out value='${data_product.soluong}' />" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>Hình ảnh:</th>
                                                        <td>
                                                            <input type="text" name="image" size="45" required
                                                                   value="<c:out value='${data_product.hinhanh}' />" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>Mô tả:</th>
                                                        <td>
                                                            <input type="text" name="des" size="45" required
                                                                   value="<c:out value='${data_product.mieuta}' />" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <th>Loại:</th>
                                                        <td>
                                                            <c:if test="${data_product.idLoai == 1}">
                                                                <input type="text" name="idLoai" size="15" checked value="Thú cưng"/>
<%--                                                                <input type="text" name="idLoai" size="15" value="2"/>Phụ kiện--%>
<%--                                                                <input type="text" name="idLoai" size="15" value="3"/>Dịch vụ--%>
                                                            </c:if>
                                                            <c:if test="${data_product.idLoai == 2}">
<%--                                                                <input type="text" name="idLoai" size="15" value="1"/>Thú cưng--%>
                                                                <input type="text" name="idLoai" size="15" checked value="Phụ kiện"/>
<%--                                                                <input type="text" name="idLoai" size="15" value="3"/>Dịch vụ--%>
                                                            </c:if>
                                                            <c:if test="${data_product.idLoai == 3}">
<%--                                                                <input type="text" name="idLoai" size="15" value="1"/>Thú cưng--%>
<%--                                                                <input type="text" name="idLoai" size="15" value="2"/>Phụ kiện--%>
                                                                <input type="text" name="idLoai" size="15" checked value="Dịch vụ"/>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><input type="submit" value="Delete"></td>
                                                        <td><a href="http://localhost:8080/products?action=products">Back to customer list</a></td>
                                                    </tr>
                                                </table>
                                            </form>
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
