package android.example.service

import android.example.model.PostModel
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostServiceInterface {

    @GET("posts")
    suspend fun getPosts() : List<PostModel>

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val webservice by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(PostServiceInterface::class.java)
        }

        fun create(): PostServiceInterface
        {
            var builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return builder.create(PostServiceInterface::class.java)
        }
    }
}