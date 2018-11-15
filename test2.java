/*************************************************************************
本程序用于计算e
JAVA程序设计第一次作业
姓名：谌悦章
学号：2016210734
创建于：2018.11.1
最后一次修改于：2018.11.5 加入了继承。
*************************************************************************/
import java.io.*;
import java.util.Scanner;
 class math
{
	public static int computeFactorial(int i)//计算阶乘
	{
		if(i == 0 || i == 1)
			return 1;
		else
			return i*computeFactorial(i-1);//递归
	}
}

class computeE extends math//计算e
{
	public static void main(String[] args)throws IOException
	{
		System.out.println("谌悦章");
		System.out.println("2016210734");
		System.out.println("请输入e泰勒展开的阶数：");
		Scanner scan = new Scanner(System.in);
		int grade = scan.nextInt();//输入阶数
		//int grade = (int) System.in.read()-'0';//System.in.read()输入的是一位ASCLL码，需要强制类型转换
		double e = 0.0;
		for(int i = 1; i <= grade; i++)
		{
			e = e + (1.0 / math.computeFactorial(i));//需1.0，否则为整数除
		}
		System.out.println("e近似为：" + e);
		scan.close();
	}
}
