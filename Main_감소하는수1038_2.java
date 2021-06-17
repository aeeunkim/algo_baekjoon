package algo0619;

import java.util.Scanner;

public class Main_감소하는수1038_2 {
	static int N;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		if(N<10)
			System.out.println(N);
		else {
			go(10,10);
			System.out.println(answer);
		}
	}
	private static void go(int an, int cnt) {
		if(cnt==N) {
			answer=an;
			return;
		}
		int temp=an;
		boolean ch = true;
		while(true) {
			if(temp<10) break;
			int a = temp %10;
			temp/=10;
			int b=temp %10;
			if(a>=b) { 
			ch=false;
			break;
			}
		}
		if(ch)go(an+1,cnt+1);
		else go(an+1,cnt);
	}

}
