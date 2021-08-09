package com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.repositories

import com.example.coroutinesexample.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllLives() = retrofitService.getAllLives()

}