package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.services.BookService;

/**
 * Adds a book to the user's shopping cart
 */
public class AddToCartServlet extends HttpServlet
{
	public void doPost (HttpServletRequest request, 
						HttpServletResponse response) 
			throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		
		String strId = request.getParameter("id");
		int id = new Integer(strId);
		
		Book requiredBook = BookService.getService().getBookById(id);
		
		HttpSession session = request.getSession();
		
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if (cart == null)
		{
			// this is the first visit (of this servlet) by this user
			cart = new ArrayList<Book>();
		}
		
		cart.add(requiredBook);
		
		session.setAttribute("cart", cart);
		out.println("<h1>Thanks</h1><p>You have added the book to your cart</p>");
		
		String url = "viewCart.html";
		url = response.encodeURL(url);
		
		out.println("<a href='" + url + "'>Click here to visit your cart</a>");
		
		out.close();
	}
}