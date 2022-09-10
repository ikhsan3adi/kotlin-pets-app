package com.ikhsan.mypets

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ikhsan.mypets.R
import com.ikhsan.mypets.dataDummy.MyBiodata
import de.hdodenhof.circleimageview.CircleImageView

class AboutMeActivity : AppCompatActivity() {

    private lateinit var tvProfilePhoto : CircleImageView
    private lateinit var tvMyName : TextView
    private lateinit var tvMyEmail : TextView
    private lateinit var tvOccupation : TextView
    private lateinit var tvAge : TextView
    private lateinit var tvHobby : TextView

    private var title : String = "About Me"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title

        val myBio = MyBiodata.listData

        tvProfilePhoto = findViewById(R.id.profile_photo)
        tvMyName = findViewById(R.id.about_name)
        tvMyEmail = findViewById(R.id.about_email)
        tvOccupation = findViewById(R.id.about_occupation)
        tvAge = findViewById(R.id.about_age)
        tvHobby = findViewById(R.id.about_hobby)

        tvProfilePhoto.setImageResource(myBio.myProfilePhoto)
        tvMyName.text = myBio.myName
        tvMyEmail.text = myBio.myEmail
        tvOccupation.text = myBio.myOccupation
        tvAge.text = myBio.myAge
        tvHobby.text = myBio.myHobby
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
        android.R.id.home -> {
            finish()
            return true
        }
    }
        return super.onOptionsItemSelected(item)
    }

}