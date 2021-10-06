package ftt.ec.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.model.User;
import ftt.ec.model.UserDao;

/**
 * Servlet implementation class UserApi
 */
@WebServlet("/UserApi")
public class UserApi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	/*
	 * 	GET — For returning resources		- SELECT
		POST — For creating a new resource  - INSERT
		PUT — For updating a resource       - UPDATE
		PATCH — For updating a resource     - UPDATE (Só um campo individualmente)
		DELETE — For deleting a resource    - DELETE
	 * 
	 * 
	 * 
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("To no GET " + new Date());
		//response.getWriter().append("Served at GET: ").append(request.getContextPath()).append(" - ").append( new Date().toString())
		//		.append(" - ").append(request.getParameter("uname"));
		
		UserDao userDao = new UserDao();
		
		User paramUser = new User();
		paramUser.setUserId(request.getParameter("uid"));
		
		User u = userDao.get(paramUser);
		
		response.getWriter().append(u.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("To no POST " + new Date());
		//doGet(request, response);
		//response.getWriter().append("Served at POST: ").append(request.getContextPath()).append(" - ").append( new Date().toString() );
		
		User u = new User(
				request.getParameter("uid"),
				request.getParameter("uname"),
				request.getParameter("uemail"),
				request.getParameter("utelefone"),
				request.getParameter("unascimento"), //Date
				request.getParameter("ucolor"),
				request.getParameter("uvalue"),
				request.getParameter("ucep"),
				request.getParameter("unumber"),
				request.getParameter("upwd")				
				);
		
		UserDao userDao = new UserDao();
		
		userDao.add(u);
		
		//this.Users.put(u.getUserId(), u);
		
		response.getWriter().append("POST - OK"); // código novo criado para o registro...

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("To no PUT " + new Date());
		
		User u = new User(
				request.getParameter("uid"),
				request.getParameter("uname"),
				request.getParameter("uemail"),
				request.getParameter("utelefone"),
				request.getParameter(null), //"unascimento"), //Date
				request.getParameter("ucolor"),
				request.getParameter("uvalue"),
				request.getParameter("ucep"),
				request.getParameter("unumber"),
				request.getParameter("upwd")				
				);
		
		UserDao userDao = new UserDao();
		
		
		userDao.update(u);
		
		//response.getWriter().append(u.toString());

		response.getWriter().append("User ID ").append(String.valueOf(u.getUserId())).append(" updated");

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("To no DELETE " + new Date());
		//response.getWriter().append("Served at DELETE: ").append(request.getContextPath()).append(" - ").append( new Date().toString() );

		User user = new User();
		
		user.setUserId(request.getParameter("uid"));
		
		UserDao userDao = new UserDao();
		
		userDao.delete(user);
		
		response.getWriter().append("User ID ").append(String.valueOf(user.getUserId())).append(" deleted");
		
	} //doDelete

}
