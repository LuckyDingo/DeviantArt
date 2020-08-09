package com.wind.deviantart

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wind.deviantart.ui.artdetail.ArtDetailFragment
import com.wind.deviantart.ui.comment.CommentFragment
import com.wind.deviantart.ui.main.MainFragment
import com.wind.deviantart.ui.main.topic.TopicDetailFragment
import com.wind.deviantart.ui.search.SearchActivity
import com.wind.model.Art
import com.wind.model.Topic
import dagger.hilt.android.AndroidEntryPoint
import util.Event
import util.EventObserver
import util.addFragment
import util.replaceFragment

private const val TAG_ART_DETAIL = "art_detail"
private const val TAG_COMMENT = "comment"
private const val TAG_TOPIC_DETAIL = "topic_detail"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val vmNav by viewModels<NavViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment)

        if (savedInstanceState == null) {
            addFragment(MainFragment(), R.id.root)
        }
        vmNav.apply {
            val lifecycleOwner = this@MainActivity
            openArt.observe(lifecycleOwner, EventObserver {
                replaceFragment(ArtDetailFragment.newInstance(it), R.id.root, TAG_ART_DETAIL,
                    isAddBackStack = true, useAnim = true)
            })
            openComment.observe(lifecycleOwner, EventObserver {
                replaceFragment(CommentFragment.newInstance(it), R.id.root, TAG_COMMENT,
                    isAddBackStack = true, useAnim = true)
            })
            openSearch.observe(lifecycleOwner, EventObserver {
                startActivity(Intent(lifecycleOwner, SearchActivity::class.java))
            })
            openTopic.observe(lifecycleOwner, EventObserver {
                replaceFragment(
                    TopicDetailFragment.newInstance(it), R.id.root, TAG_TOPIC_DETAIL,
                    isAddBackStack = true, useAnim = true)
            })
        }
    }
}

class NavViewModel @ViewModelInject constructor() : ViewModel() {
    val openSearch: MutableLiveData<Event<Unit>> by lazy {
        MutableLiveData<Event<Unit>>()
    }
    val openArt: MutableLiveData<Event<Art>> by lazy {
        MutableLiveData<Event<Art>>()
    }
    val openComment: MutableLiveData<Event<String>> by lazy {
        MutableLiveData<Event<String>>()
    }
    val openTopic: MutableLiveData<Event<Topic>> by lazy {
        MutableLiveData<Event<Topic>>()
    }
}