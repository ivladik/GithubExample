package github.com.ivladik.githubexample.ui.repositories

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import github.com.ivladik.githubexample.BuildConfig
import github.com.ivladik.githubexample.R
import github.com.ivladik.githubexample.model.Repository
import github.com.ivladik.githubexample.repository.DefaultGithubRepository
import github.com.ivladik.githubexample.ui.commits.CommitsActivity
import kotlinx.android.synthetic.main.ac_repositories.*

class RepositoriesActivity : MvpAppCompatActivity(), RepositoriesView, RepositoriesAdapter.OnItemClickListener {

    @InjectPresenter
    lateinit var presenter: RepositoriesPresenter

    @ProvidePresenter
    fun providePresenter(): RepositoriesPresenter = RepositoriesPresenter(DefaultGithubRepository.instance)

    private val adapter: RepositoriesAdapter by lazy { RepositoriesAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_repositories)
        initRecycler()
    }

    private fun initRecycler() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    override fun showRepositories(repositories: List<Repository>) {
        adapter.items = repositories
    }

    override fun onRepositoryClick(repository: Repository) {
        startActivity(CommitsActivity.makeIntent(this, repository.name, BuildConfig.EXAMPLE_USER))
    }
}
