package com.dicoding.picodiploma.loginwithanimation.di

import com.dicoding.picodiploma.loginwithanimation.data.pref.Ingredients
object FakeData {
    fun generateHeadlineIngredients() = ingredientList.take(10)
    fun generateIngredients() = ingredientList.sortedBy { it.name }
    fun searchIngredients(query: String) = ingredientList.filter { ingredient ->
        ingredient.name.contains(
            query,
            ignoreCase = true
        )
    }

    fun searchKeluhanIngredients(query: String) = ingredientList.filter { ingredient ->
        ingredient.name.contains(
            query,
            ignoreCase = true
        ) || ingredient.listKeluhan.any { keyword ->
            keyword.contains(
                query,
                ignoreCase = true
            )
        }
    }

    private val ingredientList = listOf(
        Ingredients(
            1,
            "Jahe",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Jahe adalah tanaman rimpang yang populer sebagai rempah-rempah dan bahan obat.",
            listKhasiat = listOf(
                "Mengatasi mual",
                "Mengurangi peradangan",
                "Meningkatkan Kekebalan Tubuh",
            ),
            listKeywords = listOf("Jahe"),
            listKandungan = listOf("Gingerol", "shogaol", "zingerone"),
            listKeluhan = listOf("Mual", "Peradangan", "Kekebalan Tubuh")
        ),
        Ingredients(
            2,
            "Kunyit",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1681161939/attached_image/5-manfaat-bawang-putih-untuk-wanita-yang-jarang-diketahui.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Kunyit"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
        Ingredients(
            3,
            "Jahe",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Jahe adalah tanaman rimpang yang populer sebagai rempah-rempah dan bahan obat.",
            listKhasiat = listOf(
                "Mengatasi mual",
                "Mengurangi peradangan",
                "Meningkatkan Kekebalan Tubuh",
            ),
            listKeywords = listOf("Jahe"),
            listKandungan = listOf("Gingerol", "shogaol", "zingerone"),
            listKeluhan = listOf("Mual", "Peradangan", "Kekebalan Tubuh")
        ),
        Ingredients(
            4,
            "Kunyit",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1681161939/attached_image/5-manfaat-bawang-putih-untuk-wanita-yang-jarang-diketahui.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Kunyit"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
        Ingredients(
            5,
            "Jahe",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Jahe adalah tanaman rimpang yang populer sebagai rempah-rempah dan bahan obat.",
            listKhasiat = listOf(
                "Mengatasi mual",
                "Mengurangi peradangan",
                "Meningkatkan Kekebalan Tubuh",
            ),
            listKeywords = listOf("Jahe"),
            listKandungan = listOf("Gingerol", "shogaol", "zingerone"),
            listKeluhan = listOf("Mual", "Peradangan", "Kekebalan Tubuh")
        ),
        Ingredients(
            6,
            "Bawang Merah",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1681161939/attached_image/5-manfaat-bawang-putih-untuk-wanita-yang-jarang-diketahui.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Bawang", "Merah"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
        Ingredients(
            7,
            "Jahe",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Jahe adalah tanaman rimpang yang populer sebagai rempah-rempah dan bahan obat.",
            listKhasiat = listOf(
                "Mengatasi mual",
                "Mengurangi peradangan",
                "Meningkatkan Kekebalan Tubuh",
            ),
            listKeywords = listOf("Jahe"),
            listKandungan = listOf("Gingerol", "shogaol", "zingerone"),
            listKeluhan = listOf("Mual", "Peradangan", "Kekebalan Tubuh")
        ),
        Ingredients(
            8,
            "Kunyit",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1681161939/attached_image/5-manfaat-bawang-putih-untuk-wanita-yang-jarang-diketahui.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Kunyit"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
        Ingredients(
            9,
            "Jahe",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Jahe adalah tanaman rimpang yang populer sebagai rempah-rempah dan bahan obat.",
            listKhasiat = listOf(
                "Mengatasi mual",
                "Mengurangi peradangan",
                "Meningkatkan Kekebalan Tubuh",
            ),
            listKeywords = listOf("Jahe"),
            listKandungan = listOf("Gingerol", "shogaol", "zingerone"),
            listKeluhan = listOf("Mual", "Peradangan", "Kekebalan Tubuh")
        ),
        Ingredients(
            10,
            "Kunyit",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1681161939/attached_image/5-manfaat-bawang-putih-untuk-wanita-yang-jarang-diketahui.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Kunyit"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
        Ingredients(
            11,
            "Jahe",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Jahe adalah tanaman rimpang yang populer sebagai rempah-rempah dan bahan obat.",
            listKhasiat = listOf(
                "Mengatasi mual",
                "Mengurangi peradangan",
                "Meningkatkan Kekebalan Tubuh",
            ),
            listKeywords = listOf("Jahe"),
            listKandungan = listOf("Gingerol", "shogaol", "zingerone"),
            listKeluhan = listOf("Mual", "Peradangan", "Kekebalan Tubuh")
        ),
        Ingredients(
            12,
            "Kunyit",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1681161939/attached_image/5-manfaat-bawang-putih-untuk-wanita-yang-jarang-diketahui.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Kunyit"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
        Ingredients(
            13,
            "Jahe",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Jahe adalah tanaman rimpang yang populer sebagai rempah-rempah dan bahan obat.",
            listKhasiat = listOf(
                "Mengatasi mual",
                "Mengurangi peradangan",
                "Meningkatkan Kekebalan Tubuh",
            ),
            listKeywords = listOf("Jahe"),
            listKandungan = listOf("Gingerol", "shogaol", "zingerone"),
            listKeluhan = listOf("Mual", "Peradangan", "Kekebalan Tubuh")
        ),
        Ingredients(
            14,
            "Kunyit",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1681161939/attached_image/5-manfaat-bawang-putih-untuk-wanita-yang-jarang-diketahui.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Kunyit"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
        Ingredients(
            15,
            "Kunyit",
            "https://storage.googleapis.com/herbalease-image/HD/23.%20Jahe.jpg",
            "Kunyit adalah tanaman rempah yang berasal dari Asia Tenggara dan digunakan dalam masakan serta pengobatan tradisional.",
            listKhasiat = listOf(
                "Anti-inflamasi",
                "Meningkatkan kesehatan pencernaan",
                "Antioksidan",
            ),
            listKeywords = listOf("Kunyit"),
            listKandungan = listOf("Kurkumin", "demetoksikurkumin", "bisdemetoksikurkumin"),
            listKeluhan = listOf("Peradangan", "Kesehatan Pencernaan", "Antioksidan"),
        ),
    )
}