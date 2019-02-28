package github.com.ivladik.githubexample.ui.commits

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import github.com.ivladik.githubexample.R
import github.com.ivladik.githubexample.model.Commit
import github.com.ivladik.githubexample.repository.DefaultGithubRepository
import kotlinx.android.synthetic.main.ac_commits.*

class CommitsActivity : MvpAppCompatActivity(), CommitsView {

    @InjectPresenter
    lateinit var presenter: CommitsPresenter

    @ProvidePresenter
    fun providePresenter(): CommitsPresenter {
        val repositoryName = intent.getStringExtra(KEY_REPOSITORY_NAME)
        val userName = intent.getStringExtra(KEY_USER_NAME)
        return CommitsPresenter(DefaultGithubRepository.instance, repositoryName, userName)
    }

    private val adapter: CommitsAdapter by lazy { CommitsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_commits)
        initRecycler()
    }

    private fun initRecycler() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    override fun showCommits(commits: List<Commit>) {
        adapter.items = commits
    }

    companion object {

        private const val KEY_REPOSITORY_NAME = "KEY_REPOSITORY_NAME"
        private const val KEY_USER_NAME = "KEY_USER_NAME"

        fun makeIntent(context: Context, repositoryName: String, userName: String): Intent {
            return Intent(context, CommitsActivity::class.java).apply {
                putExtra(KEY_REPOSITORY_NAME, repositoryName)
                putExtra(KEY_USER_NAME, userName)
            }
        }
    }
}