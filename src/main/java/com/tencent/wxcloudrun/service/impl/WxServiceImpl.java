package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.TextMessage;
import com.tencent.wxcloudrun.model.WeChatLog;
import com.tencent.wxcloudrun.service.NameGenerationService;
import com.tencent.wxcloudrun.service.WeChatLogService;
import com.tencent.wxcloudrun.service.WeChatSessionService;
import com.tencent.wxcloudrun.service.WxService;
import com.tencent.wxcloudrun.utils.WeChatUtils;
import com.tencent.wxcloudrun.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class WxServiceImpl implements WxService {

    final Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);

    @Autowired
    private NameGenerationService nameGenerationService;

    @Autowired
    private WeChatLogService weChatLogService;

    @Autowired
    private WeChatSessionService weChatSessionService;

    @Override
    public void handleEvent(HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = null;
        try{
            inputStream = request.getInputStream();
            Map<String,Object> map = XmlUtils.xmlToMap(inputStream);
            logger.info("handleEvent map is :{}",map);
            String userOpenId = (String) map.get("FromUserName");
            String userName = (String) map.get("ToUserName");
            String event = (String) map.get("event");
            String msgType = (String) map.get("MsgType");
            addLog(userOpenId,userName,event,msgType,map.get("Content").toString());
            if("text".equals(msgType)){
                logger.info("接收到了事件！！userOpenId:{},userName:{},event:{},msgType:{}",userOpenId,userName,event,msgType);
                String ticket = (String) map.get("Ticket");
                String mapToXml = handleEventSubscribe(map,userOpenId);
                response.getWriter().print(mapToXml);
                return;
            }else if("event".equals(msgType)){
                logger.info("接收到了事件！！");
            }
            //logger.info("接收参数：{}", map);
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

    /*
     * 收集对话日志
     * */
    private void addLog(String userOpenId, String userName, String event, String msgType,String content) {
        WeChatLog weChatLog = new WeChatLog();
        weChatLog.setUserId(userOpenId);
        weChatLog.setUserName(userName);
        weChatLog.setMsgType(msgType);
        weChatLog.setContext(content);
        weChatLog.setEvent(event);
        weChatLogService.addLog(weChatLog);
    }

    private String handleEventSubscribe(Map<String, Object> map, String userOpenId) {
        logger.info("---开始封装xml---:" + map.toString());
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(map.get("FromUserName").toString());
        textMessage.setFromUserName(map.get("ToUserName").toString());
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setMsgType("text");
        textMessage.setContent(getContentByReq(map.get("Content").toString()));
        return WeChatUtils.getXmlString(textMessage);
    }

    public String getContentByReq(String content){
        if("功能".equals(content)){
            return "1.取名 \n" +
                   "2.<a href='\"https://springboot-jhx8-1412-4-1313045077.sh.run.tcloudbase.com/index.html\"'>取名工具 </a> \n" +
                   "回复相应功能使用！";
        }
        if("取名".equals(content)){
            return "请输入姓氏,性别(逗号隔开)";
        }
        try {
            if (content.contains(",")) {
                String[] strs = content.split("，");
                if (strs[1].equals("男")) {
                    return nameGenerationService.getName(strs[0], 1, 1).get(0);
                } else if (strs[1].equals("女")) {
                    return nameGenerationService.getName(strs[0], 2, 1).get(0);
                } else {
                    return "格式异常！\n" +
                            "eg: 梁，女";
                }
            }
        }catch (Exception e){
            logger.error("异常对话：{}",content);
            e.printStackTrace();
        }
        if("取名链接".equals(content)){
            return "取名链接: "+"<a href='\"https://springboot-jhx8-1412-4-1313045077.sh.run.tcloudbase.com/index.html\"'>取名工具 </a>";
        }
        return "欢迎关注eather_liang!回复 \"功能\"获取公众号功能列表";
    }

    private String getFunctionByUserIdAndContent(String fromUserName, String content) {

        //weChatSessionService.

       /* switch (content){
            case "取名": return generationName(fromUserName);break;
            case "笑话": return takeAJoke();break;
            case "我的收藏" : return myCollection(fromUserName);break;
            case "带排期" : return "敬请期待!!";break;
            default: return "欢迎关注eather_liang!查看功能请回复\"功能\"";
        }*/
        return null;
    }


    /*private String handleEventSubscribe2(Map<String, Object> map, String userOpenId) {
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
        return WeChatUtils.getXmlString(textMessage);
    }*/

}
