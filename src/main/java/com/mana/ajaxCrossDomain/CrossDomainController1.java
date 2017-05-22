package com.mana.ajaxCrossDomain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 讲这个应用部署到两个不同端口号的tomcat上，互相访问
 * 模拟ajax跨域请求，服务器1：设置启动的端口号为：8080，请求的端口号为：8081
 * 跨域：
 * 	协议://小域名.大域名:端口号   ：有一个不一样就属于跨域问题
 * @author user
 */
@Controller
@RequestMapping("/ajaxCrossDomain")
public class CrossDomainController1 {
	 
	/**
	 * 正常请求
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/requestAjax")
	@ResponseBody
	public String getInfo(HttpServletRequest request,HttpServletResponse response){
		return "success";
	}
	
	/**
	 * ajax跨域请求时的设置：XHR方法：
	 * 优点:HTML5支持的，缺点：ie 10及以下不支持，如果是手机端应用，那么就可以使用这个了
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/requestAjax1")
	@ResponseBody
	public String getInfo1(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");  //表示可以接受任何域的请求
//      response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,token");  
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,token"); // 加入支持自定义的header 加入元素 token 前端就可以发送自定义token过来  
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
        response.setHeader("X-Powered-By"," 3.2.1");  
        response.setHeader("Content-Type", "application/json;charset=utf-8");  
		return "success";
	}
	
	/**
	 * jsonp方式跨域请求:缺点:只支持Get请求
	 */
	@RequestMapping(value="/requestAjax2")
	@ResponseBody
	public String getInfo2(HttpServletRequest request,HttpServletResponse response){
		String callbackFunName = request.getParameter("callbackparam");
		return callbackFunName + "([ { \"name\":\"John\"}])"; 
	}
	
	
	

}
