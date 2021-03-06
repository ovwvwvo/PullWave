package com.ovwvwvo.pullwave.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ovwvwvo.jkit.utils.StringUtil;
import com.ovwvwvo.pullwave.R;
import com.ovwvwvo.pullwave.model.db.History;

import java.util.ArrayList;
import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Copyright ©2017 by rawer
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ItemHolder> {

    private OnClickListener listener;
    private ArrayList<History> models = new ArrayList<>();

    public HomeAdapter(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(
            parent.getContext()).inflate(R.layout.item_history, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.name.setText(models.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setModels(ListIterator<History> iterator) {
        while (iterator.hasNext())
            this.models.add(iterator.next());
        notifyDataSetChanged();
    }

    public void clear() {
        this.models.clear();
    }

    public interface OnClickListener {

        void onItemClick(String word);

        void onItemLongClick(String word);
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        AppCompatTextView name;

        ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.name)
        void onClick() {
            String word = name.getText().toString();
            if (listener != null && !StringUtil.isBlank(word))
                listener.onItemClick(word);
        }

        @OnLongClick(R.id.name)
        boolean onLongClick() {
            String word = name.getText().toString();
            if (listener != null && !StringUtil.isBlank(word))
                listener.onItemLongClick(word);
            return true;
        }
    }
}
