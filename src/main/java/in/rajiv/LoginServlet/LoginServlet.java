package in.rajiv.LoginServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.rajiv.AdminDAO.AdminDAO;
import in.rajiv.DTO.DTO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String full_name = request.getParameter("full_name");
		String address = request.getParameter("address");
		String mobile_no = request.getParameter("mobile_no");
		String email = request.getParameter("email_id");
		String account_type = request.getParameter("account_type");
		String init_balance = request.getParameter("initial_balance");
		String dat_of_birth = request.getParameter("dob");
		String id_proof = request.getParameter("id_proof");
	
		
		LocalDate dob = null;
        try {
            dob = LocalDate.parse(dat_of_birth); 
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return; 
        }
        Float initial_balance = Float.parseFloat(init_balance);
        
        DTO dto = new DTO();
        dto.setFull_name(full_name);
        dto.setAddress(address);
        dto.setAccount_type(account_type);
        dto.setInitial_balance(initial_balance);
        dto.setId_proof(id_proof);
        dto.setEmail(email);
        dto.setDate_of_birth(dob);
        dto.setMobile_no(mobile_no);
        
        
        AdminDAO dao = new AdminDAO();
        boolean isSaved = false;
        try {
        	 isSaved = dao.registeration(dto);
        	 System.out.println(isSaved);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        String msg = isSaved ? "Registration completed" : "Registration failed";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("registration.jsp").forward(request, response);
     
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String choice = request.getParameter("Choose");
	    String username = request.getParameter("username");
	    String pwd = request.getParameter("password");

	    if ("admin".equals(choice)) { 
	        DTO dto = new DTO();
	        dto.setCategory(choice);
	        dto.setUsername(username);
	        dto.setPassword(pwd);

	        AdminDAO dao = new AdminDAO();
	        try {
	            List<DTO> user_name = dao.Login(dto); 
	            if (!user_name.isEmpty()) {
	                DTO userdto = user_name.get(0);
	                String name = userdto.getFull_name();
	                String welcomeMessage = "Welcome " + name + "...!";
	                
	                request.setAttribute("Welcome", welcomeMessage);
	                request.getRequestDispatcher("admin.jsp").forward(request, response);
	            } else {
	                request.setAttribute("error", "Invalid username or password");
	                request.getRequestDispatcher("index.jsp").forward(request, response);
	            }
	        } catch (SQLException e) {
	            request.setAttribute("error", "Database error: " + e.getMessage());
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	    }
	    

	    if ("customer".equals(choice)) { 
	        DTO dto = new DTO();
	        dto.setCategory(choice);
	        dto.setUsername(username);
	        dto.setPassword(pwd);

	        AdminDAO dao = new AdminDAO();
	        try {
	            List<DTO> user_name = dao.Login(dto); 
	            if (!user_name.isEmpty()) {
	                DTO userdto = user_name.get(0);
	                String name = userdto.getFull_name();
	                String welcomeMessage = "Welcome " + name + "...!";
	                
	                request.setAttribute("Welcome", welcomeMessage);
	                request.getRequestDispatcher("customerWelcome.jsp").forward(request, response);
	            } else {
	                request.setAttribute("error", "Invalid username or password");
	                request.getRequestDispatcher("index.jsp").forward(request, response);
	            }
	        } catch (SQLException e) {
	            request.setAttribute("error", "Database error: " + e.getMessage());
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	    }
	
	}

}