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
                                <h4 class="m-b-30 m-t-0">Edit </h4>
                                <h4>
                                    <a href="product">List All Product</a>
                                </h4>
                                <div style="text-align: center; clear: both;">
                                    <c:if test="${edit !=null}">
            <span style="color: green;">
                <c:out value="${edit}" />
            </span>
                                    </c:if>
                                </div>
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
                                <div class="row">
                                    <div class="col-lg-12 col-sm-12 col-12">
                                        <div class="table-responsive">
                                            <form class="row g-3 needs-validation" novalidate method="post">
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip01" class="form-label">Tên sản phẩm</label>
                                                    <input type="text" class="form-control" name="name" value="<c:out value='${data_product.tensp}' />" id="validationTooltip01"  required>
                                                    <div class="invalid-tooltip">
                                                        Hãy Nhập tên sản phẩm
                                                    </div>
                                                </div>
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip02" class="form-label">Gía sản phảm</label>
                                                    <input type="text" class="form-control" name="price" value="<c:out value='${data_product.gia}' />" id="validationTooltip02" required>
                                                    <div class="invalid-tooltip">
                                                        Hãy nhập giá
                                                    </div>
                                                </div>
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip03" class="form-label">Hình ảnh </label>
                                                    <input type="text" class="form-control" name="image" value="${data_product.hinhanh}"  id="validationTooltip03" required>
                                                    <div class="invalid-tooltip">
                                                        Hãy nhập hình ảnh
                                                    </div>
                                                </div>
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip05" class="form-label">Mô tả</label>
                                                    <input type="text" class="form-control" name="des" value="${data_product.mieuta}"  id="validationTooltip04" required>
                                                    <div class="invalid-tooltip">
                                                        Hãy nhập mô tả
                                                    </div>
                                                </div>
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip01" class="form-label">Gía nhập</label>
                                                    <input type="text" class="form-control" name="gianhap" value="${data_product.gianhap}" id="validationTooltip05" required>
                                                    <div class="invalid-tooltip">
                                                        Hãy nhập giá nhập
                                                    </div>
                                                </div>
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip02" class="form-label">Loại</label><br>
                                                    <c:if test="${data_product.idLoai == 1}">
                                                        <input type="radio" name="idLoai" size="15" checked value="1"/>Thú cưng
                                                        <input type="radio" name="idLoai" size="15" value="2"/>Phụ kiện
                                                        <input type="radio" name="idLoai" size="15" value="3"/>Dịch vụ
                                                    </c:if>
                                                    <c:if test="${data_product.idLoai == 2}">
                                                        <input type="radio" name="idLoai" size="15" value="1"/>Thú cưng
                                                        <input type="radio" name="idLoai" size="15" checked value="2"/>Phụ kiện
                                                        <input type="radio" name="idLoai" size="15" value="3"/>Dịch vụ
                                                    </c:if>
                                                    <c:if test="${data_product.idLoai == 3}">
                                                        <input type="radio" name="idLoai" size="15" value="1"/>Thú cưng
                                                        <input type="radio" name="idLoai" size="15" value="2"/>Phụ kiện
                                                        <input type="radio" name="idLoai" size="15" checked value="3"/>Dịch vụ
                                                    </c:if>
                                                    <div class="invalid-tooltip">
                                                        Nhập loại
                                                    </div>
                                                </div>
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip07" class="form-label">Ngày nhập</label>

                                                    <input type="text" class="form-control" name="ngaynhap"  value="${data_product.ngayNhap}" id="validationTooltip07" required>
                                                    <div class="invalid-tooltip">
                                                        Hãy nhập ngày nhập
                                                    </div>
                                                </div>
                                                <div class="col-md-6 position-relative">
                                                    <label for="validationTooltip05" class="form-label">Số lượng</label>
                                                    <input type="text" class="form-control"name="quantity" id="validationTooltip08" value="${data_product.soluong}" required>
                                                    <div class="invalid-tooltip">
                                                        Hãy nhập số lượng
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <br>
                                                    <button class="btn btn-primary" type="submit">Save</button>
                                                </div>
                                            </form>
