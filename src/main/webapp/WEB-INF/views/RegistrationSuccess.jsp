 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<title>Ehealth-Dashboard</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://bootsnipp.com/dist/bootsnipp.min.css?ver=7d23ff901039aef6293954d33d23c066">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/ehealth.css">
    
    

<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
function fetchCalories(obj){
	var id;
	var formObject=document.getElementById("dashboard");
	var targetUrl="/EAHealth/fetchcalories?id="+obj;
	formObject.method="POST";
	formObject.action=targetUrl
	formObject.submit(obj);
	}
function fetchCaloriesLunch(obj){
	var id;
	var formObject=document.getElementById("dashboard");
	var targetUrl="/EAHealth/fetchCaloriesLunch?id="+obj;
	formObject.method="POST";
	formObject.action=targetUrl
	formObject.submit(obj);
	}

function fetchCaloriesDinner(obj){
	var id;
	var formObject=document.getElementById("dashboard");
	var targetUrl="/EAHealth/fetchCaloriesDinner?id="+obj;
	formObject.method="POST";
	formObject.action=targetUrl
	formObject.submit(obj);
	}

function addBreakfastFood(obj){
	var id;
	var formObject=document.getElementById("dashboard");
	var targetUrl="/EAHealth/addFoodType?type="+obj;
	formObject.method="POST";
	formObject.action=targetUrl
	formObject.submit(obj);
	}
</script>

<style>
	
    .error {
        color: red; font-weight: bold;
    }
</style>

</head>


