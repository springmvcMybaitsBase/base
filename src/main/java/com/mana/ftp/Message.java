package com.mana.ftp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Desc: ajax请求响应信息模板
 * Author: tanshuai
 * Date: 14-3-13 下午4:49
 */
@Setter
@Getter
@ToString
public class Message {

    private boolean success = true;
    private String message;
    private String path;
    public static final Message EXCEPTION = new Message(false, "操作异常！");
    public static final Message SUCCESS = new Message(true, "操作成功");

    public Message() { }

    public Message(boolean success) {
        this.success = success;
    }

    public Message(String message) {
        this.message = message;
    }

    public Message(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    public Message(boolean success, String message,String path) {
        this.success = success;
        this.message = message;
        this.path = path;
    }

    /**
     * @param success true|false
     * @param messagePrefix 消息前缀，message = messagePrefix + (success ? "成功！" : "失败！")
     * @return Message
     */
    public static Message getInstance(boolean success, String messagePrefix) {
        return new Message(success, messagePrefix + (success ? "成功！" : "失败！"));
    }
}
