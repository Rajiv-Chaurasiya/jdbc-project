package in.rajivit.CustomerDataServletForAdmin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rajiv.AdminDAO.AdminDAO;
import in.rajiv.DTO.DTO;


@WebServlet("/CustomerData")
public class CustomerDataServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String choice = request.getParameter("choose");
		String amt = request.getParameter("amt");
		String account_no = request.getParameter("account_no");
		String transaction_Details = request.getParameter("transaction_detail");
		
		Float amount = Float.parseFloat(amt);

		
		if(choice.equals("debit")) {
			DTO deb = new DTO();
			deb.setAccount_number(account_no);
			deb.setTransaction_detail(transaction_Details);
			deb.setDebit(amount);
			boolean isSaved = false;
			try {
				AdminDAO dao = new AdminDAO();
				isSaved = dao.debit(deb);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			String msg = isSaved ? "Data Saved" : "Data Saved";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("TransactionEntry.jsp").forward(request, response);
		}
		if(choice.equals("credit")) {
			DTO cr = new DTO();
			cr.setAccount_number(account_no);
			cr.setCredit(amount);
			cr.setTransaction_detail(transaction_Details);
			boolean isSaved = false;
			try {
				AdminDAO dao = new AdminDAO();
				isSaved = dao.credit(cr);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			String msg = isSaved ? "Data Saved" : "Data Saved";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("TransactionEntry.jsp").forward(request, response);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String account_number = request.getParameter("account_number");
	    String full_name = request.getParameter("full_name");
	    String id_proof = request.getParameter("id_proof");

	    DTO data = new DTO();
	    data.setAccount_number(account_number);
	    data.setFull_name(full_name);
	    data.setId_proof(id_proof);

	    AdminDAO dao = new AdminDAO();
	    List<DTO> customers = null;
	    String error = null;

	    try {
	        customers = dao.customerDetails(data);
	        
	        if (customers.isEmpty()) {
	            error = "No customer found with the provided details.";
	        }
	    } catch (SQLException e) {
	        error = "Database error: " + e.getMessage();
	    } catch (IOException e) {
	        error = "IO error: " + e.getMessage();
	    }

	    if (error != null) {
	        request.setAttribute("error", error);
	        request.getRequestDispatcher("customerDetailForAdmin.jsp").forward(request, response);
	    } else {
	        request.setAttribute("customers", customers);
	        request.getRequestDispatcher("customerDetailForAdmin.jsp").forward(request, response);
	    }
	}
}
