package com.ayulest.latihanmp2.model

import com.google.gson.annotations.SerializedName

data class Post(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("release_date")
	val userId: Int? = null
)