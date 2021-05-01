package FBworld.service;


import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import FBworld.models.memberDTO;
import FBworld.models.quizboardDTO;


public interface fbworldService {

	
	List<quizboardDTO> getQuizBoardList() throws Exception;
	
	List<memberDTO> getQuizRanking() throws Exception; 
	
	quizboardDTO getQuizDetail(long no) throws Exception;
	
	quizboardDTO getQuizDetail(long no, boolean readcount) throws Exception;
	
	void insertQuiz(quizboardDTO quizboardDTO) throws Exception;
	
	void deleteQuiz(quizboardDTO quizboardDTO) throws Exception;
	
	void updateQuiz(quizboardDTO quizboardDTO) throws Exception;
	
	void memberLogin(memberDTO memberDto) throws Exception;
	
	void memberJoin(memberDTO memberDto) throws Exception;
	
	String checkAnswer(long no) throws Exception;
	
//	void insertHitman(long memberDTO_no, long quizboardDTO_no, long score) throws Exception;
	
	void scoreHitman(String id, long score) throws Exception;
	
	void expirecheck(long id) throws Exception;
	
}
