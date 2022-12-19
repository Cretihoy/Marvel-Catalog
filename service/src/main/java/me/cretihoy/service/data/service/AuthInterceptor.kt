package me.cretihoy.service.data.service

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class AuthInterceptor
@Inject constructor(
    @Named("publicToken") private val publicKey: String,
    @Named("timestamp") private val timeStamp: String,
    @Named("hash") private val hashcode: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = chain.request().url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("ts", timeStamp)
            .addQueryParameter("hash", hashcode)
            .build()

        val requestBuilder = original.newBuilder().url(url)
        val request: Request = requestBuilder.build()

        return chain.proceed(request)
    }
}
