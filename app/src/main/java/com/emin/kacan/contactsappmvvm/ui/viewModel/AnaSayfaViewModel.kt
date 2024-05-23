package com.emin.kacan.contactsappmvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emin.kacan.contactsappmvvm.data.entity.Kisiler
import com.emin.kacan.contactsappmvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor (var krepo:KisilerDaoRepository): ViewModel() {

    var kisilerListesi: MutableLiveData<List<Kisiler>> = MutableLiveData()

    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetirr()
    }

    fun Ara(aramaKelimesi: String) {
        krepo.kisiAra(aramaKelimesi)
    }

    fun Sil(kisi_id: Int) {
        krepo.kisiSil(kisi_id)
    }

    fun kisileriYukle() {
        krepo.tumKisileriGetir()
    }
}