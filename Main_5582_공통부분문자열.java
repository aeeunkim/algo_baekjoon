package study0626;
/*
 * 이차원 배열을 만들어서 값들 비교
 * 대각선으로 늘어난다.
 */
import java.util.Scanner;

public class Main_5582_공통부분문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String one = sc.next();
		String two = sc.next();
		int leno = one.length();
		int lent = two.length();
		int max=0;
		int [][] map = new int[leno+1][lent+1];
		for(int i=1;i<leno+1;i++) {
			for(int j=1;j<lent+1;j++) {
				if(one.charAt(i-1)==two.charAt(j-1)) {
					map[i][j]=map[i-1][j-1]+1;
					if(map[i][j]>max)max=map[i][j];
				}
			}
		}
		System.out.println(max);
	}

}
