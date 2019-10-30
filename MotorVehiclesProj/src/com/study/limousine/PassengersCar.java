package com.study.limousine;

import java.util.Random;
import java.util.Scanner;

/**  客车类
  * @author chy 
  * @date 2019年10月19日 上午10:41:29 
  * @version 1.0  
*/

public class PassengersCar extends MotorVehicles implements IPassengersCar {

	static int passengersNum;  // 记录当前载客数
	static int flag; // 记录是否上了锁(0:没上锁)
	public void setInfo() {
		System.out.println("请输入客车的信息:(包括:当前载客数、车型、车牌号、行驶里程数)");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		passengersNum = scanner.nextInt();
		model = scanner.next();
		licenseNumber = scanner.next();
		mileage = scanner.nextDouble();
		
	}
	public void showInfo() {
		System.out.println("该客车信息如下:");
		System.out.println("当前载客数:" + passengersNum);
		System.out.println("车型:" + model);
		System.out.println("车牌号:" + licenseNumber);
		System.out.println("行驶里程数:" + String.format("%.2f", mileage));
	}
	
	@Override
	public void getOn() {
		int addPassengers;
		if(passengersNum == 36) {
			System.out.println("座位已满，无法承载更多乘客!");
		} else {
			System.out.println("请输入上车的乘客数:(最大乘客容量为36):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			addPassengers = scanner.nextInt();
			if((passengersNum+addPassengers)<=36) {
				passengersNum += addPassengers;
				System.out.println("乘客已上车!");
			} else {
				do {
					System.out.println("上车的乘客数过多，请重新确定上车的乘客数:");
					addPassengers = scanner.nextInt();
				} while((passengersNum+addPassengers)>36);	
				passengersNum += addPassengers;
				System.out.println("乘客已上车!");
			}			
		}		
		
	}

	@Override
	public void getOut() {
		int substractPassengers = 0;
		if(passengersNum == 0) {
			System.out.println("乘客已全部下车!");
		} else {
			System.out.println("请输入下车的乘客数:(最小乘客数为0):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			substractPassengers = scanner.nextInt();
			if((passengersNum-substractPassengers)>=0) {
				passengersNum -= substractPassengers;
				System.out.println("乘客已下车!");
			} else {
				do {
					System.out.println("车上的乘客已无这么 多人，请重新确定下车的乘客数:");
					substractPassengers = scanner.nextInt();
				} while((passengersNum-substractPassengers)<6);	
				passengersNum -= substractPassengers;
				System.out.println("乘客已下车!");
			}			
		}
	}
	
	@Override
	public void drive() {
		if(flag == 0) {
			Random random = new Random();
			double runMile = random.nextDouble() * 100;
			mileage += 50 * runMile;
			System.out.println("客车已开出");
			System.out.println("在笔直的公路上快速行驶");
			System.out.printf("此次约行驶 %.2f公里\n", runMile*50);
		} else {
			System.out.println("车已被上锁，无法驾驶");
		}
	}

	@Override
	public void flameout() {
		System.out.println("踩离合和刹车等车停后,灭火，挂到一档，松刹车");
		System.out.println("熄火成功");
	}

	@Override
	public void lock() {
		System.out.println("将手札拉上");
		System.out.println("上锁成功");
		flag = 1;  // 表示已上锁
	}
	
	@Override
	public void unlock() {
		System.out.println("将手札按下");
		System.out.println("解锁成功");
		flag = 0;  // 表示已解锁
	}

}
