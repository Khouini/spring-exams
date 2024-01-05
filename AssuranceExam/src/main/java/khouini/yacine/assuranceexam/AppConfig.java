package khouini.yacine.assuranceexam;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("khouini.yacine.assuranceexam.services")
public class AppConfig {

}