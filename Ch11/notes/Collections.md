* Arrays 클래스
	* 배열을 다루기 위한 편리한 static 메서드들을 제공
* Collections 클래스
	* 컬렉션과 관련된 편리한 static메서드들을 제공
	* fill(), copy(), sort(), binarySearch() 등의 메서드는 Arrays클래스와 Collections클래스에 모두 포함되어 있으며 같은 기능을 함.
	* 참고) java.util.Collection은 인터페이스이고, java.util.Collentions는 클래스임.

## 52 Collections의 메서드 - 동기화
* 컬렉션의 동기화
	* 멀티 쓰레드 프로그래밍에서는 하나의 객체에 여러 쓰레드가 동시에 접근할 수 있음
	* 데이터의 무결성(integrity)을 유지하기 위해서는 공유되는 객체에 동기화 필요
	* 구버전(JDK1.2 이전)의 Vector, HashTable같은 클래스들은 자체적으로 동기화 처리가 됨
		* 멀티쓰레드 프로그래밍이 아닌 경우 불필요한 기능
		* 성능을 떨어뜨리는 요인
	* 새로 추가된 ArrayList, HashMap같은 컬렉션은 필요한 경우에만 동기화 처리가 가능하도록 변경 —> **java.util.Collections 클래스의 동기화 메서드 이용**

### Collections의 동기화 메서드
* static Collection synchronizedCollection(Collection c)
* static List synchronizedList(List list)
* static Set synchronizedSet(Set s)
* static Map synchronizedMap(Map m)
* static SortedSet synchronizedSortedSet(SortedSet s)
* static SortedMap synchronizedSortedMap(SortedMap m)

* 사용법
```
List syncList = Collections.synchronizedList(new ArrayList(...));
```

## 53 Collections의 메서드 - 변경불가, 싱글톤
### 변경불가 컬렉션 만들기
* 컬렉션을 읽기 전용으로 만들기
	* 컬렉션에 저장된 데이터를 보호하기 위해 컬렉션을 변경할 수 없게 설정해야 할 때가 있음 
	* 주로 멀티쓰레드 프로그래밍에서 여러 쓰레드가 하나의 컬렉션을 공유하다보면 데이터가 손상될 수 있음

* static Collection unmodifiableCollection(Collection c)
* static List unmodifiableList(List list)
* static Set unmodifiableSet(Set s)
* static Map unmodifiableMap(Map m)
* static NavigableSet unmodifiableNavigableSet(NavigableSet s)
* static SortedSet unmodifiableSortedSet(SortedSet s)
* static NavigableMap unmodifiableNavigableMap(NavigableMap m)
* static SortedMap unmodifiableSortedMap(SortedMap m)
	
### 싱글톤 컬렉션 만들기
* 단 하나의 객체만 저장하는 컬렉션을 만들어야 하는 경우
	* 매개변수로 저장할 요소를 지정하면 해당 요소를 저장하는 컬렉션을 반환함 
	* 이 때, 반환된 컬렉션은 변경할 수 없음 

* static List singletonList(Object o)
* static Set singleton(Object o) //주의! singletonSet이 아님. 
* static Map singletonMap(Object key, object value)

## 54 Collections의 메서드 - 단일 컬렉션
### 한 종류의 객체만 저장하는 컬렉션 만들기
* 컬렉션에 지정된 종류의 객체만 저장할 수 있도록 제한하고 싶을 때
	* JDK1.5부터는 지네릭스로 간단히 처리 가능
	* 그러나 JDK1.5이전에 작성된 코드의 호환성을 위해 아래의 메서드들이 필요할 수 있음 

* static Collection checkedCollection(Collection c, Class type)
* static List checkedList(List list, Class type)
* static Set checkedSet(Set s, Class type)
* static Map checkedMap(Map m, Class keyType, Class valueType)
* static Queue(Queue queue, Class type)
* static NavigableSet checkedNavigableSet(NavigableSet s, Class Type)
* static SortedSet checkedSortedSet(SortedSet s, Class type)
* static NavigableMap checkedNavigableMap(NavigableMap m, Class keyType, class valueType)
* static SortedMap checkedSortedMap(SortedMap m, Class keyType, Class valuePoint)

* 사용법
	* 두 번째 매개변수에 저장할 객체의 클래스를 지정함
```
List list = new ArrayList();
List checkedList = checkedList(list, String.class); //String만 저장 가능
checkedList.add("abc"); //OK.
checkedList.add(new Integer(3)); //에러. ClassCastException 발생
```

## 55 Collections 예제
