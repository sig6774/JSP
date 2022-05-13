package main.java.user;

public class User {
	

	private String account;
	private String password;
	private String name;
	private String nickName;
	// private瑜� �넻�빐�꽌 �쇅遺��뿉�꽌 吏곸젒 �젒洹쇳븯吏� 紐삵븯寃� �븯怨� User�겢�옒�뒪�쓽 媛앹껜 �뿰�궛�쑝濡쒕쭔 �젒洹쇨��뒫�븯�룄濡� �궗�슜
	
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
	// alt+shift+s瑜� �넻�빐�꽌 留ㅺ컻蹂��닔瑜� 諛쏅뒗 �깮�꽦�옄 �깮�꽦 媛��뒫
	// 媛앹껜瑜� �깮�꽦�븯硫� �옄�룞�쑝濡� �빐�떦 蹂��닔�뱾�씠 珥덇린�솕�릺�룄濡� �븿 





	// Getter�� Setter瑜� �넻�빐�꽌 硫붿냼�뱶瑜� �넻�빐 �젒洹쇳븯�뿬 媛믪쓣 蹂�寃쏀븯�룄濡� �븿(alt+shift+s)
	// Setter�뿉 �엯�젰媛믪쓽 �쑀�슚�꽦 寃�利앹쓣 �븷 �닔 �엳�쓬
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
