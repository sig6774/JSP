package user;

public class User {
	

	private String account;
	private String password;
	private String name;
	private String nickName;
	// private를 통해서 외부에서 직접 접근하지 못하게 하고 User클래스의 객체 연산으로만 접근가능하도록 사용
	
//	public User(){
//		
//	}
	
	
	public User(String account, String password, String name, String nickName) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
	}
	// alt+shift+s를 통해서 매개변수를 받는 생성자 생성 가능
	// 객체를 생성하면 자동으로 해당 변수들이 초기화되도록 함 





	// Getter와 Setter를 통해서 메소드를 통해 접근하여 값을 변경하도록 함(alt+shift+s)
	// Setter에 입력값의 유효성 검증을 할 수 있음
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
	


}
