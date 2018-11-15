/****************************************************************** 
问题：设某个田径运动会共有七个项目的比赛，分别为100米、200米、跳高、跳远、铅球、铁饼和标枪。每个选手最多参加3个项目，现有六名选手参赛，他们选择的项目如表1-1所示。考虑到每个选手的参加的各个项目不能同时进行， 
则如何设计合理的比赛日程，使运动会在尽可能短的时间内完成？ 
姓名  项目1 项目2 项目3 
张凯  跳高  跳远   
王刚  100m    200m    铁饼 
李四  跳高  铅球   
张三  跳远  标枪   
王峰  铅球  标枪  铁饼 
李杰  100m    跳远   
提示： 
1、利用图的着色思想解决该问题 
2、可以使用STL相关内容辅助解决该问题 
最后一次更改于：12.21 
coder：ini 
*******************************************************************/  
#include<iostream>  
#include<vector>  
#include<algorithm>  
#include<string>  
	  
using namespace std;  
const int N= 7;  
const int Size = 10000;  
struct Node  
{  
    int ID;//顶点编号  
	int Links;//每个顶点的度  
};  
class Map  
{  
public:  
	void Initial();//初始化邻接矩阵  
    void Transword(int i);//将输入的选手相应的项目编号转换为选手项目输出至屏幕  
	void SortNode();//顶点根据度自动排序算法，按度从大到小顺序排序  
    void Coloring();//染色函数，b是邻接矩阵，N[]是顶点颜色数组  
    void Plan();//针对图的着色结果得出时间段的规划  
	private:  
    int b[N][N];//邻接矩阵  
    vector<Node> NODE;//存储每个顶点的参数  
    //Node NODE[N];  
    //NODE.resize(n);  
    int x[N];//  
	};  
	void Map::Initial()//初始化邻接矩阵  
{  
    for (int i = 0; i < N; i++)  
    {  
        for (int j = 0; j < N; j++)  
            b[i][j] = 0;//对此二维数组进行初始化  
    }  
    cout << "请输入选手人数" << endl;//例如本次实验例中给的参考数据中选手人数为6  
   int m;  
    cin >> m;  
    int a[Size];//用于存储键盘输入的数  
    cout << "本次参赛选手数为：" << m << endl;  
    cout<< "1.标枪  2.铅球   3.铁饼   4.100米  5.200米   6.跳远   7.跳高" << endl;  
    cout << "请输入每个选手参加的项目" << endl;  
    int i = 1;  
    while (i <= m)  
    {  
		cout << "第" << i << "个选手:";  
		int choice;  
	    cin >> choice;//连续输入，最多三个项目  
		int e, f, g;  
	        e = choice / 100-1;//把三位数剥离出来  
        f = choice / 10-10*(e+1)-1;//同时为了方便邻接矩阵初始化，均减一  
        g = choice % 10-1;  
        a[3*i - 3] = e + 1;//用于记录输入的选手编号，方便之后打印到屏幕上生成的选手项目表  
        a[3 * i - 2] = f + 1;  
        a[3 * i - 1] = g + 1;  
        if ((e != 7) && (f != 7) && (g != 7))//根据输入构造邻接矩阵  
        {  
            if (b[e][f] == 0)  
                b[e][f] = b[f][e] = 1;  
            if (b[e][g] == 0)  
                b[e][g] = b[g][e] = 1;  
            if (b[f][g] == 0)  
                b[f][g] = b[g][f] = 1;  
        }  
        else if ((g == 7) && (e != 7) && (f != 7))  
        {  
            if (b[e][f] == 0)  
                b[e][f] = b[f][e] = 1;  
        }  
        i++;  
    }  
    cout<<"录入信息如下："<<endl;  
    for (int i = 1; i <= m; i++)//向屏幕打印生成的选手项目表  
    {  
        cout << "第" << i << "个选手:";  
        if(a[3*i-3]) Transword(a[3 * i - 3]); cout << " ";//输出对应项目  
        if(a[3*i-2]) {Transword(a[3 * i - 2]); cout << " ";}  
        if(a[3*i-1]) {Transword(a[3 * i - 1]);}  
        cout << endl;  
    }  
}  
void Map::Transword(int i)//将输入的选手相应的项目编号转换为选手项目输出至屏幕  
{  
    switch (i)  
    {  
        case 1:  
			cout << "标枪";  
			break;  
        case 2:  
			cout << "铅球";  
	        break;  
				case 3:  
				cout << "铁饼";  
				break;  
        case 4:  
            cout << "100米";  
            break;  
		case 5:  
            cout << "200米";  
            break;  
        case 6:  
            cout << "跳远";  
            break;  
        case 7:  
            cout << "跳高";  
            break;  
        default:  
            break;  
    }  
}  
	bool cmp(Node a,Node b)  
	{  
	    return a.Links>b.Links;  
	}  
	void Map::SortNode()//顶点根据度自动排序算法，按度从大到小顺序排序  
	{  
	    for (int i = 0; i < N; i++)  
	    {  
	        NODE.resize(N);  
	        NODE[i].ID = i;  
	        NODE[i].Links = 0;//初始化顶点度  
	        for (int j = 0; j < N; j++)  
	        {  
	            NODE[i].Links +=b[i][j];//计算每个顶点的度  
	        }  
	    }  
	    sort(NODE.begin(),NODE.end(),cmp);//使用STL中的sort函数进行降序排列  
	}  
	void Map::Coloring()//染色函数，b是邻接矩阵，N[]是顶点颜色数组  
	{  
	    for (int i = 0; i < N; i++)  
	        x[i] = 0;//顶点颜色数组先初始化  
	    x[NODE[0].ID] = 1;//给度最大的顶点染色，颜色代码为1  
	    for (int k = 1; k < N; k++)  
	    {  
	        x[NODE[k].ID] = 1;  //预设为1，如有不可则后改  
	        for (int i = 0; i < k; i++)  
	        {  
	            if (b[NODE[k].ID][NODE[i].ID] && (x[NODE[k].ID] == x[NODE[i].ID]))  
	                //关键一步，同时进行检测结点是否相邻 && 相邻结点着色是否相同  
	                //注意：这里使用id，对比的是原节点，因为矩阵中存储原id  
	                x[NODE[k].ID]+= 1;//以颜色加1的形式进行区分着色  
	        }  
	    }//时间复杂度(n^2)  
	}  
	void Map::Plan()//针对图的着色结果得出时间段的规划  
	{  
	    cout << "时间段划分结果：" << endl;  
	    int max = x[0];  
	    for (int i = 1; i < N; i++)  
	        if (x[i]>max)  
	            max = x[i];   //得出一共有几个时间段  
	    int a=1;  
	    cout <<"至少需要"<<max<<"个时段"<< endl;  
	    while (a <= max)  
	    {  
	        cout <<"第"<< a << "个时段:";  
	        for (int i = 0; i < N; i++)  
	            if (x[i] == a)  
	                Transword(i + 1);  
	        a++;  
	        cout << endl;  
	    }  
	}  
	int main()  
	{  
	    Map p;  
	    p.Initial();//初始化，从键盘录入信息  
	    p.SortNode();//对各个顶点的度进行排序  
	    p.Coloring();//对不同顶点进行着色  
	    p.Plan();//将最终的时间规划打印至屏幕  
	    system("pause");  
	    return 0;  
}  
