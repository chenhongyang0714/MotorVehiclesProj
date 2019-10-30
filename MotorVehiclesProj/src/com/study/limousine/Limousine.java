package com.study.limousine;

import java.util.Random;
import java.util.Scanner;

/**  轿车类
  * @author chy 
  * @date 2019年10月19日 上午10:38:35 
  * @version 1.0  
*/

public class Limousine extends MotorVehicles implements ILimousine {

	static int seatNum;  // 记录当前座数
	static int flag; // 记录是否上了锁(0:没上锁)
	
	public void setInfo() {
		System.out.println("请输入轿车的信息:(包括:当前座数、车型、车牌号、行驶里程数)");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		seatNum = scanner.nextInt();
		model = scanner.next();
		licenseNumber = scanner.next();
		mileage = scanner.nextDouble();
	}
	
	public void showInfo() {
		System.out.println("该轿车信息如下:");
		System.out.println("当前座数:" + seatNum);
		System.out.println("车型:" + model);
		System.out.println("车牌号:" + licenseNumber);
		System.out.println("行驶里程数:" + String.format("%.2f", mileage));
	}
	
	@Override
	public void addSeat() {
		int addSeat;
		if(seatNum == 6) {
			System.out.println("座位数已满，无法添加座位!");
		} else {
			System.out.println("请输入您想添加的轿车座位数:(最大座位容量为6):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			addSeat = scanner.nextInt();
			if((seatNum+addSeat)<=6) {
				seatNum += addSeat;
				System.out.println("座位添加成功!");
			} else {
				do {
					System.out.println("您添加的座位数过多，请重新确定添加的座位数:");
					addSeat = scanner.nextInt();
				} while((seatNum+addSeat)>6);	
				seatNum += addSeat;
				System.out.println("座位添加成功!");
			}			
		}
	}

	@Override
	public void substractSeat() {
		int substractSeat = 0;
		if(seatNum == 0) {
			System.out.println("座位已空，无法减少座位!");
		} else {
			System.out.println("请输入您想减少的轿车座位数:(最小座位容量为0):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			substractSeat = scanner.nextInt();
			if((seatNum-substractSeat)>=0) {
				seatNum -= substractSeat;
				System.out.println("座位减少成功!");
			} else {
				do {
					System.out.println("您减少的座位数过多，请重新确定减少的座位数:");
					substractSeat = scanner.nextInt();
				} while((seatNum-substractSeat)<6);	
				seatNum -= substractSeat;
				System.out.println("座位减少成功!");
			}			
		}
	}

	@Override
	public void drive() {
		if(flag == 0) {
			Random random = new Random();  // 随机生成里程数
			double runMile = random.nextDouble() * 100;
			mileage += runMile;
			System.out.println("轿车已开出");
			System.out.println("在蜿蜒的小路上慢慢行驶");
			System.out.printf("此次约行驶 %.2f公里\n", runMile);
		} else {
			System.out.println("车已被上锁，无法驾驶");
		}
	}
      
	@Override
	public void flameout() {
		System.out.println("打右转向，收油门，慢慢踩刹车");
		System.out.println("熄火成功!");
	}

	@Override
	public void lock() {
		System.out.println("按下遥控器上的锁按钮");
		System.out.println("上锁成功");
		flag = 1;  // 表示已上锁
	}
	
	@Override
	public void unlock() {
		System.out.println("按下遥控器上的锁按钮");
		System.out.println("解锁成功");
		flag = 0;  // 表示已解锁
	}
	

}
