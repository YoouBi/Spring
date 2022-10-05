class IntHolder {
	private int number;
	
	public void increse() {
		number++;
	}
	public int getNumber() {
		return number;
	}
}

public class Main5 {
	public static void main(String[] args) throws InterruptedException {
		IntHolder mySharedObject = new IntHolder();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
//				int a = 0; // 이 때 이 각각의 쓰레드에서 사용할 객체가 아니라
				for (int i = 0; i < 10000; i++) {
//					a++;
					mySharedObject.increse();
					// 똑같이 쓸 수 있는 객체지만 참조해서 쓰는 객체를 만들어서 increse로 더해보자
				}
//				System.out.println("작업 완료, a값: " + a);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
//				int a = 0;
				for (int i = 0; i < 10000; i++) {
//					a++;
					mySharedObject.increse();
				}
//				System.out.println("작업 완료, a값: " + a);
			}
		});
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(mySharedObject.getNumber());
		// 값이 2만이 나와야 정상인데 이 숫자는 실행할때마다 달라진다
		// 왜일까?
		// IntHolder라는 참조 객체는 ram이라는 공간에서 하나의 공간을 가지고 있을 것
		// CPU들은 자기가 작업하는 래지스터라는 아주 빠른 작업 공간이 따로 있다
		// ram에 있던 걸 자기가 작업하는 공간에 복사해서 들고와서 연산을 한 뒤 다시 원래의 공간으로 집어넣는다
		// 작업하는 애가 한명이면 아무 문제가 없지만
		// 두명일경우 0을 들고와서 1 더하는 사이에, 그러니까 연산한 값을 집어넣기 전에
		// 다른 일꾼이 0을 들고와서 1을 더해서 집어넣으면
		// 1을 더하는 작업은 두번 일어났지만 결과는 1일 것이다
		
		// 이런걸 방지하려면 한 일꾼이 일할 때 다른 일꾼은 기다리게 만들거나(순서 지켜서 하자!)
		// 공유되는 자원을 서로 영향을 받지 않게끔 만들수도 있겠다
		// 근데 프로젝트를 만들 때 느꼈겠지만 접점이 생길 수 밖에 없다 적용하기 힘들 수 있음
		// 그러니까 공유하는게 있다면 공유하는걸 절대 못바꾸게 하면 언제나 똑같은 값일 것
		// 읽기만 가능...변경 불가능... 인뮤트...?
		
		// 순서 지켜서 자원을 안전하게 쓰는,
		// 멀티 쓰레드 상황에서도 정확하게 쓸 수 있는 쓰레드 세이프한 프로그램을 만드는 것
	}
}