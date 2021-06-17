package kz.madiyarapps.onaytestapplication.domain.response


import com.google.gson.annotations.SerializedName

data class TagsResponse(
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("items")
    val items: List<TagItem>,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
) {
    data class TagItem(
        @SerializedName("count")
        val count: Int,
        @SerializedName("has_synonyms")
        val hasSynonyms: Boolean,
        @SerializedName("is_moderator_only")
        val isModeratorOnly: Boolean,
        @SerializedName("is_required")
        val isRequired: Boolean,
        @SerializedName("name")
        val name: String
    )
}