package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	/**
	 * 
	 * This method will be responsible for determining what resource the client is requesting
	 * It will take in the url and capture only the end part after "/FrontControllerDemo".
	 * 
	 * ONce it captures the destination it will call another class called RequestHelper
	 * which will supply the right functionality
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		//1. Save the URI
		final String URI = request.getRequestURI().replace("/FrontController/", ""); // this leaves nothing but the end
																						// part like "/login or /employees
		
		//2. Set up a switch case statement in whcih we call the appropritate functionality based on the URI returned
		switch(URI) {
		
		case "login":
			// call some processLogin() functionality and pass the request and response objects
			RequestHelper.processLogin(request, response);
			break;
		case "employees":
			// call in some type of method to process that and pass the request and response objects
			break;
		}
		
	}	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
