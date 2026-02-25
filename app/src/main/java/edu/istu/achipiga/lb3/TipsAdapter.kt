package edu.istu.achipiga.lb3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(
    private val tips: List<Tip>,
    private val onTipClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(tips[position])
    }

    override fun getItemCount(): Int = tips.size

    inner class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val dayNumberView: TextView = itemView.findViewById(R.id.item_day_number)
        private val titleView: TextView = itemView.findViewById(R.id.item_title)
        private val imageView: ImageView = itemView.findViewById(R.id.item_image)
        private val shortDescriptionView: TextView = itemView.findViewById(R.id.item_short_description)

        init {
            itemView.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    onTipClick(tips[pos])
                }
            }
        }

        fun bind(tip: Tip) {
            val ctx = itemView.context
            dayNumberView.text = ctx.getString(R.string.day_label, tip.dayNumber)
            titleView.text = ctx.getString(tip.titleResId)
            imageView.setImageResource(tip.imageResId)
            shortDescriptionView.text = ctx.getString(tip.shortDescriptionResId)
        }
    }
}
