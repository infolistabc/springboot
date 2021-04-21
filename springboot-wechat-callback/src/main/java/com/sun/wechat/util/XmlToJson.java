package com.sun.wechat.util;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
@Slf4j
public class XmlToJson {
    /**
     * xml字符串转json字符串
     *
     * @param xml
     */
    public static String xmlToJson(String xml) {
        /* 第一种方法，使用JSON-JAVA提供的方法 */
        //将xml转为json
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        //设置缩进
        String jsonPrettyPrintString = xmlJSONObj.get("xml").toString();
        return jsonPrettyPrintString;
    }

    public static void main(String[] args) {
        //String json = xmlToJson("<xml><ToUserName><![CDATA[ww15a75a9b988f8a18]]></ToUserName><Encrypt><![CDATA[DdTV95o7pT8jjdcfhpg3yAbdVcWJS9nVgx7hECMcRaEsa4RRWAIv4j26dP5qP9S0GTD+zczP/6KpoDOO4ZpCZ0vD5h5bG4Ix7KoWk84zLJUWUtgCJgc0xYKM72FF4CbLiepKPyj+KPnq8Ty3m+FmOkMCZS09R5Kr3Gzv/O0Hr1ewgYdm4PETOKjSxp7zwxTk/aXLpRyVbvdY0/OSA9XdtMeeJ7He6/68EVn8b21yRAhCnG4islejKwl4zs6N5jMerQlJ/mrNH754Wfb+Pm4d3YKI2KrY9BkjRnEPqwchab7ErGQSn64ep6nknhXZYL5GMbcmwfbJHE8oplnke+5KgWS7TZOReZqXIYaOsGPJnV8P7zTXMLOHtgYsLOiwXFSc7WHMTYhPqyOxooLBzc77UZC8Q6U72L2YYBifaFPeBSSAPEGeSNVNocBiGyuivZC6s7cF2NCxKCpr35NOb5neTSWC7qpkymabwJ8NyDAMXt3HG9LbZk4x8PCoNzuVNSgxxFjbVn7JeuoHWg5nTBI7xhQHhusF9NzTzBxcagk6ZdfRn3ERSHjVwcL6gZEDtOIeaejbHFMHNP1fmr5DQdk4MO+HcT6pYxHz3t5DIctoAPAo7e8vkoJBmv1R+WCXO8fm]]></Encrypt><AgentID><![CDATA[]]></AgentID></xml>");
        //System.out.printf(json);
        String json1 = xmlToJson("<xml><ToUserName><![CDATA[ww15a75a9b988f8a18]]></ToUserName><FromUserName><![CDATA[sys]]></FromUserName><CreateTime>1618999036</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[change_contact]]></Event><ChangeType><![CDATA[update_user]]></ChangeType><UserID><![CDATA[lisi]]></UserID><Alias><![CDATA[lisi01]]></Alias></xml>");
        System.out.println(json1);
    }

}
