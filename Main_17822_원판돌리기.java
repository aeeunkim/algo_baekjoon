package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {
	static int one[], arr[][];
	static int N,M,K;
	static Queue<int[]> que=new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		one = new int[N+1];
		arr=new int[N+1][M];
		for (int i = 1; i <= N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			que.add(new int[] {x,d,k});
		}
		while(!que.isEmpty()) {
			int c[]=que.poll();
			move(c[0],c[1],c[2]);
//			System.out.println("move");
//			print();
//			System.out.println("delete");
			delete();
//			print();
		}
		int count=0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==-1)continue;
				count+=arr[i][j];
			}
		}
		System.out.println(count);
		
	}
	private static void print() {
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	private static void delete() {
		boolean check[][]=new boolean[N+1][M];
		boolean mo=false;
		float tot=0;
		float cnt=0;
		for(int i=1;i<N+1;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==-1) {
					cnt++;
					continue;
				}
				tot+=arr[i][j];
				int ind=j+1;
				if(ind>=M)ind-=M;
				if(arr[i][j]==arr[i][ind]) {
					check[i][j]=true;
					check[i][ind]=true;
					mo=true;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if(arr[j][i]==-1) {
					continue;
				}
				int ind=j+1;
				if(arr[j][i]==arr[ind][i]) {
					check[j][i]=true;
					check[ind][i]=true;
					mo=true;
				}
			}
			
		}
		if(!mo) {
			float sss=N*M-cnt;
			//System.out.println(sss);
			if(N*M-cnt==0)return;
			
			tot=tot/(N*M-cnt);
			for (int i = 1; i < N+1; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]==-1)continue;
					if(arr[i][j]>tot)
						arr[i][j]-=1;
					else if(arr[i][j]<tot)
						arr[i][j]+=1;
				}
			}
		}
		else {
			for (int i = 1; i < N+1; i++) {
				for (int j = 0; j < M; j++) {
					if(check[i][j])arr[i][j]=-1;
				}
			}
		}
		
	}
	private static void move(int x, int d, int k) {
		for (int a = 0; a < k; a++) {
			int xx = x;
			while (true) {
				if (xx > N)
					break;
				if (d == 0) {
					int te = arr[xx][M - 1];
					for (int i = M - 1; i > 0; i--) {
						arr[xx][i] = arr[xx][i - 1];
					}
					arr[xx][0] = te;
				} else {
					int te = arr[xx][0];
					for (int i = 0; i < M - 1; i++) {
						arr[xx][i] = arr[xx][i + 1];
					}
					arr[xx][M - 1] = te;
				}
				xx += x;
			}
		}
	}

}
