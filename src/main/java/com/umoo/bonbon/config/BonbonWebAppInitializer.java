package com.umoo.bonbon.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.IntrospectorCleanupListener;

/**
 * 
 * @author umoo
 * 应用启动入口
 */
public class BonbonWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 配置ContextLoaderListener创建的上下文的bean
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class, MybatisConfig.class, AopConfig.class};
	}
	
	/**
	 * 用来定义DispatcherServlet应用上下文的bean
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}
	
	/**
	 * 请求映射规则
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	/**
	 * 开启异步
	 */
	@Override
	protected boolean isAsyncSupported() {
		return true;
	}

	//配置过滤器
	@Override
	protected Filter[] getServletFilters() {
		//POST请求乱码
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		return new Filter[]{ characterEncodingFilter};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		
	}

	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
		servletContext.addListener(IntrospectorCleanupListener.class);
		super.registerContextLoaderListener(servletContext);
	}
	
	
}
