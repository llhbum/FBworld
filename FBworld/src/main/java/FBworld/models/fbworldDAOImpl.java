package FBworld.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class fbworldDAOImpl implements fbworldDAO {
   
   private DataSource dataSource;
   private static final fbworldDAOImpl fbworldDao = new fbworldDAOImpl();
   private fbworldDAOImpl() {
      try {
         Context ctx = new InitialContext();
         dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/fbworld");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static fbworldDAOImpl getInstance() {
      return fbworldDao;
   }

@Override
public void memberLogin() throws SQLException {
	StringBuffer sql = new StringBuffer();
	sql.append("select password from member ");
	sql.append("where id=? and no=? ");
}

@Override
public List<quizboardDTO> getQuizBoardList() throws SQLException {
	StringBuffer sql = new StringBuffer();
	sql.append("select B.* ");
	sql.append("from(select rownum as rnum, A.* ");
	sql.append("	from(select no, title, regdate, expdate, readcount, expirecheck ");
	sql.append("		 from quizboard ");
	sql.append("	     order by no desc)A ) B ");
	sql.append("where rnum between 1 and 100 ");
	
	List<quizboardDTO> list = new ArrayList<>();
	
	try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					quizboardDTO quizboardDTO = new quizboardDTO();
					quizboardDTO.setNo(rs.getLong("no"));
					quizboardDTO.setTitle(rs.getString("title"));
					quizboardDTO.setRegdate(rs.getDate("regdate"));
					quizboardDTO.setExpdate(rs.getDate("expdate"));
					quizboardDTO.setReadcount(rs.getLong("readcount"));
					quizboardDTO.setExpirecheck(rs.getLong("expirecheck"));
					list.add(quizboardDTO);
				}
			}
		} 
		return list;
}

@Override
public List<memberDTO> getQuizRanking() throws SQLException {
	StringBuffer sql = new StringBuffer();
	sql.append("select no, nickname, score ");
	sql.append("from member ");
	sql.append("where rownum <= 10 ");
	sql.append("order by score desc ");
	
	List<memberDTO> list = new ArrayList<>();
	try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					memberDTO memberDto = new memberDTO();
					memberDto.setNo(rs.getLong("no"));
					memberDto.setNickname(rs.getString("nickname"));
					memberDto.setScore(rs.getLong("score"));
					list.add(memberDto);
				}
			}
		} 
	return list;
}

@Override
public void updateReadcount(long no) throws SQLException {
	StringBuffer sql = new StringBuffer();
	sql.append("update quizboard  ");
	sql.append("set readcount=readcount+1 ");
	sql.append("where no=? ");
	
	try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setLong(1, no);
			ps.executeUpdate();
		} 
}

@Override
public quizboardDTO getDetail(long no) throws SQLException {
	StringBuffer sql = new StringBuffer();
	sql.append("select no, title, content, imagepath,   ");
	sql.append("hint1, hint2, hint3, hint4, hint5, answer, readcount, expdate ");
	sql.append("from quizboard ");
	sql.append("where no=? ");

	quizboardDTO quizboardDTO = null;
	
	try (Connection conn = dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql.toString())){
		ps.setLong(1, no);
		try (ResultSet rs = ps.executeQuery()) {
			if(rs.next()) {
				quizboardDTO = new quizboardDTO();
				quizboardDTO.setNo(rs.getLong("no"));
				quizboardDTO.setTitle(rs.getString("title"));
				quizboardDTO.setContent(rs.getString("content"));
				quizboardDTO.setImagepath(rs.getString("imagepath"));
				quizboardDTO.setHint1(rs.getString("hint1"));
				quizboardDTO.setHint2(rs.getString("hint2"));
				quizboardDTO.setHint3(rs.getString("hint3"));
				quizboardDTO.setHint4(rs.getString("hint4"));
				quizboardDTO.setHint5(rs.getString("hint5"));
				quizboardDTO.setAnswer(rs.getString("answer"));
				quizboardDTO.setReadcount(rs.getLong("readcount"));
				quizboardDTO.setExpdate(rs.getDate("expdate"));
			}
		}
	} 
	return quizboardDTO;
}

@Override
public void insertQuiz(quizboardDTO quizboardDTO) throws SQLException {
	
   StringBuffer sql = new StringBuffer();
   sql.append("insert into quizboard(no,title,content,imagepath,   ");
   sql.append("hint1,hint2,hint3,hint4,hint5,answer) ");
   sql.append("values(seq_quizboard_no.nextval,?,?,?,?,?,?,?,?,?) ");
  
   try (Connection con = dataSource.getConnection();
         PreparedStatement ps = con.prepareStatement(sql.toString())){
      ps.setString(1, quizboardDTO.getTitle());
      ps.setString(2, quizboardDTO.getContent());
      ps.setString(3, quizboardDTO.getImagepath());
      ps.setString(4, quizboardDTO.getHint1());
      ps.setString(5, quizboardDTO.getHint2());
      ps.setString(6, quizboardDTO.getHint3());
      ps.setString(7, quizboardDTO.getHint4());
      ps.setString(8, quizboardDTO.getHint5());
      ps.setString(9, quizboardDTO.getAnswer());
      ps.executeUpdate();
   }
}

@Override
public int deleteQuiz(quizboardDTO quizboardDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from quizboard  ");
		sql.append("where no=?");
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
				pstmt.setLong(1, quizboardDTO.getNo());
				return pstmt.executeUpdate();
			}	
}

