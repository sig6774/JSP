package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.jsp.util.JdbcUtil;

public class BoardDAO implements IBoardDAO {

	// 싱글톤 디자인 패턴 구축

	// Connection pool의 정보를 담을 변수를 선언
	private DataSource ds;
	// 외부에서 객체 생성을 하지 못하고 접근하지 못하도록 하기 위해 private 작성
	private BoardDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		// Connection pool에서 다 설정을 했기 때문에 이제는 사용하지 않아도 됨
		
		
		// 클래스에서 Connection pool을 구하는 방법
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
			// context.xml에서 내가 지정한 jdbc/myOracle 정보를 찾아라
			// lookup은 return이 Object이므로 Datasource 객체로 형 변환
			// connection pool 정보를 가져와서 ds에 저장 
			// 
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	// DataSource 객체를 생성해서 db Connection 할 수 있음

	private static BoardDAO dao = new BoardDAO();

	// BoardDAO에 접근하기 위해서는 getInstance()메소드를 통해서만 접근
	public static BoardDAO getInstance() {
		return dao;
	}

	//////////////////////////////////////////////

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/* connection pool을 사용하면 밑의 메소드는 필요없음
	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "jsp";
		String upw = "jsp";
		
		
		return DriverManager.getConnection(url, uid, upw);
	} // DB를 연동할 수 있는 메소드를 생성
	*/
	
	// ds.getConnection(); 으로 실행
	@Override
	public boolean insert(BoardVO vo) {
		boolean flag = false;
		String sql = "INSERT INTO board VALUES(bid_seq.NEXTVAL, ?, ?, ?, sysdate)";
		// sysdate는 굳이 넣지 않아도 상관없음 그 대신 table뒤에 컬럼명을 각각 지정해줘야함
		// primary key인 board_id는 sequence로 지정했기 때문에 sequenceid명을 적어야함

		try {
			conn = ds.getConnection();
			// DB접속
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			// 값 넣어주기

			int rn = pstmt.executeUpdate();
			System.out.println(rn);
			// query 실행
			if (rn == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return flag;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> boardlist = new ArrayList<>();
		String sql = "SELECT * FROM board ORDER BY BOARD_ID ASC";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 데이터베이스 연결 및 쿼리 실행
			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("Board_ID"), rs.getString("WRITER"), rs.getString("TITLE"),
						rs.getString("CONTENT"), rs.getTimestamp("REG_DATE"));
				// 객체를 생성해서 값을 넣어줌
				boardlist.add(vo);
				// 객체를 객체 저장소인 boadlist에 넣어줌
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}

		return boardlist;
	}

	@Override
	public BoardVO selectOne(int num) {
		String sql = "SELECT * FROM board WHERE Board_ID = ?";
		BoardVO vo = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			// DB연결 수행 및 Query에 값을 넣어주고 Query 실행

			if (rs.next()) {
				vo = new BoardVO(rs.getInt("Board_ID"), rs.getString("WRITER"), rs.getString("TITLE"),
						rs.getString("CONTENT"), rs.getTimestamp("REG_DATE"));
			}
			// 값이 하나이므로 반복문보다는 조건문이 좋을 것 같음
			// if안에 객체를 생성하면 if가 끝나는 순간 객체가 사라지기 때문에 if 밖에 선언
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return vo;
		// 전역변수로 BoardVO 객체를 생성해주고 그 값을 try문에서 넣어주고 BoardVO 객체를 리턴

	}

	@Override
	public boolean update(BoardVO board) {
		boolean flag = false;
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?  WHERE WRITER = ?";
		try {
			conn = ds.getConnection();
			// DB접속
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			// sql query에 넣을 값을 지정
			// 작성자 이름을 기준으로 제목과 내용 수정

			int rn = pstmt.executeUpdate();
			System.out.println(rn);

			if (rn == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return flag;
	}

	@Override
	public boolean delete(int num) {
		boolean flag = false;
		String sql = "DELETE FROM BOARD WHERE BOARD_ID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int rn = pstmt.executeUpdate();
			
			if (rn == 1) {
				flag = true;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return flag;
	}
	
	@Override
	public boolean update1(BoardVO board) {
		boolean flag = false;
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?  WHERE BOARD_ID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardId());
			
			if (pstmt.executeUpdate() == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return flag;
	}
}
