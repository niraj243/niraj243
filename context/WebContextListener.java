package com.app.context;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import org.apache.log4j.PropertyConfigurator;

import com.app.util.ConnectionParams;
import com.app.util.DBConnectionUtils;

public class WebContextListener implements ServletContextListener {
//{
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		String dName = context.getServletContext().getInitParameter("dbname");
		String pass = context.getServletContext().getInitParameter("password");
		String uname = context.getServletContext().getInitParameter("username");

		ConnectionParams params = new ConnectionParams();
		params.setDbname(dName);
		params.setUsername(uname);
		params.setPassword(pass);
		DBConnectionUtils.getInstance().setConnectionParams(params);
	}

}
