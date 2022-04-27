## 30 Comparator와 Comparable
* 정렬(sort) 
	* 두 대상을 비교하여 자리를 바꾸는 일을 반복하는 것
* Comparator, Comparable - 컬렉션을 정렬(sort)하는데 필요한 메서드를 정의한 인터페이스
	* Comparator
		* java.util패키지에 포함됨 
		* 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용
		* **int compare(Object o1, Object o2)** - o1과 o2를 비교하여 같으면 0을 반환, 왼쪽이 크면 양수 반환, 오른쪽이 크면 음수 반환.
	* Comparable
		* java.lang패키지에 포함됨
		* 기본 정렬기준(default) 을 구현하는데 사용 
		* **int compareTo(Object o)** - 객체 자신(this)과 o를 비교 하여 같으면 0을 반환, 비교하는 값보다 크면 양수 반환, 작으면 음수 반환. 
		* Comparable을 구현한 클래스들 —> 정렬 가능하다
			* 같은 타입의 인스턴스끼리 서로 비교할 수 있는 클래스들
				* 주로 Integer같은  wrapper클래스와 String, Date, File같은 것들
			* 기본적으로 오름차순으로 정렬되도록 구현됨
		 	* JavaAPI에서 Comparable을 찾아볼 경우 이 인터페이스를 구현한 클래스들을 찾아볼 수 있음
	
```
public interface Comparator {
	int compare(Object o1, Object o2); //o1과 o2를 비교
	boolean equals(Object obj); //equals()를 오버라이딩하라는 뜻
//equals()의 경우 Comparator를 구현한 클래스가 오버라이딩이 필요할 수도 있다는 것을 알리기 위해 정의한 것일 뿐,
//그냥 compare(Object o1,  Object o2)만 구현하면 된다.
}

public interface Comparable {
	int compareTo(Object o); //객체 자신(this)과 o를 비교
}

```

* compare()와 compareTo()의 작성
	* 두 객체의 비교 결과를 반환하도록 작성함
```
public final class Integer extends Number implements Comparable { //Comparable을 구현하는 클래스
...
	public int compareTo(Integer anotherInteger) { Comparable의 22추상메서드 compareTo()를 구현해주어야 한다. 
		int v1 = this.value;
		int v2 = anotherInteger.value;
		//같으면 0, 오른쪽 값이 크면 -1, 오른쪽 값이 작으면 1을 반환
		return (v1 < v2 ? -1 : (v1 == v2 ? 0 : 1));
	}
...
}	
```
	  
## 31 Comparator와 Comparable 예제
Ch11/src/Ex11_07.java

## 32 Integer와 Comparable
* Integer클래스는 Comparable 인터페이스를 구현하여, compareTo(Object o)를 구현한다.
* Integer클래스의 compareTo()
	* 두 Integer 객체에 저장된 int 값(value)를 비교해 같으면 0, 크면 -1, 작으면 1을 반환한다. 
	* TreeSet에 Integer인스턴스를 저장할 때의 정렬 기준
```
public final class Integer extends Number implements Comparable {
...
	public int compareTo(Object o) {
		return compareTo((Integer)o);
	}

	public int CompareTo(Integer anotherInteger) {
		int thisVal = this.value;
		int anotherVal = anotherInteger.value;
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}
...
}
```
	
* Comparable을 구현한 클래스들
	* 기본적으로 오름차순으로 정렬되어 있음 
	* 내림차순으로 정렬한다거나 다른 기준에 의해 정렬하고싶다면, Comparator를 구현해 정렬기준을 제공하면 된다. 
	
## 33 Integer와 Comparable 예제
Ch11/src/Ex11_08.java
