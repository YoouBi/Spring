public class Main4 {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() { // 데몬 쓰레드가 아니라서 
			@Override
			public void run() {
				System.out.println("잘게요");
				try {
					Thread.sleep(4000); // 현재 쓰레드를 특정한 시간(밀리세컨트단위로 4초)동안 재운다
				} catch (InterruptedException e) { // 자바에서는 인터럽트를 예외로 구현해놨다
					// 왜 예외로 구현해놨을까? 블럭으로 갇혀있어서 흐름이 깨져버리기 때문
					e.printStackTrace();
				}
				System.out.println("작업 종료~");
			}
		});
//		t.setDaemon(true); // 데몬 쓰레드로 만들었기 때문에 자다가 메인 쓰레드가 죽으면 같이 죽음ㅠㅠ
		
		System.out.println("프로그램 시작");
		t.start();
		t.interrupt(); // main이 interrupt로 자는 걸 방해함
		
		System.out.println("프로그램 종료????");
	}
}
