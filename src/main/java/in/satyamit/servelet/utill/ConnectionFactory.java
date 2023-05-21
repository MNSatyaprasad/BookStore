package in.satyamit.servelet.utill;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	public static DataSource ds = null;
	
	public static Connection getConnection() throws Exception {
		if(ds == null) {
			File f = new File("C:\\Users\\Admin\\eclipse-workspace\\BookProject\\application.properties");
		FileInputStream fs = new FileInputStream(f);
		Properties ps = new Properties();
		ps.load(fs);
		String uname = ps.getProperty("application.username");
		String pwd = ps.getProperty("application.password");
		String url = ps.getProperty("application.url");
		String driver = ps.getProperty("application.driver");
		
		HikariConfig config = new HikariConfig();
		config.setUsername(uname);
		config.setPassword(pwd);
		config.setJdbcUrl(url);
		config.setDriverClassName(driver);
		ds = new HikariDataSource(config);
		}
		
		return ds.getConnection();
	}

}
