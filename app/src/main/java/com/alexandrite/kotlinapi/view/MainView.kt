package com.alexandrite.kotlinapi.view

import com.alexandrite.kotlinapi.model.Team

interface MainView{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}