package com.ikhsan.mypets.dataModel

data class Pet(
    var name: String = "pet_name",
    var character: String = "pet_character",
    var description: String = "pet_description",

    var canWalk: Boolean = false,
    var canSwim: Boolean = false,
    var canFly: Boolean = false,

    var sound: String = "pet_sound",

    var photo: Int = 0
)