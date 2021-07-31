<%-- 
    Document   : index
    Created on : Jul 8, 2021, 9:40:35 PM
    Author     : dilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="<c:url value='../../../resources/js/jquery-1.8.3.min.js'/> "></script>
        <script src="<c:url value='../../../resources/js/jquery.validate.min.js'/> "></script>
        <script src="<c:url value='../../../resources/js/handsontable-0.7.5/dist/jquery.handsontable.full.js'/> "></script>
        <style>
            .handsontableInputHolder{
                display: none;
            }
            .htCore tr td {
                background-color: #FF0;
            }
            .htCore th {
                background-color: #FFF;
            }
            .htCore tr td{
                padding: 10px;
                margin: 10px;
            }
            p.error{
                color:red;
            }
            #vehicleDetails label{
                margin-top: 20px;
            }
            .submitButton{
                color: white;
                background-color: blue;
            }

        </style>
    </head>
    <body onload="onLoad()">
        <H1>Vehicle Store</H1>
        <div class="col-md-12">
            <h3>Vehicle details</h3>
            <div class="col-md-12">
                <FORM ID="handsontableForm">
                    <div id="dataTable"></div>
                </FORM>
            </div>
            <div style=" margin-top: 20px; background-color: activeborder">
                <h3>Add new vehicle</h3>
                <form id="vehicleDetails">
                    <div style="float: left" class="col-md-6">
                        <input hidden id="id" name="id" value="">
                        <label>Vehicle Brand</label>
                        <input type="text" class="form-control" value="" id="vehicleBrand" name="vehicleBrand" required>
                        <label>Vehicle Model</label>
                        <input type="text" class="form-control" value="" id="vehicleModel" name="vehicleModel" required>
                    </div>
                    <div style="float: left" class="col-md-6">
                        <label>Model Year</label>
                        <input maxlength="4" minlength="4" type="number" class="form-control" value="" id="modelYear" name="modelYear" required>
                        <label>Vehicle count</label>
                        <input type="number" class="form-control" value="" id="vehicleCount" name="vehicleCount" required>
                    </div>

                    <div style="margin:20px; float: left;"class="col-md-12">
                        <INPUT class="submitButton" ID="Submit" TYPE="SUBMIT" VALUE="Save">
                    </div>
                </form>
            </div>
        </div>

        JSP Version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion()%> <br>

    </body>
    <script>
        $(document).ready(function () {
//            jQuery.validator.addMethod("integerValidation", function (value, element) {
//                return this.optional(element) || /^\d+$/i.test(value);
//            }, "Value should be a Integer ");
            $("#Submit").click(function (e) {
                e.preventDefault();
                if ($('#vehicleDetails').valid()) {
                    var data = $("#vehicleDetails").serialize();
                    $.ajax({
                        type: "POST",
                        url: '${pageContext.servletContext.contextPath}/home/addVehicleDetails',
                        data: data,
                        success: function (response) {
                            if (response) {
                                console.log("success");
                                window.location.reload();
                            } else {
                                console.log("Value not inserted");
                            }

                        }, error: function (error) {
                            console.log("error");

                        }
                    });
                }

            });

        });
        function onLoad() {
            $.ajax({
                type: "POST",
                url: '${pageContext.servletContext.contextPath}/home/getVehicleDetails',
                success: function (tabelDataArray) {
                    var tableObject = [];
                    var numRows = 0;
                    var numCols = 0;
                    tableObject.push(tabelDataArray.vehicleBrandsAndModels);
                    numCols = tabelDataArray.vehicleBrandsAndModels.length;
                    for (var i = 0; i < tabelDataArray.countDTOList.length; i++) {
                        tableObject.push(tabelDataArray.countDTOList[i].countList);
                        numRows++;
                    }
                    $("#dataTable").handsontable({
                        data: tableObject,
                        startRows: numRows,
                        startCols: numCols
                    });


                    console.log("success");
                }, error: function (error) {
                    console.log("error");

                }
            });
        }

        $('#vehicleDetails').validate({
            errorElement: 'p',
            rules: {
                vehicleCount: {
                    digits: true
                }
            },

        });

    </script>
</html>
