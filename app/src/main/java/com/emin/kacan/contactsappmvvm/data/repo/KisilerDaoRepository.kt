package com.emin.kacan.contactsappmvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.emin.kacan.contactsappmvvm.data.entity.Kisiler
import com.emin.kacan.contactsappmvvm.room.kisilerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisilerDaoRepository(var kdao : kisilerDao) {
    var kisilerListesi : MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }
    fun kisileriGetirr() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }
    fun kisiKaydet(kisi_Ad:String,kisi_tel:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0,kisi_Ad,kisi_tel) // kişi id 0 olma sebebi kisi id kendi kendine arttığı için rastegele bi sayı yazdık
            kdao.kisiEkle(yeniKisi)
        }
    }

    fun kisiGuncelle(kisi_id:Int,kisi_Ad:String,kisi_tel:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi = Kisiler(kisi_id,kisi_Ad,kisi_tel)
            kdao.kisiGuncelle(guncellenenKisi)
        }
    }

    fun kisiAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kdao.kisiArama(aramaKelimesi)
        }
    }

    fun kisiSil(kisi_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Kisiler(kisi_id,"","") // kisi ad ve kisi telin boş olma sebebi idi ile silmemiz ve onlara gerek kalmaması
            kdao.kisiSil(silinenKisi)
            tumKisileriGetir()
        }
    }

    fun tumKisileriGetir(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kdao.tumKisiler()
        }
    }
}