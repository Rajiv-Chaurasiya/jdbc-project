package in.rajiv.AdminDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.rajiv.ConnectionFactory.ConnectionFactory;
import in.rajiv.DTO.DTO;

public class AdminDAO {

	public List<DTO> Login(DTO dto) throws IOException, SQLException {
		
		String SQL = new String("select * from customer_accounts where category = ? and username = ? and password = ?");
		List<DTO> user_name = new ArrayList();
		
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO user = new DTO();
				user.setFull_name(rs.getString("full_name"));
				user_name.add(user);
			}
			con.close();
			return user_name;
		}
		
	}
	
	public static boolean forgetPassword(DTO pwd) throws SQLException, IOException {
		
		String SQL = "UPDATE customer_accounts SET password = ? WHERE category = 'admin' AND id_proof = ? AND mobile_no = ? AND email_id = ?";


		
		boolean isSaved = false;
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, pwd.getPassword());
			pstmt.setString(2, pwd.getId_proof());
			pstmt.setString(3, pwd.getMobile_no());
			pstmt.setString(4, pwd.getEmail());
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				isSaved = true;
			}
			con.close();
			return isSaved;
		}
	}
	
	
	public static boolean registeration(DTO customer) throws SQLException, IOException {
		
		String SQL = "INSERT INTO customer_accounts (category, full_name, address, mobile_no, email_id, account_type, initial_balance, date_of_birth, id_proof) values ('customer', ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean isSolved = false;
		
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, customer.getFull_name());
			pstmt.setString(2, customer.getAddress());
			pstmt.setString(3, customer.getMobile_no());
			pstmt.setString(4, customer.getEmail());
			pstmt.setString(5, customer.getAccount_type());
			pstmt.setFloat(6, customer.getInitial_balance());
			pstmt.setDate(7, Date.valueOf(customer.getDate_of_birth()));
			pstmt.setString(8, customer.getId_proof());
			int cnt = pstmt.executeUpdate();
			pstmt.isClosed();
			if (cnt>0) {
				isSolved = true;
			}
			con.close();
			return isSolved;	
		}
	}
	
	public static List<DTO> customerDetails(DTO dto) throws SQLException, IOException {
	    StringBuilder SQL = new StringBuilder("SELECT full_name, address, mobile_no, email_id, account_type, initial_balance, date_of_birth, id_proof, account_number, total_balance FROM customer_accounts WHERE 1=1");

	    List<DTO> details = new ArrayList<>();
	    int index = 1;

	    try (Connection con = ConnectionFactory.getConnection()) {
	        if (!dto.getAccount_number().equals("") ) {
	        	System.out.println(dto.getAccount_number().toString());
	            SQL.append(" AND account_number = ?");
	            
	        }
	        if (!dto.getFull_name().equals("")) {
	        	System.out.println(dto.getFull_name().toString());
	            SQL.append(" AND full_name = ?");
	            
	        }
	        if (!dto.getId_proof().equals("")) {
	        	System.out.println(dto.getId_proof().toString());
	            SQL.append(" AND id_proof = ?");
	            
	        }

	        PreparedStatement pstmt = con.prepareStatement(SQL.toString());

	        if (!dto.getAccount_number().equals("")) {
	            pstmt.setString(index++, dto.getAccount_number());
	        }
	        if (!dto.getFull_name().equals("")) {
	            pstmt.setString(index++, dto.getFull_name());
	        }
	        if (!dto.getId_proof().equals("")) {
	            pstmt.setString(index++, dto.getId_proof());
	        }

	        ResultSet rs = pstmt.executeQuery();
	        System.out.println(pstmt.toString());
	       
	        while (rs.next()) {
	            DTO detail = new DTO();
	            detail.setFull_name(rs.getString("full_name"));
	            detail.setDate_of_birth(rs.getDate("date_of_birth").toLocalDate());
	            detail.setAddress(rs.getString("address"));
	            detail.setMobile_no(rs.getString("mobile_no"));
	            detail.setEmail(rs.getString("email_id"));
	            detail.setAccount_type(rs.getString("account_type"));
	            detail.setAccount_number(rs.getString("account_number"));
	            detail.setInitial_balance(rs.getFloat("initial_balance"));
	            detail.setBalance(rs.getFloat("total_balance"));
	            detail.setId_proof(rs.getString("id_proof"));
	            details.add(detail);
	        }
	        pstmt.close();
	        con.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        throw ex; 	    
	    }

	    
	    return details;
	}

	
	public static boolean debit(DTO dto) throws SQLException, IOException {
		
		String SQL = "INSERT INTO transactions (account_number, debit, transaction_detail) VALUES (?, ?, ?)";
		
		boolean isSaved = false;
		
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getAccount_number());
			pstmt.setFloat(2, dto.getDebit());
			pstmt.setString(3, dto.getTransaction_detail());
			int cnt = pstmt.executeUpdate();
			System.out.println(pstmt.toString());
			pstmt.close();
			if(cnt>0){
				isSaved = true;
			}
			
			con.close();
		}
		return isSaved;
	}
	
	public static boolean credit(DTO dto) throws SQLException, IOException {
		boolean isSaved = false;
		String SQL = "insert into transactions (account_number, credit, transaction_detail) values (?, ?, ?)";
		try(Connection con = ConnectionFactory.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getAccount_number());
			pstmt.setFloat(2, dto.getCredit());
			pstmt.setString(3, dto.getTransaction_detail());
			int cnt = pstmt.executeUpdate();
			System.out.println(pstmt.toString());
			pstmt.close();
			if(cnt>0) {
				isSaved = true;
			}
			con.close();
		}
		return isSaved;
	}
	
	public static List<DTO> getTransaction(DTO dto){
		
		return null;
		
	}
	
	
}
