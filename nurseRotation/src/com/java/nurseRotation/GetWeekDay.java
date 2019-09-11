package com.java.nurseRotation;

import java.util.*;



public class GetWeekDay {
    public GetWeekDay() {
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in); // ��ĳ�� ��ü ����
    	int year = 0;
    	int month = 0;
    	int day = 1;
    	int headNurse = 0; // ����ȣ��
    	int normalNurse = 0; // �Ϲݰ�ȣ��
    	int aidNurse = 0; // ��ȣ������
    	
    	// ��¥ ����
    	try {
			System.out.print("���� (ex. 2019): "); // ���翬�� �Է�
			year = scanner.nextInt();
			if (year < 1900 || year > 2100) {
					System.out.println("1900 ~ 2100 ���̷� �Է����ּ���.");
					System.exit(0);			
			}
			
	        System.out.print("�� : "); // ����� �Է�
	        month = scanner.nextInt();
	        
	        if (month < 1 || month > 12) {
	        	System.out.println("1 ~ 12 ���̷� �Է����ּ���.");
	        	System.exit(0);			
	        }

	        
	        // ��ȣ�� ������ �ο� �Է�
	        System.out.print("����ȣ�� �ο� : ");
	        headNurse = scanner.nextInt();
	        
	        if (headNurse < 1) {
	        	System.out.println("����ȣ��� 1�� �̻����� �Է����ּ���.");
	        	System.exit(0);
	        }
	        
	        System.out.print("�Ϲݰ�ȣ�� �ο� : ");
	        normalNurse = scanner.nextInt();
	        
	        if (normalNurse < 6) {
	        	System.out.println("����ȣ��� 6�� �̻����� �Է����ּ���.");
	        	System.exit(0);
	        }
	        
	        System.out.print("��ȣ������ �ο� : ");
	        aidNurse = scanner.nextInt();
	        
	        if (aidNurse < 6) {
	        	System.out.println("��ȣ������� 6�� �̻����� �Է����ּ���.");
	        	System.exit(0);
	        }
        
    	} catch (Exception e) {
        	System.out.println("�ùٸ� ���� �Է����ּ���.");
        	System.exit(0);	
		} 
    	
    	System.out.println("\n");
    	
        
    	// ��ȣ�� ����
        int[] sunum = {headNurse, normalNurse, aidNurse};
        String[] su = {"����ȣ��", "�Ϲݰ�ȣ��", "��ȣ������"}; 

