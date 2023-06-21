package com.example.mvvm.core.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.example.mvvm.data.db.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val QUOTE_DATABASE_NAME = "quotes_table"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, QuoteDatabase::class.java, QUOTE_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: QuoteDatabase) = db.getQuoteDao()
}