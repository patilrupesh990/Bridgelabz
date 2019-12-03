package com.bridgelabz.algorithmprograms;

import java.util.Arrays;

import com.bridgelabz.util.Utility;

public class TaskScheduling 
{
	int deadline,finis;
	String taskName;
		public TaskScheduling() {
			// TODO Auto-generated constructor stub
		}
		TaskScheduling(int deadline,int finish,String taskName)
		{
			this.deadline=deadline;
			this.finis=finish;
			this.taskName=taskName;
		}
		public static void main(String[] args) {
			
			
			System.out.println("Enter the number of tasks");
			int noTasks=Utility.InputInt();
			TaskScheduling tasks[]=new TaskScheduling[noTasks];
			
			int deadline[]=new int[noTasks];
			int finish[]=new int[noTasks];
			String name[]=new String[noTasks];
			for(int count=0;count<noTasks;count++)
			{

				
				System.out.println("Enter the name of task");
				 name[count]=Utility.InputString();
				
				 System.out.println("Enter the time in minit");
				finish[count]=Utility.InputInt();
				System.out.println("Enter the Deadline");
				deadline[count]=Utility.InputInt();
				
				int deadl=deadline[count];
				int min=finish[count];
				String taskname= name[count];
				tasks[count]=new TaskScheduling(deadl, min, taskname);
			}
			
			Arrays.sort(finish);
		}
		
		
		public void taskSchedule(TaskScheduling tasks[],int finish[])
		{
			
			String names[]=new String[finish.length];
			int index=1;
			for(int count=0;count<finish.length-2;count++)
			{
				names[0]=tasks[finish[count]].taskName;
				if(tasks[count+1].finis<=tasks[count+2].deadline)
				{
					names[index++]=tasks[finish[count]].taskName;
				}
			}
			
			for(int index2=0;index2<index;index2++)
			{
				System.out.println("task"+(index2+1)+names[index2]);
			}
		}
}

