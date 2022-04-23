#  Ch.11 컬렉션 프레임웍

## 01 컬렉션 프레임웍
* 컬렉션(collection)
	* 다수의 여러 객체(데이터)를 모아 놓은 것
* 컬렉션 클래스
	* 다수의 데이터를 저장할 수 있는 클래스
	* 예) Vector, Hashtable, Properties ...
* 프레임웍(framework)
	* 표준화, 정형화된 프로그래밍 방식
	* 	유용한 기능 제공 + 프로그래밍 방식 강제
		* —> 자유도는 떨어지지만 유지,보수가 용이함
* 라이브러리(Library)
	* ≒도서관
	* 예) 오디오 라이브러리, 통계 라이브러리, 수학 라이브러리, 그래픽 라이브러리 …
	* 기능만 제공 (공통으로 사용될만한 유용한 기능을 모듈화하여 제공)
* **컬렉션 프레임웍(Collection Framework)**
	* 컬렉션을 다루기 위한 표준화된 프로그래밍 방식
	* 데이터 군을 저장하는 클래스들을 표준화한 설계
	* “데이터 군을 다루고 표현하기 위한 단일화된 구조(architecture) @Java API문서
	* 컬렉션을 쉽고 편하게 다룰 수 있는(저장, 삭제, 정렬, 검색) 다양한 클래스 제공
	* java.util 패키지에 포함됨. JDK1.2부터 제공

## 02 컬렉션 프레임웍의 핵심 인터페이스
* 컬렉션 프레임웍의 핵심 인터페이스간의 상속계층도
	* 인터페이스 List, Set, Map
	* 인터페이스 List와 Set의 공통된 부분을 다시 뽑아 **Collection 인터페이스**를 정의

* 컬렉션 프레임웍의 모든 컬렉션 클래스들은 List, Set, Map 중 하나를 구현함
	* 구현한 인터페이스의 이름이 클래스의 이름에 포함됨( —> 이름만 보고 클래스의 특징 파악 가능)
	* 다루고자 하는 컬렉션의 특징을 파악하여 어떤 인터페이스를 구현한 컬렉션 클래스를 사용할지 결정해야 함 
	
### 컬렉션 프레임웍의 핵심 인터페이스 
* **List**
	* 순서O, 중복O - 순서를 유지하고 데이터의 중복을 허용하는 데이터의 집합
	* 예) 대기자 명단
	* 구현 클래스: ArrayList, LinkedList, Stack, Vector 등
* **Set**
	* 순서X, 중복X - 순서를 유지하지 않고 데이터의 중복을 허용하지 않는 데이터의 집합
	* 예) 양의 정수의 집합, 소수의 집합
	* 구현 클래스: HashSet, TreeSet 등
* **Map**
	* 키(key)와 값(value)의 쌍(pair)으로 이루어진 데이터의 집합
	* 순서X, 중복(키X, 값O) - 순서를 유지하지 않고, 키는 중복을 허용하지 않고, 값은 중복을 허용함
	* 예) 우편번호, 지역번호(전화번호), 아이디와 패스워드
	* 구현 클래스: HashMap, TreeMap, HashTable, Properties 등

## 03 Collection 인터페이스
* **Collection 인터페이스 - List와 Set의 조상**
* **Collection 인터페이스의 메서드들**
	* 추가
		* boolean add(Object o)
		* boolean addAll(Collection c)
	* 삭제
		* void clear() - Collection의 모든 객체를 삭제
		* boolean remove(Object o)
		* boolean removeAll(Collection c)
		* boolean retainAll(Collection c)
	* 검색
		* boolean contains(Object o)
		* boolean containsAll(Collection c)
	* 비교
		* boolean equals(Object o)
	* 해쉬코드
		* int hashCode()
	* 그외
		* int size()
		* boolean isEmpty()
		* Iterator iterator()  
		* Object[] toArray()
		* Object[] toArray(Object[] a)
	* 반환 타입이 boolean인 메서드들은 작업을 성공하거나 사실이면 true반환, 그렇지 않으면 false 반환
	
