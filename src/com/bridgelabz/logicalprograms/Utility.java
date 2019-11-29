package com.bridgelabz.logicalprograms;
import java.util.Random;
/**
 * @author Rupeshp007
 * date:18/11/2019
 * Purpos:utility class for tic toe game for print 3X3 board and initialize the marks for perticuler localtions. 
 * to check who is winning
 * to check game is over or not
 * two marks "X" and "0" 
 **********************************************************************************/
public class Utility 
{
	private static char board[][];
	private static char CurrentPlayerMark;
	private static char ComputerPlayerMark;
	static com.bridgelabz.util.Utility util=new com.bridgelabz.util.Utility();
	static Utility object=new Utility();
	static String name;
	
	//Utility player=new Utility();
	//Utility computer=new Utility();
	public void Initilization()
	{
		board=new char[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]='-';
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void PrintBord(String name)
	{
		this.name=name;
		System.out.println("---------->>>>welcome Mr."+name+"<<<<<----------");
		System.out.println();
		System.out.println("=====================");
		for(int i=0;i<3;i++)
		{
			
			for(int j=0;j<3;j++)
			{
				System.out.print(" | "+(board[i][j])+" | ");	
			}
			System.out.println();
			System.out.println("=====================");
		}
		AssignMarks();
		
	}
	@SuppressWarnings("static-access")
	public void AssignMarks()
	{
		System.out.println("Enter Your Sign for Mark:");
		System.out.println("choose X or O press from keyboard");
		
		CurrentPlayerMark=util.InputChar();
		if(CurrentPlayerMark!='x'&&CurrentPlayerMark!='X'&&CurrentPlayerMark!='o'&&CurrentPlayerMark!='O')
		{
			System.out.println("invalid input please enter Only X or O");
			CurrentPlayerMark=util.InputChar();
		}
		if(CurrentPlayerMark=='x'||CurrentPlayerMark=='X')
		{
			ComputerPlayerMark='O';
		}
		else
		{
			ComputerPlayerMark='X';
		}
		boolean loop=true;
		while(loop)
		{
			if (!IsWin(ComputerPlayerMark)&&!IsWin(CurrentPlayerMark))
			{
				System.out.println("Enter Your Mark Location");
				System.out.println("enter row nob");
				int row=util.InputInt()-1;
				System.out.println("enter Colomn nob");
				int col=util.InputInt()-1;
				object.AssignMarkLocation(row,col);
			}
			else
			{
				

				if(IsWin(CurrentPlayerMark))
				{
					System.out.println(this.name+" Win the math");
				}
				else if(IsWin(ComputerPlayerMark))
				{
					System.out.println("Computer Win the math");
				}
				loop=false;
			}
		}
	}
	
	public void AssignMarkLocation(int row,int col)
	{
				
				board[row][col]=CurrentPlayerMark;
				Random r=new Random();
				int max=2,min=0;
				int row2=0,col2=0;
				boolean loop=true;
				while(loop)
				{
					row2=r.nextInt((max - min) + 1) + min;
					col2=r.nextInt((max - min) + 1) + min;
					if(!ComputerTurn(row2,col2))
					{
						board[row2][col2]=ComputerPlayerMark;
						
						System.out.println("=====================");
						for(int i=0;i<3;i++)
						{
							
							for(int j=0;j<3;j++)
							{
								System.out.print(" | "+(board[i][j])+" | ");	
							}
							System.out.println();
							System.out.println("=====================");
						}
							break;
					}
					else
						continue;
				
					
				}

	}
	public boolean ComputerTurn(int row,int col)
	{
		
		if(board[row][col]==CurrentPlayerMark)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean IsWin(char player)
	{
		return((board[0][0]+board[0][1]+board[0][2]==player*3)||
				(board[1][0]+board[1][1]+board[1][2]==player*3)||
				(board[2][0]+board[2][1]+board[2][2]==player*3)||
				(board[0][0]+board[1][0]+board[2][0]==player*3)||
				(board[0][1]+board[1][1]+board[2][1]==player*3)||
				(board[0][2]+board[1][2]+board[2][2]==player*3)||
				(board[0][0]+board[1][1]+board[2][2]==player*3)||
				(board[2][0]+board[1][1]+board[0][2]==player*3));	
	}
	
	public static boolean isTied(char[][] board)
	 {

		
		
	  return false;
	 }
	
	

}
