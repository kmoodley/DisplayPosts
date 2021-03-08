package android.example.repos

import android.example.model.PostModel
import android.example.service.PostServiceInterface

class PostRepository {

    var client: PostServiceInterface = PostServiceInterface.webservice

    suspend fun getAllPosts(): List<PostModel> {
        println("PostRepository#getAllPosts ==>> start")
        return client.getPosts()
    }

    suspend fun allPostsRestCall(posts: ArrayList<String>) {

        //val apiInterface = PostServiceInterface.create().getPosts()
        /*apiInterface.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                println("inside onResponse start")

                for (postItem in response.body()!!) {
                    var title: String = postItem.title!!
                    var postId: String = postItem.id.toString()!!
                    posts.add("[${postId}] - ${title}")
                }

                println("inside onResponse end")
                //binding.rvPostsLists.adapter = PostDisplayAdapter(posts , view.context)
                //postDisplayAdapter = PostDisplayAdapter(posts , view.context)
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                println("onFailure: ${t}")
            }
        }*/
    }

}