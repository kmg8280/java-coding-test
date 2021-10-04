import java.lang.reflect.Array;
import java.util.*;

public class Main{

	private static boolean isPrime(Long number) {
		if(number%2 == 0) {
			return number == 2;
		}
		double root = Math.sqrt(number);
		for(int i=3; i<=root; i+=2) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashSet<Long> numbers = new HashSet<Long>();
		for(int i=0; i<n; i++) {
			numbers.add(sc.nextLong());
		}
		Long ans = -1L;
		for(Long num: numbers) {
			if(isPrime(num)) {
				if(ans == -1) {
					ans = 1L;
				}
				ans *= num;
			}
		}
		System.out.println(ans);
	}
}