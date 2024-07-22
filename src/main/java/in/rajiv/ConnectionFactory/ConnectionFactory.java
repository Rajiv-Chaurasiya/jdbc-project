package in.rajiv.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.io.*;

public class ConnectionFactory {

	private static DataSource ds = null;
	
	public static Connection getConnection() throws IOException, SQLException {
		
		if(ds == null) {
		
		FileInputStream fis = new FileInputStream(new File("D:\\eclipse\\Rajiv\\dbconfig.properties"));		
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("db.url");
		String uname = p.getProperty("db.uname");
		String pwd = p.getProperty("db.pwd");
		String clas = p.getProperty("db.class");
		
		PoolProperties pool = new PoolProperties();
		pool.setUrl(url);
		pool.setUsername(uname);
		pool.setPassword(pwd);
		pool.setDriverClassName(clas);
		
		ds = new DataSource(pool);
		}
		return ds.getConnection();
		
	}
	
}
