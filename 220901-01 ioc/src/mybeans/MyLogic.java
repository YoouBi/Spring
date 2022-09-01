package mybeans;

public class MyLogic {
	private MyBean myBean;
	
	public MyLogic(MyBean myBean) {
		super();
		this.myBean = myBean;
	}

	public void setMyBean(MyBean myBean) {
		this.myBean = myBean;
	}

	public void someMethod() {
		System.out.println("다음 작업을 수행하기 위해 객체 의존성이 필요합니다.");
		myBean.hello();
	}
}
