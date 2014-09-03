//model

import java.io.*;
import java.util.*;

public class MazeModel
{
    public static char [][] readMaze(String filename) throws IOException{
        char [][] maze;
        Scanner scanner;
        try{
            scanner = new Scanner(new FileInputStream(filename));
        }
        catch(IOException ex){
            System.err.println("*** Invalid filename: " + filename);
            return null;
        }
        
        int N = scanner.nextInt();
        scanner.nextLine();
        maze = new char[N][N];
        int i=0;
        while(i < N && scanner.hasNext()){
            String line =  scanner.nextLine();
            String [] tokens = line.split("\\s+");
            int j = 0;
            for (; j< tokens.length; j++){
                maze[i][j] = tokens[j].charAt(0);
            }
            if(j!=N){
                System.err.println("*** Invalid line: " + i + " has wrong # columns: " + j);
                return null;
            }
            i++;
        }
        if(i!=N){
            System.err.println("*** Invalid file: has wrong number of rows: " + i);
            return null;
        }
        return maze;
    }
    
    public static void printMaze(char[][] maze){
        
        if(maze==null || maze[0] == null){
            System.err.println("*** Invalid maze array");
            return;
        }
        
        for(int i=0; i< maze.length; i++){
            for(int j = 0; j< maze[0].length; j++){
                System.out.print(maze[i][j] + " "); 
            }
            System.out.println();
        }
        
        System.out.println();
    }

}