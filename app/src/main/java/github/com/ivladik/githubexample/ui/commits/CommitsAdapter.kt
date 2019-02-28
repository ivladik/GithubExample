package github.com.ivladik.githubexample.ui.commits

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import github.com.ivladik.githubexample.R
import github.com.ivladik.githubexample.model.Commit
import github.com.ivladik.githubexample.utils.inflate
import github.com.ivladik.githubexample.utils.visibleOrInvisible
import kotlinx.android.synthetic.main.li_commit.view.*

class CommitsAdapter : RecyclerView.Adapter<CommitsAdapter.CommitsHolder>() {

    var items: List<Commit> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitsHolder {
        return CommitsHolder(parent.inflate(R.layout.li_commit))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CommitsHolder, position: Int) {
        holder.bind(items[position], items.lastIndex == position)
    }

    inner class CommitsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(commit: Commit, isPositionLast: Boolean) {
            with (itemView) {
                authorName.text = commit.author.name
                message.text = commit.message
                divider.visibleOrInvisible(!isPositionLast)
            }
        }
    }
}