        // �Է¹��� �Ⱓ���� ��¥ ��ü ����
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DATE, day);
       
        int endDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // �Է��� ���� �������� ���ϱ�
        
        System.out.print(cal.get(Calendar.YEAR) + "�� "); // �Է��� ���� ���
        System.out.print(cal.get(Calendar.MONTH)+1); // �Է��� �� ���
        System.out.println("��");
        
        System.out.print("\t\t");
        
        // ��¥ ���
        for (int i=1; i<=endDay; i++) {
        	System.out.print(i);
        	System.out.print("\t");
        }
        
        System.out.println("");
        System.out.print("\t");
               
        
        // ���� ���
        int w = 0;
        int weekday = 0;
        for (int i=0;i<endDay;i++) {
        	if (weekday == 7) { // �Ͽ����� �Ǹ�
        		w = w - 7; // �����Ϻ��� �ٽ� ���
        	}
        	System.out.print("\t");
    		weekday = cal.get(Calendar.DAY_OF_WEEK) + w;
    	      switch (weekday) {
    	      case Calendar.SUNDAY:
    	          System.out.print("��");
    	          break;
    	      case Calendar.MONDAY:
    	          System.out.print("��");
    	          break;
    	      case Calendar.TUESDAY:
    	          System.out.print("ȭ");
    	          break;
    	      case Calendar.WEDNESDAY:
    	          System.out.print("��");
    	          break;
    	      case Calendar.THURSDAY:
    	          System.out.print("��");
    	          break;
    	      case Calendar.FRIDAY:
    	          System.out.print("��");
    	          break;
    	      case Calendar.SATURDAY:
    	          System.out.print("��");
    	          break;
    	  }
    		w++;
        }
        System.out.println("\n");
        
        Random random = new Random(); // ���� ��ü ����
        Calendar birthday = Calendar.getInstance(); // ���� ��ü ����
        Calendar calToday = Calendar.getInstance(); // �ٹ��� ��¥ ��ü ����
        

        // ����ȣ��
        w = 0;
        for (int i=0;i<headNurse;i++ ) {
        	System.out.print(su[0] + "\t" + (i + 1) + "\t"); // ��ȣ���ȣ
        	
        	for (int y=0;y<endDay;y++) {
        		if (weekday == 7) { // �Ͽ����� �Ǹ�
            		w = w - 7; // �����Ϻ��� �ٽ� ���
            	}
        		
            	// ������ �������� ����	
            	int birthMonth = random.nextInt(12) + 1; // ���� �� ������ �Ҵ�    	
            	int birthDay = random.nextInt(endDay) + 1; // ���� �� ������ �Ҵ�    	
                birthday.set(Calendar.MONTH, birthMonth-1); // ���� �� ������ ���� ��ü�� �Ҵ�
                birthday.set(Calendar.DATE, birthDay); // ���� �� ������ ���� ��ü�� �Ҵ�                
                calToday.set(Calendar.DATE, y); // �ش� �ٹ��� ��¥ ��ü ����
               
                weekday = cal.get(Calendar.DAY_OF_WEEK) + w; // ���� ���ϱ�
                
        		if (weekday == 1 || weekday ==7 || calToday.equals(birthday)) { // �ָ��̰ų� �����̸�
        			System.out.print(" \t"); // �޹���
        		} else { // ��Ҷ��
        			System.out.print("D\t"); // ��� 
        		}
        		w++;
        	}
        	System.out.println();
        }
        System.out.println();
        
        
        
        
        // �Ϲݰ�ȣ��
        for (int i=0;i<normalNurse;i++ ) {
        	w = 0;
        	System.out.print(su[1] + "\t" + (i + 1) + "\t"); // ��ȣ���ȣ
        	int table = 0; // �ٹ���
        	
        	// �ٹ��� ������
        	if (i % 3 == 0) {
        		table = 0;
        	} else if ( i % 3 == 1) {
        		table = 1;
        	} else {
        		table = 2;
        	}

        	int weekend = 0; // �ָ� �ٹ���
        	for (int y=0;y<endDay;y++) {
        		if (weekday == 7) { // �Ͽ����� �Ǹ�
            		w = w - 7; // �����Ϻ��� �ٽ� ���
            	}
        		
        		// ������ �������� ����	
            	int birthMonth = random.nextInt(12) + 1; // ���� �� ������ �Ҵ�    	
            	int birthDay = random.nextInt(endDay) + 1; // ���� �� ������ �Ҵ�    	
                birthday.set(Calendar.MONTH, birthMonth-1); // ���� �� ������ ���� ��ü�� �Ҵ�
                birthday.set(Calendar.DATE, birthDay); // ���� �� ������ ���� ��ü�� �Ҵ�                
                calToday.set(Calendar.MONTH, month-1); // �ش� �ٹ��� ��¥ ��ü ����
                calToday.set(Calendar.DATE, y); // �ش� �ٹ��� ��¥ ��ü ����
                
        		weekday = cal.get(Calendar.DAY_OF_WEEK) + w; // ���� ���ϱ�
        		
        		// �����Ͽ� �ٹ��ð� ����
        		if (weekday == 2) {
        			if (table == 0) { 
        				table = 2;
        			} else if (table == 1 ) {
        				table = 0;
        			} else {
        				table = 1;
        			}
        		}
        		
        		// �ָ� �����
        		if (weekday == 7 || weekday == 1) { // �ָ��̸�
        			if ((i % 2) == weekend) { // �̹� �ָ� �ٹ��� �Ҵ�
        				switch (table) {
    	        		case 0:
    	        			System.out.print("D\t");   	
    	        			break;
    	        		case 1:
    	        			System.out.print("E\t");
    	        			break;
    	        		case 2:
    	        			System.out.print("N\t");
    	        			break;
    	        		}
        			} else { // �̹� �ָ� �ٹ����� �ƴϸ� �޹�
        				System.out.print(" \t");
        			}
        			if (weekday == 1) { // �Ͽ����̸� ���� �ָ� �ٹ��� �ٲ���
        				switch (weekend) {
        				case 0:
        					weekend = 1;
        					break;
        				case 1:
        					weekend = 0;
        					break;
        				}
        			}
        		} else if (calToday.equals(birthday)) { // �����̸� �޹�
        			System.out.print(" \t");
        		} else { // �ְ� �ٹ���
	        		switch (table) {
	        		case 0:
	        			System.out.print("D\t");   	
	        			break;
	        		case 1:
	        			System.out.print("E\t");
	        			break;
	        		case 2:
	        			System.out.print("N\t");
	        			break;
	        		}
        		}
        		w++;
        	}
        	System.out.println();
        }
        System.out.println();
        
        
        
        
        // ��ȣ������
        for (int i=0;i<aidNurse;i++ ) {
        	w = 0;
        	System.out.print(su[2] + "\t" + (i + 1) + "\t"); // ��ȣ���ȣ
        	int table = 0; // �ٹ���
        	
        	// �ٹ��� ������
        	if (i % 3 == 0) {
        		table = 0;
        	} else if ( i % 3 == 1) {
        		table = 1;
        	} else {
        		table = 2;
        	}
        	
        	int weekend = 0; // �ָ� �ٹ���
        	for (int y=0;y<endDay;y++) {
        		if (weekday == 7) { // �Ͽ����� �Ǹ�
        			w = w - 7; // �����Ϻ��� �ٽ� ���
        		}
        		
        		// ������ �������� ����	
        		int birthMonth = random.nextInt(12) + 1; // ���� �� ������ �Ҵ�    	
        		int birthDay = random.nextInt(endDay) + 1; // ���� �� ������ �Ҵ�    	
        		birthday.set(Calendar.MONTH, birthMonth-1); // ���� �� ������ ���� ��ü�� �Ҵ�
        		birthday.set(Calendar.DATE, birthDay); // ���� �� ������ ���� ��ü�� �Ҵ�                
        		calToday.set(Calendar.MONTH, month-1); // �ش� �ٹ��� ��¥ ��ü ����
        		calToday.set(Calendar.DATE, y); // �ش� �ٹ��� ��¥ ��ü ����
        		
        		weekday = cal.get(Calendar.DAY_OF_WEEK) + w; // ���� ���ϱ�
        		
        		// �����Ͽ� �ٹ��ð� ����
        		if (weekday == 2) {
        			if (table == 0) { 
        				table = 2;
        			} else if (table == 1 ) {
        				table = 0;
        			} else {
        				table = 1;
        			}
        		}
        		
        		// �ָ� �����
        		if (weekday == 7 || weekday == 1) { // �ָ��̸�
        			if ((i % 2) == weekend) { // �̹� �ָ� �ٹ��� �Ҵ�
        				switch (table) {
        				case 0:
        					System.out.print("D\t");   	
        					break;
        				case 1:
        					System.out.print("E\t");
        					break;
        				case 2:
        					System.out.print("N\t");
        					break;
        				}
        			} else { // �̹� �ָ� �ٹ����� �ƴϸ� �޹�
        				System.out.print(" \t");
        			}
        			if (weekday == 1) { // �Ͽ����̸� ���� �ָ� �ٹ��� �ٲ���
        				switch (weekend) {
        				case 0:
        					weekend = 1;
        					break;
        				case 1:
        					weekend = 0;
        					break;
        				}
        			}
        		} else if (calToday.equals(birthday)) { // �����̸� �޹�
        			System.out.print(" \t");
        		} else { // �ְ� �ٹ���
        			switch (table) {
        			case 0:
        				System.out.print("D\t");   	
        				break;
        			case 1:
        				System.out.print("E\t");
        				break;
        			case 2:
        				System.out.print("N\t");
        				break;
        			}
        		}
        		w++;
        	}
        	System.out.println();
        }
        System.out.println();               
    }

    
}