package study0626;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_4386_별자리만들기 {
static class Edge implements Comparable<Edge>{
	int x,y;
	double w;

	public Edge(int x, int y, double w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.w, o.w);
	}
}
static class Point {
    double x, y;

    public Point(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }
    
}
	static ArrayList<Edge> arr;
    static Point[] stars;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
        stars = new Point[n];

		boolean check[] = new boolean[n];
		double answer=0.0;

		for (int i = 0; i < n; i++) {
			double x=sc.nextDouble();
			double y=sc.nextDouble();
            stars[i] = new Point(x, y);

		}
		arr=new ArrayList<>();
		for(int i=0;i<n-1;i++) {
			   Point now = stars[i];
			for(int j=i+1;j<n;j++) {
				  Point next = stars[j];
				    double dist = Math.sqrt(Math.pow(next.x - now.x, 2) 
	                        + Math.pow(next.y - now.y, 2));
				arr.add(new Edge(i,j,dist));
			}
		}
		Collections.sort(arr);
		int cnt=1;
		int i=0;
		while(cnt<n) {
			Edge te = arr.get(i++);
			if(check[te.x] && check[te.y]) continue;
			check[te.x]=check[te.y]=true;
			answer+=te.w;
			cnt++;
		}
		System.out.println(String.format("%.2f", answer));
	}

}
