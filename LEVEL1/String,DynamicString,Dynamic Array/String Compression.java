import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){

		String comp1 = "";
		comp1 += str.charAt(0);

		//String comp1 += str.charAt(0);

		for(int i = 1; i<str.length(); i++){
			if(comp1.charAt(comp1.length()-1) != str.charAt(i)){
				comp1 += str.charAt(i);
			}
		}
		return comp1;
	}

	public static String compression2(String str){
		String comp2 = "";
		comp2 += str.charAt(0);
		int count = 1;

		for(int i = 1; i<str.length(); i++){
			if(comp2.charAt(comp2.length()-1) == str.charAt(i)){
				count++;
			}
			else{
				if(count>1){
					comp2 += count;
				}
				comp2 += str.charAt(i);
				count = 1;
			}
		}

		if(count>1){
			comp2 += count;
		}
		return comp2;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}