package day17;

public class Ex6_Generic_Test1 {

	public static void main(String[] args) {
		//<제네릭>
		Array<Integer> array = new Array<Integer>();
		Integer nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		array.setArray(nums);
		array.print();
		System.out.println();
		
		Array<String> array2 = new Array<String>();
		String strs[] = {"안녕", "학원", "공부"};
		array2.setArray(strs);
		array2.print();
		System.out.println();
		
		//와일드카드
		array.print(array2);
		
	}

}
//클래스 제한 -> Numbers 클래스 또는 상속받은 클래스들만 T에 올 수 있음
//-> 그래서 메인에서 String에 오류 발생
//class Array<T extends Number>{ 
class Array<T>{
	//필드
	private T arr[] = (T[])new Object[10];
	private int size; //현제 저장된 값의 개수
	private int capacity = 10; //배열 최대 크기
	
	//생성자
	public Array() {
		this(10);
	}
	public Array(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}
	//메소드
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public void setArray(T arr[]) {
		//매개변수 배열이 최대 크기보다 큰 배열인지 확인
		if(capacity < arr.length) {
			//배열 크기 확장
			capacity = arr.length + 10;
			//확장된 크기의 새 배열 생성
			T tmp[] = (T[]) new Object[capacity];
			System.arraycopy(this.arr, 0, tmp, 0, this.arr.length);			
			this.arr =tmp;
		}
		this.size = size < arr.length ? arr.length : size;
		int count = size < arr.length ? size : arr.length;
		for(int i = 0; i<count; i++) {
			this.arr[i] = arr[i];
		}		
	}
	
	//와일드카트 타입 -> T대신 ?로 하면 제한없이
	/* ?(와일드카드) 제네릭 클래스에서 메서드에 제네릭 클래스의 객체가 오는데, 
	객체의 타입이 서로 다른 경우에도 메소드에서 호출할 수 있게 해줌
	위 예제에서 Integer 타입으로 된 array가 String 타입으로 된 array2를
	매개변수로 가져와서 print를 실행 -> 와일드카드때문에 가능*/
	public void print(Array<?> array) {
		array.print();
	}
}