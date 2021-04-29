package FBworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;
import FBworld.models.memberDTO;
import FBworld.service.fbworldService;
import FBworld.service.fbworldServiceImpl;

public class loginActionController extends AbstractController{
	fbworldService fbworldService = fbworldServiceImpl.getInstance();

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("id", id);
		
		memberDTO memberDto = new memberDTO();
		memberDto.setId(id);
		memberDto.setPassword(password);
		
		ModelAndView mav = new ModelAndView();
		
		try {
			fbworldService.memberLogin(memberDto);
			mav.setViewName("redirect:board");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "아이디가 존재하지 않거나 비밀번호가 틀렸습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
