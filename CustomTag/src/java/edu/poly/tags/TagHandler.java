/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package edu.poly.tags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author huy08
 */
public class TagHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            out.println("<h3>");
            out.println("Hello");
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }         
            out.println("</h3>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in TagHandler tag", ex);
        }
    }
    
}
