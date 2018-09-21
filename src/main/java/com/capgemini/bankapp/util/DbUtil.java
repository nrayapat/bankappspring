package com.capgemini.bankapp.util;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.core.env.Environment;
	import org.springframework.stereotype.Component;

	@Component
	@PropertySource("classpath:db.properties")
	public class DbUtil
	{
		
		@Autowired
		Environment env;
		
		
		public Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName(env.getProperty("driver"));
				connection = DriverManager.getConnection(env.getProperty("db_url"), env.getProperty("user"), env.getProperty("password"));
				if(connection!=null)
				System.out.println("connection established");
			}
			catch(ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}




