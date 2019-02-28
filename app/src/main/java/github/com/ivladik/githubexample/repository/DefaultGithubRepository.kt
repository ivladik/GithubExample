package github.com.ivladik.githubexample.repository

import github.com.ivladik.githubexample.api.ServiceProvider
import github.com.ivladik.githubexample.model.CommitResponse
import github.com.ivladik.githubexample.model.Repository
import github.com.ivladik.githubexample.utils.RxUtils
import io.reactivex.Flowable

class DefaultGithubRepository private constructor() : GithubRepository {

    override fun getRepositories(user: String): Flowable<List<Repository>> {
        return ServiceProvider.githubService
            .getRepositories(user)
            .compose(RxUtils.async())
    }

    override fun getCommits(user: String, repo: String): Flowable<List<CommitResponse>> {
        return ServiceProvider.githubService
            .getCommits(user, repo)
            .compose(RxUtils.async())
    }

    companion object {
        val instance: GithubRepository by lazy {
            DefaultGithubRepository()
        }
    }
}