package com.myapp.todo.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ToDoInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {ToDoConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
}

/*public class ToDoInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		/*AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//ctx.setConfigLocation("com.myapp.todo.configuration");
		ctx.register(ToDoConfiguration.class);
		//ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}*/