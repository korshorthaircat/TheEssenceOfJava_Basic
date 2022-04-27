## 34 HashSet
* HashSet
	* Set인터페이스를 구현
		* 순서X, 중복X - 순서를 유지하지 않고 데이터의 중복을 허용하지 않는 데이터의 집합
	* HashSet을 특징을 이용한 컬렉션 내 중복 요소 제거 가능
		* 새로운 요소를 추가할 때 - add(), addAll() 사용
		* 이미 저장되어 있는 요소와 중복된 요소를 추가하고자 하면, 이 메서드들은 false를 반환하고 추가 실패를 알림
	* HashSet과 LinkedHashSet 비교
		* 저장순서를 유지하고 싶다면 LinkedHashSet 사용
	* HashSet과 TreeSet비교
		* TreeSet은 Hashset보다 데이터의 추가와 삭제에 시간이 더 걸림		
		* 그러나 TreeSet은 범위 검색과 정렬에 유리함
		
### HashSet의 메서드들 
* 생성자
	* HashSet()
	* HashSet(Collection c) - 주어진 컬렉션을 포함하는 HashSet객체를 생성
	* HashSet(int initialCapacity) - 주어진 값을 초기용량으로 하는 HashSet객체를 생성 
	* HashSet(int initialCapacity, float loadFactor) - 초기용량과 load factor를 지정하는 생성자
		* 참고) load factor - 컬렉션 클래스에 저장공간이 가득 차기 전에 미리 용량을 확보하기 위한. 것. 이 값을 0.8로 지정하면 저장공간의 80%가 채워졌을 때 용량이 두배로 늘어남
* 추가
	* boolean add(Object o) - 새로운 객체를 저장(성공하면 true, 실패하면 false)
	* boolean addAll(Collection c) - 주어진 컬렉션에 저장된 모든 객체들을 추가(합집합)
* 삭제
	* void clear()
	* boolean remove(Object o)
	* boolean removeAll(Collection c) - 주어진 컬렉션에 저장된 모든 객체와 동일한 것을 HashSet에서 삭제(차집합)
	* boolean retainAll(Collection c) - 주어진 컬렉션에 저장된 모든 객체와 동일한 것들만 남기고 삭제(교집합)
* 복제
	* Object clone()
* 검색
	* boolean contains(Object o) - 지정된 객체를 HashSet이 포함하고 있는지 알려줌
	* boolean containsAll(Collection c)
* 그외 
	* int size()
	* boolean isEmpty()	
	* Iterator iterator()
	* Object[] toArray() - 저장된 객체들을 객체배열의 형태로 반환
	* Object[] toArray(Object[] a) - 저장된 객체들을 주어진 객체배열(a)에 담음 
	* 참고) JDK1.8부터 스트림과 관련된 메서드들이 추가됨 

## 35-38 HashSet 예제1~4
* Ch11/src/Ex11_09.java
* Ch11/src/Ex11_10.java
* Ch11/src/Ex11_11.java
* Ch11/src/Ex11_12.java
