package com.yema.mytestlibrary.adapter

import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yema.mytestlibrary.R
import com.yema.mytestlibrary.weight.ItemInPutClick


/**
 * 回复内容
 */
class CommentAdapter() : BaseQuickAdapter<CommentData, BaseViewHolder>(R.layout.item_comment_mian_layout) {


    lateinit var itemInPutClick: ItemInPutClick
    override fun convert(helper: BaseViewHolder?, item: CommentData?) {
        var replayAdapter = ReplayAdapter()
        var rl_content = helper!!.getView<RecyclerView>(R.id.rl_content)
        rl_content.tag = helper.adapterPosition
        rl_content.layoutManager = LinearLayoutManager(mContext)
        if (rl_content.tag == helper.adapterPosition) {
            rl_content.adapter = replayAdapter
        }

        replayAdapter.setNewData(item!!.getStrings().subList(0, 3))
        if (replayAdapter.data.size > 2) {
            helper!!.setVisible(R.id.ll_replay_show, true)
            helper!!.setVisible(R.id.ll_contene_hint, true)

        } else {
            helper!!.setVisible(R.id.ll_replay_show, false)
        }

        replayAdapter.setOnItemClickListener { adapter, view, position ->
//            itemInPutClick.itemClick(adapter,position)
            var temolist = mutableListOf<ReplayMultipleItem>()

            temolist.addAll(item.getStrings())
            temolist.add(ReplayMultipleItem(2, "asdadas", "asdas", "asdasdsa"))
            val commentData1 = CommentData(item.content, temolist)
            data.set(helper.adapterPosition, commentData1)


//            replayAdapter.addData(ReplayMultipleItem(2, "asdasdasdasd是大大说", "我", "他"))
            this@CommentAdapter.notifyItemChanged(helper.adapterPosition)


        }

        helper.getView<LinearLayout>(R.id.ll_replay_show).setOnClickListener {
            item.isIsshow = !item.isshow
            if (item.isshow) {
                helper.setVisible(R.id.ll_contene_hint, item.isshow)
                helper!!.setVisible(R.id.ll_replay_show, !item.isIsshow)

                if (rl_content.tag == helper.adapterPosition) {
                    replayAdapter.setNewData(item!!.getStrings())
                }

            }


        }
        helper.getView<LinearLayout>(R.id.ll_contene_hint).setOnClickListener {
            if (item.isshow) {
                helper!!.setVisible(R.id.ll_replay_show, item.isIsshow)
                helper.setVisible(R.id.ll_contene_hint, !item.isshow)
                if (rl_content.tag == helper.adapterPosition) {
                    replayAdapter.setNewData(item!!.getStrings().subList(0, 3))
                }

            }


        }
        helper.setVisible(R.id.ll_contene_hint, item.isshow)
    }


    fun setInputClick(itemInPutClick: ItemInPutClick) {
        this.itemInPutClick = itemInPutClick
    }
}