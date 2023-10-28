/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.student;

import controller.authentication.BasedAuthorizationController;
import dal.DepartmentDBContext;
import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import model.Department;
import model.Role;
import model.Student;
import model.User;

public class Insert extends BasedAuthorizationController {
   
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, User user,ArrayList<Role> roles)
    throws ServletException, IOException {
        //check login
        DepartmentDBContext db = new DepartmentDBContext();
        ArrayList<Department> depts = db.list();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/student/insert.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, User user,ArrayList<Role> roles)
    throws ServletException, IOException {
        //check login
        
        String name = request.getParameter("name");
        boolean gender = request.getParameter("gender").equals("Male");
        Date dob = Date.valueOf(request.getParameter("dob"));
        int did = Integer.parseInt(request.getParameter("did"));
        
        Department d = new Department();
        d.setId(did);
        
        Student s = new Student();
        s.setName(name);
        s.setGender(gender);
        s.setDob(dob);
        s.setDept(d);
        
        StudentDBContext db = new StudentDBContext();
        db.insert(s);
        
        response.getWriter().println("studentid: " + s.getId() + " inserted successful!");
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}