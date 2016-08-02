package com.pingtop.android.entities.response;

/**
 * Created by wuhaojie on 2016/8/1 19:14.
 */
public class GudienceResponse {

    /**
     * timeStamp : 1
     * title : 1
     * backgroundPath : 1
     * text : 1
     */

    private String timeStamp;
    private String title;
    private String backgroundPath;
    private String text;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public void setBackgroundPath(String backgroundPath) {
        this.backgroundPath = backgroundPath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "GudienceResponse{" +
                "timeStamp='" + timeStamp + '\'' +
                ", title='" + title + '\'' +
                ", backgroundPath='" + backgroundPath + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
