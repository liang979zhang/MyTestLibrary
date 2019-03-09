package com.yema.retrofitutils.Http;

import com.yema.retrofitutils.model.ReplyVo;

import java.util.List;

public class CommentWorksListBean {


    public boolean isshow = false;  //是否展开
    private String avatar;
    private int fabulous;
    private String id;
    private String messageContent;
    private String messageId;
    private String messageTime;
    private String messageUser;
    private String nickName;
    private String replyMessageId;
    private String replyUser;
    private String type;
    private String worksId;
    private List<ReplyVo> replyVo;

    public boolean isIsshow() {
        return isshow;
    }

    public void setIsshow(boolean isshow) {
        this.isshow = isshow;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getFabulous() {
        return fabulous;
    }

    public void setFabulous(int fabulous) {
        this.fabulous = fabulous;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getReplyMessageId() {
        return replyMessageId;
    }

    public void setReplyMessageId(String replyMessageId) {
        this.replyMessageId = replyMessageId;
    }

    public String getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorksId() {
        return worksId;
    }

    public void setWorksId(String worksId) {
        this.worksId = worksId;
    }

    public List<ReplyVo> getReplyVo() {
        return replyVo;
    }

    public void setReplyVo(List<ReplyVo> replyVo) {
        this.replyVo = replyVo;
    }
}
