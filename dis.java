package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//private static final long serialVersionUID = 4907149509182425824L;

public class test2 extends JFrame{
    //** 图形化界面设计*/
    public test2(){
        Container calculator = getContentPane(); //定义一个顶级容器c
        setLayout(new GridLayout(3,1));//新建网格布局管理器，3行1列
        JTextField textfield = new JTextField("",40);//构造一个用指定文本和列初始化的新文本框--textfield
        textfield.setHorizontalAlignment(JTextField.RIGHT);//设置水平对齐方式：居右对齐
        JLabel pictureLabel = new JLabel(new ImageIcon("0.jpg"));
        
        JButton data0 = new JButton("0");
        JButton data1 = new JButton("1");
        JButton data2 = new JButton("2");
        JButton data3 = new JButton("3");
        JButton data4 = new JButton("4");
        JButton data5 = new JButton("5");
        JButton data6 = new JButton("6");
        JButton data7 = new JButton("7");
        JButton data8 = new JButton("8");
        JButton data9 = new JButton("9");
        JButton point = new JButton(".");
        JButton equ = new JButton("=");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton mtp = new JButton("×");
        JButton dvd = new JButton("/");
        JButton sqr = new JButton("sqrt");
        JButton root = new JButton("x^2");
        JButton backspace = new JButton("DEL");
        JButton clear = new JButton("AC");
        JPanel jp = new JPanel();   //新建JPanel面板--jp
        jp.setLayout(new GridLayout(4,5,5,5));//新建网格布局管理器（行数，列数，组件间的水平垂直间距）
        jp.add(data7);
        jp.add(data8);
        jp.add(data9);
        jp.add(plus);
        jp.add(sqr);
        jp.add(data4);
        jp.add(data5);
        jp.add(data6);
        jp.add(minus);
        jp.add(root);
        jp.add(data1);
        jp.add(data2);
        jp.add(data3);
        jp.add(mtp);
        jp.add(clear);
        jp.add(data0);
        jp.add(point);
        jp.add(equ);
        jp.add(dvd);
        jp.add(backspace);

        calculator.add(pictureLabel);//将图片pictureLabel添加到顶级容器中
        calculator.add(textfield);//将文本框textfield添加到顶级容器中
        calculator.add(jp);//将JPanel面板jp添加到顶级容器中

        setSize(400,400);
        setTitle("JAVA计算器——谌悦章第三次作业");
        setVisible(true);
        setResizable(false);//窗体大小由程序员决定，用户不能自由改变大小
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*
         * *********************************************************
         *                  
                    相关计算功能的实现                             
         * *********************************************************
         * */

        data0.addActionListener(new ActionListener(){//数字0的输入
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){//将按钮值与0作比较
                    textfield.requestFocus();//把输入焦点放在调用这个方法的控件上(即把光标放在文本框textfield里)
                }
                else{
                    String str = textfield.getText();//取得当前按钮的按钮值
                    textfield.setText(str+"0");   //将文本内容后加上字符0
                }
            }
        });
        data1.addActionListener(new ActionListener(){//数字1的输入
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){//将按钮值与0作比较
                    textfield.setText("");//将文本框初始化为空
                    textfield.setText("1");//将文本框内容置为 1
                    textfield.requestFocus();//把输入焦点放在调用这个方法的控件上(即把光标放在文本框textfield里)
                }
                else{
                    String str = textfield.getText();//取得当前按钮的按钮值
                    textfield.setText(str+"1");   //将文本内容后加上字符1
                }
            }
        });
        data2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("2");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"2");
                }
            }
        });
        data3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("3");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"3");
                }
            }
        });
        data4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("4");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"4");
                }
            }
        });
        data5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("5");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"5");
                }
            }
        });
        data6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("6");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"6");
                }
            }
        });
        data7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("7");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"7");
                }
            }
        });
        data8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("8");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"8");
                }
            }
        });
        data9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("9");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"9");
                }
            }
        });
        point.addActionListener(new ActionListener(){    //点号的输入
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText(".");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+".");
                }
            }
        });
        plus.addActionListener(new ActionListener(){    //+号的输入
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("+");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"+");
                }
            }
        });
        minus.addActionListener(new ActionListener(){    //-号的输入
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("-");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"-");
                }
            }
        });
        mtp.addActionListener(new ActionListener(){    //*号的输入
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("*");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"*");
                }
            }
        });
        dvd.addActionListener(new ActionListener(){    //除号的输入
            public void actionPerformed(ActionEvent arg0){
                if(textfield.getText().equals("0")){
                    textfield.setText("");
                    textfield.setText("/");
                    textfield.requestFocus();
                }
                else{
                    String str = textfield.getText();
                    textfield.setText(str+"/");
                }
            }
        });
        //【**退格功能如下**】
        backspace.addActionListener(new ActionListener(){//监听退格键
            public void actionPerformed(ActionEvent arg0){//处理退格键被按下的事件
                String text = textfield.getText();
                int i = text.length();
                if(i>0){
                    text = text.substring(0,i-1);//去掉最后一个字符
                    if (text.length() == 0) {// 如果文本没有了内容，则初始化计算器的各种值
                        textfield.setText("");
                    } else { // 显示新的文本
                        textfield.setText(text);
                }
            }
            }
        });
        //【**清零功能如下**】
        clear.addActionListener(new ActionListener(){//监听清零键
            public void actionPerformed(ActionEvent e) {
                textfield.setText("");//将文本框置为0（清零功能）
            }

        });
        //【**平方功能如下**】
        root.addActionListener(new ActionListener(){//监听root键
            public void actionPerformed(ActionEvent e){//root键被按事件
                String i = textfield.getText();
                Double j = Double.parseDouble(i);//将字符串i转换成对应的double类型的数值
                double ans = j*j;  //求平方
                String answer =String.valueOf(ans);//将int型数据转换成String类型
                textfield.setText(answer);//将文本框设置为平方后的结果
            }
        });
        //【**开方功能如下**】
        sqr.addActionListener(new ActionListener(){//监听sqrt键
            public void actionPerformed(ActionEvent e){//sqrt键被按事件
                String i = textfield.getText();
                Double j = Double.parseDouble(i);//将字符串转换成对应的double类型的数值
                double ans = (double)Math.sqrt(j);//求开方
                String answer = String.valueOf(ans);//将double型数据转换成String类型
                textfield.setText(answer);//将文本框设置为开方后的结果
            }
        });

        //【等号实现 加减乘除 功能】
        equ.addActionListener(new ActionListener(){ //监听 “等号” 按键
            public void actionPerformed(ActionEvent arg0){//处理“等号” 按键被按下事件
                //【**加法运算**】
                if(textfield.getText().indexOf("+")!= -1){
                    //将字符串分割为子字符串，然后将结果作为字符串数组返回
                    String[] s = textfield.getText().split("[+]");//转义字符，要用"[+]"或者"\+"
                    Double d1 = Double.parseDouble(s[0]);//返回一个指定字符串表示的double值
                    Double d2 = Double.parseDouble(s[1]);
                    double ans = d1 + d2;
                    String answer = String.valueOf(ans);//将结果转换为字符串
                    textfield.setText(answer);//将加法运算的结果以字符串形式在文本框中显示
                }
                //【**减法运算**】
                else if(textfield.getText().indexOf("-")!= -1){
                    String[] s = textfield.getText().split("-");
                    textfield.setText("");
                    Double d1 = Double.parseDouble(s[0]);
                    Double d2 = Double.parseDouble(s[1]);
                    double ans = d1-d2;
                    String answer =String.valueOf(ans);
                    textfield.setText(answer);
                }
                //【**乘法运算**】
                else if(textfield.getText().indexOf("*")!= -1){
                    String[] s = textfield.getText().split("[*]");//*是转义字符，要用"[*]",或者"\*"
                    textfield.setText("");
                    Double d1 = Double.parseDouble(s[0]);
                    Double d2 = Double.parseDouble(s[1]);
                    double ans = d1*d2;
                    String answer =String.valueOf(ans);
                    textfield.setText(answer);
                }
                //【**除法运算**】
                else if(textfield.getText().indexOf("/")!= -1){
                    String[] s = textfield.getText().split("/");
                    textfield.setText("");
                    Double d1 = Double.parseDouble(s[0]);
                    Double d2 = Double.parseDouble(s[1]);
                    try {
                    double ans = d1/d2;
                    String answer =String.valueOf(ans);
                    textfield.setText(answer);
                    }catch(ArithmeticException e) {
                    	System.out.println("catch"+e);
                    }
                }
                else{
                    textfield.setText("请选择要进行的运算");
                }
            }
        });
    }
    public static void main(String[] args) {
        new test2();
    }
}

