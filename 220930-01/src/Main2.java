public class Main2 {
	public static void printNumbers() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
		// 메인이 자신의 이름을 썼으니 객체를 만들고 있는 것
		
//		Thread t1 = new Thread(); // 쓰레드를 제어할 수 있는 객체를 만든 것이지 흐름을 만든 것이 아니라
		Thread t1 = new Thread(new Runnable() { // 그런데 이 쓰레드에 할 일을 만들어줘보자
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
				for (int i = 0; i > -100; i--) {
					System.out.println(i);
				}
			}
		});
		t1.start(); // 이 start로 새 흐름을 만들었다
		// 끼어있는 흐름도 이상하고 실행 할 때마다 결과가 달라질 것
		// 콘솔의 흐름 때문에 이렇게 찍히는 것도 있는데
		// 흐름 두개가 생겼을 때 일을 시키면 확실히 동시에 한다는 보장은 받지 못하는 것
		// 일꾼이 8명이 있으니까 그 중 일을 할 수 있는 일꾼들이 와서 하는 것이라
		// 즉, 코어라는 한계 때문에 동시에 일을 시키고 싶어도 그럴 수 없다
		// 쓰레드는 흐름에 맞게 기다리고 순서를 맞게 제어하는게 힘든것이고 그게 된다면 멀티 쓰레드가 되는 것
		// 자바에서는 멀티 쓰레드를 하고 싶다면
		// 멀티 쓰레드를 하고 싶다면 인터페이스 형태로 할일을 구현하면 된다
		System.out.println("작업 1 시작");
		printNumbers();
		System.out.println("작업 1 종료");
		
		System.out.println("작업 2 시작");
		printNumbers();
		System.out.println("작업 2 종료");
		
		System.out.println("작업 3 시작");
		printNumbers();
		System.out.println("작업 3 종료");
	}
}