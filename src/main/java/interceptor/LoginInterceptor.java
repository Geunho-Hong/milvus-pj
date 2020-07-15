package interceptor;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j
@Controller
public class LoginInterceptor extends HandlerInterceptorAdapter {

    // ModelAndView 는 데이터와 이동하고자 하는 View Page를 같이 저장한다.

    @Override
    public void postHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler,
                             ModelAndView modelAndView) throws Exception {

        HttpSession session = request.getSession();
        ModelMap modelMap = modelAndView.getModelMap();
        Object userDTO = modelMap.get("userDTO");

        log.info("postHandle");

        if(userDTO != null){
            log.info("login Success " + userDTO.toString());
            session.setAttribute("login",userDTO);
            response.sendRedirect("/index");
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session  = request.getSession();

        if(session.getAttribute("login") != null){
            // 기존 회원이 로그인한 상태라면 이를 삭제한다.
            log.info("Delete Login Data");
            session.removeAttribute("login");
        }

        return true;
    }
}
