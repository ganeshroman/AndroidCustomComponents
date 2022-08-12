package com.example.customcomponents.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.example.customcomponents.databinding.RowTempItemBinding;
import com.example.customcomponents.interfaces.RecyclerViewItemClickListener;
import com.example.customcomponents.utils.GenericRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * @author Ganesh
 * <p>
 * This will be Custom Recyclerview
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class MyRecyclerviewAdapter extends GenericRecyclerViewAdapter {

    // you can use K  & V Generics to and also reduce next level of class to only one method i.e. binding of


    public MyRecyclerviewAdapter(ArrayList<Object> list, Context mcontext, RecyclerViewItemClickListener listener) {
        super(list, mcontext, listener);
    }

    @Override
    public ViewBinding getCustomViewBinding(ViewGroup parent) {
        return RowTempItemBinding.inflate(LayoutInflater.from(parent.getContext()));
    }

    @Override
    public void getCustomBindViewHolder(RecyclerViewHolder holder, Object model) {
        RowTempItemBinding view = (RowTempItemBinding) holder.view;
        // MyModel myModel=(MyModel) model;

    }

}