## 04 List 인터페이스
* **List**
	* 순서O, 중복O - 순서를 유지하고 데이터의 중복을 허용하는 데이터의 집합
	* List 인터페이스를 구현한 클래스들
		* **ArrayList** - 동기화X 
		* Vector - 동기화O
			* Stack
		* **LinkedList**

* **List 인터페이스의 메서드들**
	* Collection인터페이스로부터 상속받은 메서드들은 아래의 목록에서 제외했음
	* 추가
		* void add(int index, Object element)
		* boolean addAll(int index, Collection c)
	* 삭제
		* Object remove(int index)
	* 검색
		* int indexOf(Object o) - 지정된 객체의 위치(index)를 반환한다. List의 첫번째 요소부터 **순방향**으로 찾음
		* int lastIndexOf(Object O) - 지정된 객체의 위치(index)를 반환한다. List의 마지막 요소부터 **역방향**으로 찾음 
	* 정렬
		* void sort(Comparator c) - 지정된 비교자(Comparator)로 List를 정렬한다.
	* 반환
		* Object get(int index) - 지정된 위치에 있는 객체를 반환한다. (읽어오기)
		* Object set(int index, Object element) - 지정된 위치에 객체를 저장한다. (변경하기)
		* List subList(int fromIndex int toIndex) - 지정된 범위(fromIndex~toIndex)에 있는 객체를 반환한다.(일부만 뽑아내기)
	* 그외
		* ListIterator listIterator()
		* ListIterator listIterator(int index)
	
	
## 05 Set 인터페이스
* **Set**
	* 순서X, 중복X - 순서를 유지하지 않고 데이터의 중복을 허용하지 않는 데이터의 집합
	* Set 인터페이스를 구현한 클래스들
		* **HashSet**
		* SortedSet
			* **TreeSet**

* **Set 인터페이스의 메서드들** 
	* Collection인터페이스의 메서드들과 동일하다.
	* 집합과 관련된 메서드들
		* boolean addAll(Collection c) - 합집합
		* boolean containsAll(Collection c) -부분집합
		* boolean removeAll(Collection c) - 차집합
		* boolean retainAll(Collection c) -교집합	

## 06 Map 인터페이스
* **Map**
	* 키(key)와 값(value)의 쌍(pair)으로 이루어진 데이터의 집합
		* Map이란 개념은 어떤 두 값을 열결한다는 의미에서 붙여진 이름
	* 순서X, 중복(키X, 값O) - 순서를 유지하지 않고, 키는 중복을 허용하지 않고, 값은 중복을 허용함
	* Map 인터페이스를 구현한 클래스들
		* HashTable - 동기화O
		* **HashMap** - 동기화X
			* LinkedHashMap
		* SortedMap
			* **TreeMap** 

* **Map 인터페이스의 메서드들**  
	* 추가
		* Object put(Object key, Object value)
		* void putAll(Map t)
	* 삭제
		* void clear()
		* Object remove(Object key) 
	* 검색
		* boolean containsKey(Object key)
		* boolean containsValue(Object value)
		* Object get(Object key) - 지정한 key객체에 대응하는 value객체를 찾아 반환
	* 비교
		* boolean equals(Object o)
		* boolean isEmpty() - Map이 비어있는지 확인
	* 반환
		* Set entrySet() - Map에 저장된 모든 key-value 쌍(Entry)를 반환 (읽어오기)
		* Set keySet() - Map에 저장된 모든 key 객체를 반환(읽어오기) (맵에서 키는 중복 허용하지 않으므로 Set타입으로 반환) 
		* Collection values() - Map에 저장된 모든 value 객체를 반환(읽어오기) (맵에서 값은 중복 허용하므로 Collection타입으로 반환)
	* 그외 
		* int size() - Map에 저장된 key-value 쌍의 개수 
