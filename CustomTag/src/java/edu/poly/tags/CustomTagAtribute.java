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
public class CustomTagAtribute extends SimpleTagSupport {

    private String color;
    private int row;

    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
     * @throws jakarta.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            out.print(String.format("<table style='color:%s'>",color));
            
            for(int i =0;i<row;i++){
                out.print("<tr>");
                out.print("<td>"+i+"</td>");
                out.print("</tr>");

            }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            
            
            out.print("</table>");
            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in CustomTagAtribute tag", ex);
        }
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setRow(int row) {
        this.row = row;
    }
}
