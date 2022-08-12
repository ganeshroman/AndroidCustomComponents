package com.example.customcomponents.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.customcomponents.interfaces.RecyclerViewItemClickListener;

import java.util.ArrayList;


/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will be Generic RecyclerView Adapter.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public abstract class GenericRecyclerViewAdapter extends RecyclerView.Adapter<GenericRecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<Object> list;
    private Context mcontext;
    private RecyclerViewItemClickListener listener;

    public GenericRecyclerViewAdapter(ArrayList<Object> list, Context mcontext, RecyclerViewItemClickListener listener) {
        this.list = list;
        this.mcontext = mcontext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewBinding binding = getCustomViewBinding(parent);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        binding.getRoot().setLayoutParams(lp);

        return new RecyclerViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        final int index = holder.getAdapterPosition();

        getCustomBindViewHolder(holder, list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onClickItemClick(view, holder.itemView, index, list.get(index));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder<T extends ViewBinding> extends RecyclerView.ViewHolder {
        public T view;

        public RecyclerViewHolder(T itemView) {
            super(itemView.getRoot());
            view = itemView;
        }
    }


    public abstract ViewBinding getCustomViewBinding(ViewGroup parent);

    public abstract void getCustomBindViewHolder(RecyclerViewHolder holder, Object model);

    /*ViewBinding getViewBinding(ViewGroup parent){ // make this abstract
        return RowDeliveryDetailsBinding.inflate(LayoutInflater.from(parent.getContext()));
    }

    public void getBindViewHolder(RecyclerViewHolder holder, Object model){

    }*/

}