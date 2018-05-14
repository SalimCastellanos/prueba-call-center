package co.com.almundo.callcenter.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.com.almundo.callcenter.AppConfig;

public class Context {
	
	 private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	   
	
	public static Object getBean(Class myClass) {
		return ctx.getBean(myClass);
	}

}
