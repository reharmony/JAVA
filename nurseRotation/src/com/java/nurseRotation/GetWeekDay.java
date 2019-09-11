package com.java.nurseRotation;

import java.util.*;



public class GetWeekDay {
    public GetWeekDay() {
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in); // 스캐너 객체 생성
    	int year = 0;
    	int month = 0;
    	int day = 1;
    	int headNurse = 0; // 수간호사
    	int normalNurse = 0; // 일반간호사
    	int aidNurse = 0; // 간호조무사
    	
    	// 날짜 설정
    	try {
			System.out.print("연도 (ex. 2019): "); // 현재연도 입력
			year = scanner.nextInt();
			if (year < 1900 || year > 2100) {
					System.out.println("1900 ~ 2100 사이로 입력해주세요.");
					System.exit(0);			
			}
			
	        System.out.print("월 : "); // 현재월 입력
	        month = scanner.nextInt();
	        
	        if (month < 1 || month > 12) {
	        	System.out.println("1 ~ 12 사이로 입력해주세요.");
	        	System.exit(0);			
	        }

	        
	        // 간호사 유형별 인원 입력
	        System.out.print("수간호사 인원 : ");
	        headNurse = scanner.nextInt();
	        
	        if (headNurse < 1) {
	        	System.out.println("수간호사는 1명 이상으로 입력해주세요.");
	        	System.exit(0);
	        }
	        
	        System.out.print("일반간호사 인원 : ");
	        normalNurse = scanner.nextInt();
	        
	        if (normalNurse < 6) {
	        	System.out.println("수간호사는 6명 이상으로 입력해주세요.");
	        	System.exit(0);
	        }
	        
	        System.out.print("간호조무사 인원 : ");
	        aidNurse = scanner.nextInt();
	        
	        if (aidNurse < 6) {
	        	System.out.println("간호조무사는 6명 이상으로 입력해주세요.");
	        	System.exit(0);
	        }
        
    	} catch (Exception e) {
        	System.out.println("올바른 값을 입력해주세요.");
        	System.exit(0);	
		} 
    	
    	System.out.println("\n");
    	
        
    	// 간호사 유형
        int[] sunum = {headNurse, normalNurse, aidNurse};
        String[] su = {"수간호사", "일반간호사", "간호조무사"}; 

