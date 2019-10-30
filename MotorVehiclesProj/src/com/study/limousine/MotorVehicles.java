package com.study.limousine;

/**  机动车类
  * @author chy 
  * @date 2019年10月19日 上午10:29:43 
  * @version 1.0  
*/

public abstract class MotorVehicles {

	public String model;
	public String licenseNumber;
	public double mileage;
	
	public abstract void setInfo();
	public abstract void showInfo();
	public abstract void drive();
	public abstract void flameout();
	public abstract void lock();
	public abstract void unlock();
	
}
