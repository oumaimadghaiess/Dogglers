package com.oumaima.dogglers.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oumaima.dogglers.R
import com.oumaima.dogglers.const.Layout.GRID

import com.oumaima.dogglers.data.DataSource
import com.oumaima.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int,
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource
    private val dogs: List<Dog> = DataSource.dogs
    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
        val dogImage: ImageView =view!!.findViewById(R.id.dog_image)
        val dogName: TextView =view!!.findViewById(R.id.dog_name)
        val dogAge: TextView =view!!.findViewById(R.id.dog_age)
        val dogHobbies: TextView =view!!.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.

        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        val adepterLayout = when (layout){
            Layout.GRID-> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)
        }
        return DogCardViewHolder(adepterLayout)

    }

    override fun getItemCount(): Int = 0 // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val dog =dogs[position]
        // TODO: Set the image resource for the current dog
        holder.dogImage.setImageResource(dog.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.dogName.text=dog.name
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        holder.dogAge.text=resources?.getString(R.string.dog_age,dog.age)

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dogHobbies.text=resources?.getString(R.string.dog_hobbies,dog.hobbies)
    }
}
