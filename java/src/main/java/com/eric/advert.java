package com.eric;

/**
 * @author Chen 2017/11/8
 */
public class advert {
    private String url;
    private String picUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "advert{" +
                "url='" + url + '\'' +"\n";
    }
}
