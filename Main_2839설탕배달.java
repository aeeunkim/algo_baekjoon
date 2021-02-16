package algo0216;

import java.util.Scanner;
public class Main_2839설탕배달 {//dfs
	static int num;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		go(num,0);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	private static void go(int size,int sum) {
		if(size==0) {
			min=Math.min(min, sum);
			return;
		}
		else if(size>0) {
			go(size-5,sum+1);
			go(size-3,sum+1);
		}
		else
			return;
	}
}
