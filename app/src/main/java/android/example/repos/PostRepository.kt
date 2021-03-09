package android.example.repos

import android.example.model.PostModel
import android.example.service.APIServiceInterface

class PostRepository {

    var client: APIServiceInterface = APIServiceInterface.webservice

    suspend fun getAllPosts(): List<PostModel> {
        println("PostRepository#getAllPosts ==>> start")
        return client.getPosts()
    }
}