<%--                                            <form method="post" id="edit">--%>
<%--                                                <table id="datatable"--%>
<%--                                                       class="table table-striped table-bordered dt-responsive nowrap"--%>
<%--                                                       cellspacing="0" width="100%">--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Tên sản phẩm:</th>--%>
<%--                                                        <td>--%>
<%--                                                            <input type="text" name="name" size="45"--%>
<%--                                                                   value="<c:out value='${data_product.tensp}' />" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Gía:</th>--%>
<%--                                                        <td>--%>
<%--                                                            <input type="text" name="price" size="15"--%>
<%--                                                                   value="<c:out value='${data_product.gia}' />" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Số lượng:</th>--%>
<%--                                                        <td>--%>
<%--                                                            <input type="text" name="quantity" size="45"--%>
<%--                                                                   value="${data_product.soluong}" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Hình ảnh:</th>--%>
<%--                                                        <td>--%>
<%--                                                            <input type="text" name="image" size="45"--%>
<%--                                                                   value="${data_product.hinhanh}" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Mô tả:</th>--%>
<%--                                                        <td>--%>
<%--                                                            <input type="text" name="des" size="45"--%>
<%--                                                                   value="${data_product.mieuta}" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Loại:</th>--%>
<%--                                                        <td>--%>
<%--                                                            <c:if test="${data_product.idLoai == 1}">--%>
<%--                                                                <input type="radio" name="idLoai" size="15" checked value="1"/>Thú cưng--%>
<%--                                                                <input type="radio" name="idLoai" size="15" value="2"/>Phụ kiện--%>
<%--                                                                <input type="radio" name="idLoai" size="15" value="3"/>Dịch vụ--%>
<%--                                                            </c:if>--%>
<%--                                                            <c:if test="${data_product.idLoai == 2}">--%>
<%--                                                                <input type="radio" name="idLoai" size="15" value="1"/>Thú cưng--%>
<%--                                                                <input type="radio" name="idLoai" size="15" checked value="2"/>Phụ kiện--%>
<%--                                                                <input type="radio" name="idLoai" size="15" value="3"/>Dịch vụ--%>
<%--                                                            </c:if>--%>
<%--                                                            <c:if test="${data_product.idLoai == 3}">--%>
<%--                                                                <input type="radio" name="idLoai" size="15" value="1"/>Thú cưng--%>
<%--                                                                <input type="radio" name="idLoai" size="15" value="2"/>Phụ kiện--%>
<%--                                                                <input type="radio" name="idLoai" size="15" checked value="3"/>Dịch vụ--%>
<%--                                                            </c:if>--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Ngày nhập :</th>--%>
<%--                                                        <td>--%>
<%--                                                            <input type="date" name="ngaynhap" size="45"--%>
<%--                                                                   value="${data_product.ngayNhap}" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <th>Gía nhập:</th>--%>
<%--                                                        <td>--%>
<%--                                                            <input type="text" name="gianhap" size="45"--%>
<%--                                                                   value="${data_product.gianhap}" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                    <tr>--%>
<%--                                                        <td colspan="2" align="center">--%>
<%--                                                            <input type="submit" value="Save" />--%>
<%--                                                        </td>--%>
<%--                                                    </tr>--%>
<%--                                                </table>--%>
<%--                                            </form>--%>
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


<script>
    $(function () {
        $("#edit").validate({
            rules: {
                // onfocusout: false,
                // onkeyup: false,
                // onclick: false,
                name: {
                    required: true,
                    minlength: 2,
                    maxlength: 50
                },
                price: {
                    required: true,
                    number: true,
                    min:1,
                    max: 100000000
                },
                gianhap: {
                    required: true,
                    number: true,
                    min:1,
                    max: 100000000
                },
                ngaynhap: {
                    required: true,
                },
                quantity: {
                    required: true,
                    minlength: 1,
                    maxlength: 20
                },
                image: {
                    required: true,
                },
                des: {
                    required: true,
                }
            },
            messages: {
                name: {
                    required: "hãy nhập tên sản phẩm",
                    minlength: "độ dài tối thiểu là 2",
                    maxlength: "độ dài tối đa là 50"
                },
                price: {
                    required: "Hãy nhập giá của sản phẩm",
                    number: "Hãy nhập lại giá của sản phẩm",
                    min:"Gía tối thiểu là 1",
                    max: "Gía tối đa là 100000000"
                },
                gianhap: {
                    required: "Hãy nhập giá nhập ",
                    number: "Hãy nhập lại số lương",
                    min:"Gía tối thiểu là 1",
                    max: "Gía tối đa là 100000000"
                },
                ngaynhap: {
                    required: "Hãy nhập ngày nhập",
                },
                quantity: {
                    required: "Hãy nhập số lượng",
                    minlength: "độ dài tối thiểu là 1",
                    maxlength: "độ dài tối đa là 20"
                },
                image: {
                    required: "Hãy nhập hình ảnh",
                },
                des: {
                    required: "Hãy nhập mô tả",
                }
            }
        });
    });
</script>
</body>
</html>
