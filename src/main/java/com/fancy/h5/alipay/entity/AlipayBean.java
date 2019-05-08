package com.fancy.h5.alipay.entity;

/**
 * @author: fangdaji
 * @date: 2019/5/8 21:03
 * @description:
 */
public class AlipayBean {

    /**
     * 商户订单号，商户网站订单系统中唯一订单号，必填
     */
    private String outTradeNo;

    /**
     * 付款金额，必填
     */
    private String totalAmount;

    /**
     * 订单名称，必填
     */
    private String subject;

    /**
     * 商品描述，可空
     */
    private String body;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
