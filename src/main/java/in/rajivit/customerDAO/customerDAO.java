package in.rajivit.customerDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.rajiv.ConnectionFactory.ConnectionFactory;
import in.rajiv.DTO.DTO;

public class customerDAO {

	public static boolean signup(DTO dto) throws SQLException, IOException {
		
		boolean isSaved = false;
		String SQL = "update customer_accounts set username = ?, password = ? where full_name = ? and mobile_no = ? and email_id = ?";
		
		try(Connection con = ConnectionFactory.getConnection()){
			
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getFull_name());
			pstmt.setString(4, dto.getMobile_no());
			pstmt.setString(5, dto.getEmail());
		int cnt = pstmt.executeUpdate();
		pstmt.close();
			if(cnt>0) {
				isSaved = true;
			}
			con.close();
		return isSaved;
		}
	}

	
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
				user.setAccount_number(rs.getString("account_number"));
				user_name.add(user);
				
			}
			con.close();
			return user_name;
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


	public static List<DTO> transaction(DTO dto) throws SQLException, IOException{
	 
		List<DTO> datas = null;
		
		String SQL = "select transaction_date, transaction_detail, debit, credit where account_number = ?";
		try(Connection con = ConnectionFactory.getConnection()){
			
			
			
		}
		
		return datas;
	}
	
	
	public List<DTO> transacti(DTO dto) throws SQLException, IOException {
	    StringBuilder SQL = new StringBuilder("SELECT * FROM transactions WHERE account_number = ?");
	    List<DTO> transactions = new ArrayList<>();

	    try (Connection con = ConnectionFactory.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(SQL.toString())) {
	        pstmt.setString(1, dto.getAccount_number());

	        if (dto.getDay() != null) {
	            SQL.append(" AND DAY(transaction_date) = ?");
	            pstmt.setInt(2, dto.getDay().getDayOfMonth());
	        }
	        if (dto.getMonth() != null) {
	            SQL.append(" AND MONTH(transaction_date) = ?");
	            pstmt.setInt(3, dto.getMonth().getMonthValue());
	        }
	        if (dto.getYear() != null) {
	            SQL.append(" AND YEAR(transaction_date) = ?");
	            pstmt.setInt(4, dto.getYear().getYear());
	        }

	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                DTO transactionDTO = new DTO();
	                transactions.add(transactionDTO);
	            }
	        }
	    }

	    return transactions;
	}

	
}

