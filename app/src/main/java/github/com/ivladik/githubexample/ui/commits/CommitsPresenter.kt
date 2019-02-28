package github.com.ivladik.githubexample.ui.commits

import android.annotation.SuppressLint
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import github.com.ivladik.githubexample.model.Commit
import github.com.ivladik.githubexample.model.CommitResponse
import github.com.ivladik.githubexample.repository.GithubRepository

@InjectViewState
class CommitsPresenter(
    private val repository: GithubRepository,
    private val repositoryName: String,
    private val userName: String
) : MvpPresenter<CommitsView>() {

    private val tag = javaClass::class.java.simpleName

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCommits()
    }

    @SuppressLint("CheckResult")
    private fun loadCommits() {
        repository.getCommits(userName, repositoryName)
            .map { mapToCommitsList(it) }
            .subscribe(
                { commits -> viewState.showCommits(commits) },
                { throwable -> Log.d(tag, throwable.message, throwable) }
            )
    }

    private fun mapToCommitsList(response: List<CommitResponse>): List<Commit> = response.map { it.commit }
}