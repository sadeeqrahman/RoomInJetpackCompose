package com.sadeeq.encoders.roominjetpackcompose.module

// DatabaseModule.kt

import android.content.Context
import androidx.room.Room
import com.sadeeq.encoders.roominjetpackcompose.dao.Dao
import com.sadeeq.encoders.roominjetpackcompose.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "your_database_name"
        ).build()
    }

    @Provides
    fun provideYourDao(appDatabase: AppDatabase): Dao {
        return appDatabase.yourDao()
    }
}
