package com.ityj.design.bridge;

public class Mac extends OperationSystem{

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void playVideo(String fileName) {
        System.out.println("Mac播放视频");
        videoFile.decode(fileName);
    }
}
