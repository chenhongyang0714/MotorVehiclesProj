package com.study.limousine;

import java.util.Scanner;


/** 菜单
  * @author chy 
  * @date 2019年10月19日 上午10:56:09 
  * @version 1.0  
*/

public class ManagementSystem {

	MotorVehicles motorVehicles;
	
	public void Execute() {
		
		int selectOut = -1;
		while(selectOut != 0) {
			System.out.println("---------Management System---------");
			System.out.println("Option:");
			System.out.println("    	1. Manage Limousine System");
			System.out.println("	2. Manage Truck System");
			System.out.println("	3. Manage PassengersCar System");
			System.out.println("	0. Exit System");
			System.out.println("-----------------------------------");
			
			do {
				System.out.println("Please make your choice!");
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				selectOut = scanner.nextInt();
			}while(selectOut < 0 || selectOut > 3);
			
			switch(selectOut) {
			case 1:
				motorVehicles = new Limousine();  // 对象的上转型对象
				Limousine limousine = new Limousine(); // Limousine 对象 
				int selectInOne = -1;
				while(selectInOne != 0) {
					System.out.println("Limousine Option:");
					System.out.println("	1. Set Limousine Infomation");
					System.out.println("    	2. Show Limousine Infomation");
					System.out.println("	3. Drive");
					System.out.println("	4. Flameout");
					System.out.println("	5. Lock");
					System.out.println("    	6. Unlock");
					System.out.println("	7. AddSeat");
					System.out.println("	8. SubstractSeat");
					System.out.println("    	0. Break Limousine System");
					
					do {
						@SuppressWarnings("resource")
						Scanner scanner = new Scanner(System.in);
						selectInOne = scanner.nextInt();
					} while(selectInOne < 0 || selectInOne > 8);
					
					switch(selectInOne) {
					case 1: motorVehicles.setInfo(); break;
					case 2: motorVehicles.showInfo(); break;
					case 3: motorVehicles.drive(); break;
					case 4: motorVehicles.flameout(); break;
					case 5: motorVehicles.lock(); break;
					case 6: motorVehicles.unlock(); break;
					case 7: limousine.addSeat(); break;
					case 8: limousine.substractSeat(); break;
					case 0: System.out.println("Thank you for using limousine system"); break;
					}
				}
				break;
			case 2:
				motorVehicles = new Truck();
				Truck truck = new Truck();
				int selectInTwo = -1;
				while(selectInTwo != 0) {
					System.out.println("Truck Option:");
					System.out.println("	1. Set Truck Infomation");
					System.out.println("    	2. Show Truck Infomation");
					System.out.println("	3. Drive");
					System.out.println("	4. Flameout");
					System.out.println("	5. Lock");
					System.out.println("    	6. Unlock");
					System.out.println("	7. Loading");
					System.out.println("	8. Unloading");
					System.out.println("    	0. Break Truck System");
					
					do {
						@SuppressWarnings("resource")
						Scanner scanner = new Scanner(System.in);
						selectInTwo = scanner.nextInt();
					} while(selectInTwo < 0 || selectInTwo > 8);
					
					switch(selectInTwo) {
					case 1: motorVehicles.setInfo(); break;
					case 2: motorVehicles.showInfo(); break;
					case 3: motorVehicles.drive(); break;
					case 4: motorVehicles.flameout(); break;
					case 5: motorVehicles.lock(); break;
					case 6: motorVehicles.unlock(); break;
					case 7: truck.loading(); break;
					case 8: truck.unloading(); break;
					case 0: System.out.println("Thank you for using truck system"); break;
					}
					
				}
				break;
			case 3: 
				motorVehicles = new PassengersCar();  // 多态
				PassengersCar passengersCar = new PassengersCar();
				int selectInThree = -1;
				while(selectInThree != 0) {
					System.out.println("PassengersCar Option:");
					System.out.println("	1. Set PassengersCar Infomation");
					System.out.println("    	2. Show PassengersCar Infomation");
					System.out.println("	3. Drive");
					System.out.println("	4. Flameout");
					System.out.println("	5. Lock");
					System.out.println("    	6. Unlock");
					System.out.println("	7. GetOn");
					System.out.println("	8. GetOut");
					System.out.println("    	0. Break PassengersCar System");
					
					do {
						@SuppressWarnings("resource")
						Scanner scanner = new Scanner(System.in);
						selectInThree = scanner.nextInt();
					} while(selectInThree < 0 || selectInThree > 8);
					
					switch(selectInThree) {
					case 1: motorVehicles.setInfo(); break;
					case 2: motorVehicles.showInfo(); break;
					case 3: motorVehicles.drive(); break;
					case 4: motorVehicles.flameout(); break;
					case 5: motorVehicles.lock(); break;
					case 6: motorVehicles.unlock();  break;
					case 7: passengersCar.getOn(); break;
					case 8: passengersCar.getOut(); break;
					case 0: System.out.println("Thank you for using passengersCar system"); break;
					}
				}
				break;
			case 0:
				System.out.println("Thank you for using me");
				System.out.println("BYE");
				System.exit(0);
			}
			
		}
	}
}
