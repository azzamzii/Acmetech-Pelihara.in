package com.acmetech.peliharain.data.response

import com.google.gson.annotations.SerializedName

data class ResponseCat(

	@field:SerializedName("ResponseCat")
	val responseCat: List<ResponseCatItem?>? = null
)

data class ResponseCatItem(

	@field:SerializedName("Content")
	val content: String? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("Title")
	val title: String? = null,

	@field:SerializedName("Publisher")
	val publisher: String? = null,

	@field:SerializedName("Image")
	val image: String? = null,

	@field:SerializedName("idCat")
	val idCat: Long? = null

)
