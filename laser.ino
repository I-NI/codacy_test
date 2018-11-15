/*车辆内轮差预警装置从机
 * 接收主机传来的转角数据，如果转弯，光线预警启动，根据内轮差，由舵机控制遮蔽物控制投影范围。
 * ini
 * 最后一次更改于2018/6/1
 */

float comfloat;
double innerdistence=0,humandistence=0;//定义内轮差及与行人距离。 
double car_length=0.5;//定义车长
double pos=0;//定义舵机转角，单位度
      int relay_pin=5;//定义继电器针脚为A4
int servopin=10;//定义数字接口9 连接伺服舵机信号线

int myangle;//定义角度变量
int pulsewidth;//定义脉宽变量
int val;

void servopulse(int servopin,int myangle)//定义一个脉冲函数
{
  pulsewidth=(myangle*11)+500;//将角度转化为500-2480 的脉宽值
  digitalWrite(servopin,HIGH);//将舵机接口电平至高
  delayMicroseconds(pulsewidth);//延时脉宽值的微秒数
  digitalWrite(servopin,LOW);//将舵机接口电平至低
  delay(20-pulsewidth/1000);
}
//定义电位器测定转角函数
double potentionmeter()
{
    innerdistence=car_length*tan(0.5*comfloat);//根据数学模型得到内轮差
    return(innerdistence);//返回内轮差
  }

//定义光线预警函数
 void projection(double innerdistence)
{
   digitalWrite(relay_pin,LOW);//继电器断开
   if (innerdistence>0.01  )//如果转弯
   {
     digitalWrite(relay_pin,HIGH);//继电器接上
     pos=atan(1.5*innerdistence/car_length);//根据数学模型算出舵机转角
     pos=pos/PI*180;
    }
  else
  {
    pos=0;
  }
  for(int i=0;i<=5;i++) //给予舵机足够的时间让它转到指定角度
  {
    servopulse(servopin,pos+10);//引用脉冲函数
  }
}
void setup() {
  // put your setup code here, to run once:
  Serial.begin(38400);//设置波特率
  while(Serial.read()>= 0){}
  pinMode(relay_pin,OUTPUT);
  pinMode(servopin,OUTPUT);//设定舵机接口为输出接口
}

void loop() {
  // put your main code here, to run repeatedly:
  float coming;
  delay(100);
  if(Serial.available()>0){
      coming = Serial.parseFloat();//接收主机传来的角度数据
      if(coming<1.1 && coming>0.09)
      {
         comfloat=coming-0.1;
         //Serial.print("Serial.parseFloat:");
         Serial.println(comfloat);
         innerdistence=potentionmeter();//电位器测定车轮转角,计算内轮差
      }
      projection(innerdistence); 
    }
  while(Serial.read() >= 0){}
  }



