package github.com.ivladik.githubexample.ui.repositories

import android.annotation.SuppressLint
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import github.com.ivladik.githubexample.BuildConfig
import github.com.ivladik.githubexample.repository.GithubRepository

@InjectViewState
class RepositoriesPresenter(private val repository: GithubRepository) : MvpPresenter<RepositoriesView>() {

    private val tag = javaClass::class.java.simpleName

    override fun onFirstViewAttach() {
        loadRepositories()
    }

    @SuppressLint("CheckResult")
    private fun loadRepositories() {
        repository.getRepositories(BuildConfig.EXAMPLE_USER)
            .subscribe(
                { repositories -> viewState.showRepositories(repositories) },
                { throwable -> Log.d(tag, throwable.message, throwable) }
            )
    }
}