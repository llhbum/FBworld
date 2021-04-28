package FBworld.models;

import java.sql.SQLException;
import java.util.List;


public interface fbworldDAO {

//	void insertArticle(memberDTO articleDTO) throws SQLException;
//
//	List<memberDTO> getArticleList() throws SQLException;
//
//	void updateReadcount(long no) throws SQLException;
//
//	memberDTO getDetail(long no) throws SQLException;
//
//	int updateArticle(memberDTO articleDTO) throws SQLException;
//	
//	int deleteArticle(memberDTO articleDTO) throws SQLException;
	
	void memberLogin() throws SQLException;
	
	List<quizboardDTO> getQuizBoardList() throws SQLException;
	
	List<memberDTO> getQuizRanking() throws SQLException;
	
	void updateReadcount(long no) throws SQLException;
	
	quizboardDTO getDetail(long no) throws SQLException;
	
	void insertQuiz(quizboardDTO quizboardDTO) throws SQLException;

	int deleteQuiz(quizboardDTO quizboardDTO) throws SQLException;

	int updateQuiz(quizboardDTO quizboardDTO) throws SQLException;
	
	int memberLogin(memberDTO memberDto) throws SQLException;
	
	void memberJoin(memberDTO memberDto) throws SQLException;

	
}
