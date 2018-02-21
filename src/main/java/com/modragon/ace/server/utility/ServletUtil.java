package com.modragon.ace.server.utility;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.modragon.ace.server.utility.constants.ErrorCode;


public class ServletUtil {

	//服务器标识
	private static String hostName = "";

	//响应的ContentType内容
	private static final String RESPONSE_CONTENTTYPE = "text/html";

	//响应编码
	private static final String RESPONSE_CHARACTERENCODING = "utf-8";

	//业务名称的缩写
	private static final String BIZ_NAME = "";

	private static Logger log = Logger.getLogger(ServletUtil.class);

	static{
		try {
			//获取主机名称
			InetAddress netAddress = InetAddress.getLocalHost();
			hostName = netAddress.getHostName();
		} catch (UnknownHostException e) {
			log.error("netAddress.getHostName failed", e);
		}
	}
	
	/*****************************错误报文生成***********************************/
	/**
	 * 生成错误报文
	 * @param errorCode 错误码对象(http状态码，结果状态码，错误编码，错误信息)
	 * @param response
	 */
	public static String createErrorResponse(ErrorCode errorCode,
											 HttpServletResponse response){
		return createErrorResponse(errorCode.getHttpStatus(),errorCode.getRes_code(),errorCode.getCode(),
				errorCode.getMessage(),response);
	}
	
	/**
	 * 生成错误报文
	 * @param res_code 结果码（按http状态码规则）
	 * @param code 错误信息编码
	 * @param message 错误信息内容
	 * @param response
	 * @return
	 */
	public static String createErrorResponse(Integer res_code, Object code,
			String message, HttpServletResponse response) {
		return createErrorResponse(200,res_code,code,message,response);
	}
	
	/**
	 * 生成错误报文
	 * @param httpStatus http状态码
	 * @param res_code 结果码（按http状态码规则）
	 * @param code 错误信息编码
	 * @param message 错误信息内容
	 * @param response
	 * @return
	 */
	public static String createErrorResponse(Integer httpStatus,Integer res_code, Object code,
											 String message, HttpServletResponse response){
		code = BIZ_NAME + code;
		PrintWriter printWriter = null;
		String jsonString = "";
		try {
			response.setCharacterEncoding(RESPONSE_CHARACTERENCODING);
			response.setContentType(RESPONSE_CONTENTTYPE);
			response.setStatus(httpStatus);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", code);
			map.put("message", message);
			//map.put("request_id", requestId==null?"":requestId);
			//map.put("host_id", hostName);
			map.put("res_code", res_code);
			map.put("server_time", DateUtil.formatISO8601DateString(new Date()));

			printWriter = response.getWriter();
			jsonString = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
			printWriter.write(jsonString);
			printWriter.flush();
		} catch (Exception e) {
			log.error("createResponse failed", e);
		} finally {
			if(null!=printWriter)printWriter.close();
		}

		return jsonString;
	}
	

	/****************************************成功报文***************************************/
	/**
	 * 生成成功报文
	 * @param httpCode
	 * @param result
	 * @param response
	 */
	public static String createSuccessResponse(Integer httpCode, Object result, HttpServletResponse response){
		return createSuccessResponse(httpCode, result,SerializerFeature.WriteMapNullValue,null,response);
	}

	public static String createSuccessResponse(Integer httpCode,String message,Object result,HttpServletResponse response){

		return createSuccessResponse(httpCode,message,result,SerializerFeature.WriteMapNullValue,null,response);

	}

	public static String createSuccessResponse(Integer httpCode, Object result,SerializeFilter filter, HttpServletResponse response){

		return createSuccessResponse(httpCode, result,SerializerFeature.WriteMapNullValue,filter,response);

	}
	
	public static String createSuccessResponse(Integer httpCode, Object result,SerializerFeature serializerFeature, HttpServletResponse response){

		return createSuccessResponse(httpCode, result,serializerFeature,null,response);

	}

	public static String createSuccessResponse(Integer httpCode, Object result,SerializerFeature serializerFeature,SerializeFilter filter,HttpServletResponse response){
		PrintWriter printWriter = null;
		String jsonString = "";
		try {
			response.setCharacterEncoding(RESPONSE_CHARACTERENCODING);
			response.setContentType(RESPONSE_CONTENTTYPE);
			response.setStatus(httpCode);
			printWriter = response.getWriter();
			if(null != result){
				if(null!=filter){
					jsonString = JSONObject.toJSONString(result,filter,serializerFeature);
				}else{
					jsonString = JSONObject.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss",serializerFeature);
				}
				//System.out.println(jsonString);
				printWriter.write(jsonString); 
				
			}
			printWriter.flush();

		} catch (Exception e) {
			log.error("createResponse failed", e);
		} finally {
			if(null!=printWriter)printWriter.close();
		}
		return jsonString;
	}

