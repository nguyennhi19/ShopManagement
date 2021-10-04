<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
                            <h4 class="header-title">Danh sách pet</h4>
                            <table id="basic-datatable" class="table dt-responsive nowrap">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>DateOfBirth</th>
                                    <th>Color</th>
                                    <th>Species</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>status</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="pet" items="${listPet}">
                                    <tr>
                                        <td style="text-align: right"><c:out value="${pet.id}"/></td>
                                        <td><c:out value="${pet.name}"/></td>
                                        <td style="text-align: right"><c:out value="${pet.age}"/></td>
                                        <c:if test="${pet.gender == 1}">
                                            <td><c:out value="Male"/></td>
                                        </c:if>
                                        <c:if test="${pet.gender == 0}">
                                            <td><c:out value="Female"/></td>
                                        </c:if>
                                        <td><c:out value="${pet.dateOfBirth}"/></td>
                                        <td><c:out value="${pet.color}"/></td>
                                        <td><c:out value="${pet.species}"/></td>
                                        <td style="text-align: right"><strong><fmt:formatNumber value="${pet.price}" type="currency" currencySymbol="₫"></fmt:formatNumber> </strong></td>
                                        <td style="text-align: right"><c:out value="${pet.quantity}"/></td>
                                        <td><c:out value="${pet.status}"/></td>
                                        <td>
                                            <a href="/pets?action=edit&id=${pet.id}" class="btn-sm btn-primary" title="Edit" size="30"><i class="fa fa-edit"></i></a>
                                            <a href="/pets?action=delete&id=${pet.id}" class="btn-sm btn-danger " title="Delete" size="30"><i class="fa fa-trash"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

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
