package com.example.common.coroutine

import com.example.common.coroutine.qualifiers.DefaultDispatcher
import com.example.common.coroutine.qualifiers.IODispatcher
import com.example.common.coroutine.qualifiers.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class DispatcherModule {

    @DefaultDispatcher
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    @IODispatcher
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @MainDispatcher
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}