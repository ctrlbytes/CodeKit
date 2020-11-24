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
package com.ctrlbytes.codekit.ui.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.util.*

@Suppress("unused")
abstract class RViewAdapter<T, RVH : RViewHolder<T>> : RecyclerView.Adapter<RVH>() {

    private var items: MutableList<T> = ArrayList()
    private var mRViewListener: RViewListener<T>? = null

    fun getItemAt(position: Int): T {
        return items[position]
    }

    fun add(item: T) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun add(item: T, position: Int) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun addAll(items: List<T>) {
        for (item in items) {
            add(item)
        }
    }

    fun remove(item: T) {
        remove(items.indexOf(item))
    }

    fun remove(position: Int) {
        if (position > -1) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    val isEmpty: Boolean
        get() = itemCount == 0

    fun getItems(): List<T> {
        return items
    }

    fun setItems(mItems: MutableList<T>) {
        items = mItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RVH, position: Int) {
        val item = items[position]
        holder.onBind(item)
        mRViewListener?.let {
            holder.itemView.setOnClickListener { v: View ->
                it.onItemClick(position, item, v)
            }
            holder.itemView.setOnLongClickListener { v: View ->
                it.onItemLongClick(position, item, v)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setListener(listener: RViewListener<T>?) {
        mRViewListener = listener
    }
}