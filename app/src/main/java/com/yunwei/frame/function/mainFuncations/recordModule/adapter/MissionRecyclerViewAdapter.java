package com.yunwei.frame.function.mainFuncations.recordModule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunwei.frame.R;
import com.yunwei.frame.function.account.data.UserInfoEntity;
import com.yunwei.frame.base.BaseRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.mainFuncations.recordModule.adapter
 * @Description:
 * @date 2016/12/9 11:45
 */

public class MissionRecyclerViewAdapter extends BaseRecyclerViewAdapter<UserInfoEntity> {

    public MissionRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindBaseViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.itemMissionRecyclerViewTextView.setText(mLists.get(position).getName());
    }

    @Override
    public RecyclerView.ViewHolder onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new ItemViewHolder(inflater.inflate(R.layout.item_mission_recyclerview, parent, false));
        return viewHolder;
    }

    protected class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_mission_recyclerView_textView)
        TextView itemMissionRecyclerViewTextView;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(ItemViewHolder.this, view);
        }
    }
}
