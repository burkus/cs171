
/*
 THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
 CODE WRITTEN BY OTHER STUDENTS. Andrew Burkus
 */

import java.io.*;
import java.util.Scanner;

public class MazeSolver
{
	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		MazeModel model = new MazeModel();
		char maze[][];

		/*=============================================
		=            Create Maze
		=============================================*/
		if(args.length > 1)
			maze = model.readMaze(args[0]);
		else
		{
			System.out.print("\nFilename?\n");
			String fileName = "";
			if((fileName = keyboard.nextLine())!= null)
				maze = model.readMaze(fileName);
		}

		/*==========  Solve Dat Bitch!  ==========*/

	}

	/*=============================================
	=            Stack Algorithm
	=============================================*/
	public static solveWithStack(char maze[][])
	{

	}
}