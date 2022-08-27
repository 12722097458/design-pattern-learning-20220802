package com.ityj.design.bridge;

public abstract class OperationSystem {

    protected VideoFile videoFile;

    protected OperationSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void playVideo(String fileName);

}
