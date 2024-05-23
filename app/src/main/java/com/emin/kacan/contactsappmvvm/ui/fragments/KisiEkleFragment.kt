package com.emin.kacan.contactsappmvvm.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.emin.kacan.contactsappmvvm.R
import com.emin.kacan.contactsappmvvm.databinding.FragmentKisiEkleBinding
import com.emin.kacan.contactsappmvvm.ui.viewModel.AnaSayfaViewModel
import com.emin.kacan.contactsappmvvm.ui.viewModel.KisiEkleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiEkleFragment : Fragment() {
    private lateinit var binding: FragmentKisiEkleBinding
    private lateinit var viewModel : KisiEkleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :KisiEkleViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_ekle,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.kisiKayitFragment = this
        binding.kisiKayitToolbarBaslik="kişi kayıt"
    }

    fun buttonKaydet(kisi_Ad:String,kisi_tel:String){
        viewModel.kayit(kisi_Ad,kisi_tel)
    }
}