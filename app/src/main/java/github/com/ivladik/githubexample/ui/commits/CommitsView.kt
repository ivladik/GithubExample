package github.com.ivladik.githubexample.ui.commits

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import github.com.ivladik.githubexample.model.Commit

@StateStrategyType(AddToEndSingleStrategy::class)
interface CommitsView : MvpView {

    fun showCommits(commits: List<Commit>)
}