        // 입력받은 기간으로 날짜 객체 생성
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DATE, day);
       
        int endDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // 입력한 달의 마지막날 구하기
        
        System.out.print(cal.get(Calendar.YEAR) + "년 "); // 입력한 연도 출력
        System.out.print(cal.get(Calendar.MONTH)+1); // 입력한 월 출력
        System.out.println("월");
        
        System.out.print("\t\t");
        
        // 날짜 출력
        for (int i=1; i<=endDay; i++) {
        	System.out.print(i);
        	System.out.print("\t");
        }
        
        System.out.println("");
        System.out.print("\t");
               
        
        // 요일 출력
        int w = 0;
        int weekday = 0;
        for (int i=0;i<endDay;i++) {
        	if (weekday == 7) { // 일요일이 되면
        		w = w - 7; // 월요일부터 다시 출력
        	}
        	System.out.print("\t");
    		weekday = cal.get(Calendar.DAY_OF_WEEK) + w;
    	      switch (weekday) {
    	      case Calendar.SUNDAY:
    	          System.out.print("일");
    	          break;
    	      case Calendar.MONDAY:
    	          System.out.print("월");
    	          break;
    	      case Calendar.TUESDAY:
    	          System.out.print("화");
    	          break;
    	      case Calendar.WEDNESDAY:
    	          System.out.print("수");
    	          break;
    	      case Calendar.THURSDAY:
    	          System.out.print("목");
    	          break;
    	      case Calendar.FRIDAY:
    	          System.out.print("금");
    	          break;
    	      case Calendar.SATURDAY:
    	          System.out.print("토");
    	          break;
    	  }
    		w++;
        }
        System.out.println("\n");
        
        Random random = new Random(); // 랜덤 객체 생성
        Calendar birthday = Calendar.getInstance(); // 생일 객체 생성
        Calendar calToday = Calendar.getInstance(); // 근무일 날짜 객체 생성
        

        // 수간호사
        w = 0;
        for (int i=0;i<headNurse;i++ ) {
        	System.out.print(su[0] + "\t" + (i + 1) + "\t"); // 간호사번호
        	
        	for (int y=0;y<endDay;y++) {
        		if (weekday == 7) { // 일요일이 되면
            		w = w - 7; // 월요일부터 다시 출력
            	}
        		
            	// 생일을 랜덤으로 생성	
            	int birthMonth = random.nextInt(12) + 1; // 랜덤 월 변수에 할당    	
            	int birthDay = random.nextInt(endDay) + 1; // 랜덤 일 변수에 할당    	
                birthday.set(Calendar.MONTH, birthMonth-1); // 랜덤 월 변수를 생일 객체에 할당
                birthday.set(Calendar.DATE, birthDay); // 랜덤 일 변수를 생일 객체에 할당                
                calToday.set(Calendar.DATE, y); // 해당 근무일 날짜 객체 설정
               
                weekday = cal.get(Calendar.DAY_OF_WEEK) + w; // 요일 구하기
                
        		if (weekday == 1 || weekday ==7 || calToday.equals(birthday)) { // 주말이거나 생일이면
        			System.out.print(" \t"); // 휴무일
        		} else { // 평소라면
        			System.out.print("D\t"); // 출근 
        		}
        		w++;
        	}
        	System.out.println();
        }
        System.out.println();
        
        
        
        
        // 일반간호사
        for (int i=0;i<normalNurse;i++ ) {
        	w = 0;
        	System.out.print(su[1] + "\t" + (i + 1) + "\t"); // 간호사번호
        	int table = 0; // 근무조
        	
        	// 근무조 나누기
        	if (i % 3 == 0) {
        		table = 0;
        	} else if ( i % 3 == 1) {
        		table = 1;
        	} else {
        		table = 2;
        	}

        	int weekend = 0; // 주말 근무조
        	for (int y=0;y<endDay;y++) {
        		if (weekday == 7) { // 일요일이 되면
            		w = w - 7; // 월요일부터 다시 출력
            	}
        		
        		// 생일을 랜덤으로 생성	
            	int birthMonth = random.nextInt(12) + 1; // 랜덤 월 변수에 할당    	
            	int birthDay = random.nextInt(endDay) + 1; // 랜덤 일 변수에 할당    	
                birthday.set(Calendar.MONTH, birthMonth-1); // 랜덤 월 변수를 생일 객체에 할당
                birthday.set(Calendar.DATE, birthDay); // 랜덤 일 변수를 생일 객체에 할당                
                calToday.set(Calendar.MONTH, month-1); // 해당 근무일 날짜 객체 설정
                calToday.set(Calendar.DATE, y); // 해당 근무일 날짜 객체 설정
                
        		weekday = cal.get(Calendar.DAY_OF_WEEK) + w; // 요일 구하기
        		
        		// 월요일에 근무시간 변경
        		if (weekday == 2) {
        			if (table == 0) { 
        				table = 2;
        			} else if (table == 1 ) {
        				table = 0;
        			} else {
        				table = 1;
        			}
        		}
        		
        		// 주말 출근조
        		if (weekday == 7 || weekday == 1) { // 주말이면
        			if ((i % 2) == weekend) { // 이번 주말 근무조 할당
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
        			} else { // 이번 주말 근무조가 아니면 휴무
        				System.out.print(" \t");
        			}
        			if (weekday == 1) { // 일요일이면 다음 주말 근무조 바꿔줌
        				switch (weekend) {
        				case 0:
        					weekend = 1;
        					break;
        				case 1:
        					weekend = 0;
        					break;
        				}
        			}
        		} else if (calToday.equals(birthday)) { // 생일이면 휴무
        			System.out.print(" \t");
        		} else { // 주간 근무조
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
        
        
        
        
        // 간호조무사
        for (int i=0;i<aidNurse;i++ ) {
        	w = 0;
        	System.out.print(su[2] + "\t" + (i + 1) + "\t"); // 간호사번호
        	int table = 0; // 근무조
        	
        	// 근무조 나누기
        	if (i % 3 == 0) {
        		table = 0;
        	} else if ( i % 3 == 1) {
        		table = 1;
        	} else {
        		table = 2;
        	}
        	
        	int weekend = 0; // 주말 근무조
        	for (int y=0;y<endDay;y++) {
        		if (weekday == 7) { // 일요일이 되면
        			w = w - 7; // 월요일부터 다시 출력
        		}
        		
        		// 생일을 랜덤으로 생성	
        		int birthMonth = random.nextInt(12) + 1; // 랜덤 월 변수에 할당    	
        		int birthDay = random.nextInt(endDay) + 1; // 랜덤 일 변수에 할당    	
        		birthday.set(Calendar.MONTH, birthMonth-1); // 랜덤 월 변수를 생일 객체에 할당
        		birthday.set(Calendar.DATE, birthDay); // 랜덤 일 변수를 생일 객체에 할당                
        		calToday.set(Calendar.MONTH, month-1); // 해당 근무일 날짜 객체 설정
        		calToday.set(Calendar.DATE, y); // 해당 근무일 날짜 객체 설정
        		
        		weekday = cal.get(Calendar.DAY_OF_WEEK) + w; // 요일 구하기
        		
        		// 월요일에 근무시간 변경
        		if (weekday == 2) {
        			if (table == 0) { 
        				table = 2;
        			} else if (table == 1 ) {
        				table = 0;
        			} else {
        				table = 1;
        			}
        		}
        		
        		// 주말 출근조
        		if (weekday == 7 || weekday == 1) { // 주말이면
        			if ((i % 2) == weekend) { // 이번 주말 근무조 할당
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
        			} else { // 이번 주말 근무조가 아니면 휴무
        				System.out.print(" \t");
        			}
        			if (weekday == 1) { // 일요일이면 다음 주말 근무조 바꿔줌
        				switch (weekend) {
        				case 0:
        					weekend = 1;
        					break;
        				case 1:
        					weekend = 0;
        					break;
        				}
        			}
        		} else if (calToday.equals(birthday)) { // 생일이면 휴무
        			System.out.print(" \t");
        		} else { // 주간 근무조
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