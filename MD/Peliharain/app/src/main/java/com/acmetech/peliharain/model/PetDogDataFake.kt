package com.acmetech.peliharain.model

import androidx.compose.runtime.Immutable

@Immutable
data class PetDogDataFake(
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

val petDogDataFakes = listOf(
    PetDogDataFake(
        id = 1L,
        title = "Ras Anjing yang Populer di Kepolisian",
        publisher = "Yovita",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Dog/Dog_1.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=lceW249uC98pbYW8BE9TtHtTgMTWk4W7eIopsUDZJHgVAyO0uXLHJFUdDOf1KkBR%2BuCXmJExPrMynOiAS6trZ50kk7i51ptCs2uCmaX2maLOEl%2BX8kEWAyuKciHcTnX4ctyXifibeNScYS3G287w16BWxezAU7nHJsA%2FwwEpOMFnXD871DeJ9TyJZ%2BmpdgJqLMi7D%2BQtEVzSd6%2FuHGc%2F%2FkmWb0RIR6yhyjRjrkudJAD44wO%2Fx%2FDokOrrzlI5fateeoLBNcNjZ1xMa52ycWCNEdJeXFSBZSV8IGtsNA1Qv5OFRN6QJME1H2mK6zRKKeejS4DhFnZOlrUApmOlipAdyA%3D%3D",
        description = "Belgian Malinois merupakan anjing penggembala,  yang kerap menggembalakan domba. Namun, mereka juga dijadikan sebagai anjing pelindung keluarga karena mampu melakukan pekerjaan berbeda. Sampai akhirnya, polisi mulai menggunakan mereka untuk melakukan tugas-tugas kepolisian."
    ),

    PetDogDataFake(
        id = 2L,
        title = "Anjing Adalah Teman?",
        publisher = "Kun Sila Ananda",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Dog/Dog_2.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=OqWavPWpMzlPFnzNAEkh5jkXpzQsZvp26AM10a32x0ml7KHlhCR2QMyi8RG2ba1GbCAvZP3DuH6t8QPGp%2BJO%2BZxZ%2Bj2XpODM0nQauIqvC%2FKmnjDA6F4GVR6O3TEBZkkouppLynASzKoASj4BMSU9ySLeegka9rq60jxU3AyyH4VJ20fHVZJbpAx4c5Flamjk%2FVSJpQvJWVoRz5mOtkk2CG8BJgHsCYXENk%2Fr7oye9hNIoaI93TjVPMf0ZMRRXg7GFy1OdJASmcUL398ERZU%2FdoM7qxhHIpWSTNXqvFkd8txjnX606ja5mYNQOOX0T9ultzRug8%2BExPbi%2FoBiv%2FZ2tw%3D%3D",
        description = "Sebuah penelitian menemukan bahwa nenek moyang anjing yang saat itu masih liar menjadi jinak dan berteman dengan manusia ketika mereka mulai suka mengonsumsi makanan manusia. Kebiasaan mengonsumsi makanan manusia ini lambat laun mengubah genetik anjing dan membuat mereka beradaptasi dengan manusia."
    ),
    PetDogDataFake(
        id = 3L,
        title = "Sifat menonjol pada Anjing",
        publisher = "Anggi Miftasha",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Dog/Dog_3.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=K298ya5FcCET%2BG5bJFDTzCf%2FvKc38P9cDuIhzvQ4vuTJCcFZLyeqazJGDufdxwLQYPYo5FnLapTWvwS5BG%2B9wFPbAQfSrgFIcAZuM3chImDBalmzrh6JwRQ00wlxlNsLOWbRNzJ27NCgGna1WZgMgNYw%2BgM%2Fn1zDe77Elmqj%2FUy%2Bfv8NxlYixRetL0%2BwsUBRsNotUNdRGD4FN%2FqkOaz9pUcFPEnFm5nviOY4j31XwvyPq9T9N1y9bJdH%2F6nD9VX1Tihjw9V7oppXECSy9%2BFfrr%2FDviijs%2Bjff26jC9Fx3IYE2RGl118aLNpizqAuaexygVj8yR%2FyjV7loT59vbYwqw%3D%3D",
        description = "Anjing adalah hewan yang setia dengan orang-orang yang selalu memberinya kasih sayang, yakni pemiliknya. Jika Anda memberikan kasih sayang, menemaninya bermain,  dan merawatnya dengan baik, sebagai gantinya Anda akan mendapatkan loyalitas dari anjing Anda. Kesetiaan ini sudah terbukti dari kisah-kisah anjing peliharaan di seluruh dunia."
    ),
    PetDogDataFake(
        id = 4L,
        title = "Kapan Seharusnya Kita Memeriksakan Anjing Kita ?",
        publisher = "Agita Natalia",
        imageUrl = "https://storage.googleapis.com/pelihara-in-389202.appspot.com/Dog/Dog_4.jpg?GoogleAccessId=firebase-adminsdk-oa0ib%40pelihara-in-389202.iam.gserviceaccount.com&Expires=16730323200&Signature=FP8tL5XmnCBjqvS8t3nw0hCifJa%2BMtZ8%2BDRjlnMzK%2Fztyf%2FPvZLRsee5SkMkpjx0N6%2B6yY7mQ0Fnxp%2BxwF5ew%2BhUAvG7agHyhJOzPvGCmJiFbqozcEdjDR9m%2Farwl5YWh6iHPjz48odlspJulwOhPLX0Kuqn9tiAviQRsC6EimSdOYF7kVzjqLMvAZRlGIJzK8NAtfY4zdDlATO%2FLZ6PKCN8VjVcNBV3Gh9XfwCL5vufBzcdelSPleUUafNlZ8me1D7NpXVg7qghI580L0ldH%2BeEMzsmsyp5d5J17%2FknH%2F6CryTWcJt3N9ACSid0rkRZcCCJoYMhheCbLvXNxSFYjA%3D%3D",
        description = "Frekuensi pemeriksaan kesehatan anjing secara berkala tergantung pada usia anjing. Anak anjing tumbuh dengan cepat dan membutuhkan lebih banyak pemeriksaan dan vaksinasi. Umumnya, pemeriksaan kesehatan untuk anak anjing dibawah 1 tahun dilakukan setiap 3-4 minggu sekali. Setelah anjing tumbuh dewasa, pemeriksaan kesehatan dapat dilakukan setiap enam bulan sekali atau satu tahun sekali. Untuk anjing senior, pemeriksaan kesehatan dapat dilakukan dua kali dalam setahun tergantung keputusan dokter hewanmu."
        ),
)
