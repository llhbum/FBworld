package FBworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;
import FBworld.models.quizboardDTO;
import FBworld.service.fbworldService;
import FBworld.service.fbworldServiceImpl;

public class quizDeleteActionController extends AbstractController{
	private fbworldService fbworldService = fbworldServiceImpl.getInstance();

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
	      
		long no = Long.parseLong(request.getParameter("no"));
//	      String title = request.getParameter("title");
//	      String name = request.getParameter("name");
//	      String password = request.getParameter("password");
//	      String content = request.getParameter("content");

	      quizboardDTO quizboardDTO = new quizboardDTO();
	      quizboardDTO.setNo(no);
//	      articleDTO.setTitle(title);
//	      articleDTO.setName(name);
//	      articleDTO.setContent(content);
	      
	      ModelAndView mav = new ModelAndView();
	      
	      try {
	    	  fbworldService.deleteQuiz(quizboardDTO);
	         mav.setViewName("/WEB-INF/views/result.jsp");
	         mav.addObject("msg", no + "번 게시물이 삭제되었습니다.");
	         mav.addObject("url", "board");
	      }catch (Exception e) {
	         e.printStackTrace();
	         mav.setViewName("/WEB-INF/views/result.jsp");
	         mav.addObject("msg", e.getMessage());
	         mav.addObject("url", "javascript:history.back()");
	      }
	      
	      return mav;
	}

	
}
