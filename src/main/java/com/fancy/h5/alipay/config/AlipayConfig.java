package com.fancy.h5.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "";

	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "";

	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";

	// 请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";

	// 编码
	public static String CHARSET = "UTF-8";

	// 返回格式
	public static String FORMAT = "json";

	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvhyekrFy6ggkpe+Cpy8J9uSanF/ZN8KD6iWio9bQK8jkclLmXuVkMx44UXLPnFEltxJfEpVCs6hY/BLEnk9ECACFeuZNvMrfLD5Hx6UGoUHa5Ph2xy0NyQ+gdCjgp6h3J9M34gbh0whlmGUqiCMywYIjpFlNKF5YCuX9NKY+Plja2Nq5fysxP150Cnaa+9j7qu3KVTUKnhaU5lax2wF40/j7H0v41QQIvdMKyElcRfNjiGbrvY4jyAmPiykYZ5j1zTScn03oPakCx2LjUdD+eBVrHYjzOBeWD071Y92sfst0omj4xxJm8gwn7mr7m66/fSMnGIGI/gvaNDmh133SSwIDAQAB";

	// 日志记录目录
	public static String log_path = "/log";

	// RSA2
	public static String SIGNTYPE = "RSA2";
}
