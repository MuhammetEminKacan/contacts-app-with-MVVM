package com.emin.kacan.contactsappmvvm.ui.viewModel

import androidx.lifecycle.ViewModel
import com.emin.kacan.contactsappmvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiEkleViewModel @Inject constructor (var krepo:KisilerDaoRepository) : ViewModel() {


    fun kayit(kisi_Ad:String,kisi_tel:String){
        krepo.kisiKaydet(kisi_Ad,kisi_tel)
    }
}