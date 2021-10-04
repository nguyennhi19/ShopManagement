<%
    request.setCharacterEncoding("UTF-8");
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="../jquery.validate.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery.validate-1.19.3.js"></script>
    <style>
        #name-error,#age-error,#address-error,#phone-error,#email-error {width:600px;margin: 20px auto;color:red;font-weight:bold}
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style>
        body{
            height: 100vh;
            background: palevioletred;
        }
        .section-login{
            min-height: 700px;
        }
        .form-background{
            background: white;
            margin-top:120px;
            margin-bottom: 10px;
            padding-top: 10px;
            border-radius: 10px ;
        }
        .form-background > h3{
            text-align: center;
            font-size: 30px;
        }
        .form-item{
            margin-bottom: 30px;
        }
        .pw{
            text-align: right;
        }
        .btn-login{
            padding: 12px 38px;
            font-size: 18px;
            text-transform: uppercase;
            letter-spacing: 2px;
            background-color: #e17055;
            color: white;
            border: none;
            display: table;
            cursor:pointer;
            margin: 15px auto 30px;
            border-radius: 10px ;
        }

        .user-register{
            text-align: center;
        }

    </style>
</head>
<body>
<section class="section-register">
    <div class="col-xs-2 col-sm-3 col-md-3 col-lg-4"></div>
    <div class="col-xs-8 col-sm-6 col-md-6 col-lg-4 form-background">
        <h3>Register now</h3>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <form name="loginForm" method="POST">
                <div class="row">
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" name="username" class="form-control" placeholder="User Name:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="password" name="password" class="form-control" placeholder="Password:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="password" name="repassword" class="form-control" placeholder="Retype Password:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" name="fullName" class="form-control" placeholder="Type name:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" name="email" class="form-control" placeholder="Type email:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" name="phone" class="form-control" placeholder="Type phone:">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                            <input type="text" name="address" class="form-control" placeholder="Type address:">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
<%--                        <h4 style="text-align:center" class="${mess=="Successful"?"btn-success":"btn-danger"}">${mess}</h4>--%>
                        <c:if test='${requestScope["success"] != null}'>
                            <div id="div1" class="alert alert-success" role="alert">
                                    ${requestScope["success"]}
                            </div>
                        </c:if>
                        <c:if test='${requestScope["mess"] != null}'>
                            <div id="div1" class="alert alert-danger" role="alert">
                                    ${requestScope["mess"]}
                            </div>
                        </c:if>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item">
                        <a href="/login">Back to login</a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 form-item" style="text-align:center">
                        <input type="submit" name="submit" class="btn-login" value="REGISTER">
                    </div>
                </div>
            </form>
        </div>
    </div>
    </div>
    <div class="col-xs-2 col-sm-3 col-md-3 col-lg-4"></div>
</section>
</body>
</html>
