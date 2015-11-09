package com.juns.wechat.common;

import android.media.MediaRecorder;

/**
 * 项目名称：WeChat For Android Studio
 * 类描述：
 * 创建人：chengshengli
 * 创建时间：2015/10/28 15:59  15 59
 * 修改人：chengshengli
 * 修改时间：2015/10/28 15:59  15 59
 * 修改备注：
 */
public class VoiceUtils {

    MediaRecorder recorder;
    public  void setRecorder(){
       this. recorder=new MediaRecorder();
        this.recorder.setAudioSource(MediaRecorder.AudioSource.MIC);//1
        recorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);//3
        this.recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//1
        this.recorder.setAudioChannels(1);
        this.recorder.setAudioSamplingRate(8000);
        this.recorder.setAudioEncodingBitRate(64);
        //this.recorder.setOutputFile(mSampleFile.getAbsolutePath());
    }




}
