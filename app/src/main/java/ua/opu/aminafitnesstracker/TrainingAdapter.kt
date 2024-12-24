package ua.opu.aminafitnesstracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.opu.aminafitnesstracker.R


// Адаптер для списку тренувань
class TrainingAdapter(private val trainingList: List<Training>) : RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_training, parent, false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val training = trainingList[position]
        holder.bind(training)
    }

    override fun getItemCount(): Int = trainingList.size


    class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.trainingName)
        private val categoryTextView: TextView = itemView.findViewById(R.id.trainingCategory)

        fun bind(training: Training) {
            nameTextView.text = training.name
            categoryTextView.text = training.category
        }
    }
}
