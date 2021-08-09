package com.example.coroutinesexample.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutinesexample.models.Live
import com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()
    val testingLazy:String by lazy {
       Log.i("LAZY","CHAMOU LAZY")
        "LAZY";
    }

    fun getAllLives() {

        val response = repository.getAllLives()
        response.enqueue(object : Callback<List<Live>> {
            override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {
                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Live>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}