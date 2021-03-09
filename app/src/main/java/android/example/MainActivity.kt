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
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

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

        var recyclerView:RecyclerView = binding.rvPostsLists
        (recyclerView.itemAnimator as SimpleItemAnimator?)!!.supportsChangeAnimations = false

        binding.doneButton.setOnClickListener {
            getAllPosts(it)
        }
    }

    private fun getAllPosts(view: View?) {
        viewModel.allPosts.observe(this, Observer {
            binding.rvPostsLists.adapter = PostDisplayAdapter(it, view!!.context)
        })
    }
}