	public static String createSuccessResponse(Integer httpCode,String message,Object result,SerializerFeature serializerFeature,SerializeFilter filter,HttpServletResponse response){
		PrintWriter printWriter = null;
		String jsonString = "";
		try {
			response.setCharacterEncoding(RESPONSE_CHARACTERENCODING);
			response.setContentType(RESPONSE_CONTENTTYPE);
			response.setStatus(httpCode);
			printWriter = response.getWriter();
			Map<String, Object> map = new HashMap<String, Object>();
			if(null != result){
				map.put("res_code", httpCode);
				map.put("message", message);
				map.put("data",result);
				if(null!=filter){
					jsonString = JSONObject.toJSONString(map,filter,serializerFeature);
				}else{
					jsonString = JSONObject.toJSONString(map, serializerFeature);
				}
				printWriter.write(jsonString);
			}
			printWriter.flush();

		} catch (Exception e) {
			log.error("createResponse failed", e);
		} finally {
			if(null!=printWriter)printWriter.close();
		}
		return jsonString;
	}
	/****************************************成功报文***************************************/
	
	/**
	 * 获取报文IP
	 * @param request
	 * @return
	 */
	public static String getRemortIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		if(ip.startsWith(",")){
			ip = ip.substring(1, ip.length());
		}

		return ip;
	}

	/**
	 * 获取带参数的URL串
	 */
	public static String getUrlWithParams(HttpServletRequest request) {
		String url = request.getRequestURI();

		if (StringUtils.isNotBlank(request.getQueryString())) {
			url = url + "?" + request.getQueryString();
		}

		return url;
	}

	/**
	 * 获取AccessToken
	 * @param request
	 * @return
	 */
	public static String getAccessToken(HttpServletRequest request){
		String accessToken = null;

		String authorization = request.getHeader("Authorization");
		if(StringUtils.isBlank(authorization)){
			return accessToken;
		}

		if(authorization.startsWith("MAC")){
			Pattern p = Pattern.compile("MAC id=\"(.*)\",nonce=\"(.*)\",mac=\"(.*)\"");
			Matcher m = p.matcher(authorization);
			if(m.find() && StringUtils.isNotBlank(m.group(1))){
				return m.group(1);
			}
		}else if(authorization.startsWith("Bearer")){
			Pattern p = Pattern.compile("Bearer \"(.*)\"");
			Matcher m = p.matcher(authorization);
			if(m.find() && StringUtils.isNotBlank(m.group(1))){
				return m.group(1);
			}
		}

		return accessToken;
	}

	/**
	 * 判断是否是Mac Token
	 * @param request
	 * @return
	 */
	public static boolean isExistMacToken(HttpServletRequest request){
		String authorization = request.getHeader("Authorization");
		if(StringUtils.isNotBlank(authorization) && authorization.startsWith("MAC id=")){
			return true;
		}

		return false;
	}
	
	/** 
	   * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址, 
	   * 
	   * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？ 
	   * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
	   * 
	   * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 
	   * 192.168.1.100 
	   * 
	   * 用户真实IP为： 192.168.1.110 
	   * 
	   * @param request 
	   * @return 
	   */
	  public static String getIpAddress(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	  }
	  
	  /**
		 * 设置让浏览器弹出下载对话框的Header.
		 * 根据浏览器的不同设置不同的编码格式  防止中文乱码
		 * @param fileName 下载后的文件名.
		 */
		public static void setFileDownloadHeader(HttpServletRequest request,HttpServletResponse response, String fileName) {
		    try {
		        //中文文件名支持
		        String encodedfileName = null;
		        String agent = request.getHeader("USER-AGENT");
		        if(null != agent && -1 != agent.indexOf("MSIE")){//IE
		            encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
		        }else if(null != agent && -1 != agent.indexOf("Mozilla")){
		            encodedfileName = new String (fileName.getBytes("UTF-8"),"iso-8859-1");
		        }else{
		            encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
		        }
		        response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
		        response.setContentType("application/force-download");
		    } catch (UnsupportedEncodingException e) {
		        e.printStackTrace();
		    }
		}

}
