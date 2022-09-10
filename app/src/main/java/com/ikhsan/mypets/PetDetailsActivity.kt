package com.ikhsan.mypets

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream


class PetDetailsActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val PET_NAME = "PET_NAME"
        const val PET_CHARACTER = "PET_CHARACTER"
        const val PET_DESCRIPTION = "PET_DESCRIPTION"
        const val PET_CAN_WALK = "PET_CAN_WALK"
        const val PET_CAN_SWIM = "PET_CAN_SWIM"
        const val PET_CAN_FLY = "PET_CAN_FLY"
        const val PET_SOUND = "PET_SOUND"
        const val PET_PHOTO = "PET_PHOTO"
    }
    private lateinit var shareMenuItem : MenuItem
    private lateinit var shareBtnview : View

    private lateinit var tvPetImage : ImageView
    private lateinit var tvPetName : TextView
    private lateinit var tvPetCharacter : TextView
    private lateinit var tvPetDescription : TextView
    private lateinit var tvPetCanWalk : TextView
    private lateinit var tvPetCanSwim : TextView
    private lateinit var tvPetCanFly : TextView

    private lateinit var petSoundBtn : Button

    private var petName : String? = ""
    private var petCharacter : String? = ""
    private var petDescription : String? = ""
    private var petCanWalk: Boolean = false
    private var petCanSwim: Boolean = false
    private var petCanFly: Boolean = false
    private var petSound : String? = ""
    private var petImage :Int = 0

    private lateinit var shareText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // reference View
        tvPetImage = findViewById(R.id.img_pet_photo)
        tvPetName = findViewById(R.id.pet_name)
        tvPetCharacter = findViewById(R.id.pet_character)
        tvPetDescription = findViewById(R.id.pet_description)
        tvPetCanWalk = findViewById(R.id.pet_can_walk)
        tvPetCanSwim = findViewById(R.id.pet_can_swim)
        tvPetCanFly = findViewById(R.id.pet_can_fly)

        petSoundBtn = findViewById(R.id.pet_sound_btn)

        // get data
        getData()

        supportActionBar?.title = petName // set action bar title to pet name
        petSoundBtn.setOnClickListener(this)

        // show data
        showData()

        // create text to share
        createTextToShare()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        shareMenuItem = menu.findItem(R.id.menu_share)
        shareMenuItem.setActionView(R.layout.share_btn)

        shareBtnview = shareMenuItem.actionView
        shareBtnview.setOnClickListener {
            onOptionsItemSelected(shareMenuItem)
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_share -> {
                val intentSend = Intent()
                intentSend.action = Intent.ACTION_SEND
                intentSend.putExtra(Intent.EXTRA_TEXT, shareText)
                intentSend.putExtra(Intent.EXTRA_STREAM, shareDrawable(applicationContext, petImage, "$petName") )
                intentSend.type = "image/*"
                intentSend.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

                startActivity(Intent.createChooser(intentSend, "Share my pet"))
            }
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.pet_sound_btn -> {
                Toast.makeText(this, petSound, Toast.LENGTH_SHORT).show()
            }
        }
    }

    // function for convert drawable to file Uri
    private fun shareDrawable(context: Context, resourceId: Int, fileName: String) : Uri {

        val bitmap = BitmapFactory.decodeResource(context.resources, resourceId)

        val outputFile = File(context.cacheDir, "$fileName.png")
        val outPutStream = FileOutputStream(outputFile)
        bitmap.compress(CompressFormat.PNG, 100, outPutStream)
        outPutStream.flush()
        outPutStream.close()

        return FileProvider.getUriForFile(context, context.packageName, outputFile)
    }

    private fun createTextToShare() {

        val canWalk = boolToYaTidak(petCanWalk)
        val canSwim = boolToYaTidak(petCanSwim)
        val canFly = boolToYaTidak(petCanFly)

        shareText =
            "$petName\n\n" +
            "Karakteristik : \n" +
            "$petCharacter\n\n" +
            "Deskripsi : \n" +
            "$petDescription\n\n" +
            "Suara : $petSound\n\n" +
            "Kemampuan : \n" +
            "Bisa berjalan : $canWalk\n" +
            "Bisa berenang : $canSwim\n" +
            "Bisa terbang : $canFly"
    }

    private fun getData() {
        petName = intent.getStringExtra(PET_NAME)
        petCharacter  = intent.getStringExtra(PET_CHARACTER)
        petDescription = intent.getStringExtra(PET_DESCRIPTION)
        petCanWalk = intent.getBooleanExtra(PET_CAN_WALK, false)
        petCanSwim = intent.getBooleanExtra(PET_CAN_SWIM, false)
        petCanFly = intent.getBooleanExtra(PET_CAN_FLY, false)
        petSound  = intent.getStringExtra(PET_SOUND)
        petImage = intent.getIntExtra(PET_PHOTO, 0)
    }

    private fun showData() {
        tvPetImage.setImageResource(petImage)
        tvPetName.text = petName.toString()
        tvPetCharacter.text = petCharacter.toString()
        tvPetDescription.text = petDescription.toString()
        tvPetCanWalk.text = boolToYesNo(petCanWalk)
        tvPetCanSwim.text = boolToYesNo(petCanSwim)
        tvPetCanFly.text = boolToYesNo(petCanFly)
    }

    private fun boolToYesNo (b : Boolean) : String {
        return if (b) {
            "Yes"
        } else {
            "No"
        }
    }

    private fun boolToYaTidak (b : Boolean) : String {
        return if (b) {
            "Ya"
        } else {
            "Tidak"
        }
    }
}