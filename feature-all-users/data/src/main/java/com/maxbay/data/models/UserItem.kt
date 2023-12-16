package com.maxbay.data.models

import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName(value = "avatar_url")
    val avatarUrl: String,
    @SerializedName(value = "events_url")
    val eventsUrl: String,
    @SerializedName(value = "followers_url")
    val followersUrl: String,
    @SerializedName(value = "following_url")
    val followingUrl: String,
    @SerializedName(value = "gists_url")
    val gistsUrl: String,
    @SerializedName(value = "gravatar_id")
    val gravatarId: String,
    @SerializedName(value = "html_url")
    val htmlUrl: String,
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "login")
    val login: String,
    @SerializedName(value = "node_id")
    val nodeId: String,
    @SerializedName(value = "organizations_url")
    val organizationsUrl: String,
    @SerializedName(value = "received_events_url")
    val receivedEventsUrl: String,
    @SerializedName(value = "repos_url")
    val reposUrl: String,
    @SerializedName(value = "site_admin")
    val siteAdmin: Boolean,
    @SerializedName(value = "starred_url")
    val starredUrl: String,
    @SerializedName(value = "subscriptions_url")
    val subscriptionsUrl: String,
    @SerializedName(value = "type")
    val type: String,
    @SerializedName(value = "url")
    val url: String
)