package 백준;

import java.util.Scanner;

public class Main_5525_ioio {
	static String s,p;
	static int pi[];
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int S_len=sc.nextInt();
		
		s=sc.next();
		p="I";
		for (int i = 0; i < N; i++) {
			p+="OI";
		}
		pi=new int[p.length()];
		getPi();
		kmp();
		System.out.println(cnt);
		
	}
	private static void kmp() {
		int j=0;
		for (int i = 0; i < s.length(); i++) {
			while(j>0 && s.charAt(i)!=p.charAt(j))
				j=pi[j-1];
			if(s.charAt(i)==p.charAt(j)) {
				if(j==p.length()-1) {
					cnt+=1;
					j=pi[j];
				}
				else
					++j;
			}
		}
	}
	private static void getPi() {
		int j=0;
		for (int i = 1; i < p.length(); i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j))
				j=pi[j-1];
			if(p.charAt(i)==p.charAt(j)) {
				pi[i]=++j;
			}
		}
	}

}
