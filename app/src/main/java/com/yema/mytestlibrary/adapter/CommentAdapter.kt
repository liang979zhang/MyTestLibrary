package com.yema.mytestlibrary.adapter

import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yema.mytestlibrary.R


/**
 * 回复内容
 */
class CommentAdapter() : BaseQuickAdapter<CommentData, BaseViewHolder>(R.layout.item_comment_mian_layout) {

    lateinit var replayAdapter: ReplayAdapter
    override fun convert(helper: BaseViewHolder?, item: CommentData?) {
        replayAdapter = ReplayAdapter()
        var rl_content = helper!!.getView<RecyclerView>(R.id.rl_content)
        rl_content.layoutManager = LinearLayoutManager(mContext)
        rl_content.adapter = replayAdapter
        replayAdapter.setNewData(item!!.getStrings().subList(0, 2))
        if (item!!.strings.size > 2) {
            helper!!.setVisible(R.id.ll_replay_show, true)
        } else {
            helper!!.setVisible(R.id.ll_replay_show, true)
        }

        var ll_replay_show = helper.getView<LinearLayout>(R.id.ll_replay_show)
        ll_replay_show.setOnClickListener {
            if (item.isshow) {
                helper!!.setVisible(R.id.ll_replay_show, !item.isIsshow)
                replayAdapter.setNewData(item!!.getStrings().subList(0, 2))
            } else {
                replayAdapter.setNewData(item!!.getStrings())
                helper.setVisible(R.id.ll_contene_hint, item.isshow)
            }
            item.isIsshow = true

        }


        helper.setVisible(R.id.ll_contene_hint, item.isshow)


    }
}