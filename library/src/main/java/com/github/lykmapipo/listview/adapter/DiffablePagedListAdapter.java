package com.github.lykmapipo.listview.adapter;

import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView;

import com.github.lykmapipo.listview.data.Diffable;

import static com.github.lykmapipo.listview.data.Diffable.DIFF_CALLBACK;

/**
 * {@link RecyclerView RecyclerView.Adapter} base class for presenting {@link Diffable} paged
 * data from {@link androidx.paging.PagedList} in a {@link RecyclerView}
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public abstract class DiffablePagedListAdapter<P extends Diffable, VH extends RecyclerView.ViewHolder>
        extends PagedListAdapter<P, VH> {

    public DiffablePagedListAdapter() {
        super((ItemCallback<P>) DIFF_CALLBACK); //TODO generify without casting
    }

}
