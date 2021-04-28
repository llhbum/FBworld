package FBworld.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;
import FBworld.models.fbworldDAOImpl;
import FBworld.models.memberDTO;
import FBworld.models.quizboardDTO;
import FBworld.service.fbworldService;
import FBworld.service.fbworldServiceImpl;
import jdk.internal.org.jline.utils.Log;


public class boardController extends AbstractController{
	private fbworldService fbworldService = fbworldServiceImpl.getInstance();
	
//	private static Logger logger = Logger.getLogger(boardController.class);
//	private static Logger logger = LoggerFactory.getLogger(boardController.class);
	
   @Override
   public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
	   
	ModelAndView mav = new ModelAndView(); 
//	logger.info("log4j test");
	
   try {
		List<quizboardDTO> quizboardList = fbworldService.getQuizBoardList();
		for(quizboardDTO dto : quizboardList) {
			break;
		}
		
		List<memberDTO> memberList = fbworldService.getQuizRanking();
		for(memberDTO dto : memberList) {
			break;
		}
		
		mav.setViewName("/WEB-INF/views/quizBoard.jsp");
		mav.addObject("quizBoardDto", quizboardList);
		mav.addObject("memberDto", memberList);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return mav;
   }

}