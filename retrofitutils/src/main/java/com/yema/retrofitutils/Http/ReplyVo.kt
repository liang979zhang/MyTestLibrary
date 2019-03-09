package com.yema.retrofitutils.model

import com.chad.library.adapter.base.entity.MultiItemEntity

class ReplyVo(val avatar: String, val fabulous: Int, private val id: String, val messageContent: String, val messageId: String,
              val messageTime: String
              , val messageUser: String, val nickName: String, val replyMessageId: String, val replyNickName: String, val replyUser: String, val type: String, val worksId: String) : MultiItemEntity {
    override fun getItemType(): Int {

        var mtype = if (type == "1") {
            1
        } else if (type == "2") {
            2
        } else {
            1
        }

        return mtype

    }


    companion object {
        @JvmField
        val NORME = 1
        @JvmField
        val TOMMAIN = 2
    }
}