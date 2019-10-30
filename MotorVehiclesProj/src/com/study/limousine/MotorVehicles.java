package com.study.limousine;

/**  ��������
  * @author chy 
  * @date 2019��10��19�� ����10:29:43 
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
