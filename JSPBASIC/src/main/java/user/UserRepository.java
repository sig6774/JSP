package user;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	
	// 회원의 정보를 담아놓을 리스트(회원 저장소)
	private static List<User> userList = new ArrayList<>();
	// user의 정보를 담을 수 있는 리스트 생성하면서 전역에서 사용할 수 있음
	
	public static void save (User u) {
		userList.add(u);
	}
	// 회원저장소(List)에 회원(User)을 추가하기 위한 메소드
	
//	public User find (int number) {
//		return userList.get(number);
//	}
//	
//	public void delete (int number) {
//		userList.remove(number);
//	}
	
	//회원 정보 저장 후 리스트 내부를 보여주는 메서드.
   public static void showUsers() {
      System.out.println("### 회원 정보 ###");

      for(User user : userList) {
         System.out.println("아이디: " + user.getAccount());
         System.out.println("비밀번호: " + user.getPassword());
         System.out.println("이름: " + user.getName());
         System.out.println("별명: " + user.getNickName());
         System.out.println("===============================");
      }
   }
   
   // 매개값으로 id를 받아서 해당 id를 가진 객체가 userList에 있는지 탐색 
   public static User getUser(String id) {
	   User finduser = null;
	   for (int i = 0; i<userList.size(); i++) {
		   if (userList.get(i).getAccount().equals(id)) {
			   //userList에 같은 id가 있으면 
			   	finduser = userList.get(i);
		   }

	   }
	   return finduser;
   }
}
