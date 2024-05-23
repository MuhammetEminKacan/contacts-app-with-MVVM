package com.emin.kacan.contactsappmvvm.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.emin.kacan.contactsappmvvm.R
import com.emin.kacan.contactsappmvvm.data.entity.Kisiler
import com.emin.kacan.contactsappmvvm.databinding.FragmentAnasayfaBinding
import com.emin.kacan.contactsappmvvm.ui.adapter.KisilerAdapter
import com.emin.kacan.contactsappmvvm.ui.viewModel.AnaSayfaViewModel
import com.emin.kacan.contactsappmvvm.ui.viewModel.KisiEkleViewModel
import com.emin.kacan.contactsappmvvm.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnasayfaFragment : Fragment() ,SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel : AnaSayfaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnaSayfaViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.anaSayfaFragment = this
        binding.anaSayfaToolbarBaslik = "kişiler"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnaSayfa)    // toolbar a menu eklediğimizi belirttim

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val adapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter = adapter
        }



        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)   // viewLifecycleOwner ve Lifecycle.State.RESUMED yapısı düzgün çalışması için
    }

    fun fabTikla(it:View){
        Navigation.gecisYap(it,R.id.action_kisiEkle)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query !=null){
            viewModel.Ara(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText !=null){
            viewModel.Ara(newText)
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()

    }

}