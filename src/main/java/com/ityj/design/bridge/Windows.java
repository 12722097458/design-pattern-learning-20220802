package com.ityj.design.bridge;

public class Windows extends OperationSystem{

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void playVideo(String fileName) {
        System.out.println("Windows播放视频");
        videoFile.decode(fileName);
    }
}
