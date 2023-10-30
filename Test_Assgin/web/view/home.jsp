<%-- 
    Document   : home
    Created on : Oct 28, 2023, 10:22:48 PM
    Author     : huy08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style.css" rel="stylesheet" type="text/css"/>
        
        
    </head>
    <body>
        <nav>
            <ul>
                <div class="toggle_menu"><ion-icon name="menu"></ion-icon></div>
                     
                <li class="home">
                    <button onclick="myFunction()" id="button_home">
                    <a href=""><ion-icon name="home"></ion-icon>Home</a>   
                    </button>
                </li>
                
                <li class="timetable">
                    
                    <a href=""><ion-icon name="browsers"></ion-icon>Timetable</a>
                    
                </li>
                
                <li class="Attendent">
                    <a href=""><ion-icon name="checkbox-outline"></ion-icon>Attendent</a>
                </li>
                
                <li class="logout">
                    <a href=""><ion-icon name="log-out"></ion-icon>Log-out</a>
                </li>
                               
            </ul>
        </nav>
        <section class="content" >
            <jsp:include page="../authentication/authentbox.jsp"></jsp:include>
                <h2>Content 1</h2>           
        </section>
        
        
    </body>
    
    <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
    <script>
        const nav = document.querySelector('nav');
        const toggle_menu = document.querySelector('.toggle_menu');
        const content = document.querySelector('.content');
        const home = document.querySelector('.home');
        const timetable = document.querySelector('.timetable');
        const li = document.querySelector('li');
        document.get
        toggle_menu.onclick = function(){
            nav.classList.toggle('hide');
            content.classList.toggle('expand');
        };
        
        timetable.onclick= function() {
            li.classList.toggle('not_selected');                   
        };
        
        myFunction(){
            document.getElementById('button_home').classList.toggle("button_1");
        };
        
        
    </script>


        
    

</html>