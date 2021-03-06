package com.wind.data.di

import javax.inject.Qualifier

/**
 * Created by Phong Huynh on 7/20/2020
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class RemoteDataSource

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class LocalDataSource