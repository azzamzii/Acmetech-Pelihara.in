package com.acmetech.peliharain.model

import androidx.compose.runtime.Immutable

@Immutable
data class PetCatDataFake(
    val id: Long,
    val title: String,
    val publisher: String = "",
    val imageUrl: String="",
    val description: String = "",
    val tags: Set<String> = emptySet()
)

/**
 * Static data
 */

val petCatDataFakes = listOf(
    PetCatDataFake(
        id = 1L,
        title = "Apa sih ras Kucing Termahal ?",
        publisher = "Nabilah Nur Alifah",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Cat/Cat_1.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=jmlu%2FrFfS%2BGUfNtywwL3SH416k7tFNIEVTf%2BLbXCcc7QbzJxJItZd6TE5ltAwCVciH2LwLWcyPmdQ1OdTMECVYXJyqVpKoUZmz0ZlGmRzvg6Hz4zXuBlz3fWvwTTVOq%2BTRC5Rs4eUgLdk5f%2BrAaWjrGDTAqHjBDUbC4Q3U0ECy9NowNFEjFzyYNaazYifh1lJ6ol0sQXHw305UA2vF%2BjGRX2qCKaJ9y9GAtmikY8MaLto%2FDI%2BLBx8N%2BcpdGN%2BT%2FkqbXgvHkLA9jvLK%2B24eHips7jRrOgcgfCqQ6tHuQQRf9%2B8M5FWy6%2FhXzzodMZBEGZdeEP3GfIHLJSP%2FiwP14T%2Fg%3D%3D",
        description = "Ras kucing termahal nomor satu di dunia adalah The Ashera. Ras kucing asal Los Angeles satu ini merupakan jenis kucing campuran dari beberapa kucing liar, termasuk macan tutul Asia dan Serval Afrika, serta kucing rumahan. Ashera memiliki sifat keturunan dari kolaborasi ras kucing Savannah dan kucing Bengal. Harga yang ditawarkan untuk mendapatkan Ashera ditaksir mencapai 112,5 dolar AS atau sekitar Rp1,9 miliar.",

    ),
    PetCatDataFake(
        id = 2L,
        title = "Apakah bulu Kucing Berbahaya ?",
        publisher = "Bocah Indonesia",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Cat/Cat_2.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=WpfNKZ1YZuJ4Kvi3dILK%2FAGRmJ%2FtkcQ4%2B66wNlqxBlwYPznpnd5OjJqP6%2BGM2VQsIdvho4DkaZxg%2F%2B6g2qUwf4yNkwatlQsOnDTzit2i9YZ%2BS1JLAPZKJTaTvM4QJMvOTikzMrLBhfwjb6zBYkLFjmAGUqs7nyIqGsFSnJSZLFuc7Z8kjmBjE3T0fDHoymHNC7%2Bm%2FrEIchQ3i5Il5d7MGxx1JJYbmahLMUPunyrAuiYJHB8uHt9eoQznS%2BuAE1XEONS1pgxhxDvmqiW%2FttdRcy%2F4msvTkfVld%2F1OOGS3VH7dl4PebMC5SYw4rErvU4YDM%2BSdytgaYAGbVc%2BPq5m%2FDQ%3D%3D",
        description = "Bulu kucing yang berbahaya adalah bulu kucing yang terkontaminasi dengan kotoran, luar, maupun tanah. Risikonya ini bisa menimbulkan reaksi alergi hingga penyakit yang diakibatkan oleh kutu.  Sebaiknya, jaga kebersihan dan kesehatan kucing. Pastikan selalu menerapkan pola hidup sehat dan bersih agar mengurangi risiko tersebut.",

    ),
    PetCatDataFake(
        id = 3L,
        title = "Bagaimana Menghentikan Kebiasaan Mencakar Kucing ?",
        publisher = "Jean Johnson",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Cat/Cat_3.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=iwEn8tQF0447RXO1WB3fp9OQXXTmpeRC1maAA8VEYDfOnf%2FSCUmOL5iUwkWnaar26rI4J5XarjVkALmWFVWbUEAWIiHw3wlUAr7JeE3wosLmgglQ3Bhl8sFqE6EG2hDiPwJA%2BlRmmUjamqhAX2c7lIPs84QSdtQKp944AMTUVPJzcuopShCxoKiHzNtqvim0rkESwanqc4nsR%2BlWNyOsFB4FZsOQJxCtPkaQsvHAQ510saUwpeKlOSgYkQ4ewZu49R5IolHXZjP6AkYx4PkmUMQqOdrTlPHHwB7UMGDrn7k28OILgdtkYITiS%2BaJTtm1kZ1O97nFrCJX6XudNYWuiw%3D%3D",
        description = "Sebagian besar kucing adalah hewan yang jinak dan patuh. Kucing jarang menggigit dan mencakar, dan berusaha keras untuk menghindari situasi yang memaksanya berperilaku demikian. Walaupun begitu, ada waktu tertentu kucing akan melawan dan melukai sang pemilik. Selain terasa sakit, gigitan atau cakaran kucing bisa memicu infeksi, sehingga lebih baik dihindari. Dengan demikian, mempelajari cara mencegah kucing menggigit atau mencakar, serta mengetahui cara bereaksi saat hal tersebut terjadi adalah hal yang berguna.",

    ),
    PetCatDataFake(
        id = 4L,
        title = "Bagaimana Jadwal Vaksin Kucing ?",
        publisher = "Drh. Jepriadi Kertawinata",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Cat/Cat_4.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=GdkfvibnwUl8xEYu5NcYkl47h7lFTCy2jvLMcHqKJgZQ7bheI7%2BJXNjoD%2Fg38xwSquueAR6UY9PKmPIF1q72cs3AQPWGt%2BRiooUm5srwm6tHSGC9iyqu%2B8OkAWb25of%2BDM%2BCaoqB8dcM0NBrKChahs1FVSRC2%2BhgIL%2FxzfNjiY3vYXUkS7DPLS%2FJ57s6nYSjAz7EHjbtrBonwHbFPXWm4bBHbpPmV4DvZwO2qrcJr7LRLaNR%2FLWJcK4fcGx7brCVvNHCbLxVMtGvxna2IF8njN%2Fqu7r9%2FWXBf0GM%2FLH6%2FdKFtxj9V5NIwvUEB1Dw%2F4CKoAkyOEDMydMgf4G3InsyXA%3D%3D",
        description = "Untuk jadwal vaksin kucing, biasanya dimulai pada umur 8-10 minggu dengan vaksin Panleukopenia, Feline Rhinotracheitis (herpes), Calici virus, dan Chlamydia.  Vaksinasi diulangi 4-5 minggu, kemudian pada umur 12-14 minggu. Setelah berumur 20 minggu, kucing akan divaksin rabies dan akan diulangi setahun kemudian.",

    ),

)
