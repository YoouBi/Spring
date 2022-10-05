
public class test {
	public static void main(String[] args) {
		int x = 11;
		
		boolean answer = true;
        int sum = 0;
        int y = x;
        
        while(x >= 1) {
            sum += x % 10;
            x /= 10;
            System.out.println(sum);
        }
        System.out.println(y);
        
        if(y % sum != 0) {
        	answer = false;
        }
        
        System.out.println(x % sum);
	}
}