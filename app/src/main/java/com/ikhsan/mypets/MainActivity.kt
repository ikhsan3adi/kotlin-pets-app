package com.ikhsan.mypets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*
import com.ikhsan.mypets.adapter.ListPetAdapter
import com.ikhsan.mypets.dataModel.Pet
import com.ikhsan.mypets.dataDummy.PetsData
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.ikhsan.mypets.R
import com.ikhsan.mypets.dataDummy.MyBiodata
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var aboutMeMenuItem : MenuItem

    private lateinit var rvPet: RecyclerView
    private var list: ArrayList<Pet> = arrayListOf()
    private var title: String = "MyPets"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPet = findViewById(R.id.rv_pets)
        rvPet.setHasFixedSize(true)

        list.addAll(PetsData.listData)
        showRecyclerList()

        setTheme(R.style.Theme_MyPet)

        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        rvPet.layoutManager = LinearLayoutManager(this)
        val listPetAdapter = ListPetAdapter(list)
        rvPet.adapter = listPetAdapter

        listPetAdapter.setOnItemClickCallback(object : ListPetAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pet) {
                showDetail(data)
            }
        })
    }

    private fun showDetail (data: Pet) {
        val moveIntent = Intent(this@MainActivity, PetDetailsActivity::class.java)
        moveIntent.putExtra(PetDetailsActivity.PET_NAME, data.name)
        moveIntent.putExtra(PetDetailsActivity.PET_CHARACTER, data.character)
        moveIntent.putExtra(PetDetailsActivity.PET_DESCRIPTION, data.description)
        moveIntent.putExtra(PetDetailsActivity.PET_CAN_WALK, data.canWalk)
        moveIntent.putExtra(PetDetailsActivity.PET_CAN_SWIM, data.canSwim)
        moveIntent.putExtra(PetDetailsActivity.PET_CAN_FLY, data.canFly)
        moveIntent.putExtra(PetDetailsActivity.PET_SOUND, data.sound)
        moveIntent.putExtra(PetDetailsActivity.PET_PHOTO, data.photo)
        startActivity(moveIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        aboutMeMenuItem = menu.findItem(R.id.about_page)
        aboutMeMenuItem.setActionView(R.layout.about_btn)

        val aboutBtnView : View = aboutMeMenuItem.actionView
        val aboutBtnPhoto : CircleImageView = aboutMeMenuItem.actionView.findViewById(R.id.small_profile_photo)

        aboutBtnView.setOnClickListener { onOptionsItemSelected(aboutMeMenuItem) }
        aboutBtnPhoto.setImageResource(MyBiodata.listData.myProfilePhoto)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            aboutMeMenuItem.itemId -> {
                startActivity(Intent(this@MainActivity, AboutMeActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
