package com.yema.mytestlibrary.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yema.mytestlibrary.R;
import com.yema.mytestlibrary.adapter.ReplayMultipleItem;
import com.yema.mytestlibrary.weight.ItemInPutClick;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<ReplayMultipleItem> mstrings;
    private Context context;


    public BAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return mstrings.get(position).getItemType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new AHolder(LayoutInflater.from(context).inflate(R.layout.itme_replay_layout, parent, false));
        } else if (viewType == 2) {
            return new BHolder(LayoutInflater.from(context).inflate(R.layout.itme_a_replay_b_layout, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (mstrings.get(position).getItemType() == 1) {
            ((AHolder)holder).tv_repla_nor.setText("asdas");

        } else if (mstrings.get(position).getItemType() == 2) {
            ((BHolder)holder).tv_repla_to.setText("啊大苏打实打实大");
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemInPutClick.itemClick2(position);

            }
        });
    }


    @Override
    public int getItemCount() {
        return mstrings == null ? 0 : mstrings.size();
    }



    public void updata(List<ReplayMultipleItem> strings) {
        this.mstrings = strings;
        notifyDataSetChanged();
    }

    public void adddata(ReplayMultipleItem strings, int position) {
        mstrings.add(strings);
        notifyDataSetChanged();
    }

    class AHolder extends RecyclerView.ViewHolder {


        private TextView tv_repla_nor;
        public AHolder(@NonNull View itemView) {
            super(itemView);
            tv_repla_nor = itemView.findViewById(R.id.tv_repla_nor);


        }
    }

    class BHolder extends RecyclerView.ViewHolder {
        private TextView tv_repla_to;

        public BHolder(@NonNull View itemView) {
            super(itemView);
            tv_repla_to = itemView.findViewById(R.id.tv_repla_to);

        }
    }

    public void setListener(ItemInPutClick listener) {
        this.itemInPutClick = listener;
    }

    private ItemInPutClick itemInPutClick;
}
