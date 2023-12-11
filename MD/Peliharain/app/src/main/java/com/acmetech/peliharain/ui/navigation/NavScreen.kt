package com.acmetech.peliharain.ui.navigation

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val REGIST_GRAPH_ROUTE = "regist"
const val HOME_GRAPH_ROUTE = "home"
const val SPLASH_GRAPH_ROUTE = "splash"
const val SCAFFOLD_GRAPH_ROUTE = "scaffold"
const val PETSHOP_GRAPH_ROUTE = "petshop"

sealed class PetScreen(val route: String) {
    object Splashscreen : PetScreen("splashscreen")
    object LoginPage : PetScreen("login")
    object RegisPage : PetScreen("Register")
    object Home : PetScreen("home")
    object NavPet : PetScreen("navpet")
    object ChatBotPage : PetScreen("chatbot")
    object ProfilPage : PetScreen("profile")
    object PetCare : PetScreen("petnews")
    object PetShop : PetScreen("petshop")
    object PetForm : PetScreen("petform")
    object DetailPetCare : PetScreen("petnews/{petnewsid}") {

    }
}