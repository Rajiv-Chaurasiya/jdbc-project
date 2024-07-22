package in.rajivit.customerAndAdminPWDSignUpAndFor;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rajiv.AdminDAO.AdminDAO;
import in.rajiv.DTO.DTO;
import in.rajivit.customerDAO.customerDAO;


@WebServlet("/pwdUtil")
public class pwdUtil extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String customer_name = request.getParameter("full_name");
		String mobile_no = request.getParameter("mobile_no");
		String email_id = request.getParameter("email");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String cnf_pwd = request.getParameter("cnf_pwd");
		
		if(pwd.equals(cnf_pwd)) {
			DTO dto = new DTO();
			dto.setFull_name(customer_name);
			dto.setMobile_no(mobile_no);
			dto.setEmail(email_id);
			dto.setPassword(pwd);
			dto.setUsername(username);
			boolean isSaved = false;
			try {
				customerDAO dao = new customerDAO();
				isSaved = dao.signup(dto);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			String msg = isSaved ? "Password updated" : "Password not updated";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		else {
			String msg = "Password doesn't match";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id_proof = request.getParameter("id_proof");
	    String mobile_no = request.getParameter("mobile_no");
	    String email_id = request.getParameter("email");
	    String new_pwd = request.getParameter("new_pwd");
	    String cnf_pwd = request.getParameter("cnf_pwd");

	
	    if (new_pwd.equals(cnf_pwd)) {
	        DTO pwd = new DTO();
	        pwd.setId_proof(id_proof);
	        pwd.setMobile_no(mobile_no);
	        pwd.setEmail(email_id);
	        pwd.setPassword(new_pwd);
	        
	//        System.out.println(pwd.toString());

	        AdminDAO dao = new AdminDAO();
	        boolean isChange = false;
	        try {
	            isChange = dao.forgetPassword(pwd); 
	        } catch (SQLException e) {
	            String msg = "Database error: " + e.getMessage();
	            request.setAttribute("error", msg);
	            request.getRequestDispatcher("forgetPassword.jsp").forward(request, response);
	            return; 
	     }

	        String msg = isChange ? "Password Changed" : "Password Not Changed";
	        request.setAttribute("msg", msg);
	        request.getRequestDispatcher("forgetPassword.jsp").forward(request, response);
	    } else {
	        String msg = "New password and Confirm Password don't match";
	        request.setAttribute("msg", msg);
	        request.getRequestDispatcher("forgetPassword.jsp").forward(request, response);
	    }
	}



}
