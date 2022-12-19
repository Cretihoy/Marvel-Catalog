package me.cretihoy.service.data.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.cretihoy.service.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    private const val BASE_URL = "https://gateway.marvel.com"
    private const val PUBLIC_TOKEN = "093ae71df34b6ccabc350350df4433f4"
    private const val PRIVATE_TOKEN = "9e3c198cb5f2ed5b050868af9c43c7ec1ab83432"

    private const val BASE_URL_KEY = "baseUrl"
    private const val PUBLIC_TOKEN_KEY = "publicToken"
    private const val PRIVATE_TOKEN_KEY = "privateToken"
    private const val TIMESTAMP_KEY = "timestamp"
    private const val HASH_KEY = "hash"

    @Provides
    @Named(BASE_URL_KEY)
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor
    ): OkHttpClient =
        with(OkHttpClient.Builder()) {
            val timeout = 10L
            connectTimeout(timeout, TimeUnit.SECONDS)
            readTimeout(timeout, TimeUnit.SECONDS)

            if (BuildConfig.DEBUG) {
                addNetworkInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }

            addInterceptor(authInterceptor)

            build()
        }

    @Singleton
    @Provides
    fun provideApiCharacterService(
        httpClient: OkHttpClient
    ): CharacterService {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiComicService(
        httpClient: OkHttpClient
    ): ComicService {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ComicService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiCreatorService(
        httpClient: OkHttpClient
    ): CreatorService {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CreatorService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiEventService(
        httpClient: OkHttpClient
    ): EventService {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiSeriesService(
        httpClient: OkHttpClient
    ): SeriesService {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SeriesService::class.java)
    }

    @Provides
    @Named(HASH_KEY)
    fun provideHash(
        @Named(TIMESTAMP_KEY) timeStamp: String,
        @Named(PRIVATE_TOKEN_KEY) privateKey: String,
        @Named(PUBLIC_TOKEN_KEY) publicKey: String,
    ): String {
        val stringToHash = "${timeStamp}${privateKey}${publicKey}"
        val crypt = MessageDigest.getInstance("MD5");
        crypt.update(stringToHash.toByteArray());
        return BigInteger(1, crypt.digest()).toString(16)
    }

    @Provides
    @Named(TIMESTAMP_KEY)
    fun provideTimeStamp(): String {
        return Date().time.toString()
    }

    @Provides
    @Named(PRIVATE_TOKEN_KEY)
    fun providePrivateKey(): String {
        return PRIVATE_TOKEN
    }

    @Provides
    @Named(PUBLIC_TOKEN_KEY)
    fun providePublicKey(): String {
        return PUBLIC_TOKEN
    }
}