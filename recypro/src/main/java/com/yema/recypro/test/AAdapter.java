package com.yema.recypro.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.yema.recypro.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AAdapter extends RecyclerView.Adapter<AAdapter.Holder> {
    private Context mContext;
    private List<CommentData> commentDatas;
    private ItemInPutClick itemInPutClick;

    public AAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(mContext, LayoutInflater.from(mContext).inflate(R.layout.item_comment_mian_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int positiona) {

        final CommentData commentData = commentDatas.get(positiona);

        holder.tv_com_content.setText(commentData.content+positiona);

        if (commentData.strings.size() > 2) {
            holder.ll_replay_show.setVisibility(View.VISIBLE);
            holder.ll_contene_hint.setVisibility(View.VISIBLE);
        } else {
            holder.ll_replay_show.setVisibility(View.GONE);
        }
        holder.bAdapter.updata(commentDatas.get(positiona).strings.subList(0,2));


        holder.bAdapter.setListener(new ItemInPutClick() {
            @Override
            public void itemClick2(int position) {

                List<ReplayMultipleItem> replayMultipleItems = new ArrayList<>();
                replayMultipleItems.addAll(commentData.getStrings());
                replayMultipleItems.add(new ReplayMultipleItem(2, "asdadas", "asdas", "asdasdsa"));
                CommentData commentData1 = new CommentData(commentData.content, replayMultipleItems);
                commentDatas.set(positiona, commentData1);
//                commentData.getStrings().add(new ReplayMultipleItem(2, "asdadas", "asdas", "asdasdsa"));
//                holder.bAdapter.adddata(new ReplayMultipleItem(2, "asdadas", "asdas", "asdasdsa"), position);
                AAdapter.this.notifyItemChanged(positiona);
            }
        });
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return commentDatas == null ? 0 : commentDatas.size();
    }

    public void setNewData(List<CommentData> testList) {
        this.commentDatas = testList;
//        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void updata(int po, CommentData testList) {
//        commentDatas.add(testList);
//        commentDatas.add(po, testList);
//        commentDatas.get(po).getStrings().add(new ReplayMultipleItem(2, "asdadas", "asdas", "asdasdsa"));
//        notifyItemChanged(po);
    }

    class Holder extends RecyclerView.ViewHolder {


        private TextView tv_com_content;
        private RecyclerView rl_content;
        private LinearLayout ll_replay_show, ll_contene_hint;
        private BAdapter bAdapter;

        public Holder(Context mContext, @NonNull View itemView) {
            super(itemView);

            tv_com_content = itemView.findViewById(R.id.tv_com_content);
            rl_content = itemView.findViewById(R.id.rl_content);
            ll_replay_show = itemView.findViewById(R.id.ll_replay_show);
            ll_contene_hint = itemView.findViewById(R.id.ll_contene_hint);
            bAdapter = new BAdapter(mContext);
            rl_content.setLayoutManager(new LinearLayoutManager(AAdapter.this.mContext));
            rl_content.setAdapter(bAdapter);

        }
    }


    public void setListtener(ItemInPutClick listtener) {
        this.itemInPutClick = listtener;
    }


}
