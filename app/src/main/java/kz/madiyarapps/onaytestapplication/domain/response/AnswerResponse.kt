package kz.madiyarapps.onaytestapplication.domain.response


import com.google.gson.annotations.SerializedName

data class AnswerResponse(
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("items")
    val items: List<AnswerItem>,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
) {
    data class AnswerItem(
        @SerializedName("answer_id")
        val answerId: Int,
        @SerializedName("body")
        val body: String,
        @SerializedName("body_markdown")
        val bodyMarkdown: String,
        @SerializedName("comments")
        val comments: List<Comment>,
        @SerializedName("creation_date")
        val creationDate: Int,
        @SerializedName("is_accepted")
        val isAccepted: Boolean,
        @SerializedName("last_activity_date")
        val lastActivityDate: Int,
        @SerializedName("link")
        val link: String,
        @SerializedName("owner")
        val owner: Owner,
        @SerializedName("question_id")
        val questionId: Int,
        @SerializedName("score")
        val score: Int,
        @SerializedName("tags")
        val tags: List<Any>,
        @SerializedName("title")
        val title: String
    ) {
        data class Comment(
            @SerializedName("comment_id")
            val commentId: Int,
            @SerializedName("content_license")
            val contentLicense: String,
            @SerializedName("creation_date")
            val creationDate: Int,
            @SerializedName("edited")
            val edited: Boolean,
            @SerializedName("owner")
            val owner: Owner,
            @SerializedName("post_id")
            val postId: Int,
            @SerializedName("reply_to_user")
            val replyToUser: ReplyToUser,
            @SerializedName("score")
            val score: Int
        ) {
            data class Owner(
                @SerializedName("accept_rate")
                val acceptRate: Int,
                @SerializedName("display_name")
                val displayName: String,
                @SerializedName("link")
                val link: String,
                @SerializedName("profile_image")
                val profileImage: String,
                @SerializedName("reputation")
                val reputation: Int,
                @SerializedName("user_id")
                val userId: Int,
                @SerializedName("user_type")
                val userType: String
            )

            data class ReplyToUser(
                @SerializedName("accept_rate")
                val acceptRate: Int,
                @SerializedName("display_name")
                val displayName: String,
                @SerializedName("link")
                val link: String,
                @SerializedName("profile_image")
                val profileImage: String,
                @SerializedName("reputation")
                val reputation: Int,
                @SerializedName("user_id")
                val userId: Int,
                @SerializedName("user_type")
                val userType: String
            )
        }

        data class Owner(
            @SerializedName("display_name")
            val displayName: String,
            @SerializedName("link")
            val link: String,
            @SerializedName("profile_image")
            val profileImage: String,
            @SerializedName("reputation")
            val reputation: Int,
            @SerializedName("user_id")
            val userId: Int,
            @SerializedName("user_type")
            val userType: String
        )
    }
}