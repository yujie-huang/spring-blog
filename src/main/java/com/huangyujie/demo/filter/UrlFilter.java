package com.huangyujie.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "UrlFilter",urlPatterns = {"/*"})
public class UrlFilter implements Filter {

	
	   //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"login","index","showArticle","user","search","css","image","js","layui","uploadImges","getuserbyid","getarticlebytitle"};
    
    
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) servletRequest;
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        HttpSession session = request.getSession(false);
	        String uri = request.getRequestURI();

	        System.out.println("filter url:"+uri);
	        //是否需要过滤
	        boolean needFilter = isNeedFilter(uri);


	        if (!needFilter) { //不需要过滤直接传给下一个过滤器
	            filterChain.doFilter(servletRequest, servletResponse);
	        } else { //需要过滤器
	            // session中包含user对象,则是登录状态
	          if(session!=null&&(session.getAttribute("userName") != null || session.getAttribute("admin") != null || session.getAttribute("suadmin") != null)){
	                // System.out.println("user:"+session.getAttribute("user"));
	                filterChain.doFilter(request, response);
	            }else{
	                String requestType = request.getHeader("X-Requested-With");
	                //判断是否是ajax请求
	                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
	                    response.getWriter().write("0");
	                }else{
	                    //重定向到登录页
	                    response.sendRedirect("login");
	                }
	               
	            }
	        }

	}
	
	 public boolean isNeedFilter(String uri) {

	        for (String includeUrl : includeUrls) {
	            if(uri.contains(includeUrl)||uri.equals("/")) {
	                return false;
	            }
	        }

	        return true;
	    }


}
