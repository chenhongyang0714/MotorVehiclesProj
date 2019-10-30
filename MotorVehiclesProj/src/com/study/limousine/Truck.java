package com.study.limousine;

import java.util.Random;
import java.util.Scanner;

/** ����
  * @author chy 
  * @date 2019��10��19�� ����10:40:24 
  * @version 1.0  
*/

public class Truck extends MotorVehicles implements ITruck {

	static double loadNum;   // ��ǰ����
	static int flag; // ��¼�Ƿ�������(0:û����)
	
	public void setInfo() {
		System.out.println("�����뿨������Ϣ:(����:��ǰ���ء����͡����ƺš���ʻ�����)");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		loadNum = scanner.nextDouble();
		model = scanner.next();
		licenseNumber = scanner.next();
		mileage = scanner.nextDouble();
	}
	public void showInfo() {
		System.out.println("�ÿ�����Ϣ����:");
		System.out.println("��ǰ����:" + loadNum + "��");
		System.out.println("����:" + model);
		System.out.println("���ƺ�:" + licenseNumber);
		System.out.println("��ʻ�����:" + String.format("%.2f", mileage));
	}
	
	@Override
	public void loading() {
		int addLoad;
		if(loadNum == 1500) {
			System.out.println("�Ѵ�������أ��޷����ӻ���");
		} else {
			System.out.println("����������װ�صĻ�������:(����ػ�����Ϊ1500��):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			addLoad = scanner.nextInt();
			if((loadNum+addLoad)<=1500) {
				loadNum += addLoad;
				System.out.println("�������ӳɹ�!");
			} else {
				do {
					System.out.println("�����ӵĻ�����࣬������ȷ������Ļ�������:");
					addLoad = scanner.nextInt();
				} while((loadNum+addLoad)>1500);	
				loadNum += addLoad;
				System.out.println("�������ӳɹ�!");
			}			
		}		
	}

	@Override
	public void unloading() {
		int substractLoad = 0;
		if(loadNum == 0) {
			System.out.println("������ȫ��ж��");
		} else {
			System.out.println("����������ж�صĻ�������:(��С������Ϊ0):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			substractLoad = scanner.nextInt();
			if((loadNum-substractLoad)>=0) {
				loadNum -= substractLoad;
				System.out.println("����ж�سɹ�!");
			} else {
				do {
					System.out.println("�����Ѳ���ָ�������Ļ��������ȷ��ж������:");
					substractLoad = scanner.nextInt();
				} while((loadNum-substractLoad)<0);	
				loadNum -= substractLoad;
				System.out.println("����ж�سɹ�!");
			}			
		}
	}

	@Override
	public void drive() {
		if(flag == 0) {
			Random random = new Random();
			double runMile = random.nextDouble();
			mileage += runMile;
			System.out.println("�����ѿ���");
			System.out.println("��ʩ���ص�������ʻ");
			System.out.printf("�˴�Լ��ʻ %.2f����\n", runMile);
		} else {
			System.out.println("���ѱ��������޷���ʻ");
		}
	}

	@Override
	public void flameout() {
		System.out.println("��ɲ�����ȳ��ٽ��������𲽽������ڿ�ֹͣʱ�������ֱ��ֹͣ");
		System.out.println("Ϩ��ɹ�");

	}

	@Override
	public void lock() {
		System.out.println("���س��ţ�����ң����");
		System.out.println("�����ɹ�");
		flag = 1;  // ��ʾ������
	}
	
	@Override
	public void unlock() {
		System.out.println("����ң�������򿪳���");
		System.out.println("�����ɹ�");
		flag = 0;  // ��ʾ�ѽ���
	}

}
