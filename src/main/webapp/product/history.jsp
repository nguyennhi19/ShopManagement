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
                                <h4 class="m-b-30 m-t-0">List History</h4>
                                <p class="text-muted font-13 mb-4">
                                </p>
                                <div class="row">
                                    <div class="col-lg-12 col-sm-12 col-12">
                                        <div class="table-responsive">
                                            <table id="basic-datatable" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"  width="100%">
                                                <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Id_hoadon</th>
                                                    <th>Id_sanpham</th>
                                                    <th>Id_khachhang</th>
                                                    <th>TenSanPham</th>
                                                    <th>TenKhachHang</th>
                                                    <th>Gia</th>
                                                    <th>GiaNhap</th>
                                                    <th>Ngayban</th>
                                                    <th>TongTienHang</th>
                                                    <th>TongtienTT</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="product" items="${list}">
                                                    <tr>
                                                        <td><c:out value="${product.id}"/></td>
                                                        <td><c:out value="${product.idHoadon}"/></td>
                                                        <td><c:out value="${product.idSanpham}"/></td>
                                                        <td><c:out value="${product.idKhachhang}"/></td>
                                                        <td><c:out value="${product.tenSanPham}"/></td>
                                                        <td><c:out value="${product.tenKhachHang}"/></td>
                                                        <td><c:out value="${product.gia}"/></td>
                                                        <td><c:out value="${product.giaNhap}"/></td>
                                                        <td><c:out value="${product.ngayban}"/></td>
                                                        <td><c:out value="${product.tongTienHang}"/></td>
                                                        <td><c:out value="${product.tongtienTT}"/></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <p  style="float: right;font-weight: bold; margin-right: 150px ">Doanh thu:<c:out value="${total}"/></p>
                                            <p  style="float: right;font-weight: bold; margin-right: 150px ">Lợi nhuận:<c:out value="${loinhuan}"/></p>
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
