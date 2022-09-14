package kr.co.greenart.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 웹 어플리케이션 설정을 도와주는 추상메소드를 상속받으면 된당
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() { // 어플리케이션 기반이 되는 설정으로 root-context역할을 한다
		return new Class[] { RootConfig.class }; // 비어있는 null 그대로 안만들어도 되고 빈 contiguration을 만들어도 되고 필요한게 있다면 생성한 RootConfig.java에 만들어도 된다
	} // 이렇게 만들면 src>main>webapp>WEB-INF>spring>root-context.xml을 지워도 된다
	// 같이 써도 되긴하지만 그러면 config가 여기저기 있으니까... 자바가 편하니까...

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	// Web.xml의 <servlet-mapping>여서 그냥 문자열로 반환하면 됨
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() { // 배열로써 등록하고자 하는 필터를 만들어서 등록해주면 된다
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return new Filter[] { encodingFilter };
	}
}
