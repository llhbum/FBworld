package FBworld.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;

public class joinController extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();   
		
		try {
			mav.setViewName("/WEB-INF/views/join.jsp");
			System.out.println(mav);
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return mav;
	}

}
