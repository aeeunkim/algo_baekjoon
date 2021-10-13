package 삼성기출;
/*
 * 한번에 o
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 { //처음엔 1,1 오른쪽
	static int N,cnt;
	static int arr[][],time[];
	static boolean check[][];
	static int dy[]= {0,1,0,-1}; //오 아 왼 위
	static int dx[]= {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		arr=new int [N][N];
		check=new boolean[N][N];
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			arr[r][c]=1;
		}
		int l=Integer.parseInt(br.readLine());
		time=new int[10001];
		for(int i=0;i<l;i++) {
			st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			char m=st.nextToken().charAt(0);
			if(m=='D')
				time[t]=1;//오른쪽
			else if(m=='L')
				time[t]=2;//왼쪽		
		}
		int sm=0;
		Queue<int[]> head = new LinkedList<>();
		Queue<int[]> tail = new LinkedList<>();
		tail.add(new int[] {0,0});
		head.add(new int[] {0,1});
		check[0][0]=true;
		check[0][1]=true;
		while(true) {
			cnt++;
			if(time[cnt]!=0) {
				if(time[cnt]==1) {
					sm+=1;
					if(sm>3)sm=sm-4;
				}
				else if(time[cnt]==2) {
					sm-=1;
					if(sm<0)sm=sm+4;
				}
			}
			int cur[]=head.poll();
			int cy=cur[0];
			int cx=cur[1];
			if(arr[cy][cx]==0) {
				int be[]=tail.poll();
				int by=be[0];
				int bx=be[1];
				check[by][bx]=false;
			}
			int my=cy+dy[sm];
			int mx=cx+dx[sm];
			if(my<0||mx<0||my>=N||mx>=N)break; //벽
			if(check[my][mx]==true)break; //뱀
			check[my][mx]=true;

			arr[cy][cx]=0; //사과 먹음
			tail.add(new int[] {cy,cx}); //바로 직전
			head.add(new int[] {my,mx});
		}
		System.out.println(cnt+1);
		
	}

}
