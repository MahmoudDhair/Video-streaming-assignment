package com.mahmoud.videostreamingassignment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class VideoActivity : AppCompatActivity() {
    var videoURL:String = ""
    var index: Int = 1
    lateinit var playerView: PlayerView
    lateinit var player: SimpleExoPlayer
    private var play_when_ready: Boolean = true
    private var current_window: Int = 0
    private var playpack_position: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        index = intent.getIntExtra("index", 0)
        playerView = findViewById(R.id.videoView)
        when(index){
            1-> videoURL = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
            2-> videoURL = "http://www.fsbarbara.com/videos/Vid1501.mp4"
            3-> videoURL = "http://www.fsbarbara.com/videos/Vid_0301.mp4"
            4-> videoURL = "http://www.fsbarbara.com/videos/Vid_0201.mp4"
        }

        Toast.makeText(this,videoURL,Toast.LENGTH_LONG).show()
    }

    public fun initVideo() {
        //player
        player = ExoPlayerFactory.newSimpleInstance(this)
        //connect player with player view
        playerView.player = player
        //media source
        var uri: Uri = Uri.parse(videoURL)
        var dataSource: DataSource.Factory = DefaultDataSourceFactory(this,"exoplayer-codelab")
        var mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri)
        player.playWhenReady = play_when_ready
        player.seekTo(current_window,playpack_position)
        player.prepare(mediaSource,false,false)
    }

    public fun releaseVideo() {
        if (player.isPlaying){
            play_when_ready = player.playWhenReady
            playpack_position = player.currentPosition
            current_window = player.currentWindowIndex
            player.release()
        }
    }

    override fun onStart() {
        super.onStart()
        initVideo()
    }

    override fun onResume() {
        super.onResume()
        if(player.isPlaying){
            initVideo()
        }
    }

    override fun onStop() {
        super.onStop()
        releaseVideo()
    }

    override fun onPause() {
        super.onPause()
        releaseVideo()
    }
}