package day18;

import java.util.*;


public class Ex01_Map {

	public static void main(String[] args) {
		// <Map>
		Map<String, String> map = new HashMap<String, String>();
		
		//map.put(key, value)
		map.put("abc123", "abc123");
		map.put("abc456", "abc123");
		map.put("abc789", "null");
		//중복 안되고 순서 보장 안함
		map.put("abc123", "123456"); //기존 abc123에 덮어쓰기
		System.out.println(map);

		//Map에 저장된 회원의 아이디와 비밀번호를 하나의 객체로 만들어서 List에 저장
		/*
		Set<Map.Entry<String, String>> entry = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entry.iterator();
		*/
		//위의 두 줄을 한 줄로..
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); 
		//List 생성
		List<User> list = new ArrayList<User>();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			list.add(new User(entry.getKey(), entry.getValue()));
		}
		System.out.println(map);
		System.out.println(list);
		System.out.println("------------------------------------");
		
		//remove
		map.remove("abc456");
		System.out.println(map);
		System.out.println("------------------------------------");
		
		//해당 아이디가 있는지 확인
		System.out.println("아이디 abc123인 회원이 있습니까? " + map.containsKey("abc123")); //true
		//해당 비밀번호가 있는지 확인
		System.out.println("비밀번호가 456인 회원이 있습니까? " + map.containsValue("456")); //false
		System.out.println("------------------------------------");
		
		//map에 있는 회원 정보를 반복문으로 출력
		Iterator<String> it2 = map.keySet().iterator();
		while(it2.hasNext()) {
			//id를 찾고
			String id = it2.next();
			//id로 pw 찾기
			String pw = map.get(id);
			System.out.println(new User(id,pw));
		}
	}

}

class User{
	String id, pw;
	
	//생성자 -> 리턴타입이 없음
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	//toString
	@Override
	public String toString() {
		return "[ID : " + id + ", PW : " + pw + "]";
	}
}