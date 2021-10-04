import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String array[] = br.readLine().split(" ");
		int x = Integer.parseInt(br.readLine());

		Long sum = 0L;
		int cnt = 0;
		
		Vector<Integer> num = new Vector<Integer>();
		boolean[] prime = new boolean[1000001];
		Arrays.fill(prime, true);

		prime[1] = false;
		for(int i=2; i<1000001; i++) {
			if(prime[i] == false) continue;
			if(x % i == 0) num.add(i);
			for(int j=i*2; j<1000001; j+=i) { 
				prime[j] = false;
			}
		}

		for(String s: array) {
			int pi = Integer.parseInt(s);
			boolean check = true;
			for(int i: num) {
				if(pi < i) break;
				if(pi % i == 0) {
					check = false;
					break;	
				}
			}
			if(check) {
				sum += pi;
				cnt++;
			}
		}

		System.out.println((double)sum/cnt);
	}
}