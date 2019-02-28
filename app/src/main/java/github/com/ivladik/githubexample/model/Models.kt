package github.com.ivladik.githubexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repository(
    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("stargazers_count")
    private val starsCount: Int,

    @Expose
    @SerializedName("forks_count")
    private val forksCount: Int
) {

    fun getStarsCount() = starsCount.toString()

    fun getForkCount() = forksCount.toString()
}

data class CommitResponse(
    @Expose
    @SerializedName("commit")
    val commit: Commit
)

data class Commit(
    @Expose
    @SerializedName("author")
    val author: Author,
    @Expose
    @SerializedName("message")
    val message: String
)

data class Author(
    @Expose
    @SerializedName("name")
    val name: String
)
