package FBworld.models;

import java.sql.SQLException;
import java.util.List;


public interface fbworldDAO {
	
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

	String checkAnswer(long no) throws SQLException;
	
//	void insertHitman(long memberDTO_no, long quizboardDTO_no, long score) throws SQLException;
	
	int scoreHitman(String id, long score) throws SQLException;
	
	int expirecheck(long no) throws SQLException;
	

	
}
