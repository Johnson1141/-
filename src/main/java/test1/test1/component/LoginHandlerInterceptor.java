package test1.test1.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
//登录检查
public class LoginHandlerInterceptor implements HandlerInterceptor {

    private List<String> url = new ArrayList();

    //执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("userId");
        //System.out.println(user);
        if(user==null){
            response.sendRedirect("loginPage");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    public List<String> getUrl(){

        url.add("/loginPage");      //登录页
        url.add("/login");   //登录action URL
        url.add("/test");
        //网站静态资源
        url.add("/js/**");
        url.add("/css/**");
        url.add("/lib/**");
        url.add("/layui/**");
        url.add("/x-admin/**");
        return url;
    }

}
