/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package edu.poly.tags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author huy08
 */
public class VNDate extends SimpleTagSupport {

    private String value;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        LocalDate date=java.time.LocalDate.now();
        int day= date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        try {
            out.println(String.format("<h2 value:'&s'>", value));
            if(value == "now")
            {
            out.println("Ngày "+day+" Tháng "+month+" Năm "+year);
        }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            out.println("</h2>");
            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in VNDate tag", ex);
        }
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
