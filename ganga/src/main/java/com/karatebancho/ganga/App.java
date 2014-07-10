package com.karatebancho.ganga;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;


/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws LifecycleException {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(4126);

		Context ctx = tomcat.addContext("/ganga", "/ganga");
		ctx.setDocBase("web");

		Wrapper defaultServlet = Tomcat.addServlet(ctx, "default",
				new GangaServlet());
		defaultServlet.setLoadOnStartup(1);
		defaultServlet.setOverridable(true);
		ctx.addServletMapping("/", "default");

		tomcat.start();
		tomcat.getServer().await();
	}
}
