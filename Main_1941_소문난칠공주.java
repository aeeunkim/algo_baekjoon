package study0626;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1941_소문난칠공주 {
	static char[][]arr = new char[5][5];
	static boolean V[],adj[];
	static int[] select;
	static int answer;
	static Queue<Integer>ss;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			String a = sc.next();
			arr[i]=a.toCharArray();
		}
		V=new boolean [25];
		select = new int[7];
		find(0,0,0);
		
		
		
	}
	private static void find(int idx, int cnt, int cns) {
		if(cnt==7) {
			if(cns>=4) {
				if(possible())
					answer++;
			}
			return;
		}
		for(int i=idx;i<25;i++) {
			V[i]=true;
			select[cnt]=i;
			if(arr[i/5][i%5]=='S') find(i+1,cnt+1,cns+1);
			else find(i+1,cnt+1,cns);
			V[i]=false;
		}
	}
	private static boolean possible() {
		ss = new LinkedList<>();
		int cnt=1;
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};
		ss.add(select[0]);
		while(!ss.isEmpty()) {
			int now = ss.poll();
			adj[now]=true;
			int y=now/5;
			int x=now%5;
			for(int d=0;d<4;d++) {
				int my=y+dy[d];
				int mx=x+dx[d];
				if(mx<0 || my<0 || mx>=5 || my>=5)continue;
			}
		}
		return false;
	}

}
