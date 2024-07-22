package in.rajiv.DTO;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.tomcat.jni.Local;

public class DTO {
	
	private String full_name;
	private String address;
	private String mobile_no;
	private String email;
	private LocalDate date_of_birth;
	private String username;
	private String password;
	private Float balance;
	private String category;
	private Float initial_balance;
	private String account_type;
	private String account_number;
	private String id_proof;
	private String transaction_detail;
	private Float debit;
	private Float credit;
	private Integer id;
	private LocalDate day;
	private LocalDate month;
	private LocalDate year;
	
	
	
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public LocalDate getMonth() {
		return month;
	}
	public void setMonth(LocalDate month) {
		this.month = month;
	}
	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
	public String getTransaction_detail() {
		return transaction_detail;
	}
	public void setTransaction_detail(String transaction_detail) {
		this.transaction_detail = transaction_detail;
	}
	public Float getDebit() {
		return debit;
	}
	public void setDebit(Float debit) {
		this.debit = debit;
	}
	public Float getCredit() {
		return credit;
	}
	public void setCredit(Float credit) {
		this.credit = credit;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Float getInitial_balance() {
		return initial_balance;
	}
	public void setInitial_balance(Float initial_balance) {
		this.initial_balance = initial_balance;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getId_proof() {
		return id_proof;
	}
	public void setId_proof(String id_proof) {
		this.id_proof = id_proof;
	}
	
	
		

}