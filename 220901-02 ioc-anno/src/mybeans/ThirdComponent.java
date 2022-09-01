package mybeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope(value="prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
public class ThirdComponent {
	private String value;
	private int num;
	
	// 이 value라는 프로퍼티는 삭제해도 된다
	public ThirdComponent(@Value(value = "vvv") String value, @Value("100") int num) {
		this.value = value;
		this.num = num;
	}
	
	public void printValue() {
		System.out.println(value);
		System.out.println(num);
	}
}