package com.example.home.discover.data.datasource.response

import com.google.gson.annotations.SerializedName

data class GenresResponse(

    @field:SerializedName("genres")
    val genres: List<GenresItem> = emptyList()
) {
    data class GenresItem(

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("id")
        val id: Int? = null
    )
}
