package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.TextMessage;
import com.tencent.wxcloudrun.service.WxService;
import com.tencent.wxcloudrun.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class WxServiceImpl implements WxService {

    final Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);

    @Override
    public void handleEvent(HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = null;
        try{
            inputStream = request.getInputStream();
            Map<String,Object> map = XmlUtils.xmlToMap(inputStream);
            String userOpenId = (String) map.get("FromUserName");
            String userName = (String) map.get("ToUserName");
            String event = (String) map.get("event");
            String msgType = (String) map.get("MsgType");
            if("text".equals(msgType)){
                logger.info("接收到了事件！！userOpenId:{},userName:{},event:{},msgType:{}",userOpenId,userName,event,msgType);
                String ticket = (String) map.get("Ticket");
                String mapToXml = handleEventSubscribe(map,userOpenId);
                response.getWriter().print(mapToXml);
                return;
            }else if("event".equals(msgType)){
                logger.info("接收到了事件！！");
            }
            logger.info("接收参数：{}", map);
        }catch (IOException e){
            logger.info("处理微信公众号请求异常: ",e);
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                }catch (IOException ioException){
                    logger.error("关闭inputStream 异常: ",ioException);
                }
            }
        }
    }

    private String handleEventSubscribe(Map<String, Object> map, String userOpenId) {
        logger.info("---开始封装xml---:" + map.toString());
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(map.get("FromUserName").toString());
        textMessage.setFromUserName(map.get("ToUserName").toString());
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setMsgType("text");
        textMessage.setContent("你好，欢迎关注XXX！\n" +
                "\n" +
                "关注XXX。立即登录PC端网址 \n"  +
                " 即可完成注册！\n" +
                "\n" +
                "或，" +
                "<a href='"  + "'>点击这里立即完成注册</a>");
        return getXmlString(textMessage);
    }

    public String getXmlString(TextMessage textMessage) {
        String xml = "";
        if (textMessage != null) {
            xml = "<xml>";
            xml += "<ToUserName><![CDATA[";
            xml += textMessage.getToUserName();
            xml += "]]></ToUserName>";
            xml += "<FromUserName><![CDATA[";
            xml += textMessage.getFromUserName();
            xml += "]]></FromUserName>";
            xml += "<CreateTime>";
            xml += textMessage.getCreateTime();
            xml += "</CreateTime>";
            xml += "<MsgType><![CDATA[";
            xml += textMessage.getMsgType();
            xml += "]]></MsgType>";
            xml += "<Content><![CDATA[";
            xml += textMessage.getContent();
            xml += "]]></Content>";
            xml += "</xml>";
        }
        return xml;
    }
}
