import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        boolean visited[][] = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][]visited) {
        //-ve base case 
        if(sr<0 || sc<0 || sr>=maze.length || sc>=maze[0].length || maze[sr][sc]==1 || visited[sr][sc] == true ){
            return;
        }
        
        //+ve base case
        if(sr==maze.length-1 && sc==maze[0].length-1 ){
            System.out.println(asf);
            return;
        }

        visited[sr][sc] = true;
        //top
        floodfill(maze, sr-1, sc, asf+"t", visited);
        //left
        floodfill(maze, sr, sc-1, asf+"l", visited);
        //down
        floodfill(maze, sr+1, sc, asf+"d", visited);
        //right
        floodfill(maze, sr, sc+1, asf+"r", visited);
        /* bcoz back ate hai to sare node true hoti hai esliye
         hamara last asf print nhi karta hai usko print karne kai liye   (below line) */ 
        visited[sr][sc] = false;
    }
}

