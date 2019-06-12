package com.whaletail.testtask.base

import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoLogger

abstract class BaseAdapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>(), AnkoLogger {
}