package FBworld.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import FBworld.models.fbworldDAO;
import FBworld.models.fbworldDAOImpl;
import FBworld.models.memberDTO;
import FBworld.models.quizboardDTO;



public class fbworldServiceImpl implements fbworldService{
	private static final fbworldService articleService = new fbworldServiceImpl();
	private fbworldDAO fbworldDao = fbworldDAOImpl.getInstance();
	
	
	private fbworldServiceImpl() {
		
	}
	
	public static fbworldService getInstance() {
		return articleService;
	}

	@Override
	public List<quizboardDTO> getQuizBoardList() throws Exception {
		return fbworldDao.getQuizBoardList();
	}
	
	@Override
	public List<memberDTO> getQuizRanking() throws Exception {
		return fbworldDao.getQuizRanking();
	}

	@Override
	public quizboardDTO getQuizDetail(long no) throws Exception {
		return getQuizDetail(no, true);
	}

	@Override
	public quizboardDTO getQuizDetail(long no, boolean updateReadcount) throws Exception {
		try {
			if (updateReadcount) fbworldDao.updateReadcount(no);
			
			quizboardDTO quizboardDTO = fbworldDao.getDetail(no);
			if (quizboardDTO == null) {
				throw new RuntimeException("상세보기 실패");
			}
			return quizboardDTO;
		} finally {}
	}

	@Override
	public void insertQuiz(quizboardDTO quizboardDTO) throws Exception {
		fbworldDao.insertQuiz(quizboardDTO);
	}

	@Override
	public void deleteQuiz(quizboardDTO quizboardDTO) throws Exception {
			if (fbworldDao.deleteQuiz(quizboardDTO) == 0) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
	}

	@Override
	public void updateQuiz(quizboardDTO quizboardDTO) throws Exception {
			if (fbworldDao.updateQuiz(quizboardDTO) == 0) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
	}

	@Override
	public void memberLogin(memberDTO memberDto) throws Exception {

		if(fbworldDao.memberLogin(memberDto) == 1 ) {
			System.out.println("로그인 성공");
		}else {
			throw new RuntimeException("로그인실패");
		}
	}

	@Override
	public void memberJoin(memberDTO memberDto) throws Exception {
		fbworldDao.memberJoin(memberDto);
	}

	@Override
	public String checkAnswer(long no) throws Exception {
		String answer = fbworldDao.checkAnswer(no);
		return answer;
	}

	@Override
	public void scoreHitman(String id , long score) throws Exception {
		if (fbworldDao.scoreHitman(id, score) == 0) {
			throw new RuntimeException("실패하였습니다.");
		}
	}

	@Override
	public void expirecheck(long id) throws Exception {
		if (fbworldDao.expirecheck(id) == 0) {
			throw new RuntimeException("실패하였습니다.");
		}
	}

	

}
