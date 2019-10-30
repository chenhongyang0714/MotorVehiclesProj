package com.study.limousine;

import java.util.Random;
import java.util.Scanner;

/**  �ͳ���
  * @author chy 
  * @date 2019��10��19�� ����10:41:29 
  * @version 1.0  
*/

public class PassengersCar extends MotorVehicles implements IPassengersCar {

	static int passengersNum;  // ��¼��ǰ�ؿ���
	static int flag; // ��¼�Ƿ�������(0:û����)
	public void setInfo() {
		System.out.println("������ͳ�����Ϣ:(����:��ǰ�ؿ��������͡����ƺš���ʻ�����)");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		passengersNum = scanner.nextInt();
		model = scanner.next();
		licenseNumber = scanner.next();
		mileage = scanner.nextDouble();
		
	}
	public void showInfo() {
		System.out.println("�ÿͳ���Ϣ����:");
		System.out.println("��ǰ�ؿ���:" + passengersNum);
		System.out.println("����:" + model);
		System.out.println("���ƺ�:" + licenseNumber);
		System.out.println("��ʻ�����:" + String.format("%.2f", mileage));
	}
	
	@Override
	public void getOn() {
		int addPassengers;
		if(passengersNum == 36) {
			System.out.println("��λ�������޷����ظ���˿�!");
		} else {
			System.out.println("�������ϳ��ĳ˿���:(���˿�����Ϊ36):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			addPassengers = scanner.nextInt();
			if((passengersNum+addPassengers)<=36) {
				passengersNum += addPassengers;
				System.out.println("�˿����ϳ�!");
			} else {
				do {
					System.out.println("�ϳ��ĳ˿������࣬������ȷ���ϳ��ĳ˿���:");
					addPassengers = scanner.nextInt();
				} while((passengersNum+addPassengers)>36);	
				passengersNum += addPassengers;
				System.out.println("�˿����ϳ�!");
			}			
		}		
		
	}

	@Override
	public void getOut() {
		int substractPassengers = 0;
		if(passengersNum == 0) {
			System.out.println("�˿���ȫ���³�!");
		} else {
			System.out.println("�������³��ĳ˿���:(��С�˿���Ϊ0):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			substractPassengers = scanner.nextInt();
			if((passengersNum-substractPassengers)>=0) {
				passengersNum -= substractPassengers;
				System.out.println("�˿����³�!");
			} else {
				do {
					System.out.println("���ϵĳ˿�������ô ���ˣ�������ȷ���³��ĳ˿���:");
					substractPassengers = scanner.nextInt();
				} while((passengersNum-substractPassengers)<6);	
				passengersNum -= substractPassengers;
				System.out.println("�˿����³�!");
			}			
		}
	}
	
	@Override
	public void drive() {
		if(flag == 0) {
			Random random = new Random();
			double runMile = random.nextDouble() * 100;
			mileage += 50 * runMile;
			System.out.println("�ͳ��ѿ���");
			System.out.println("�ڱ�ֱ�Ĺ�·�Ͽ�����ʻ");
			System.out.printf("�˴�Լ��ʻ %.2f����\n", runMile*50);
		} else {
			System.out.println("���ѱ��������޷���ʻ");
		}
	}

	@Override
	public void flameout() {
		System.out.println("����Ϻ�ɲ���ȳ�ͣ��,��𣬹ҵ�һ������ɲ��");
		System.out.println("Ϩ��ɹ�");
	}

	@Override
	public void lock() {
		System.out.println("����������");
		System.out.println("�����ɹ�");
		flag = 1;  // ��ʾ������
	}
	
	@Override
	public void unlock() {
		System.out.println("����������");
		System.out.println("�����ɹ�");
		flag = 0;  // ��ʾ�ѽ���
	}

}
