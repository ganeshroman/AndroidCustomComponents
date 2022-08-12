package com.example.customcomponents.interfaces;

import android.view.View;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * Generic OnClickListener for the RecyclerView Item.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public interface RecyclerViewItemClickListener {

    public void onClickItemClick(View view, View itemView, int position, Object object);

}
