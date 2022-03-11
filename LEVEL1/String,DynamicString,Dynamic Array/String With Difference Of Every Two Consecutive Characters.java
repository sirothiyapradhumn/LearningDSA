import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
		StringBuilder sb1 = new StringBuilder();
		sb1.append(str.charAt(0));
		for(int i = 1; i<str.length(); i++){
			int diff = str.charAt(i) - str.charAt(i-1);
			sb1.append(diff);
			sb1.append(str.charAt(i));
		}

		return sb1.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}