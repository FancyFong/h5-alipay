package com.fancy.h5.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.fancy.h5.alipay.config.AlipayConfig;
import com.fancy.h5.alipay.entity.AlipayBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fangdaji
 * @date: 2019/5/8 20:59
 * @description:
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    /**
     * 支付宝手机网站支付
     *
     * @param alipayBean
     * @return
     */
    @RequestMapping(value = "/web/alipay", method = RequestMethod.POST)
    public String webAlipay(@RequestBody AlipayBean alipayBean) {

        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
        //调用RSA签名方式
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayModel model = getAlipayTradeWapPayModel(alipayBean);

        // 设置请求支付信息
        alipayRequest.setBizModel(model);
        // 设置异步通知地址
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        // 设置同步地址
        alipayRequest.setReturnUrl(AlipayConfig.return_url);

        // form表单生产
        String form = "";
        try {
            // 调用SDK生成表单
            form = client.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            System.out.printf("调用SDK生成表单异常");
        }

        return form;
    }

    /**
     * 封装请求支付信息
     *
     * @param alipayBean
     * @return
     */
    private AlipayTradeWapPayModel getAlipayTradeWapPayModel(AlipayBean alipayBean) {

        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        // 商户订单号，商户网站订单系统中唯一订单号，必填
        model.setOutTradeNo(alipayBean.getOutTradeNo());
        // 订单名称，必填
        model.setSubject(alipayBean.getSubject());
        // 付款金额，必填
        model.setTotalAmount(alipayBean.getTotalAmount());
        // 商品描述，可空
        model.setBody(alipayBean.getBody());
        // 超时时间 可空
        model.setTimeoutExpress("2m");
        // 销售产品码 必填
        model.setProductCode("QUICK_WAP_WAY");
        return model;
    }


}
