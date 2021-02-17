import java.util.Scanner;

public class Main_백준_1992 {

	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		arr=new int[T][T];
		for(int i=0;i<T;i++) { //입력
			String[] sr = sc.next().split("");
			for(int j=0;j<T;j++) {
				arr[i][j]=Integer.parseInt(sr[j]);
			}
		}
		go(0,0,T);//x시작, y시작, size만큼
		System.out.println(sb);
	}
	private static void go(int stx, int sty, int size) {
		int one=0; //1
		int zero=0; //0
		for(int i=sty;i<sty+size;i++) { //y축 
			for(int j=stx;j<stx+size;j++) {//x축
				if(arr[i][j]==1)
					one+=1;
				else
					zero+=1;
			}
		}
		if(one==0) { // 모두다 0으로 채워졌을 때
			sb.append(0);
			return;
		}
		else if(zero==0) { //모두 다 1로 채워졌을 때
			sb.append(1);
			return;
		}
		else { //나머지
			sb.append("(");
			go(stx,sty,size/2); //1사분면
			go(stx+size/2,sty,size/2); //2사분면
			go(stx,sty+size/2,size/2); //3사분면
			go(stx+size/2,sty+size/2,size/2); //4사분면
			sb.append(")");
		}
		return;
	}
}