@Override
public int updateQuiz(quizboardDTO quizboardDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE quizboard SET ");
		sql.append("       title=?,     ");
		sql.append("      content=?,    ");
		sql.append("      hint1=?,      ");
		sql.append("      hint2=?,      ");
		sql.append("      hint3=?,      ");
		sql.append("      hint4=?,      ");
		sql.append("      hint5=?,      ");
		sql.append("      answer=?      ");
		sql.append("where no=? ");
	
		try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, quizboardDTO.getTitle());
			pstmt.setString(2, quizboardDTO.getContent());
			pstmt.setString(3, quizboardDTO.getHint1());
			pstmt.setString(4, quizboardDTO.getHint2());
			pstmt.setString(5, quizboardDTO.getHint3());
			pstmt.setString(6, quizboardDTO.getHint4());
			pstmt.setString(7, quizboardDTO.getHint5());
			pstmt.setString(8, quizboardDTO.getAnswer());
			pstmt.setLong(9, quizboardDTO.getNo());
			return pstmt.executeUpdate();
		}
}

@Override
public int memberLogin(memberDTO memberDto) throws SQLException {
	StringBuffer sql = new StringBuffer();
	sql.append("select password ");
	sql.append("from member ");
	sql.append("where id=? ");
	
	
	try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, memberDto.getId());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(memberDto.getPassword())) {
					System.out.println("memberLogin");
					return 1; // 로그인 성공
				}else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 존재하지 않는 오류
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //db오류
}

@Override
public void memberJoin(memberDTO memberDto) throws SQLException {
	
	   StringBuffer sql = new StringBuffer();
	   sql.append("insert into member(no, id, password, nickname)");
	   sql.append("values(seq_member_no.nextval,?,?,?) ");
	  
	   try (Connection con = dataSource.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql.toString())){
	      ps.setString(1, memberDto.getId());
	      ps.setString(2, memberDto.getPassword());
	      ps.setString(3, memberDto.getNickname());
	      ps.executeUpdate();
	   }
}



//   @Override
//   public void insertArticle(memberDTO articleDTO) throws SQLException {
//      StringBuffer sql = new StringBuffer();
//      sql.append("INSERT INTO t_board(no, title, name, password, content) ");
//      sql.append("VALUES(seq_board.nextval, ?, ?, ?, ?) ");
//      
//      try (Connection con = dataSource.getConnection();
//            PreparedStatement ps = con.prepareStatement(sql.toString())){
//         ps.setString(1, articleDTO.getTitle());
//         ps.setString(2, articleDTO.getName());
//         ps.setString(3, articleDTO.getPassword());
//         ps.setString(4, articleDTO.getContent());
//         ps.executeUpdate();
//      }
//   }
//
//	@Override
//	public List<memberDTO> getArticleList() throws SQLException {
//		StringBuffer sql = new StringBuffer();
//		sql.append("select B.* ");
//		sql.append("from  (select rownum as rnum, A.* ");
//		sql.append("       from  (select no, title, name, regdate, readcount from t_board ");
//		sql.append("              order by no desc) A) B ");
//		sql.append("where rnum between 1 and 10 ");
//
//		List<memberDTO> list = new ArrayList<>();
//		
//		try (Connection conn = dataSource.getConnection();
//			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
//			
//			try (ResultSet rs = ps.executeQuery()) {
//				while(rs.next()) {
//					memberDTO articleDTO = new memberDTO();
//					articleDTO.setNo(rs.getLong("no"));
//					articleDTO.setTitle(rs.getString("title"));
//					articleDTO.setName(rs.getString("name"));
//					articleDTO.setRegdate(rs.getDate("regdate"));
//					articleDTO.setReadcount(rs.getInt("readcount"));
//					list.add(articleDTO);
//				}
//			}
//		} 
//		return list;
//	}
//
//	@Override
//	public memberDTO getDetail(long no) throws SQLException {
//		StringBuffer sql = new StringBuffer();
//		sql.append("select no, title, name, regdate, readcount, content ");
//		sql.append("from   t_board ");
//		sql.append("where  no=? ");
//
//		memberDTO articleDTO = null;
//		
//		try (Connection conn = dataSource.getConnection();
//			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
//			ps.setLong(1, no);
//			try (ResultSet rs = ps.executeQuery()) {
//				if(rs.next()) {
//					articleDTO = new memberDTO();
//					articleDTO.setNo(rs.getLong("no"));
//					articleDTO.setTitle(rs.getString("title"));
//					articleDTO.setName(rs.getString("name"));
//					articleDTO.setRegdate(rs.getDate("regdate"));
//					articleDTO.setReadcount(rs.getInt("readcount"));
//					articleDTO.setContent(rs.getString("content"));
//				}
//			}
//		} 
//		return articleDTO;
//	}
//	
//	
//	@Override
//	public void updateReadcount(long no) throws SQLException {
//	}
//	
//	@Override
//	public int updateArticle(memberDTO articleDTO) throws SQLException {
//		StringBuffer sql = new StringBuffer();
//		sql.append("UPDATE t_board SET ");
//		sql.append("       title=?     ");
//		sql.append("      ,name=?      ");
//		sql.append("      ,content=?   ");
//		sql.append("WHERE  no=? AND password=? ");
//
//		try(Connection conn = dataSource.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
//			pstmt.setString(1, articleDTO.getTitle());
//			pstmt.setString(2, articleDTO.getName());
//			pstmt.setString(3, articleDTO.getContent());
//			pstmt.setLong(4, articleDTO.getNo());
//			pstmt.setString(5, articleDTO.getPassword());
//			return pstmt.executeUpdate();
//		}		
//	}
//
//	@Override
//	public int deleteArticle(memberDTO articleDTO) throws SQLException {
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete from t_board ");
//		sql.append("where no=? and password=?");
//		
//		try(Connection conn = dataSource.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
//				pstmt.setLong(1, articleDTO.getNo());
//				pstmt.setString(2, articleDTO.getPassword());
//				return pstmt.executeUpdate();
//			}	
//	}
}
