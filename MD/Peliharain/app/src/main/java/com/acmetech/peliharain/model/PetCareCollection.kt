package com.acmetech.peliharain.model

import androidx.compose.runtime.Immutable

@Immutable
data class PetCollectionCat(
    val id: Long,
    val name: String,
    val type: CollectionType = CollectionType.Normal
)
@Immutable
data class PetCollectionDog(
    val id: Long,
    val name: String,
    val type: CollectionType = CollectionType.Normal
)
enum class CollectionType { Normal, Highlight }

/**
 * A fake repo
 */
object SnackRepo {
    fun getCats(): List<PetCollectionCat> = catCollections
    fun getDogs(): List<PetCollectionDog> = anjingCollections

    fun getPetCat(snackId: Long) = petCatDataFakes.find { it.id == snackId }!!
    fun getPetDog(snackIdDog: Long) = petDogDataFakes.find { it.id == snackIdDog }!!

    fun getRelated(@Suppress("UNUSED_PARAMETER") snackId: Long) = related
}

/**
 * Static data
 */

private val educat = PetCollectionCat(
    id = 1L,
    name = "Edu Pet Kucing",
    type = CollectionType.Highlight,
    //snacks = snacks.subList(0, 5)
)

private val edudog = PetCollectionDog(
    id = 1L,
    name = "Edu Pet Anjing",
    type = CollectionType.Highlight,
    //snacks = snacks.subList(0, 5)
)



private val popular = PetCollectionCat(
    id = 2L,
    name = "Another News",
    //snacks = snacks.subList(6, 10)
)

private val catCollections = listOf(
    educat,
)
private val anjingCollections = listOf(
    edudog,
)

private val related = listOf(
    //also,
    popular
)
