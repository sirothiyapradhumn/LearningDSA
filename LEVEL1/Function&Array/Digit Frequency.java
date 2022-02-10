import java.util.*;

public class Main {

    public static int frequency(int n, int d){
        int count = 0;
        while( n!= 0){
            int rem = n % 10;
            if(rem == d){
                count++;
            }
            n = n / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int fqcy = frequency(n, d);
        System.out.println(fqcy);

    }
}