
class Person {
	private String name;
	public int age;
	
	public static int COUNT = 0;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		Person.COUNT++;
	}
}

public class TestPerson {
	public static void main(String[] args) {
//		Person p = new Person("rksk", 22);
//		
//		p.age = 10;
//		Person.COUNT++;
		
		String h1 = "Hello World";
		String h2 = "Hello World" + "a";
		String h3 = h1 + "a";
		String h4 = "Hello World";
		
		System.out.println(h2 == h3);
		// 문자 배열로 다루게 되면 그 배열의 참조만 없애면 걔는 쓰레기로써 잠시 후에 사라지게 될테니까
		// 그때까지는 문자 배열로 쓰자 하는게 스트링 빌더 버퍼
		// 차이는 쓰레드 세이프한가 세이프하지 않는가
		// 세이프하면 여러개의 자원이 달려들어도 한 자원이 동작하는동안 다른 애는 기다려라함
		// 빌더는 멈춰라하는게(동기화작업) 없어서 작업이 빠른데 세이프하지 않음
		// 버퍼는 세이프하지만 동기화작업이 수행되기 때문에 느림
		
		// = new vector...?
		// 우리가 컬렉션에서도 세이프한 걸 볼 수 있는데
		// 어레이 리스트는 세이프하지 않음
		
		// 컬렉션 프레임워크가 리스트 맵 셋 같은 것
		// 자료구조라고 부르는 것들은 인터페이스로 정의해놓고 패키징한것
		// 사용법과 특징으로 접근해서
		// 이런 자료구조들이 왜 만들어졌나
		// 특정한 상황에서 장점이 많기 때문,
		// 데이터를 표현하기 위해서
		// 모든 자료구조의 베이스는 배열이고 그걸 맵핑해서 쓰기 편하게 만든 것
		// 리스트는 자바에서는 캐퍼시티? 라는 걸 두고 기본값이 10개가 나옴
		// 그리고 늘어날 때 1개를 늘린다고 하면 2배로 늘린다
		// 다음에는 더 늘리는데 점점 많이 들어갈거다, 라는 예측을 하고 배로 늘리는 것
		
		// 아파치 스트럿츠?
	}
}