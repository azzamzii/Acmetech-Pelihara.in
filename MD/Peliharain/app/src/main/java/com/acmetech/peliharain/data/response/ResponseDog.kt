package com.acmetech.peliharain.data.response

import com.google.gson.annotations.SerializedName

data class ResponseDog(

	@field:SerializedName("ResponseDog")
	val responseDog: List<ResponseDogItem?>? = null
)

data class ResponseDogItem(

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

	@field:SerializedName("idDog")
	val idDog: Long? = null
) {



}
