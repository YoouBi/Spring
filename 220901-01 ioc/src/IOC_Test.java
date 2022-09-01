import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		MyStatefulObj fourth = context.getBean("fourth", MyStatefulObj.class);
		System.out.println(fourth.toString());
		// IOC container에 등록된 bean이 똑같은 타입이 두개나 있더라 그래서 뭘 줘야하는지 모르겠더라고 오류를 뱉어냄
		// 이럴때 bean의 고유한 아이디를 앞에 적어준다 ("fourth",
		
//		MyStatefulObj third = context.getBean(MyStatefulObj.class);
//		System.out.println(third.toString());
//		third.setName("new-name");
//		third.setNumber(200);
//		
//		MyStatefulObj oneMoreTime = context.getBean(MyStatefulObj.class);
//		// scope="prototype"이면 달라고 할 때 마다 새로운 인스턴스를 생성해준다
//		// 만들어달라고 할 때 주면 되니까 IOC 관리대상에서 제외된다
//		System.out.println(oneMoreTime.toString());
//		System.out.println(third == oneMoreTime);
		
//		MyLogic logic = context.getBean(MyLogic.class);
//		logic.someMethod();
		
//		MyBean b = context.getBean(MyBean.class);
//		
//		b.hello();
//		
//		MyBean b2 = (MyBean) context.getBean("first", MyBean.class);
//		// 이렇게 해도 객체를 주는데 오브젝트 형으로 준다
//		// 그렇기 때문에 다운 캐스팅을 하거나 뒤에 , MyBean.class)라고 쓴 것처럼 인자로 넘겨줘도 된다
//		b2.hello();
//		
//		System.out.println(b == b2);
//		// 똑같은 인스턴스에 대한 참조만 여러개라서 같은 것
	}
}