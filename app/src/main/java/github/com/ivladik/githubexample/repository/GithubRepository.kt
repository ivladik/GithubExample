package github.com.ivladik.githubexample.repository

import github.com.ivladik.githubexample.model.CommitResponse
import github.com.ivladik.githubexample.model.Repository
import io.reactivex.Flowable

interface GithubRepository {

    fun getRepositories(user: String): Flowable<List<Repository>>

    fun getCommits(user: String, repo: String): Flowable<List<CommitResponse>>
}