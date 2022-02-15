import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    //int d = getProductWithSingleDigit(n1, n2, b);
    //int d = anyBaseAddition(n1, n2, b);
    System.out.println(d);
 }

 public static int getProduct(int b, int n1, int n2){
    int MainAns = 0;
    int count = 0;

    while(n2!=0){
        int rem  = n2 % 10;
        int semiAns = getProductWithSingleDigit(n1, rem, b);
        int po = (int)Math.pow(10, count);
        MainAns = anyBaseAddition(MainAns, semiAns*po, b); 
        count++;
        n2 /= 10;
    }
    return MainAns;
 }

 public static int getProductWithSingleDigit(int n1, int d, int b){
    int ans = 0;
    int count = 0;
    int carry = 0;

    while(n1!=0 || carry!=0){
        int rem  = n1 % 10;
        int product = (rem * d) + carry;
        int check1 = product % b;
        int check2 = product / b;
        int po = (int)Math.pow(10, count);
        ans += po*check1;
        carry = check2;
        count++;
        n1 /= 10;
    }
    return ans;
 }

 public static int anyBaseAddition(int n1, int n2, int b){
    int ans = 0;
    int count = 0;
    int carry = 0;

    while(n1!=0 || n2!=0 || carry!=0){
        int rem1 = n1 % 10;
        int rem2 = n2 % 10;
        int sum = rem1 + rem2 + carry;
        int check1 = sum % b;
        int check2 = sum / b;
        int po = (int)Math.pow(10, count);
        ans += check1*po;
        carry = check2;
        count++;
        n1 /= 10;
        n2 /= 10;
    }

    return ans;
 }

}