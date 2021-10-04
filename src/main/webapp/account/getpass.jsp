<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/9/2021
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate-1.19.3.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            height: 100vh;
            background: palevioletred;
        }

        #username-error, #fullName-error, #email-error, #phone-error, #email-error {
            width: 600px;
            margin: 20px auto;
            color: red;
            font-weight: bold
        }

        .section-login {
            min-height: 700px;
        }

        .form-background {
            background: white;
            margin-top: 120px;
            margin-bottom: 10px;
            padding-top: 10px;
            border-radius: 10px;
        }

        .form-background > h3 {
            text-align: center;
            font-size: 30px;
        }

        .form-item {
            margin-bottom: 30px;
        }

        .pw {
            text-align: right;
        }

        .btn-login {
            padding: 12px 38px;
            font-size: 18px;
            text-transform: uppercase;
            letter-spacing: 2px;
            background-color: #e17055;
            color: white;
            border: none;
            display: table;
            cursor: pointer;
            margin: 15px auto 30px;
            border-radius: 10px;
        }

        .user-register {
            text-align: center;
        }

    </style>
</head>
<body>
<section class="section-register">
    <div class="col-xs-2 col-sm-3 col-md-3 col-lg-4"></div>
    <div class="col-xs-8 col-sm-6 col-md-6 col-lg-4 form-background">
        <h3>Get your password</h3>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="row">
                <form name="loginForm" method="POST" id="getpass">
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" id="username" name="username" class="form-control"
                                   placeholder="User Name:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" id="fullName" name="fullName" class="form-control"
                                   placeholder="Type name:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" id="email" name="email" class="form-control" placeholder="Type email:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <%--                            <h4 style="text-align:center" class="${mess=="Something is wrong !"?"btn-danger":"btn-success"}">${mess}</h4>--%>
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
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <a href="/login">Back to login</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item" style="text-align:center">
                            <input type="submit" name="submit" class="btn-login" value="CHECK">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
    <div class="col-xs-2 col-sm-3 col-md-3 col-lg-4"></div>
</section>
<script>
    $(document).ready(function () {
        $("#getpass").validate({
            rules: {
                username: {
                    required: true,
                },
                fullName: {
                    required: true,
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                username: {
                    required: "Không được để trống",
                },
                fullName: {
                    required: "Không được để trống",
                },
                email: {
                    required: "Không được để trống",
                    email: "email không hợp lệ"
                }
            }
        })
    });
</script>
</body>
</html>
