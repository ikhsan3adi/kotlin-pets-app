package com.ikhsan.mypets.dataDummy

import com.ikhsan.mypets.R
import com.ikhsan.mypets.dataModel.Pet

object PetsData {
    private val petNames = arrayOf(
        "Ikan Mas",
        "Kelinci",
        "Ayam Jago",
        "Ikan Cupang",
        "Kucing Oren",
        "Bebek",
        "Ikan Koi",
        "Burung Merpati",
        "Bunglon",
        "Burung Beo")

    private val petCharacter = arrayOf(
        "Memiliki ciri-ciri mata yang kecil, bibir tebal, dua sungut di sudut mulut dan sisik yang besar.",
        "Memiliki telinga yang panjang, kaki belakang yang besar dan kuat dan memiliki gigi seri yang besar",
        "Memiliki paruh dan memiliki 2 kaki yang fungsinya untuk menggaruk tanah agar bisa mencari makan.",
        "Bentuk sirip dan ekor menjumbai panjang",
        "Ramah, penyayang, dan jinak. Mereka tidak termasuk hewan yang buas, meski terkadang mereka menggigit atau mencakar.",
        "Memiliki tubuh langsing, berleher panjang, kaki lebih pendek dibandingkan tubuhnya, antara jari yang satu dengan yang lain dihubungkan dengan selaput renang",
        "Memiliki perawakan tubuh memanjang seperti torpedo. Sirip terdapat pada punggung, pinggul, sepasang di dada serta ekor.",
        "Berleher pendek dan berbadan kekar. Ia memiliki paruh pendek ramping dengan ceres atau lubang hidung berdaging pada spesies tertentu.",
        "Dapat mengubah warna tubuhnya sebagai tanggapan terhadap perubahan suhu dan cahaya di sekitarnya",
        "Mempunyai bulu yang cukup pendek pada bagian kepalanya. Terdapat sebuah garis melengkung yang berwarna kuning pada bagian kepalanya",
    )

    private val petDescription = arrayOf(
        "Ikan mas atau Ikan karper adalah ikan air tawar yang memiliki nilai ekonomis penting dan sudah tersebar luas di Indonesia. Di Indonesia, ikan mas mulai dipelihara sekitar tahun 1920-an. Ikan mas yang terdapat di Indonesia merupakan ikan mas yang dibawa dari Cina, Eropa, Taiwan dan Jepang.",
        "Kelinci adalah hewan mamalia dari famili Leporidae, yang dapat ditemukan di banyak bagian bumi. Kelinci berkembang biak dengan cara beranak yang disebut vivipar. Dulunya, hewan ini adalah hewan liar yang hidup di Afrika hingga ke daratan Eropa.",
        "Ayam adalah unggas yang biasa dipelihara untuk dimanfaatkan daging, telur, dan bulunya. Ayam peliharaan merupakan keturunan langsung dari salah satu subspesies ayam hutan yang dikenal sebagai ayam hutan merah atau ayam bangkiwa. Semua ayam merupakan theropoda seperti tyrannosaurus.",
        "Cupang, ikan laga, atau ikan adu siam adalah ikan air tawar yang habitat asalnya adalah beberapa negara di Asia Tenggara, antara lain Thailand, Malaysia, Brunei Darussalam, Singapura, Vietnam, dan Indonesia. Ikan ini mempunyai bentuk dan karakter yang unik dan cenderung agresif dalam mempertahankan wilayahnya.",
        "Kucing disebut juga kucing domestik atau kucing rumah adalah sejenis mamalia karnivora dari keluarga Felidae. Kata \"kucing\" biasanya merujuk kepada \"kucing\" yang telah dijinakkan, tetapi bisa juga merujuk kepada \"kucing besar\" seperti singa dan harimau.",
        "Bebek atau itik adalah nama umum untuk beberapa spesies burung dalam famili Anatidae. Bebek umumnya adalah burung akuatik yang sebagian besar berukuran lebih kecil dibandingkan kerabatnya, angsa dan angsa berleher pendek, dan dapat ditemukan pada perairan air tawar maupun air laut.",
        "Koi atau secara spesifiknya koi berasal dari bahasa Jepang yang berarti ikan karper. Lebih spesifik lagi merujuk pada nishikigoi, yang kurang lebih bermakna ikan karper yang bersulam emas atau perak.",
        "Merpati dan dara termasuk dalam famili Columbidae atau burung berparuh merpati dari ordo Columbiformes, yang mencakup sekitar 300 spesies burung kerabat pekicau. Dalam percakapan umum, istilah \"dara\" dan \"merpati\" dapat saling menggantikan.",
        "Bunglon adalah sebutan khusus untuk beraneka jenis kadal/bengkarung yang memiliki kemampuan mengubah warna kulitnya. Secara umum, istilah \"bunglon\" digunakan untuk menyebut kadal-kadal dari suku Iguania termasuk Iguanidae, agamidae dan chamaeleonidae. Istilah dalam bahasa Inggris adalah Chameleon atau Chamaeleon.",
        "Beo, mamiang, atau tiong emas adalah sejenis burung anggota suku Sturnidae. Wilayah persebaran alaminya adalah mulai dari Sri Lanka, India, Himalaya, ke timur hingga Filipina, jawa hingga kepulauan sunda kecil. Burung ini dapat ditemukan di dataran rendah hingga dataran tinggi lebih dari 2000m",
    )

    private val petCanWalk = arrayOf(
        false,
        true,
        true,
        false,
        true,
        true,
        false,
        true,
        true,
        true,
    )

    private val petCanSwim = arrayOf(
        true,
        false,
        false,
        true,
        false,
        true,
        true,
        false,
        false,
        false
    )

    private val petCanFly = arrayOf(
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        true,
        false,
        true
    )

    private val petSound = arrayOf(
        "BLUPBLUP\uD83D\uDC1F",
        "\uD83D\uDC07",
        "\uD83D\uDC13",
        "BLUPBLUP\uD83D\uDC1F",
        "MEEOOWWW\uD83D\uDE3A",
        "WEKWEKWKEWK\uD83E\uDD86",
        "BLUPBLUP\uD83D\uDC1F",
        "\uD83D\uDC26",
        "\uD83E\uDD8E",
        "\uD83D\uDC26",
    )

    private val petImages = intArrayOf(
        R.drawable.ikan_mas,
        R.drawable.kelinci,
        R.drawable.ayam,
        R.drawable.ikan_cupang,
        R.drawable.kucing,
        R.drawable.bebek,
        R.drawable.ikan_koi,
        R.drawable.burung_merpati,
        R.drawable.bunglon,
        R.drawable.burung_beo,
    )

    val listData: ArrayList<Pet>
     get() {
         val list = arrayListOf<Pet>()
         for (position in petNames.indices) {
            val pet = Pet()
             pet.name = petNames[position]
             pet.character = petCharacter[position]
             pet.description = petDescription[position]
             pet.canWalk = petCanWalk[position]
             pet.canSwim = petCanSwim[position]
             pet.canFly = petCanFly[position]
             pet.sound = petSound[position]
             pet.photo = petImages[position]
             list.add(pet)
         }
         return list
     }
}