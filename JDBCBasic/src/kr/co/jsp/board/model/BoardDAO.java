package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.jsp.score.model.ScoreVO;
import kr.co.jsp.util.JdbdUtil;

public class BoardDAO implements IBoardDAO {

	// 싱글톤 디자인 패턴 구축

	// 외부에서 객체 생성을 하지 못하고 접근하지 못하도록 하기 위해 private 작성
	private BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static BoardDAO dao = new BoardDAO();

	// BoardDAO에 접근하기 위해서는 getInstance()메소드를 통해서만 접근
	public static BoardDAO getInstance() {
		return dao;
	}

	//////////////////////////////////////////////

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "jsp";
		String upw = "jsp";

		return DriverManager.getConnection(url, uid, upw);
	} // DB를 연동할 수 있는 메소드를 생성

	@Override
	public boolean insert(BoardVO vo) {
		boolean flag = false;
		String sql = "INSERT INTO board VALUES(bid_seq.NEXTVAL, ?, ?, ?, sysdate)";
		// sysdate는 굳이 넣지 않아도 상관없음 그 대신 table뒤에 컬럼명을 각각 지정해줘야함

		try {
			conn = getConnection();
			// DB접속
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			// 값 넣어주기

			int rn = pstmt.executeUpdate();
			if (rn == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbdUtil.close(conn, pstmt);
		}

		return flag;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> boardlist = new ArrayList<>();
		String sql = "SELECT * FROM board ORDER BY BOARD_ID ASC";
		try {
			conn = getConnection();
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
			JdbdUtil.close(conn, pstmt);
		}

		return boardlist;
	}

	@Override
	public BoardVO selectOne(int num) {
		List<BoardVO> boardList = new ArrayList<>();
		String sql = "SELECT * FROM board WHERE Board_ID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
			BoardVO vo = new BoardVO(
					rs.getInt("Board_ID"),
					rs.getString("WRITER"), 
					rs.getString("TITLE"),
					rs.getString("CONTENT"),
					rs.getTimestamp("REG_DATE"));
			boardList.add(vo);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbdUtil.close(conn, pstmt);
		}
		return boardList;
		// =============================================================================================== 
		// 이거 다시 
		
	}

	@Override
	public boolean update(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int num) {
		// TODO Auto-generated method stub
		return false;
	}

}
