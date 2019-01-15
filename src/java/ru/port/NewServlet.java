/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.port;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Администратор
 */
@WebServlet(
        name = "helloServlet",
        urlPatterns = {"/greeting", "/salutation", "/wazzap"},
        loadOnStartup = 1
)
public class NewServlet extends HttpServlet {

    public static final String DEFAULT_USER = "Гость";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        if (user == null) {
            user = DEFAULT_USER;
        }
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Hello user application</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("Привет, " + user + "<br/><br/>");
        writer.println("<form action=\"greeting\" metod=\"POST\">");
        writer.println("Введите свое имя<br/>");
        writer.println("<br/>");
        writer.println("<input type=\"text\" name=\"user\"/><br/>");
        writer.println("<input type=\"submit\" value=\"Submit\"/><br/>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
