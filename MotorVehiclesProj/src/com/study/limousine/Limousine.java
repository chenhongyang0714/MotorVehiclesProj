package com.study.limousine;

import java.util.Random;
import java.util.Scanner;

/**  �γ���
  * @author chy 
  * @date 2019��10��19�� ����10:38:35 
  * @version 1.0  
*/

public class Limousine extends MotorVehicles implements ILimousine {

	static int seatNum;  // ��¼��ǰ����
	static int flag; // ��¼�Ƿ�������(0:û����)
	
	public void setInfo() {
		System.out.println("������γ�����Ϣ:(����:��ǰ���������͡����ƺš���ʻ�����)");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		seatNum = scanner.nextInt();
		model = scanner.next();
		licenseNumber = scanner.next();
		mileage = scanner.nextDouble();
	}
	
	public void showInfo() {
		System.out.println("�ýγ���Ϣ����:");
		System.out.println("��ǰ����:" + seatNum);
		System.out.println("����:" + model);
		System.out.println("���ƺ�:" + licenseNumber);
		System.out.println("��ʻ�����:" + String.format("%.2f", mileage));
	}
	
	@Override
	public void addSeat() {
		int addSeat;
		if(seatNum == 6) {
			System.out.println("��λ���������޷������λ!");
		} else {
			System.out.println("������������ӵĽγ���λ��:(�����λ����Ϊ6):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			addSeat = scanner.nextInt();
			if((seatNum+addSeat)<=6) {
				seatNum += addSeat;
				System.out.println("��λ��ӳɹ�!");
			} else {
				do {
					System.out.println("����ӵ���λ�����࣬������ȷ����ӵ���λ��:");
					addSeat = scanner.nextInt();
				} while((seatNum+addSeat)>6);	
				seatNum += addSeat;
				System.out.println("��λ��ӳɹ�!");
			}			
		}
	}

	@Override
	public void substractSeat() {
		int substractSeat = 0;
		if(seatNum == 0) {
			System.out.println("��λ�ѿգ��޷�������λ!");
		} else {
			System.out.println("������������ٵĽγ���λ��:(��С��λ����Ϊ0):");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			substractSeat = scanner.nextInt();
			if((seatNum-substractSeat)>=0) {
				seatNum -= substractSeat;
				System.out.println("��λ���ٳɹ�!");
			} else {
				do {
					System.out.println("�����ٵ���λ�����࣬������ȷ�����ٵ���λ��:");
					substractSeat = scanner.nextInt();
				} while((seatNum-substractSeat)<6);	
				seatNum -= substractSeat;
				System.out.println("��λ���ٳɹ�!");
			}			
		}
	}

	@Override
	public void drive() {
		if(flag == 0) {
			Random random = new Random();  // ������������
			double runMile = random.nextDouble() * 100;
			mileage += runMile;
			System.out.println("�γ��ѿ���");
			System.out.println("�����ѵ�С·��������ʻ");
			System.out.printf("�˴�Լ��ʻ %.2f����\n", runMile);
		} else {
			System.out.println("���ѱ��������޷���ʻ");
		}
	}
      
	@Override
	public void flameout() {
		System.out.println("����ת�������ţ�������ɲ��");
		System.out.println("Ϩ��ɹ�!");
	}

	@Override
	public void lock() {
		System.out.println("����ң�����ϵ�����ť");
		System.out.println("�����ɹ�");
		flag = 1;  // ��ʾ������
	}
	
	@Override
	public void unlock() {
		System.out.println("����ң�����ϵ�����ť");
		System.out.println("�����ɹ�");
		flag = 0;  // ��ʾ�ѽ���
	}
	

}
