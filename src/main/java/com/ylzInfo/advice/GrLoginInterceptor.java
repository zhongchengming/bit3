///*
//package com.ylzInfo.advice;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//public class GrLoginInterceptor extends HandlerInterceptorAdapter {
//
//	private List<String> exceptUrls;
//
//
//	public List<String> getExceptUrls() {
//		return exceptUrls;
//	}
//
//	public void setExceptUrls(List<String> exceptUrls) {
//		this.exceptUrls = exceptUrls;
//	}
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//
////		HandlerMethod handlerMethod = (HandlerMethod) handler;
////
////		String requestUri = request.getRequestURI();
////		String contextPath = request.getContextPath();
////		System.out.print(contextPath);
////		if(requestUri.startsWith(request.getContextPath())){
////			requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
////		}
////		for (String url:exceptUrls) {//设置不需要拦截的路径
////			if(url.endsWith("/**")){
////				if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
////					return true;
////				}
////			} else if (requestUri.startsWith(url)) {
////				return true;
////			}
////		}
////
////		String username = (String) request.getSession().getAttribute("username");
////		String password = (String) request.getSession().getAttribute("password");
////        //	判断是否登录 已登录不处理 未登录跳转至登录界面
////		if(StringUtils.equalsIgnoreCase(username,"admin")&&StringUtils.equalsIgnoreCase(password,"abcd123e45")){
////	     	return true;
////		}else {
////			response.sendRedirect(contextPath+"/index.jsp");
////			return false;
////		}
//		return true;
//	}
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//
//	}
//}
//*/
