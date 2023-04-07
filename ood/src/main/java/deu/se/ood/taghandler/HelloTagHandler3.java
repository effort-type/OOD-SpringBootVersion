/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package deu.se.ood.taghandler;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author admin
 */
@Slf4j
public class HelloTagHandler3 extends SimpleTagSupport {

    @Setter
    private String user;
    @Setter
    private int count = 1; // required가 아니기때문에 반드시 초기값을 지정해줘야함

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            for (int i = 0; i < count; i++) {
                out.println(String.format("%s님, 안녕하십니까? <br>", user));
            }

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            log.error("HelloTagHandler3: 예외 = {}", ex.getMessage());
        }
    }
}
