package com.sun.wechat.controller;

import com.sun.wechat.util.AesException;
import com.sun.wechat.util.WXBizJsonMsgCrypt;
import com.sun.wechat.util.XmlToJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;

@RestController
@RequestMapping("callback")
@Slf4j
public class WeChatUserCallBackController {
    @Value("${wechat.token}")
    String token;
    @Value("${wechat.encodingAESKey}")
    String encodingAESKey;
    @Value("${wechat.corpId}")
    String corpId;

    /**
     * 配置回调
     * @param request
     * @return
     */
    @GetMapping("/verify")
    public String doGetVerify(HttpServletRequest request){
        // 微信加密签名
        String msg_signature = request.getParameter("msg_signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        log.info("验证路径:{},路径验证为参数：msg_signature:{},timestamp:{},nonce:{},echostr:{}",request.getRequestURL(),msg_signature,timestamp ,nonce,echostr);
        String result = null;
        try {
            WXBizJsonMsgCrypt wxBizJsonMsgCrypt = new WXBizJsonMsgCrypt(token, encodingAESKey, corpId);
            //检验url的合法性，并能正确返回密文参数对应的明文字符串，则验证通过，否则失败
            result = wxBizJsonMsgCrypt.VerifyURL(msg_signature, timestamp, nonce, echostr);
        } catch (AesException e) {
            log.info("验证异常code:{},错误信息:{}",e.getCode(),e.getMessage());
        }
        return result;
    }

    /**
     * 进行回调事件
     * @param request
     * @return
     */
    @PostMapping("/verify")
    public String doPostVerify(HttpServletRequest request) throws Exception{
        Enumeration enu=request.getParameterNames();

        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            log.info("key:{},value:{}",paraName,request.getParameter(paraName));
        }
        // 企业微信加密签名，msg_signature结合了企业填写的token、请求中的timestamp、nonce参数、加密的消息体
        String msg_signature = request.getParameter("msg_signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        log.info("验证路径:{},消息验证数据为,msg_signature:{},timestamp:{},nonce:{},echostr:{}",request.getRequestURL(),msg_signature,timestamp ,nonce);

        String result = null;
        //1.获取加密的请求消息：使用输入流获得加密请求消息postData
        ServletInputStream in = request.getInputStream();
        try {
            // 密文，对应POST请求的数据
            String postData="";
            BufferedReader reader =new BufferedReader(new InputStreamReader(in));
            //作为输出字符串的临时串，用于判断是否读取完毕
            String tempStr="";
            while(null!=(tempStr=reader.readLine())){
                postData+=tempStr;
            }
            //针对不同的场景，出入不同的receiveId进行数据的解密
            WXBizJsonMsgCrypt wxBizJsonMsgCrypt = new WXBizJsonMsgCrypt(token, encodingAESKey, corpId);
            if (!StringUtils.isEmpty(postData)){
                postData= XmlToJson.xmlToJson(postData);
                result = wxBizJsonMsgCrypt.DecryptMsg(msg_signature, timestamp, nonce, postData);
            }
            log.info("解密数据：{}",XmlToJson.xmlToJson(result));
            //异步处理业务逻辑,如果失败了就记录，定时拉去数据
        } catch (AesException e) {
            log.info("验证异常code:{},错误信息:{}",e.getCode(),e.getMessage());
        }finally {
            in.close();
        }
        return result;
    }
}
