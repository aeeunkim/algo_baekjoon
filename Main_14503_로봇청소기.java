package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 현재 위치를 청소한다.
 * 
현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 */
public class Main_14503_로봇청소기 {
	static int N,M;
	static int arr[][];
	static int dy[]= {-1,0,1,0}; //위 오 아 왼
	static int dx[]= {0,1,0,-1};
	static int cnt;
	static boolean check[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		check=new boolean[N][M];
		st=new StringTokenizer(br.readLine());
		int y=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int c=0;
		int my=0;
		int mx=0;
		while(true) {
			if(!check[y][x]&&arr[y][x]==0) {
				check[y][x]=true;
				cnt++;
			}
			
			if(c>=4) {
				my=y+dy[d]*-1;
				mx=x+dx[d]*-1;
				if(my<0||my>=N||mx<0||mx>=M)break;
				if(arr[my][mx]==0) {
					y=my;
					x=mx;
					c=0;
				}
				else break;
			}
			d-=1;
			if(d==-1)d=3;
			c++;

			my=y+dy[d];
			mx=x+dx[d];
			if(my<0||my>=N||mx<0||mx>=M)continue;
			if(arr[my][mx]==0 && !check[my][mx]) {
				y=my;
				x=mx;
				c=0;
				continue;
			}
		
		}
		System.out.println(cnt);
	}

}
