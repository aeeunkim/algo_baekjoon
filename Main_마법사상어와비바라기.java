package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_마법사상어와비바라기 {
	static int arr[][];
	static int N,M;
	static Queue<int[]> que = new LinkedList<int[]>();
	static int dy[]= {0,-1,-1,-1,0,1,1,1};
	static int dx[]= {-1,-1,0,1,1,1,0,-1};
	static boolean[][] c;
	static ArrayList<int[]> ar=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][N];
		c=new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken())-1;
			int s=Integer.parseInt(st.nextToken());
			que.add(new int[] {d,s});
		}
		int s_y=N-2;
		int s_x=0; //다른애들은 +1씩임
		int [] cur=que.poll();
		int[] mo = move(s_y,s_x,cur[0],cur[1]);
		int y=mo[0];
		int x=mo[1];
		arr[y][x]-=1;
		int mo1[]=numna(y+1,x+1);
		int mo2[]=numna(y+1,x);
		int mo3[]=numna(y,x+1);
		ar.add(mo);
		ar.add(mo1);
		ar.add(mo2);
		ar.add(mo3);
		plusone(ar);
		is(ar);	

		
		while(!que.isEmpty()) {
			int mqu[]=que.poll();
			ArrayList<int[]> a=new ArrayList<>();
			ArrayList<int[]> b= new ArrayList<>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]>=2 && !c[i][j]) {
						a.add(new int[] {i,j});
						arr[i][j]-=2;
					}
					c[i][j]=false;
				}
			}//움직인 구름
			for(int i=0;i<a.size();i++) {
				int to[]=move(a.get(i)[0],a.get(i)[1],mqu[0],mqu[1]);
				b.add(new int[] {to[0],to[1]});
			}
			is(b);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]>=2 && !c[i][j]) {
					arr[i][j]-=2;
				}
			}
		}//움직인 구름
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum+=arr[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	private static void plusone(ArrayList<int[]> ar2) {
		for (int i = 0; i < ar2.size(); i++) {
			int p[]=ar2.get(i);
			int y=p[0];
			int x=p[1];
			arr[y][x]+=1;
		}
	}
	private static void is(ArrayList<int[]> ar2) {
		for (int i = 0; i < ar2.size(); i++) {
			int p[]=ar2.get(i);
			int y=p[0];
			int x=p[1];
		
			c[y][x] = true;
			int cnt = 0;
			int ddy[] = { -1, -1, 1, 1 };
			int ddx[] = { -1, 1, -1, 1 };
			for (int d = 0; d < 4; d++) {
				int my=ddy[d]+y;
				int mx=ddx[d]+x;
				if(my<0 || mx<0 ||my>=N||mx>=N) continue;
				if (arr[my][mx] > 0)
					cnt++;
			}
			arr[y][x]+=cnt;
		}
	}
	private static int[] move(int s_y, int s_x,int d,int s) {
	
		int my=s_y+dy[d]*s;
		int mx=s_x+dx[d]*s;
		int b[]=numna(my,mx);
		arr[b[0]][b[1]]+=1;
		return b;
	}
	private static int[] numna(int my, int mx) {
		if(my<0)my=(my%N)+N;
		if(mx<0)mx=(mx%N)+N;
		if(my>=N)my=(my%N);
		if(mx>=N)mx=(mx%N);
		int a[]= {my,mx};
		return a;
	}


}
