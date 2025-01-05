package com.example.proiectpiu_managementfinanciar.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectpiu_managementfinanciar.R
import com.example.proiectpiu_managementfinanciar.models.Objective

class ObjectiveAdapter(private var objectives: List<Objective>) :
    RecyclerView.Adapter<ObjectiveAdapter.ObjectiveViewHolder>() {

    private var selectedPosition: Int = RecyclerView.NO_POSITION
    private var isSelectionLocked: Boolean = false


    inner class ObjectiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val objectiveIcon: ImageView = itemView.findViewById(R.id.objectiveIcon)
        val objectiveTitle: TextView = itemView.findViewById(R.id.objectiveTitle)
        val objectiveAmount: TextView = itemView.findViewById(R.id.objectiveAmount)
        val objectiveProgressBar: ProgressBar = itemView.findViewById(R.id.objectiveProgressBar)
        val completedCheckIcon: ImageView = itemView.findViewById(R.id.completedCheckIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.objective_item_activity, parent, false)
        return ObjectiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectiveViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val objective = objectives[position]
        holder.objectiveTitle.text = objective.denumire
        holder.objectiveAmount.text = "${objective.sumaCurenta} RON / ${objective.sumaTotala} RON"

        // Calculare procentaj progres
        val progressPercentage = if (objective.sumaTotala > 0) {
            (objective.sumaCurenta / objective.sumaTotala * 100).toInt()
        } else {
            0
        }
        holder.objectiveProgressBar.progress = progressPercentage

        when {
            objective.iconita != 0 -> holder.objectiveIcon.setImageResource(objective.iconita)
            else -> holder.objectiveIcon.setImageResource(R.drawable.object_icon) // Default icon
        }


        if (objective.sumaCurenta >= objective.sumaTotala) {
            holder.completedCheckIcon.visibility = View.VISIBLE
        } else {
            holder.completedCheckIcon.visibility = View.GONE
        }

        if (selectedPosition == position) {
            holder.itemView.setBackgroundResource(R.drawable.selected_objective_border)
        } else {
            holder.itemView.setBackgroundResource(R.drawable.objective_card_background)
        }

        holder.itemView.setOnClickListener {
            if (objective.sumaCurenta >= objective.sumaTotala) {
                Toast.makeText(holder.itemView.context, "Obiectiv deja atins!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isSelectionLocked) {
                val previousPosition = selectedPosition
                selectedPosition = position

                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)
            }
        }

    }

    override fun getItemCount(): Int = objectives.size

    fun getSelectedPosition(): Int {
        return selectedPosition
    }

    fun lockSelection() {
        isSelectionLocked = true
    }

    fun unlockSelection() {
        isSelectionLocked = false
        notifyItemChanged(selectedPosition)
        selectedPosition = RecyclerView.NO_POSITION
    }


    fun updateObjectives(newObjectives: List<Objective>) {
        objectives = newObjectives
        notifyDataSetChanged()
    }
}