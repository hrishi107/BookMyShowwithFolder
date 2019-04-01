package com.BookMyShow.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BookMyShow.bean.InputLoginBean;
import com.BookMyShow.bean.InputRegistrationBean;
import com.BookMyShow.bean.OutputRegistrationBean;
import com.BookMyShow.helper.RegistartionHelper;


/**
 * Servlet implementation class CommonController
 */
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		 System.out.println("hello");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boolean result = false;
		boolean loginResult = false;
		String action=req.getParameter("action");
		
		if(action!=null && !"".equals(action))
		{
			 if("registration".equals(action))
			{
				 InputRegistrationBean regBeanObj=new InputRegistrationBean();
				 
				 regBeanObj.setFirstName(req.getParameter("firstname"));
				 regBeanObj.setLastName(req.getParameter("lastname"));
				 regBeanObj.setGender(req.getParameter("gender"));
				 regBeanObj.setHobbies(req.getParameter("Hobbies"));
				 regBeanObj.setMobileNumber(Long.parseLong(req.getParameter("mbnum")));
				 regBeanObj.setEmail(req.getParameter("email"));
				 regBeanObj.setAddress(req.getParameter("address"));
				 regBeanObj.setDateOfBirth(req.getParameter("dateOfBirth"));
				 regBeanObj.setPinCode(Integer.parseInt(req.getParameter("pincode")));
				 regBeanObj.setPassword(req.getParameter("psw"));
				 regBeanObj.setRepeatPassword(req.getParameter("psw-repeat"));
				
				 		/*........Helper method calling.............*/
				 RegistartionHelper reghelperObj=new RegistartionHelper();
				 
				try {
					result = reghelperObj.validateFeilds(regBeanObj);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				 
				 if(!result)
				 {
					  //redirection to error page
					 res.sendRedirect(req.getContextPath()+"/jsp/error.jsp");
				 }
				 else
				 {
					 System.out.println(result);
					 res.sendRedirect(req.getContextPath()+"/jsp/success.jsp");
					 
				 }
				 
			}//If StateMent for Registartion ends
			 else if("login".equals(action))
				{
					 OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
					 InputLoginBean inputLoginBeanObj=new InputLoginBean();
					 InputRegistrationBean regBeanObj=new InputRegistrationBean();
					 
					// inputLoginBeanObj.setEmail(req.getParameter("email"));
					 //inputLoginBeanObj.setPassword(req.getParameter("psw")); 
					 regBeanObj.setEmail(req.getParameter("email"));
					 regBeanObj.setPassword(req.getParameter("psw"));
					 //LoginHelper loginhelperObj=new LoginHelper();
					 RegistartionHelper reghelperObj=new RegistartionHelper();
					 
					 try {
						regBeanObj=reghelperObj.validLogin(regBeanObj);
					} catch (ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}
					 if(outRegBeanObj.isStatusFlag())
					 {
						 //redirection to error page
						 res.sendRedirect(req.getContextPath()+"/jsp/error.jsp");
					 }
					 else
					 {
						 System.out.println(loginResult);
						 req.setAttribute("id",regBeanObj.getId());
						 req.setAttribute("firstname",regBeanObj.getFirstName());
						 req.setAttribute("lastname",regBeanObj.getLastName());
						 req.setAttribute("gender",regBeanObj.getGender());
						 req.setAttribute("Hobbies", regBeanObj.getHobbies());
						 req.setAttribute("mbnum", regBeanObj.getMobileNumber());
						 req.setAttribute("email", regBeanObj.getEmail());
						 req.setAttribute("address", regBeanObj.getAddress());
						 
						HttpSession session=req.getSession();
						session.setAttribute("email", regBeanObj.getEmail());
						session.setAttribute("Id", regBeanObj.getId());
						
						//res.sendRedirect(req.getContextPath()+"/jsp/success.jsp");
						 
						/*ye waps likhna he*/
						RequestDispatcher rd=req.getRequestDispatcher("/jsp/success.jsp");
						 rd.forward(req, res);
						//res.sendRedirect(req.getContextPath()+"/jsp/movielist.jsp");
						
						 
					 }
				}
			 if("logout".equals(action))
			{
					
					HttpSession session=req.getSession();
					session.removeAttribute("email");
					session.invalidate();
					res.sendRedirect(req.getContextPath()+"/jsp/totalseat.jsp");
			}


			
		}
		
	}

}
