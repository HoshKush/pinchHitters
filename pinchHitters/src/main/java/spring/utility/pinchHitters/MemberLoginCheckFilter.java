package spring.utility.pinchHitters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MemberLoginCheckFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Filterê°? ?š”ì²? ì¤‘ê°„?—?„œ requestê°ì²´ë¥? ì¶”ì¶œ?•©?‹ˆ?‹¤.
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// ?ƒˆë¡œìš´ ?„¸?…˜?„ ?ƒ?„±?•˜ì§? ?•Šê³? request ê°ì²´?—?„œ ê¸°ì¡´?˜ ?„¸?…˜ ë°˜í™˜
		HttpSession session = httpRequest.getSession(false);

		String id = request.getParameter("id");
		String sid = (String) session.getAttribute("id");

		// ë¡œê·¸?¸ ?•˜ì§? ?•Š?‹¸?‹¤ê³? ê°?? •
		boolean login = false;

		if (session != null) {// session ê°ì²´ê°? ?ƒ?„±?˜?–´ ?ˆ?Š”ì§? ?™•?¸
			// ë¡œê·¸?¸?„ ?–ˆ?œ¼ë©´ì„œ ê´?ë¦¬ì?¸ì§? ?™•?¸?•©?‹ˆ?‹¤.
			if (sid != null && sid.equals("admin")) {
				login = true;// ê´?ë¦¬ì ?™•?¸
			} else if (sid != null && (id == null || sid.equals(id))) {
				login = true;
			}
		}
		// ? •?ƒ? ?œ¼ë¡? ë¡œê·¸?¸?´ ?˜?—ˆ?‹¤ë©? ?š”ì²? ?˜?´ì§?ë¡? ?´?™?•©?‹ˆ?‹¤
		if (login) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/login.do");
			dispatcher.forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
