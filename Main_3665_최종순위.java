package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3665_최종순위 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st=new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int ago[] = new int[n+1];
			int degree[] = new int[n+1];
			int answer[] = new int[n];		
			boolean check[] = new boolean[n+1];
			boolean ch=false;;
			for (int i = 1; i <= n; i++) {
				int te=Integer.parseInt(st.nextToken());
					ago[i]=te;
			}

			ArrayList<Integer> list[] = new ArrayList[n+1];
			for (int i = 1; i <=n; i++) {
				list[i]=new ArrayList<>();
			}
			for (int i = 1; i <=n; i++) {
				int from = ago[i];
				for (int j = i+1; j <= n; j++) {
					list[from].add(ago[j]);
					degree[ago[j]]++;
				}
			}
			st=new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int i = 0; i < cnt; i++) {
				st=new StringTokenizer(br.readLine());
				int forward = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[forward].add(end);
				if(list[end].indexOf(forward)==-1) {
					ch=true;
					break;
				}
				list[end].remove(list[end].indexOf(forward));
				degree[end]++;
				degree[forward]--;
			}
			if(!ch) {
				Queue<Integer> que = new LinkedList<Integer>();
				for (int i = 1; i <= n; i++) {
					if (degree[i] == 0)
						que.add(i);
				}
				int in = 0;
				while (!que.isEmpty()) {
					int cur = que.poll();
					answer[in++] = cur;
					check[cur] = true;
					for (int i = 0; i < list[cur].size(); i++) {
						int next = list[cur].get(i);
						if (check[next]) {
							ch = true;
							break;
						}
						degree[next]--;
						if (degree[next] == 0)
							que.add(next);
					}
					if (ch)
						break;
				}
				for (int i = 0; i < n; i++) {
					System.out.print(answer[i] + " ");
				}
			}
		
			else {
				if(ch)System.out.print("IMPOSSIBLE");
			}
			System.out.println();
			
		}
		
	}

}
