package android.example

import android.example.adapter.PostDisplayAdapter
import android.example.databinding.ActivityMainBinding
import android.example.view.MainViewModel
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        binding.rvPostsLists.layoutManager = linearLayoutManager
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.doneButton.setOnClickListener {
            getAllPosts(it)
        }
    }

    private fun getAllPosts(view: View?) {
        val dataSet = ArrayList<String>()

        viewModel.allPosts.observe(this, Observer {
            for (postItem in it) {
                var title: String = postItem.title!!
                var postId: String = postItem.id.toString()!!
                dataSet.add("[${postId}] - ${title}")
            }
            binding.rvPostsLists.adapter = PostDisplayAdapter(dataSet, view!!.context)
        })
    }
}