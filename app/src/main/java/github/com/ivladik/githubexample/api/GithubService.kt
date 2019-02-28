package github.com.ivladik.githubexample.api

import github.com.ivladik.githubexample.model.CommitResponse
import github.com.ivladik.githubexample.model.Repository
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {

    @GET("/users/{user}/repos")
    fun getRepositories(@Path("user") user: String): Flowable<List<Repository>>

    @GET("/repos/{user}/{repo}/commits")
    fun getCommits(@Path("user") user: String, @Path("repo") repo: String): Flowable<List<CommitResponse>>
}