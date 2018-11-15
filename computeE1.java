/*************************************************************************
本程序用于计算e
JAVA程序设计第一次作业
姓名：谌悦章
学号：2016210734
创建于：2018.11.1
*************************************************************************/
import java.io.*;
import java.util.Scanner;
public class computeE1
{
	public static int computeFactorial(int i)
	{
		if(i == 0 || i == 1)
			return 1;
		else
			return i*computeFactorial(i-1);
	}
	public static void main(String[] args)throws IOException
	{
		System.out.println("谌悦章");
		System.out.println("2016210734");
		System.out.println("请输入e泰勒展开的阶数：");
		Scanner in = new Scanner(System.in);
		//int grade = in.nextInt();
		//System.out.println(grade);
		int grade = (int) System.in.read()-'0';//强制类型转换
		double e = 0.0;
		for(int i = 1; i <= grade; i++)
		{
			e = e + (1.0 / computeFactorial(i));//整数除
			System.out.println(computeFactorial(i));
		}
		System.out.println(e);		
	}
}