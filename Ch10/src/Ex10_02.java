//Ch.10 - 04 Calendar 예제2 

import java.util.*;

class Ex10_02 {
	public static void main(String[] args) {
		//요일은 1부터 시작하기 때문에, Day_Of_Week[0]은 비워두었다.
		final String[] DAY_OF_WEEK = { "", "일", "월", "화", "수", "목", "금", "토" };
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		//날짜와 시간을 원하는 값으로 변경하려면 set메서드 사용 
		//void set(int field, int value)
		//void set(int year, int month, int date)
		//void set(int year, int month, int date, int hourOfDay, int minute)
		//void set(int year, int month, int date, int hourOfDay, int minute, int second)
		date1.set(2021, 3, 29); //2021년 4월 29일로 날짜 설정
		//month의 경우 0부터 시작하기 때문에, 4월인 경우 3으로 지정해야 한다.
		//date1.set(2021, Calendar.April, 29);와 같이 할 수도 있다.
		
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고, ");
		System.out.println("date2(오늘)은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다. ");
	
		//두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야 한다.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println("그 날(date1)부터 지금(date2)까지 " + difference + "초가 지났습니다.");
		System.out.println("일(day)로 계산하면 " + difference/(24*60*60) + "일입니다.");
	}

	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH)+1) + "월 " + date.get(Calendar.DATE) + "일 ";
	}
}
