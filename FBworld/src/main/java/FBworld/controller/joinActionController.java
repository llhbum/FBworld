package FBworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;
import FBworld.models.memberDTO;
import FBworld.service.fbworldService;
import FBworld.service.fbworldServiceImpl;

public class joinActionController extends AbstractController{
	fbworldService fbworldService = fbworldServiceImpl.getInstance();

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		
		memberDTO memberDto = new memberDTO();
		memberDto.setId(id);
		memberDto.setPassword(password);
		memberDto.setNickname(nickname);
		
		ModelAndView mav = new ModelAndView();
		
		try {
			fbworldService.memberJoin(memberDto);
			mav.setViewName("redirect:login");
			mav.addObject("msg", "회원가입에 성공하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "중복된 ID입니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
