package com.github.lykmapipo.listview.adapter;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.github.lykmapipo.listview.data.Diffable;

import static com.github.lykmapipo.listview.data.Diffable.DIFF_CALLBACK;

/**
 * {@link RecyclerView.Adapter RecyclerView.Adapter} base class for presenting {@link Diffable}
 * list data in a {@link RecyclerView}, including computing diffs between lists
 * on a background thread.
 *
 * @param <P>  Type of the Lists this Adapter will receive.
 * @param <VH> A class that extends ViewHolder that will be used by the adapter.
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public abstract class DiffableListAdapter<P extends Diffable, VH extends RecyclerView.ViewHolder>
        extends ListAdapter<P, VH> {

    public DiffableListAdapter() {
        super((ItemCallback<P>) DIFF_CALLBACK); //TODO generify without casting
    }

}
