package com.study.limousine;

import java.util.Random;
import java.util.Scanner;

/** 货车
  * @author chy 
  * @date 2019年10月19日 上午10:40:24 
  * @version 1.0  
*/

public class Truck extends MotorVehicles implements ITruck {

	static double loadNum;   // 当前载重
	static int flag; // 记录是否上了锁(0:没上锁)
	
	public void setInfo() {
		System.out.println("请输入卡车的信息:(包括:当前载重、车型、车牌号、行驶里程数)");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		loadNum = scanner.nextDouble();
		model = scanner.next();
		licenseNumber = scanner.next();
		mileage = scanner.nextDouble();
	}
	public void showInfo() {
		System.out.println("该卡车信息如下:");
		System.out.println("当前载重:" + loadNum + "吨");
		System.out.println("车型:" + model);
		System.out.println("车牌号:" + licenseNumber);
		System.out.println("行驶里程数:" + String.format("%.2f", mileage));
	}
	
	@Override
	public void loading() {
		int addLoad;
		if(loadNum == 1500) {
			System.out.println("已达最大载重，无法增加货物");
		} else {
			System.out.println("请输入您想装载的货物重量:(最大载货重量为1500吨):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			addLoad = scanner.nextInt();
			if((loadNum+addLoad)<=1500) {
				loadNum += addLoad;
				System.out.println("货物增加成功!");
			} else {
				do {
					System.out.println("您增加的货物过多，请重新确定货物的货物重量:");
					addLoad = scanner.nextInt();
				} while((loadNum+addLoad)>1500);	
				loadNum += addLoad;
				System.out.println("货物增加成功!");
			}			
		}		
	}

	@Override
	public void unloading() {
		int substractLoad = 0;
		if(loadNum == 0) {
			System.out.println("货物已全部卸载");
		} else {
			System.out.println("请输入您想卸载的货物重量:(最小载重量为0):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			substractLoad = scanner.nextInt();
			if((loadNum-substractLoad)>=0) {
				loadNum -= substractLoad;
				System.out.println("货物卸载成功!");
			} else {
				do {
					System.out.println("车上已不足指定重量的货物，请重新确定卸载重量:");
					substractLoad = scanner.nextInt();
				} while((loadNum-substractLoad)<0);	
				loadNum -= substractLoad;
				System.out.println("货物卸载成功!");
			}			
		}
	}

	@Override
	public void drive() {
		if(flag == 0) {
			Random random = new Random();
			double runMile = random.nextDouble();
			mileage += runMile;
			System.out.println("卡车已开出");
			System.out.println("在施工重地蜿蜒行驶");
			System.out.printf("此次约行驶 %.2f公里\n", runMile);
		} else {
			System.out.println("车已被上锁，无法驾驶");
		}
	}

	@Override
	public void flameout() {
		System.out.println("踩刹车，等车速降下来，逐步降档，在快停止时踩下离合直至停止");
		System.out.println("熄火成功");

	}

	@Override
	public void lock() {
		System.out.println("紧关车门，按下遥控锁");
		System.out.println("上锁成功");
		flag = 1;  // 表示已上锁
	}
	
	@Override
	public void unlock() {
		System.out.println("按下遥控锁，打开车门");
		System.out.println("解锁成功");
		flag = 0;  // 表示已解锁
	}

}
