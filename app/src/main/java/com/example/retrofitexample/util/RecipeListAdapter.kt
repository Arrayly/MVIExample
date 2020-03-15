package com.example.retrofitexample.util

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.OnClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.retrofitexample.R
import com.example.retrofitexample.api.model.Food.Hit.Recipe
import kotlinx.android.synthetic.main.recipelist_item.view.recipe_image
import kotlinx.android.synthetic.main.recipelist_item.view.recipe_label

class RecipeListAdapter(private val interaction: Interaction? = null, private val context: Context? = null) :
    ListAdapter<Recipe, RecipeListAdapter.RecipeViewHolder>(RecipeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecipeViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recipelist_item, parent, false), interaction
    )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecipeViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            if (adapterPosition == RecyclerView.NO_POSITION) return

            interaction?.onItemSelected(adapterPosition, getItem(adapterPosition))
        }

        fun bind(item: Recipe) = with(itemView) {
            recipe_label.text = item.label
            Glide
                .with(context)
                .load(item.image)
                .into(recipe_image)
        }
    }

    interface Interaction {

        fun onItemSelected(position: Int, item: Recipe)
    }

    private class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
            return oldItem.label == newItem.label
        }

        override fun areContentsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ): Boolean {
            return oldItem == newItem
        }
    }
}