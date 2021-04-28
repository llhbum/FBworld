package FBworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;
import FBworld.models.quizboardDTO;
import FBworld.service.fbworldService;
import FBworld.service.fbworldServiceImpl;

public class quizUpdateController extends AbstractController {
	private fbworldService fbworldService = fbworldServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		try {
			quizboardDTO quizboardDTO = fbworldService.getQuizDetail(no, false);
			return new ModelAndView("/WEB-INF/views/quizUpdate.jsp", "quizboardDTO", quizboardDTO);
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}
}