<body id="gradient">
    <!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <div class="container">
    
        <nav class="navbar navbar-default" style="font-size: 16px; font-weight: 600;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" style="font-size:33px;font-style: oblique;font-family: fantasy;" href="#">eHealth</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Welcome, ${userForm.username}</a></li>
                    <li><a href="/EAHealth/login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </nav>
        <div class="row">

            <div class="col-sm-6 col-lg-9">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                BMI Details</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <div class="col-sm-3 col-lg-3" style="text-align: left;">

                                    <div class="table-responsive">

                                        <table class="table table-borderless">
                                            <tbody>
                                                <tr>
                                                    <td>Name</td>
                                                    <td>:</td>
                                                    <td>${nutrition.userForm.username}</td>
                                                </tr>
                                                <tr>
                                                    <td>Age</td>
                                                    <td>:</td>
                                                    
                                                    <td>${nutrition.userForm.age} .Years</td>
                                                </tr>
                                                <tr>
                                                    <td>Current Weight</td>
                                                    <td>:</td>
                                                    <td>${nutrition.userForm.weight} .Kgs</td>
                                                </tr>
                                                <tr>
                                                    <td>Current Height</td>
                                                    <td>:</td>
                                                    <td>${nutrition.userForm.height} .mtr</td>
                                                </tr>
                                                <tr>
                                                    <td>Total calories In take per Day</td>
                                                    <td>:</td>
                                                    <td>${nutrition.userForm.bmiDetail.bmr} Calories/day</td>
                                                </tr>
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="col-sm-4 col-lg-5" style="text-align: center;">
                                    <h4>Your BMI</h4>
                                    <span class="circlespan">${nutrition.userForm.bmiDetail.bmi}</span>
                                </div>
                                <div class="col-sm-4 col-lg-4" style="text-align: right;">
                                    <h5>BMI Catagories:</h5>
                                    <p>
                                        Underweight = 18.5
                                        <br> Normalweight= 18.5 - 24.9
                                        <br> Overweight = 25 - 29.9
                                        <br> Obesity = BMI of 30 pr greater.
                                    </p>
                                </div>



                            </div>
                        </div>
                    </div>
                </div>
                
                                
                                
                <form:form id="dashboard" action="" method="post" commandName="nutrition" cssClass="form-signin">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title" style="margin-top: 10px; margin-bottom: 10px;">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
        Starters/Soup</a>
      </h4>
                            <!--        <button class="btn btn-primary" type="button">Add <span class="glyphicon glyphicon-plus"></span></button>-->
                            <div class="pull-right btn-group btn-group-xs">
                      	<input type="button" id="breakfast" class="btn btn-success btn-xs" style="margin-top:-38px;" onclick="addBreakfastFood(0)" value="Add Food">
                      
                      
                                <!-- <button id="breakfast"class="btn btn-success btn-xs" style="margin-top: -38px;" onclick="addBreakfastFood()" >&nbsp;Add Food&nbsp;<span class="glyphicon glyphicon-plus"></span>&nbsp;</button> -->
                       
                            </div>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <div class="table-responsive col-sm-8 col-lg-8">
                                    <table class="table" style="background-color:white">
                                        <thead>
                                       <font color="red" style="richness: inherit;"> ${warningBreakfast} </font>
                                            <tr>
                                            
                                                <th>Food Name</th>
                                                <th>Quantity</th>
                                                <th>Calories</th>
                                                <th>Fiber(s)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${nutrition.breaskfastList}" var="nutrionList" varStatus="rowCount">
                                            <tr>
                                                <th>`
                                               		
                                                   <form:select path="breaskfastList[${rowCount.index}].foodType" items="${breakfastfoodList}" cssStyle="width:40%;display:inline;" onchange="fetchCalories(${rowCount.index})"/>
                                                </th>
                                                <th>
                                                   <form:select path="breaskfastList[${rowCount.index}].qty" items="${selectQtyList}" cssStyle="width:80%;display:inline;" onchange="fetchCalories(${rowCount.index})"/>
                                                </th>
                                                <th>
                                                <form:input path="breaskfastList[${rowCount.index}].calories"/>
                                                </th>
                                                <th>
                                                <form:input path="breaskfastList[${rowCount.index}].fiber"/>
                                                </th>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                        
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title" style="margin-top: 10px; margin-bottom: 10px;">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
        Lunch</a>
      </h4>
                            <div class="pull-right btn-group btn-group-xs">
                            
                                                  	<input type="button" id="lunch" class="btn btn-success btn-xs" style="margin-top:-38px;" onclick="addBreakfastFood(1)" value="Add Food">
                        <!--         <button class="btn btn-success btn-xs" style="margin-top: -38px;">&nbsp;Add Food&nbsp;<span class="glyphicon glyphicon-plus"></span>&nbsp;</button> -->
                            </div>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <div class="table-responsive col-sm-8 col-lg-8">
                                    <table class="table" style="background-color:white">
                                        <thead>
                                       <font color="red" style="richness: inherit;"> ${warningLunch}</font>
                                            <tr>
                                                <th>Food Name</th>
                                                <th>Quantity</th>
                                                <th>Calories</th>
                                                <th>Fiber(s)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${nutrition.lunchList}" var="nutrionList" varStatus="rowCount">
                                            <tr>
                                                <th>
                                                  <form:select path="lunchList[${rowCount.index}].foodType" items="${lunchfoodlist}" cssStyle="width:40%;display:inline;" onchange="fetchCaloriesLunch(${rowCount.index})"/>
                                                </th>
                                                <th>
                                                   <form:select path="lunchList[${rowCount.index}].qty" items="${selectQtyList}" cssStyle="width:80%;display:inline;" onchange="fetchCaloriesLunch(${rowCount.index})"/>
                                                </th>
                                                <th>
                                                <form:input path="lunchList[${rowCount.index}].calories"/>
                                                </th>
                                                <th>
                                                <form:input path="lunchList[${rowCount.index}].fiber"/>
                                                </th>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title" style="margin-top: 10px; margin-bottom: 10px;">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
        Deserts</a>
      </h4>
                            <div class="pull-right btn-group btn-group-xs">
                            
                            <input type="button" id="dinner" class="btn btn-success btn-xs" style="margin-top:-38px;" onclick="addBreakfastFood(2)" value="Add Food">
                        <!--         <button class="btn btn-success btn-xs" style="margin-top: -38px;">&nbsp;Add Food&nbsp;<span class="glyphicon glyphicon-plus"></span>&nbsp;</button> -->
                            </div>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <div class="table-responsive col-sm-8 col-lg-8">
                                    <table class="table" style="background-color:white">
                                        <thead>
                                      <font color="red" style="richness: inherit;">${warningDinner}</font>
                                            <tr>
                                                <th>Food Name</th>
                                                <th>Quantity</th>
                                                <th>Calories</th>
                                                <th>Fiber(s)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${nutrition.dinnerList}" var="nutrionList" varStatus="rowCount">
                                            <tr>
                                                <th>
                                                    <form:select path="dinnerList[${rowCount.index}].foodType" items="${dinnerfoodList}" cssStyle="width:40%;display:inline;" onchange="fetchCaloriesDinner(${rowCount.index})"/>
                                                </th>
                                                    <th>
                                                   <form:select path="dinnerList[${rowCount.index}].qty" items="${selectQtyList}" cssStyle="width:80%;display:inline;" onchange="fetchCaloriesDinner(${rowCount.index})"/>
                                                </th>
                                                <th>
                                                <form:input path="dinnerList[${rowCount.index}].calories"/>
                                                </th>
                                                <th>
                                                <form:input path="dinnerList[${rowCount.index}].fiber"/>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                </form:form>
            </div>

            <!--
            <div class="col-sm-6 col-lg-8" style="background-color:white;border-radius:4px;margin:14px;">
                <div class="col-sm-3 col-lg-3" style="text-align: left;">

                    <div class="table-responsive">

                        <table class="table table-borderless">
                            <tbody>
                                <tr>
                                    <td>Name</td>
                                    <td>:</td>
                                    <td>User</td>
                                </tr>
                                <tr>
                                    <td>Age</td>
                                    <td>:</td>
                                    <td>26</td>
                                </tr>
                                <tr>
                                    <td>Current Weight</td>
                                    <td>:</td>
                                    <td>28</td>
                                </tr>
                                <tr>
                                    <td>Current Height</td>
                                    <td>:</td>
                                    <td>5.6</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-sm-4 col-lg-4" style="text-align: center;">
                    <h4>Your BMI</h4>
                    <span class="circlespan">23%</span>
                </div>
                <div class="col-sm-4 col-lg-4" style="text-align: right;">
                    <h5>BMI Catagories:</h5>
                    <p>
                        Underweight = 18.5
                        <br> Normalweight= 18.5 - 24.9
                        <br> Overweight = 25 - 29.9
                        <br> Obesity = BMI of 30 pr greater.
                    </p>
                </div>
            </div>
-->

            <div class="col-sm-3 col-lg-3">
                <div class="table-responsive">

                    <table class="table" style="background-color:white">
                        <thead>
                            <tr class="info">
                                <th colspan="3">Your Recommended minimums</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Total Carbohydrates</td>
                                <td>130.0</td>
                                <td>g</td>
                            </tr>
                            <tr>
                                <td>Dietary Fiber</td>
                                <td>38.0</td>
                                <td>g</td>
                            </tr>
                            <tr>
                                <td>Linoleic Acid</td>
                                <td>17000.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Alpha-Linoleic Acid</td>
                                <td>1600.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Protein</td>
                                <td>40.0</td>
                                <td>g</td>
                            </tr>
                        </tbody>
                        <thead>
                            <tr class="info">
                                <th colspan="3">Vitamins</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Vitamin A</td>
                                <td>3000.0</td>
                                <td>IU</td>
                            </tr>
                            <tr>
                                <td>Vitamin C</td>
                                <td>90.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Vitamin D</td>
                                <td>200.0</td>
                                <td>IU</td>
                            </tr>
                            <tr>
                                <td>Vitamin E</td>
                                <td>15.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Vitamin K</td>
                                <td>120.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Thiamin</td>
                                <td>1.2</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Riboflavin</td>
                                <td>1.3</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Niacin</td>
                                <td>16.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Vitamin B6</td>
                                <td>1.3</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Folate</td>
                                <td>400.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Vitamin B12</td>
                                <td>2.4</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Pantothenic Acid</td>
                                <td>5.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Biotin</td>
                                <td>30.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Choline</td>
                                <td>550.0</td>
                                <td>mg</td>
                            </tr>
                        </tbody>
                        <thead>
                            <tr class="info">
                                <th colspan="3">Minerals</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Calcium</td>
                                <td>1000.0</td>
                                <td>IU</td>
                            </tr>
                            <tr>
                                <td>Chromium</td>
                                <td>35.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Copper</td>
                                <td>0.9</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Flouride</td>
                                <td>35.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Iodine</td>
                                <td>150.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Iron</td>
                                <td>8.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Magne</td>
                                <td>150.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Iron</td>
                                <td>8.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Magnesium</td>
                                <td>400.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Manganese</td>
                                <td>2.3</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Molybdenum</td>
                                <td>45.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Phosphrous</td>
                                <td>700.0</td>
                                <td>mg</td>
                            </tr>
                            <tr>
                                <td>Selenium</td>
                                <td>55.0</td>
                                <td>mcg</td>
                            </tr>
                            <tr>
                                <td>Zinc</td>
                                <td>11.0</td>
                                <td>mg</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
            
        </div>








        <footer>
            <address>&copy; Copyright 2016 All Rights Reserved</address>
        </footer>
    
    </div>
    <!-- /container -->

</body>

</html>::