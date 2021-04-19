package algo0419;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main_1708_블록껍질 {

	static class Point{
		long x;
		long y;
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "L [x=" + x + ", y=" + y + "]";
		}
		
	}
	static class LC implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			int re=Long.compare(p1.y, p2.y);
			if(re==0) {
				return Long.compare(p1.x, p2.x);
			}else {
				return re;
			}
		}
		
	}
	static class LTC implements Comparator<Point>{

		Point p0;
		public LTC(Point p0) {
			this.p0 = p0;
		}

		@Override
		public int compare(Point p1, Point p2) {
			int re=ccw(p0,p1,p2);
			if(re==0) {
				long distance1 = dist(p0, p1);
                long distance2 = dist(p0, p2);

                if (distance1 > distance2) {    // 거리가 더 가까운 순으로 정렬
                    return 1;
                }else return -1;
			}else {
				return re>0 ? -1:1;// 앞에가 크면 뒤집어 -> ASC 각도순으로 첫 좌표에서
			}
		}
		
	}
	static int N;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		ArrayList<Point> points=new ArrayList<>();
		Stack<Point> hull=new Stack<>();
		for (int i = 0; i < N; i++) {
			long x=scann.nextLong();
			long y=scann.nextLong();
			points.add(new Point(x,y));
		}
		points.sort(new LC());
		Point p0=points.remove(0);
		hull.push(p0);
		points.sort(new LTC(p0));
		Point p1=points.remove(0);
		hull.push(p1);
		for (int i = 0; i < N-2; i++) {
			Point b=points.get(i);
			while(hull.size()>=2) {// 두개이상
				Point a=hull.pop();   //위의것이 뒤에 들어간것.
				Point p=hull.peek();  //먼저 들어간것
				int ccwvalue=ccw(p,a,b);
				if(ccwvalue>0) {
					hull.push(a);
					break;
				}
			}
			hull.push(b);
		}
		System.out.println(hull.size());
/*		int size=hull.size();
		for (int i = 0; i < size; i++) {
			L a=hull.pop();
			System.out.println(a.x+" "+a.y);
		}*/
	}

	static int ccw(Point p, Point a, Point b) {
		long result =cross(vec(p,a),vec(a,b));
    	if (result > 0) {   // 반시계 방향
            return 1;
        } else if (result < 0) {    // 시계 방향
            return -1;
        } else {
            return 0;
        }
	}
	static long cross(Point a, Point b) {
		return a.x*b.y-a.y*b.x;
	}
	//ab-> ob-oa 상대벡터
	static Point vec(Point a, Point b) {
		long x=b.x-a.x;
		long y=b.y-a.y;
		return new Point(x,y);
	}
	static long dist(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
}