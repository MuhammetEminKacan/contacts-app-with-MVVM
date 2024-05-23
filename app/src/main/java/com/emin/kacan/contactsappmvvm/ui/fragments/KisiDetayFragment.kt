package com.emin.kacan.contactsappmvvm.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.emin.kacan.contactsappmvvm.R
import com.emin.kacan.contactsappmvvm.databinding.FragmentKisiDetayBinding
import com.emin.kacan.contactsappmvvm.ui.viewModel.AnaSayfaViewModel
import com.emin.kacan.contactsappmvvm.ui.viewModel.KisiDetayViewModel
import com.emin.kacan.contactsappmvvm.ui.viewModel.KisiEkleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel : KisiDetayViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kisiDetayFragment = this
        binding.kisiDetayToolbarBaslik = "kişi detayları"

        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        binding.kisiNesnesi = gelenKisi

    }

    fun guncelle(kisi_id:Int,kisi_Ad:String,kisi_tel:String){
        viewModel.guncelle(kisi_id,kisi_Ad,kisi_tel)
    }
}