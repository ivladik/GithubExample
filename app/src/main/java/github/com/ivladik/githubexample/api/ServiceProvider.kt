package github.com.ivladik.githubexample.api

import github.com.ivladik.githubexample.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceProvider private constructor() {

    companion object {
        val githubService: GithubService by lazy {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_ENDPOINT)
                .build()

            retrofit.create(GithubService::class.java)
        }
    }
}