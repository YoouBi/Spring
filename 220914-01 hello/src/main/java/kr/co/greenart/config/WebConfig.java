package kr.co.greenart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.greenart.controller.MyInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("kr.co.greenart")
public class WebConfig implements WebMvcConfigurer { // 인터페이스로 설정을 편하게 하자
	@Autowired
	private MyInterceptor interceptor;
	
	// 찾을 때 경로로 찾는게 아니라 이름으로 찾아서 원래는 commonsResolver였지만 multipartResolver로 이름 바꿈
	@Bean
	public MultipartResolver multipartResolver() { // MultipartResolver는 스프링에서 멀티페이스 리졸브를 사용할 수 있는 인터페이스인데
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(); // 이 인터페이스의 구현체가 CommonsMultipartResolver
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	
	// src>main>webapp>WEB-INF>spring>appServlet>servlet-context.xml에 있는
	//<resources mapping>과 <beans:bean> 두개가 바로 밑의 두개 설정...
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) { // 사용자의 모든 요청을 자원으로서 직접 접근을 막고 서블릿이 모든 요청을 다 전달받음
		// 정적 리소스에 접근하는걸 다 막아버림
		// 왜? 맵핑이 되어있지 않으니까(근데 뭐가...)
		// 정적 자원에 쉽게 접근할 수 있게끔 리소스핸들러라는 친구한테 요청하는데
		// 그래서 이런식으로 이미지라던가 자원을 관리하면 된다
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 서블릿이 뷰를 찾기 위해서 접근하는 친구
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/my/**");
		// .addPathPatterns(주소 패턴)로 언제 동작하는지도 설정 가능
	}
}