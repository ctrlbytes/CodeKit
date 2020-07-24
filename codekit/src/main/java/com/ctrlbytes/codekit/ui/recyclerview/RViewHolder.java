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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("unused")
public abstract class RViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private Callback mCallback;

    public RViewHolder(ViewGroup parent, int resId, Callback callback) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        if (callback != null) {
            this.mCallback = callback;
            this.itemView.setOnClickListener(this);
            this.itemView.setOnLongClickListener(this);
        }
    }

    public RViewHolder(View itemView, Callback callback) {
        super(itemView);
        if (callback != null) {
            this.mCallback = callback;
            this.itemView.setOnClickListener(this);
            this.itemView.setOnLongClickListener(this);
        }
    }

    @Override
    public void onClick(View mView) {
        if (mCallback != null) {
            mCallback.onViewHolderClick(getAbsoluteAdapterPosition(), itemView);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mCallback != null) {
            mCallback.onViewHolderLongClick(getAbsoluteAdapterPosition(), itemView);
            return true;
        }
        return false;
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public final String getString(int resId) {
        return getContext().getString(resId);
    }

    public abstract void onBind(T item);

    public interface Callback {
        void onViewHolderClick(int position, View ItemView);

        void onViewHolderLongClick(int position, View ItemView);
    }
}
