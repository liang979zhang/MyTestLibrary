package com.yema.retrofitutils.Http;

import java.util.List;

public class CommentListModel {


    /**
     * code : 200
     * commentWorksList : [{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":12,"id":"1085442324545458176","messageContent":"我是评论发起者杰斯","messageId":"","messageTime":"2019-01-22 13:43:06","messageUser":"1085442324545458176","nickName":"杰斯","replyMessageId":"","replyUser":"","replyVo":[{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":10,"id":"1085463572946161664","messageContent":"我在杰斯下面回复了，我是炸弹人","messageId":"1087586428124348416","messageTime":"2019-02-17 10:06:41","messageUser":"1085463572946161664","nickName":"炸弹人","replyMessageId":"","replyNickName":"","replyUser":"","type":"2","worksId":"1087606131731857407"},{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/1551349553038.jpg","fabulous":10,"id":"1089037745180045312","messageContent":"我在杰斯的下面回复炸弹人，我是亮哥","messageId":"1087586428124348416","messageTime":"2019-02-18 14:43:00","messageUser":"1089037745180045312","nickName":"亮哥","replyMessageId":"1087625676334993408","replyNickName":"炸弹人","replyUser":"1085463572946161664","type":"2","worksId":"1087606131731857407"},{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":10,"id":"1100243718038360064","messageContent":"我也在杰斯下面回复了,我是洛霞","messageId":"1087586428124348416","messageTime":"2019-02-18 14:43:00","messageUser":"1100243718038360064","nickName":"洛霞","replyMessageId":"","replyNickName":"","replyUser":"","type":"2","worksId":"1087606131731857407"}],"type":"1","worksId":"1087606131731857407"},{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":12,"id":"1085470683812306944","messageContent":"我是评论发起者提莫","messageId":"","messageTime":"2019-01-22 13:43:06","messageUser":"1085470683812306944","nickName":"提莫","replyMessageId":"","replyUser":"","replyVo":[{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":12,"id":"1085470683812306944","messageContent":"我在提莫下面回复了，我是提莫","messageId":"1187586428124348521","messageTime":"2019-01-22 13:43:06","messageUser":"1085470683812306944","nickName":"提莫","replyMessageId":"","replyNickName":"","replyUser":"","type":"2","worksId":"1087606131731857407"},{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":12,"id":"1095560619803287552","messageContent":"我在提莫下面回复了提莫，我是兰博","messageId":"1187586428124348521","messageTime":"2019-01-22 13:43:06","messageUser":"1095560619803287552","nickName":"兰博","replyMessageId":"1187586428124348522","replyNickName":"提莫","replyUser":"1085470683812306944","type":"2","worksId":"1087606131731857407"},{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":12,"id":"1095562267137155072","messageContent":"我在提莫下面回复了，我是盖伦","messageId":"1187586428124348521","messageTime":"2019-01-22 13:43:06","messageUser":"1095562267137155072","nickName":"盖伦","replyMessageId":"","replyNickName":"","replyUser":"","type":"2","worksId":"1087606131731857407"},{"avatar":"https://cp-short-video-1258603426.cos.ap-shanghai.myqcloud.com/image/head.jpg","fabulous":12,"id":"1095583310231040000","messageContent":"我在提莫下面回复了，我是剑圣","messageId":"1187586428124348521","messageTime":"2019-01-22 13:43:06","messageUser":"1095583310231040000","nickName":"剑圣","replyMessageId":"","replyNickName":"","replyUser":"","type":"2","worksId":"1087606131731857407"}],"type":"1","worksId":"1087606131731857407"}]
     * lastPageFlag : false
     * msg : 获取评论成功
     */

    private int code;
    public boolean lastPageFlag;
    private String msg;
    private List<CommentWorksListBean> commentWorksList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isLastPageFlag() {
        return lastPageFlag;
    }

    public void setLastPageFlag(boolean lastPageFlag) {
        this.lastPageFlag = lastPageFlag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CommentWorksListBean> getCommentWorksList() {
        return commentWorksList;
    }

    public void setCommentWorksList(List<CommentWorksListBean> commentWorksList) {
        this.commentWorksList = commentWorksList;
    }

}
