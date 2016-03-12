<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="Bean.RedisConnector" %>
<%@ page import="Bean.SetOperatinos" %>
<%@ page import="Bean.AlchemyConnector" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mystyle.css"> 
        <title>MyApp - Feature Extraction and Image Analysis</title>
    </head>
    <body>
        <div class ="main">
            <input id ="tab1" type ="radio" name="tabs" checked>
            <label for="tab1"> Feature Extraction </label>
            <input id="tab2" type="radio" name="tabs">
            <label for="tab2"> Image Analysis </label>
            <div class ="content">s
                <div id ="content1">
                    <form action="FServlet" method="GET">
                        <input type="text" name="furl" size="80">
                        <input type="submit" value="Extract">
						
                    </form> <br/>
                </div>
                <div id="content2">
                    <form action="IServlet" method="GET">
                        <input type="text" name="gurl" size="80">
                        <input type="submit" value="Extract">
						
                    </form> <br/>
                </div>
            </div>
			 
        </div>
    </body>
</html>