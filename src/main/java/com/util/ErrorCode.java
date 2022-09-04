package com.util;

/**
 * 系统错误编码，根据业务定义如下
 * 用户部分编码以10000开始
 *
 *
 */
public class ErrorCode {

	/*认证模块错误码-start*/
	public final static String AUTH_UNKNOWN="10000";//注册失败
	public final static String AUTH_USER_ALREADY_EXISTS="10001";//注册失败，数据库链接异常
	public final static String AUTH_AUTHENTICATION_FAILED="10002";//激活失败用户没有注册
    public final static String AUTH_AUTHENTICATION_UPDATE="10003";//激活失败，验证码错误
	public final static String AUTH_PARAMETER_ERROR="10004";//激活失败，该用户已经激活
	public final static String AUTH_ACTIVATE_FAILED="10005";//激活失败，验证码过期重新发送
	public final static String AUTH_REPLACEMENT_FAILED="10006";//置换token失败
	public final static String AUTH_TOKEN_INVALID="10007";//token无效
	public static final String AUTH_ILLEGAL_USERCODE = "10008";//非法的用户名
	/*认证模块错误码-end*/
}
