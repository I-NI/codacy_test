/*************************************************************************
本程序用于根据考试成绩的等级打印出百分制分数段
JAVA程序设计第一次作业
姓名：谌悦章
学号：2016210734
创建于：2018.11.1
*************************************************************************/
import java.io.*;

public class gradeToScore
{
	public static void main(String[] args)throws IOException
	{
		System.out.println("谌悦章");
		System.out.println("2016210734"); 
        System.out.print("Enter a Char:"); 
        char grade = (char) System.in.read(); 		
		switch(grade)
		{
			case 'A':
				System.out.println("90分以上");
				break;
			case 'B':
				System.out.println("80分以上");
				break;
			case 'C':
				System.out.println("70分以上");
				break;
			case 'D':
				System.out.println("60分以上");
				break;				
			case 'E':
				System.out.println("59分以下");
				break;			
			default:
				System.out.println("没有这个等级！");				
		}
	}
}
	