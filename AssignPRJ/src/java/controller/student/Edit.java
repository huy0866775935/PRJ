/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.student;

import controller.authentication.BasedAuthorizationController;
import controller.authentication.BasedRequiredAuthenticationController;
import dal.DepartmentDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Department;
import model.Role;
import model.Student;
import model.User;

/**
 *
 * @author sonnt
 */
public class Edit extends BasedAuthorizationController {
   
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response,User user,ArrayList<Role> roles)
    throws ServletException, IOException {
        DepartmentDBContext db = new DepartmentDBContext();
        ArrayList<Department> depts = db.list();
        request.setAttribute("depts", depts);
        
        StudentDBContext stuDB = new StudentDBContext();
        Student param = new Student();
        param.setId(Integer.parseInt(request.getParameter("id")));
        Student student = stuDB.get(param);
        request.setAttribute("student", student);
        
        if(student ==null)
            response.getWriter().println("student does not exist!");
        else
            request.getRequestDispatcher("../view/student/edit.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response,User user,ArrayList<Role> roles)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender = request.getParameter("gender").equals("Male");
        Date dob = Date.valueOf(request.getParameter("dob"));
        int did = Integer.parseInt(request.getParameter("did"));
        
        Department d = new Department();
        d.setId(did);
        
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setGender(gender);
        s.setDob(dob);
        s.setDept(d);
        
        StudentDBContext db = new StudentDBContext();
        db.update(s);
        
        response.sendRedirect("list");
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
