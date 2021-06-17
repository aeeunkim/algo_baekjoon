package algo0619;

import java.util.Scanner;

public class Main_nqueen9663 {
	static int T;
	static int arr[];
	static int ans=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		arr=new int[T];
		go(0);
		System.out.println(ans);
	}
	private static void go(int cnt) {
		if(cnt==T) {
			ans++;
			return;
		}
		for(int i=0;i<T;i++) {
			arr[cnt]=i;
			if(possible(cnt)) {
				go(cnt+1);
			}
		}
	}
	private static boolean possible(int col) {
		for (int i = 0; i < col; i++) {
			if(arr[col]==arr[i])return false;
			else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i]))return false;
		}
		return true;
	}

}
