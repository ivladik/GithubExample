package github.com.ivladik.githubexample.ui.repositories

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import github.com.ivladik.githubexample.model.Repository

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepositoriesView : MvpView {

    fun showRepositories(repositories: List<Repository>)
}