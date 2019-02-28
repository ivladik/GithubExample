package github.com.ivladik.githubexample.ui.repositories

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import github.com.ivladik.githubexample.R
import github.com.ivladik.githubexample.model.Repository
import github.com.ivladik.githubexample.utils.inflate
import github.com.ivladik.githubexample.utils.visibleOrInvisible
import kotlinx.android.synthetic.main.li_repository.view.*

class RepositoriesAdapter(onClickListener: OnItemClickListener)
    : RecyclerView.Adapter<RepositoriesAdapter.RepositoriesHolder>() {

    var items: List<Repository> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    private val internalClickListener = View.OnClickListener {
        val position = it.tag as Int
        onClickListener.onRepositoryClick(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesHolder {
        return RepositoriesHolder(parent.inflate(R.layout.li_repository))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RepositoriesHolder, position: Int) {
        holder.bind(items[position], position, items.lastIndex == position)
    }

    interface OnItemClickListener {

        fun onRepositoryClick(repository: Repository)
    }

    inner class RepositoriesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(repository: Repository, position: Int, isPositionLast: Boolean) {
            with(itemView) {
                name.text = repository.name
                starsAmount.text = repository.getStarsCount()
                forksAmount.text = repository.getForkCount()
                divider.visibleOrInvisible(!isPositionLast)
                tag = position
                container.setOnClickListener(internalClickListener)
            }
        }
    }
}