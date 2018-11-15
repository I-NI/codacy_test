/*车辆内轮差预警装置主机
 * 获取车轮转角数据，并传给从机，如果转弯，雷达转动，判断障碍物位置，计算内轮差危险区域范围，如果危险区域内有行人，则蜂鸣器报警。
 * ini
 * 最后一次更改于2018/6/3
 */

#include<Servo.h>

#define PIN_SERVO 10
Servo myservo;

int mAngleNum=20;//当前角度
double hudu;
char mFront=0;//正转反转

const int TrigPin = 2;//超声波引脚 
const int EchoPin = 3;
int relay_pin=5;//定义继电器针脚为A4
int buzzerPin=7;//蜂鸣器针脚为7

float distance,x,y;
double innerdistence=0,inner_human=-1,humandistence=100,val=0,degree=0;//定义内轮差及与行人距离。 
double wheel_length=45;//定义轴距cm
double car_length=50;//定义车长cm
int i=0;

double ultrasonic(void)//超声波测距
          {
            // 产生一个10us的高脉冲去触发TrigPin 
        digitalWrite(TrigPin, LOW); 
        delayMicroseconds(2); 
        digitalWrite(TrigPin, HIGH); 
        delayMicroseconds(10);
        digitalWrite(TrigPin, LOW); 
    // 检测脉冲宽度，并计算出距离
        distance = pulseIn(EchoPin, HIGH) / 58.00;//!!!
        //Serial.println(distance); //cm
        //delay(10); 
        return(distance);
          }
          
 //定义电位器测定转角函数
double potentionmeter(double Length)
{
    int potentionmeter_pin=A0;//定义电位器针脚为A0
    double degree,innerdistence;//定义电位器传回值，角度，内轮差
    val = analogRead(potentionmeter_pin);//接收电位器传回值（0到1024）
   // Serial.println(val);
    degree=val*PI/1024;//转角为0到1.5pi，转换得角度
    if(i>10){
    Serial.println(degree+0.1);
    i=0;
    }
    i++;
    //delay(10);
    innerdistence=Length*tan(0.5*degree);//根据数学模型得到内轮差
    //Serial.println(innerdistence);
    return(innerdistence);//返回内轮差
  }
  //定义声音预警函数
    void buzzer(double innerdistence,double humandistence)
    {
       if(innerdistence>humandistence)//单位转换
        tone(buzzerPin,400);
      else
        noTone(buzzerPin);
      }
      
void setup()
{
    Serial.begin(38400);
    myservo.attach(PIN_SERVO);
    pinMode(TrigPin, OUTPUT); 
    pinMode(EchoPin, INPUT);
    pinMode(buzzerPin,OUTPUT); 
    pinMode(relay_pin,OUTPUT);
  } 

void loop()
{
  innerdistence=potentionmeter(wheel_length);//电位器测定车轮转角,计算内轮差
  if(innerdistence>1)//内轮差到一个阈值
  {
    if(innerdistence<humandistence)//如果危险区域内无行人
    {
      myservo.write(180-mAngleNum);//舵机继续转
      if(mFront==0)
      {
        mAngleNum++;
        if(mAngleNum>160)
          mFront=1;
        }
        else
        {
          mAngleNum--;
          if(mAngleNum<20)
          mFront=0;
          }
    }
        humandistence=ultrasonic();//超声波测距
        hudu=mAngleNum*3.14/180;//根据转角判断行人相对于车的具体位置
        y=distance*cos(hudu);//cm
        x=distance*sin(hudu);//cm 
        buzzer(innerdistence,humandistence);//报警
  }
}

