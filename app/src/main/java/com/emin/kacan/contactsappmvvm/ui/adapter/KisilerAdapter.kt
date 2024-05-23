package com.emin.kacan.contactsappmvvm.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.emin.kacan.contactsappmvvm.R
import com.emin.kacan.contactsappmvvm.data.entity.Kisiler
import com.emin.kacan.contactsappmvvm.databinding.CardTasarimBinding
import com.emin.kacan.contactsappmvvm.ui.fragments.AnasayfaFragmentDirections
import com.emin.kacan.contactsappmvvm.ui.viewModel.AnaSayfaViewModel
import com.emin.kacan.contactsappmvvm.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context,var kisilerList:List<Kisiler>,var viewModel: AnaSayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(binding: CardTasarimBinding) : RecyclerView.ViewHolder(binding.root){
        var binding :CardTasarimBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerList.get(position)
        val ct = holder.binding
        ct.kisiNesnesi = kisi
        ct.ivSil.setOnClickListener {ivView ->
            Snackbar.make(ivView,"kişi silinsinmi",Snackbar.LENGTH_LONG)
                .setAction("evet"){
                    viewModel.Sil(kisi.kisi_id)
                }.show()
        }

        ct.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionKisiDetay(kisi = kisi)
            Navigation.gecisYap(it,gecis)
        }
    }

    override fun getItemCount(): Int {
        return kisilerList.size
    }

}