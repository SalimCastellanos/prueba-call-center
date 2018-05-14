package co.com.almundo.callcenter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
//@ComponentScan({"co.com.almundo.callcenter.manager.impl","co.com.almundo.callcenter.dao.impl"})
@ComponentScan("co.com.almundo.callcenter")
public class AppConfig {


}