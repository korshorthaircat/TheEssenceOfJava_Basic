# Arrays클래스
* 배열을 다루기 위한 편리한 static 메서드들을 제공

## 25 Arrays의 메서드(1) - 출력, 복사
### 배열의 출력 - toString(), deepToString()
* 같은 기능의 메서드가 타입만 다르게 오버로딩 
	*  아무 배열을 넣어도 문자열로 만들어준다. 
		* static String toString(boolean[] a)
		* static String toString(byte[] a)
		* static String toString(char[] a)
		* static String toString(short[] a)
		* static String toString(int[] a)
		* static String toString(long[] a)
		* static String toString(float[] a)
		* static String toString(double[] a)
		* static String toString(Object[] a)
		
* toString() - 배열의 모든 요소를 문자열로 편하게 출력 가능, 일차원 배열에만 사용할 수 있음
* deepToString() - 다차원 배열의 모든 요소를 문자로 출력 가능(모든 요소에 재귀적으로 접근하여 문자열을 구성함)
```
int[] arr = { 0, 1, 2, 3, 4 }
int[][] arr2D = { {11, 12}, {21, 22} };

System.out.println(Arrays.toString(arr));
System.out.println(Arrays.deepToString(arr2D));
```
	
###  배열의 복사 - copyOf(), copyOfRange()
* copyOf() - 배열 전체를 복사해 새로운 배열을 생성하여 반환
* copyOfRange() - 배열의 일부를 복사해 새로운 배열을 생성하여 반환(지정된 범위의 끝은 포함x)

```
int[] arr = {0, 1, 2, 3, 4};

int[] arr2 = Arrays.copyOf(arr, arr.length); 
//arr2 = [0,1,2,3,4]

int[] arr3 = Arrays.copyOf(arr, 3);

int[] arr4 = Arrays.copyOf(arr, 7);
//arr4 = [0,1,2,3,4,0,0]

int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
//arr5 = [2,3] (toIndex는 불포함)

int[] arr6 = Arrays.copyOfRange(arr, 0, 7);
//arr6 = [0,1,2,3,4,0,0]
```

## 26 Arrays의 메서드(2) - 채우기, 정렬, 검색
###  배열 채우기 - fill(), setAll()
* fill() - 배열의 모든 요소를 지정된 값으로 채움
* setAll() - 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받음
```
int[] arr = new int[5];

Arrays.fill(arr, 9); 
//arr = [9,9,9,9,9]

Arrays.setAll(arr, (i) -> (int)(Math.random()*5+1); //람다식이 반환한 임의의 정수로 배열을 채움
//arr = [1,3,5,3,4]
```

### 배열의 정렬, 검색 - sort(), binarySearch()
* sort() - 배열을 정렬
* binarySearch() - 배열에 저장된 요소를 검색함. 배열에서 지정된 값이 저장된 위치(index)를 반환. 단, 반드시 **배열이 정렬된 상태** 이어야 올바른 결과를 얻음.

```
int[] arr = { 3, 2, 0, 1, 4 };
int idx = Arrays.binarySearch(arr,2) //정렬하지 않고 binarySearch()를 사용했으므로 잘못된 결과를 얻음

Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
//[0, 1, 2, 3, 4]
int idx = Arrays.binarySearch(arr,2); //idx=2
```

### 순차 검색과 이진 검색
*  순차 검색(linear search)
	* 배열의 첫번째 요소부터 순서대로 하나씨 검색함
	* 배열이 정렬되어 있을 필요는 없으나 시간이 많이 걸린다.
* 이진 검색(binary search) 
	* 배열의 검색할 범위를 반복적으로 절반씩 줄여나가므로 검색속도가 상당히 빠르다. 
	* 큰 배열의 검색에 유리하다. 
	* 단, 배열이 정렬되었을 때만 사용할 수 있다. 

## 27 Arrays의 메서드(3) - 비교
### 문자열의 비교- equals(), deepEquals()
* equals() - 두 배열에 저장된 모든 요소를 비교해 같으면 true, 다르면 false 반환, 일차원 배열에만 사용 가능
* deepEquals() - 다차원 배열에 저장된 모든 요소를 비교
```
String[][] str2D = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
String[][] str2D2 = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};

System.out.println(Arrays.equals(str2D, str2D2)); //false. 다차원 배열은 '배열의 배열'형태로 구성하기 때문에 equals()로 비교하면 문자열을 비교하는 것이 아니라 '배열에 저장된 배열의 주소'를 비교하게 됨. 따라서 false를 결과로 얻음. 
System.out.println(Arrays.deepEquals(str2D, str2D2)); //true 
```

## 28 Arrays의 메서드(4) - 변환
### 배열을 List로 변환 - asList(Object …a)
* asList(Object…a) - 배열을 List에 담아 반환. 
	* 매개변수의 타입이 가변인수라서 배열의 생성 없이 저장할 요소만 나열 가능
	* asList()가 반환한 List의 크기는 변경할  수 없음(추가 또는 삭제 불가)
	* asList()가 반환한 List의 저장된 내용은 변경 가능
```
List list = Arrays.asList(new Integer[] {1,2,3,4,5});
//list=[1,2,3,4,5]
List list = Arrays.asList(1,2,3,4,5);
//list=[1,2,3,4,5]
list.add(6); //UnsupportedOperationException발생. asList로 만들어낸 리스트는 읽기 전용. 

//만일 크기를 변경할 수 있는 List가 필요하다면 
List list = new ArrayList(Arrays.asList(1,2,3,4,5));
```

### parallelXXX(), spliterator(), stream()
* parallel로 시작하는 이름의 메서드들 - 보다 빠른 결과를 얻기 위해 여러 쓰레드가 작업을 나누어 처리하도록 함
* spliterator() - 여러 쓰레드가 처리할 수 있게 하나의 작업을 여러 작업으로 나누는 Spliterator를 반환
* stream() - 컬렉션을 스트림으로 변환

## 29 Arrays의 메서드 예
Ch11/src/Ex11_06.java
