import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
		String str1 = "";
		for(int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			if( ch>='a' && ch<='z'){
				char upperCase = (char)('A' + ch - 'a');
				str1 += upperCase;
			}
			else {
				char lowerCase = (char)('a' + ch - 'A');
				str1 += lowerCase;
			}
		}
		return str1;
	}

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}