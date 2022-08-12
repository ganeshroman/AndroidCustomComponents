package com.example.customcomponents.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

import kotlin.collections.CollectionsKt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public abstract class CommonAdapter extends RecyclerView.Adapter<ViewHolder> {


    private List mListItems;
    private OnClickListener mListener;


    public CommonAdapter() {
        this.mListItems = CollectionsKt.emptyList();
    }

    public CommonAdapter(@NotNull OnClickListener listener) {
        super();
        this.mListItems = CollectionsKt.emptyList();
        this.mListener = listener;
    }


    @NotNull
    public final List getMListItems() {
        return this.mListItems;
    }

    public final void setMListItems(@NotNull List var1) {
        this.mListItems = var1;
    }

    @Nullable
    public final OnClickListener getMListener() {
        return this.mListener;
    }

    public final void setMListener(@Nullable OnClickListener var1) {
        this.mListener = var1;
    }

    public final void setItems(@NotNull List listItems) {
        this.mListItems = listItems;
        this.notifyDataSetChanged();
    }

    public final void refreshRecyclerView() {
        this.notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        return this.getViewHolder(view, viewType);
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {

        ((CommonAdapter.Binder) holder).bind(this.mListItems.get(position));
        View view = holder.itemView;

        view.setTag(this.mListItems.get(position));

        if (this.mListener != null) {
            holder.itemView.setOnClickListener(this.mListener);
        }

    }

    public int getItemCount() {
        return this.mListItems.size();
    }

    public int getItemViewType(int position) {
        return this.getLayoutId(position, this.mListItems.get(position));
    }

    protected abstract int getLayoutId(int position, Object model);

    @NotNull
    public abstract ViewHolder getViewHolder(@NotNull View var1, int var2);

    public interface Binder {
        void bind(Object model);
    }
}

