package algo_myselr;

import java.util.Scanner;

public class Main_2941_크로아티아 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cr[] = {"c=", "c-", "dz=", "d-", "lj", "nj","s=", "z="};
		String res=sc.next();
		for(int i=0;i<cr.length;i++) {
			if(res.contains(cr[i])) {
				res=res.replace(cr[i], "q");
			}
		}
		System.out.println(res.length());
	}		
}
