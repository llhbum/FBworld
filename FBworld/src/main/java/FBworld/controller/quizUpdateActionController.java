package FBworld.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FBworld.fx.AbstractController;
import FBworld.fx.ModelAndView;
import FBworld.models.quizboardDTO;
import FBworld.service.fbworldService;
import FBworld.service.fbworldServiceImpl;


public class quizUpdateActionController extends AbstractController{
   private fbworldService fbworldService = fbworldServiceImpl.getInstance();

   @Override
   public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
      
      long no = Long.parseLong(request.getParameter("no"));
      String title = request.getParameter("title");
      String content = request.getParameter("content");
      String hint1 = request.getParameter("hint1");
      String hint2 = request.getParameter("hint2");
      String hint3 = request.getParameter("hint3");
      String hint4 = request.getParameter("hint4");
      String hint5 = request.getParameter("hint5");
      String answer = request.getParameter("answer");

      quizboardDTO quizboardDTO = new quizboardDTO();
      quizboardDTO.setTitle(title);
      quizboardDTO.setContent(content);
      quizboardDTO.setHint1(hint1);
      quizboardDTO.setHint2(hint2);
      quizboardDTO.setHint3(hint3);
      quizboardDTO.setHint4(hint4);
      quizboardDTO.setHint5(hint5);
      quizboardDTO.setAnswer(answer);
      
      ModelAndView mav = new ModelAndView();
      
      try {
         fbworldService.updateQuiz(quizboardDTO);
         mav.setViewName("/WEB-INF/views/result.jsp");
         mav.addObject("msg", "게시물이 수정되었습니다.");
         mav.addObject("url", "quizDetail?no=" + quizboardDTO.getNo());
      }catch (Exception e) {
         e.printStackTrace();
         mav.setViewName("/WEB-INF/views/result.jsp");
         mav.addObject("msg", "수정오류");
         mav.addObject("url", "javascript:history.back()");
      }
      
      return mav;
   }

}