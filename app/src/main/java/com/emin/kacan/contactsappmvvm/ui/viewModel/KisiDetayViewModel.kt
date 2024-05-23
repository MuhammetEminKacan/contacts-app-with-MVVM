package com.emin.kacan.contactsappmvvm.ui.viewModel

import androidx.lifecycle.ViewModel
import com.emin.kacan.contactsappmvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor (var krepo:KisilerDaoRepository) : ViewModel() {

    fun guncelle(kisi_id:Int,kisi_Ad:String,kisi_tel:String){
        krepo.kisiGuncelle(kisi_id,kisi_Ad,kisi_tel)
    }
}