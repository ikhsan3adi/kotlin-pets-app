package com.ikhsan.mypets.dataDummy

import com.ikhsan.mypets.R
import com.ikhsan.mypets.dataModel.Bio

object MyBiodata {
    private  var myProfilePhoto : Int = R.drawable.t_ikhsan
    private var myName : String = "Ikhsan Satriadi"
    private var myEmail : String = "ikhsansatriadi175@gmail.com"
    private var myOccupation : String = "Pelajar/Siswa"
    private var myAge : String = "17"
    private var myHobby : String = "Ngoding"

    val listData: Bio
        get() {
            val myBio = Bio()

            myBio.myProfilePhoto = myProfilePhoto
            myBio.myName = myName
            myBio.myEmail = myEmail
            myBio.myOccupation = myOccupation
            myBio.myAge = myAge
            myBio.myHobby = myHobby

            return myBio
        }
}