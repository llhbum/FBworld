package FBworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;
import FBworld.models.memberDTO;
import FBworld.models.quizboardDTO;
import FBworld.service.fbworldService;
import FBworld.service.fbworldServiceImpl;

public class answerController extends AbstractController {
	fbworldService fbworldService = fbworldServiceImpl.getInstance();

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String answer = request.getParameter("answer");
		long no = Long.parseLong(request.getParameter("no"));
		long score = Long.parseLong(request.getParameter("score"));
//		System.out.println(score);// ok
		
		HttpSession session = request.getSession(true);
		String id = (String)session.getAttribute("id");
//		System.out.println(id); //user01
		
		ModelAndView mav = new ModelAndView();   
		
		try {
			if(answer.equals(fbworldService.checkAnswer(no))){
				System.out.println("정답입니다. ");
				fbworldService.scoreHitman(id, score);
				fbworldService.expirecheck(no);
				mav.setViewName("/WEB-INF/views/result2.jsp");
				mav.addObject("msg", "정답입니다.");
				
			}else {
				System.out.println("오답입니다.");
				mav.setViewName("/WEB-INF/views/result2.jsp");
				mav.addObject("msg", "오답입니다.");
			}
		} catch (Exception e) {
		     e.printStackTrace();
	         mav.setViewName("/WEB-INF/views/result2.jsp");
	         mav.addObject("msg","Exception입니다.");
	         mav.addObject("url", "javascript:history.back();");

		}
	    return mav;
	}
	

}
