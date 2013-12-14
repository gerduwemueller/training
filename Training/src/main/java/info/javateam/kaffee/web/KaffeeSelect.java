package info.javateam.kaffee.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.javateam.kaffee.model.*;

public class KaffeeSelect extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> types = new KaffeeExperte().getTypes(request.getParameter("taste"));
        request.setAttribute("types", types);
        RequestDispatcher view = request.getRequestDispatcher("kaffee.jsp");
        view.forward(request, response);
    }	

}
