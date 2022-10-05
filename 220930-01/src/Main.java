public class Main {
	public static void printNumbers() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
		// 자바에서 이 쓰레드의 흐름을 제어할 수 있게끔 객체의 형태로 다루고 있다
		// 그래서 현재 쓰레드의 이름을 달라고 해봤는데
		
		// 동기적인 흐름이 일어남
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