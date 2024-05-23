package com.emin.kacan.contactsappmvvm.di

import android.content.Context
import androidx.room.Room
import com.emin.kacan.contactsappmvvm.data.repo.KisilerDaoRepository
import com.emin.kacan.contactsappmvvm.room.kisilerDao
import com.emin.kacan.contactsappmvvm.room.veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  // bir nesnem olacak ve her yerden erişecem dedim
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDaoRepository(kdao:kisilerDao) : KisilerDaoRepository{
        return KisilerDaoRepository(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : kisilerDao{
        val vt = Room.databaseBuilder(context,veritabani::class.java,"rehber.sqlite")   //işleme
            .createFromAsset("rehber.sqlite").build()  // yüklediğim veritabanı nı kopyaladım
        return vt.getKisilerDao()
    }
}