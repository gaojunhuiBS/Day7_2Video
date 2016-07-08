package com.education.myvideoplayertest;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by zhonghang on 16/6/22.
 */

public class TestVideoView extends SurfaceView {
    private SurfaceHolder mSurfaceHolder;
//    private MediaPlayer mMediaPlayer;
//    private int mVideoWidth;
//    private int mVideoHeight;
//    private Uri uri;
//    private GestureDetector gestureDetector;
SurfaceHolder.Callback mSurfaceCallBack = new SurfaceHolder.Callback() {
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mSurfaceHolder = holder;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        //屏幕横竖屏切换
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //关闭surfaceview时
//            if (mMediaPlayer != null) {
//                if (mMediaPlayer.isPlaying())
//                    mMediaPlayer.stop();
//                mMediaPlayer.release();
//                mMediaPlayer = null;
//            }
    }
};
    public SurfaceHolder getSurfaceHolder() {
        return mSurfaceHolder;
    }

//    public MediaPlayer getMediaPlayer() {
//        return mMediaPlayer;
//    }
//
//    public Uri getUri() {
//        return uri;
//    }
//
//    public void setUri(Uri uri) {
//        this.uri = uri;
//    }

    public TestVideoView(Context context) {
        super(context);
        init();
    }

    public TestVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TestVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        //进行初始化,初始化
        SurfaceHolder holder = getHolder();
        getHolder().addCallback(mSurfaceCallBack);
    }


//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
//        int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
//        if (mVideoWidth > 0 && mVideoHeight > 0) {
//
//            int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
//            int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
//            int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
//            int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
//
//            if (widthSpecMode == MeasureSpec.EXACTLY && heightSpecMode == MeasureSpec.EXACTLY) {
//                // the size is fixed
//                width = widthSpecSize;
//                height = heightSpecSize;
//
//                // for compatibility, we adjust size based on aspect ratio
//                if (mVideoWidth * height < width * mVideoHeight) {
//                    //Log.i("@@@", "image too wide, correcting");
//                    width = height * mVideoWidth / mVideoHeight;
//                } else if (mVideoWidth * height > width * mVideoHeight) {
//                    //Log.i("@@@", "image too tall, correcting");
//                    height = width * mVideoHeight / mVideoWidth;
//                }
//            } else if (widthSpecMode == MeasureSpec.EXACTLY) {
//                // only the width is fixed, adjust the height to match aspect ratio if possible
//                width = widthSpecSize;
//                height = width * mVideoHeight / mVideoWidth;
//                if (heightSpecMode == MeasureSpec.AT_MOST && height > heightSpecSize) {
//                    // couldn't match aspect ratio within the constraints
//                    height = heightSpecSize;
//                }
//            } else if (heightSpecMode == MeasureSpec.EXACTLY) {
//                // only the height is fixed, adjust the width to match aspect ratio if possible
//                height = heightSpecSize;
//                width = height * mVideoWidth / mVideoHeight;
//                if (widthSpecMode == MeasureSpec.AT_MOST && width > widthSpecSize) {
//                    // couldn't match aspect ratio within the constraints
//                    width = widthSpecSize;
//                }
//            } else {
//                // neither the width nor the height are fixed, try to use actual video size
//                width = mVideoWidth;
//                height = mVideoHeight;
//                if (heightSpecMode == MeasureSpec.AT_MOST && height > heightSpecSize) {
//                    // too tall, decrease both width and height
//                    height = heightSpecSize;
//                    width = height * mVideoWidth / mVideoHeight;
//                }
//                if (widthSpecMode == MeasureSpec.AT_MOST && width > widthSpecSize) {
//                    // too wide, decrease both width and height
//                    width = widthSpecSize;
//                    height = width * mVideoHeight / mVideoWidth;
//                }
//            }
//        } else {
//            // no size yet, just adopt the given spec sizes
//        }
//        setMeasuredDimension(width, height);
//    }

    /**
     * 启动播放
     */
//    private void start() {
//        if (uri == null) {
//            //播放路径为空返回
//            return;
//        }
//        if (mMediaPlayer == null) {
//            //mediaplayer为空创建
//            mMediaPlayer = new MediaPlayer();
//        }
//        //重置播放
//        mMediaPlayer.reset();
//        try {
//            mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
//                @Override
//                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
//
//                }
//            });
//            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//
//                }
//            });
//            mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//                @Override
//                public boolean onError(MediaPlayer mp, int what, int extra) {
//                    return false;
//                }
//            });
//            mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//                @Override
//                public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                    return false;
//                }
//            });
//            mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
//                @Override
//                public void onBufferingUpdate(MediaPlayer mp, int percent) {
//                    //流准备的百分比
//                }
//            });
//            //设置播放的位置
//            mMediaPlayer.setDisplay(mSurfaceHolder);
//            //设置音频输出为媒体音量
//            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            //设置是否可以在播放时截屏
//            mMediaPlayer.setScreenOnWhilePlaying(false);
//            //设置播放的地址
//            mMediaPlayer.setDataSource(getContext(), uri);
//            //设置准备的监听
//            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    mVideoWidth = mp.getVideoWidth();
//                    mVideoHeight = mp.getVideoHeight();
//                    Log.d("-----------", "视频的宽高" + mVideoWidth + "     " + mVideoHeight);
//                    mSurfaceHolder.setFixedSize(mVideoWidth, mVideoHeight);
//                    requestLayout();
//                    mp.start();
//                }
//            });
//            //异步准备,因为播放的视频准备时间较长
//            mMediaPlayer.prepareAsync();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
