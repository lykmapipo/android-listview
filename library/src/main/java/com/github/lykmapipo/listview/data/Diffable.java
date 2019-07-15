package com.github.lykmapipo.listview.data;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;

/**
 * A contract to be implemented by object that will be presented by
 * {@link androidx.paging.PagedListAdapter} or {@link androidx.recyclerview.widget.ListAdapter}
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public interface Diffable {

    /**
     * Callback that informs {@link androidx.paging.PagedListAdapter} how to compute
     * list updates when using {@link androidx.recyclerview.widget.DiffUtil} on a background thread.
     */
    ItemCallback<? extends Diffable> DIFF_CALLBACK = new ItemCallback<Diffable>() {
        /**
         * Called to decide whether two objects represent the same item.
         *
         * @param oldItem The item in the old list.
         * @param newItem The item in the new list.
         * @return True if the two items represent the same object or false if they are different.
         * @see androidx.recyclerview.widget.DiffUtil.Callback#areContentsTheSame(int, int)
         */
        @Override
        public boolean areItemsTheSame(@NonNull Diffable oldItem, @NonNull Diffable newItem) {
            return oldItem.getId().equals(newItem.getId());
        }


        /**
         * Called to decide whether two items have the same data. This information is used to detect if
         * the contents of an item have changed.
         *
         * @param oldItem The item in the old list.
         * @param newItem The item in the new list.
         * @return True if the contents of the items are the same or false if they are different.
         * @see androidx.recyclerview.widget.DiffUtil.Callback#areContentsTheSame(int, int)
         */
        @Override
        public boolean areContentsTheSame(@NonNull Diffable oldItem, @NonNull Diffable newItem) {
            return oldItem.equals(newItem);
        }
    };

    /**
     * Obtain valid stable id for the diffable item
     *
     * @return object id
     * @since 0.1.0
     */
    String getId();

    /**
     * Check if current diffable is same as the given diffable
     *
     * @param object compared diffable
     * @return true or false
     * @since 0.1.0
     */
    boolean equals(Object object);
}
