/*
 * MIT License
 *
 * Copyright (c) 2020 CtrlBytes Technologies
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.ctrlbytes.codekit.ui.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("unused")
public abstract class RViewAdapter<T, GVH extends RViewHolder<T>> extends RecyclerView.Adapter<GVH> implements
        RViewHolder.Callback {

    private List<T> items = new ArrayList<>();
    private RViewListener<T> mRViewListener;

    public T getItem(int position) {
        return items.get(position);
    }

    public void add(T item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void add(T item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void addAll(List<T> items) {
        for (T item : items) {
            add(item);
        }
    }

    public void remove(T item) {
        remove(items.indexOf(item));
    }

    public void remove(int position) {
        if (position > -1) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> mItems) {
        items = mItems;
        notifyDataSetChanged();
    }

    @Override
    public void onViewHolderClick(int position, View ItemView) {
        if (mRViewListener != null) {
            mRViewListener.onItemClick(position, getItem(position), ItemView);
        }
    }

    @Override
    public void onViewHolderLongClick(int position, View ItemView) {
        if (mRViewListener != null) {
            mRViewListener.onItemLongClick(position, getItem(position), ItemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull GVH holder, int position) {
        holder.onBind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setRViewListener(RViewListener<T> listener) {
        mRViewListener = listener;
    }

    protected View inflateView(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }
}