package com.umoo.bonbon.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.umoo.bonbon.resolver.GlobalExceptionResolver;
/**
 * 
 * @author umoo
 * SpringMVC配置
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.umoo.bonbon.web")
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	private static final String VIEWS = "/WEB-INF/views/";
	private static final String MESSAGE_SOURCE = "classpath:i18n/messages";
	/**
	 * 
	 * @return html视图解析
	 */
	@Bean
	public ViewResolver htmlViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix(VIEWS);
		viewResolver.setSuffix(".html");
		viewResolver.setOrder(9999);//优先级最低
		return viewResolver;
	}
	
	//国际化
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(MESSAGE_SOURCE);
		messageSource.setCacheSeconds(120);
		return messageSource;
	}
	
	@Bean
	public HandlerExceptionResolver globalExceptionResolver(){
		return new GlobalExceptionResolver();
	}
	
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
		placeholderConfigurer.setFileEncoding("UTF-8");
		placeholderConfigurer.setLocations(new ClassPathResource("jdbc.properties"));
		return placeholderConfigurer;
	}
	
	//视图控制器
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}

	//验证器
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	//静态资源
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	
}
