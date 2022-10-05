public class Main3 {
	public static void printThreadStatus() {
		Thread current = Thread.currentThread();
		
		// 세터로 값을 바꿔줄 수도 있다
		System.out.println(current.getName());
		System.out.println(current.getId()); // 하나의 아이디 고유 번호
		System.out.println(current.isAlive()); // 살아움직이냐(흐름으로 쭉 흘러가고 있음)에 true
		System.out.println(current.getState()); // RUNNABLE은 일을 할 수 있는 상태라는 것
		System.out.println(current.getPriority()); // 선호도를 나타내는 표시인데 1부터 10까지 존재
		// 최솟값인 1이면 이 쓰레드의 중요도가 낮다는 것 최대값인 10이면 이 쓰레드의 작업 중요도가 높다는 것
		// 중요도는 왜 필요한가? 급한 일이 있으면 최대한 그 일부터 작업을 할 수 있게끔하려고
		// CPU라는 작업장치는 윈도우라는 OS가 관리하고 판단을 해서 작업을 할당해주고 있는 것
		// 그래서 10이라고해도 윈도우가 판단하기에 중요하지 않다고 생각하면 뒤로 밀릴수도 있다
		System.out.println(current.isDaemon());
		// Daemon 쓰레드가 아니라면 프로세스가 종료될때까지 자기 할 일을 다 한다
		// 데몬 쓰레드라면 자기 할 일이 남아있더라도 메인 쓰레드가 작업을 다 해서 죽으면 다 같이 죽는다
		// 주 흐름이랑 관계없이 자기 할일을 끝까지해야하면 Daemon 쓰레드가 아니게 만들고
		// 주 흐름이 끝나면 일을 끝내야하는 쓰레드라면 Daemon 쓰레드로 만든다
	}
	
	public static void main(String[] args) throws InterruptedException {
		// 메인 쓰레드가 동작하고 있는 상태
		Thread another = new Thread(new Runnable() { // 쓰레드를 제어할 수 있는 쓰레드 객체 만듦
			@Override
			public void run() {
				printThreadStatus();
			}
		}); // 여기까지는 호출을 하지 않았기 때문에 런어블, 동작을 하지 않는 상태
		another.start(); // 스타트로 호출을 했기 때문에 둘 다 달리고 있는 상태다
		// 이 때엔 누가 먼저 선택받아서 동작될지 모른다
		another.join(); // 쓰레드의 흐름을 제어했기 때문에 다시 시작해도 흐름이 섞이거나 바뀌지 않는다
		// 메인 쓰레드는 another라는 쓰레드의 작업이 종료될때까지 기다려달라고해서
		// 메인 쓰레드는 살아있는 블럭이라는 상태가 됨 흐름이 막혀있음
		// 쓰레드는 작업이 종료되면 죽는다
		// another 쓰레드가 죽을때 Block되어있는 메인 쓰레드를 인터럽트, 깨운다
		// 그럼 메인 쓰레드가 그 때 깨어나서 다시 runnable 상태가 된다
		// 모든 흐름이 끝나면 메인 쓰레드까지 죽는 것이므로 이 프로세스는 종료가 되는 것이다
		
		System.out.println("---------------------");
		printThreadStatus();
		
		System.out.println("새 쓰레드의 현재 상태 : " + another.getState());
	}
}
