## 46 HashMap과 HashTable
* HashMap과 HashTable의 관계
	* (Vector와 ArrayList의 관계와 유사함) 
	* HashTable보다 HashMap사용을 권장

### HashMap
* Map인터페이스를 구현함
	* 키(key)와 값(value)을 묶어 하나의 데이터(entry)로 저장
* 해싱(hashing) 사용
	* 많은 양의 데이터를 검색하는데 뛰어난 성능
```java
public class HashMap extends AbstractMap implements Map, Cloneable, Serializable
{
	transient Entry[] table;
	...
	static class Entry implements Map.Entry { //Map.Entry는 Map인터페이스에 정의된 static inner interface
		final Object key;
		Object value;
		...
	}
}
```
```java
//HashMap은 Entry라는 내부클래스를 정의하고, 다시 Entry타입의 배열을 선언함
//키와 값은 별개의 값이 아니라 서로 관련된 값이기 때문에, 
//각각의 배열로 선언하기보다는 하나의 클래스로 정의해 하나의 배열로 다루는 것이
//데이터의 무결성(integrity)적인 측면에서 바람직 

//비객체지향적인 코드
Object[] key;
Object[] value;

//객체지향적인 코드 
Entry[] table;

class Entry {
	Object key;
	Object value;
}
```

## 47 HashMap의 키(key)와 값(value)
* HashMap의 키(key)
	* 컬렉션 내의 키 중에서 유일해야 함(중복 허용X)
	* Object타입(어떠한 객체든)을 저장할 수있지만, 키는 주로 String을 대문자 또는 소문자로 통일해 사용 
	* 예) 사용자의  ID
* HashMap의 값(value)
	* 키와는 달리 데이터의 중복을 허용함
	* 예) 사용자의 비밀번호

### 해싱(hashing) - HashTable, HashMap, HashSet
* 예) 환자 정보의 효율적인 관리를 위해, 환자의 정보가 담긴 문서를 출생연도별로 캐비닛 서랍을 달리하여 저장하는 경우 
	* 주민번호 72년생 환자의 정보를 찾기 위해 7번 캐비닛 서랍을 확인함
	* 키 - 72년생 환자의 주민번호
	* 해시코드 - 환자의 정보 문서가 담긴 캐비닛 서랍 인덱스(7)
* 해싱(hashing)
	* 해시함수를 이용해 자료를 저장하고 읽어오는 행위
	* 해시함수를 이용해 해시테이블에 데이터를 저장하고 검색함
* 해시 함수
	* 해시코드를 반환하는 함수
	* 같은 키에 대해서 항상 같은 해시코드를 반환해야함
	* 서로 다른 키일지라도 같은 값의 해시코드를 반환할 수 있음(다른 환자들의 key-주민번호일지라도, 같은 index의 캐비닛에 저장될 수 있듯이)
* 해시테이블
	* 배열과 링크드리스트가 조합된 형태
	* 배열의 장점(접근성) + 링크드 리스트의 장점(변경 유리) 
* 해시테이블에 저장된 데이터를 가져오는 과정
	* 1) 키로 해시함수를 호출해 해시코드를 얻는다.
	* 2) 해시코드(해시함수의 반환값)에 대응하는 링크드리스트를 배열에서 찾는다.
	
## 48 HashMap의 메서드
* 생성자
	* HashMap() - HashMap의 객체를 생성 
	* HashMap(int initialCapacity) - 지정된 값을 초기용량으로 하는 HashMap객체를 생성 
	* HashMap(int initialCapacity, float loadFactor) - 지정된 초기용량과 loadFactor의 HashMap객체를 생성 
	* HashMap(Map m) - 지정된 Map의 모든 요소를 포함하는 HashMap을 생성 
* 추가
	* Object put(Object key, Object value) - 지정된 키와 값을 HashMap에 저장
	* void putAll(Map m) - Map에 저장된 모든 요소를 HashMap에 저장 
* 삭제
	* void clear() - HashMap에 저장된 모든 객체를 제거
	* Object remove(Object key) - HashMap에서 지정된 키로 저장된 값(객체)을 제거
* 검색
	* boolean containsKey(Object key)  - HashMap에 지정된 키가 포함되어 있는지 알려준다.(포함되어 있으면 true)
	* boolean containsValue(Object value) - HashMap에 지정된 값이 포함되어있는지 알려준다.(포함되어 있으면 true) 
* 반환
	* Object get(Object key) - 지정된 키의 값(객체)을 반환. 못 찾으면 null 반환
	* Object getOfDefault(Object key, Object defaultValue) - 지정된 키의 값(객체)을 반환. 키를 못 찾으면 defaultValue로 지정된 객체를 반환	
	* Set entrySet() - HashMap에 저장된 키와 값을 엔트리(키와 값의 결합)의 형태로 Set에 저장해서 반환 
	* Set keySet() - HashMap에 저장된 모든 키가 저장된 Set을 반환 
	* Collection values() - HashMap에 저장된 모든 값을 컬렉션의 형태로 반환 
* 변경
	* Object replace(Object key, Object oldValue, Object newValue) - 지정된 키와 객체(oldValue)가 모두 일치하는 경우 새로운 객체(newValue)로 대체
* 복제
	* Object clone(0 - 현재 HashMap을 복제해서 반환 
* 그외
	* int size() - HashMap에 저장된 요소의 개수를 반환 
	* boolean isEmpty() - HashMap이 비어있는지 알려줌
	
## 49-51 HashMap 예제1~3
