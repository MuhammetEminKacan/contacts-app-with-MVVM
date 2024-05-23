package com.emin.kacan.contactsappmvvm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emin.kacan.contactsappmvvm.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class veritabani : RoomDatabase() {
    abstract fun getKisilerDao() : kisilerDao
}