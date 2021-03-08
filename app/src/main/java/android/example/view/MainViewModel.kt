package android.example.view

import android.example.repos.PostRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository: PostRepository = PostRepository()

    val allPosts = liveData(Dispatchers.IO) {
        val posts = repository.getAllPosts()
        emit(posts)
    }
}