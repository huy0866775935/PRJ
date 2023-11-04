<%-- 
    Document   : Attendent
    Created on : Nov 4, 2023, 11:54:38 PM
    Author     : huy08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="StyleAttendent.css" rel="stylesheet" type="text/css"/>
        
        
    </head>
    <body>
        <nav>
            <ul>
                <div class="toggle_menu"><ion-icon name="menu"></ion-icon></div>
                     
                <li class="home">
                    
                    <a href="home.jsp"><ion-icon name="home"></ion-icon>Home</a>   
                   
                </li>
                
                <li class="timetable">
                    
                    <a href="TimeTable.jsp"><ion-icon name="browsers"></ion-icon>Timetable</a>
                    
                </li>
                
                <li class="attendent">
                    <a href="Attendent.jsp"><ion-icon name="checkbox-outline"></ion-icon>Attendent</a>
                </li>
                
                <li class="logout">
                    <a href=""><ion-icon name="log-out"></ion-icon>Log-out</a>
                </li>
                               
                               
            </ul>
        </nav>
        <section class="content" >
            
                <h2>Content Att</h2>           
        </section>
        
        
    </body>
    
    <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
    <script>
        const nav = document.querySelector('nav');
        const toggle_menu = document.querySelector('.toggle_menu');
        const content = document.querySelector('.content');
        
        toggle_menu.onclick = function(){
            nav.classList.toggle('hide');
            content.classList.toggle('expand');
        };
        
       
        
        
    </script>


