//This application is to find the max in 10 integers!
import java.util.*;
public class findMax
{
	public static void main(String[] args)
	{
		final int intNum=10;
		double[] integerList = new double[intNum];
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入十个数");
		for(int i = 1; i <= integerList.length; i++)
		{
			System.out.println("请输入第" + i + "个数：");
			integerList[i-1]=sc.nextDouble();
		}
		Arrays.sort(integerList);
		System.out.println("最大数为：" + integerList[9]);
		sc.close();
	}
}