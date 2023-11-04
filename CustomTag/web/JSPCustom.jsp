<%-- 
    Document   : JSPCustom
    Created on : Nov 4, 2023, 12:00:34 AM
    Author     : huy08
--%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/myCustomTag.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <my:VNDate value="now"></my:VNDate>
    </body>
</html>
