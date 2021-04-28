package FBworld.service;


import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import FBworld.models.memberDTO;
import FBworld.models.quizboardDTO;


public interface fbworldService {

//	void insertArticle(memberDTO articleDTO) throws Exception;
//
//	List<memberDTO> getArticleList() throws Exception;
//
//	memberDTO getDetail(long no, boolean updateReadcount) throws Exception;
//
//	memberDTO getDetail(long no) throws Exception;
//
//	void updateArticle(memberDTO articleDTO) throws Exception;
//	
//	void deleteArticle(memberDTO articleDTO) throws Exception;
	
	List<quizboardDTO> getQuizBoardList() throws Exception;
	
	List<memberDTO> getQuizRanking() throws Exception; 
	
	quizboardDTO getQuizDetail(long no) throws Exception;
	
	quizboardDTO getQuizDetail(long no, boolean readcount) throws Exception;
	
	void insertQuiz(quizboardDTO quizboardDTO) throws Exception;
	
	void deleteQuiz(quizboardDTO quizboardDTO) throws Exception;
	
	void updateQuiz(quizboardDTO quizboardDTO) throws Exception;
	
	void memberLogin(memberDTO memberDto) throws Exception;
	
	void memberJoin(memberDTO memberDto) throws Exception;
	
}
