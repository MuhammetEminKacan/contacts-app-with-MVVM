package com.emin.kacan.contactsappmvvm.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.emin.kacan.contactsappmvvm.data.entity.Kisiler

@Dao
interface kisilerDao {

    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler() : List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    suspend fun kisiArama(aramaKelimesi:String) : List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisi:Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi:Kisiler)

    @Delete
    suspend fun kisiSil(kisi:Kisiler)
}