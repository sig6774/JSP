package kr.co.jsp.score.model;

/*
 CREATE TABLE scores (
    id    NUMBER PRIMARY KEY,
    name  VARCHAR2(30) NOT NULL,
    kor   NUMBER(3) DEFAULT 0,
    eng   NUMBER(3) DEFAULT 0,
    math  NUMBER(3) DEFAULT 0,
    total NUMBER(3) DEFAULT 0,
    avg   NUMBER(5, 2)
);

CREATE SEQUENCE id_seq 
START WITH 1 INCREMENT BY 1 MAXVALUE 1000 NOCACHE NOCYCLE;
 */
/**
 * @author MY
 *
 */
public class ScoreVO {
	// 자바빈 클래스란 데이터베이스와의 반복적인 작업을 쉽게 처리하기 위해 디자인하는 클래스
	// 자바빈 클래스는 은닉(캡슐화)을 사용하여 설계
	// 자바빈 클래스는 데이터베이스의 컬럼과 1:1로 매칭되는 멤버변수를 선언 
	
	private int id; 
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	// DB의 컬럼이름과 일치하게 변수 선언 
	// 자바빈 클래스는 일반적으로 기본 생성자(필수)와 모든 필드값을 매개값으로 받는 생성자(선택)를 하나씩 제작해줌 
	
	// 기본 생성자 
	public ScoreVO() {
		// TODO Auto-generated constructor stub
	}
	// 기본생성자 생성 단축키 : ctrl + space + enter
	
	
	
	// 매개변수를 받는 생성자 
	public ScoreVO(int id, String name, int kor, int eng, int math, int total, double avg) {	
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
		this.avg = avg;
	}
	// 매개변수받는 생성자 생성 단축키 : alt + shift + s 

	// getter setter 생성 단축키  : alt + shift + s
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public double getAvg() {
		return avg;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}
}
