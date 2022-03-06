package com.smartassistance.DTOs;

import org.springframework.web.multipart.MultipartFile;

public class OCRRequest {

    private String language ;

    private  boolean isOverlayRequired ;

    private boolean iscreatesearchablepdf ;

    private boolean issearchablepdfhidetextlayer ;

    private boolean isTable ;

    private String imageBase64;

    private String filetype;

    public OCRRequest() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOverlayRequired() {
        return isOverlayRequired;
    }

    public void setOverlayRequired(boolean overlayRequired) {
        isOverlayRequired = overlayRequired;
    }

    public boolean isIscreatesearchablepdf() {
        return iscreatesearchablepdf;
    }

    public void setIscreatesearchablepdf(boolean iscreatesearchablepdf) {
        this.iscreatesearchablepdf = iscreatesearchablepdf;
    }

    public boolean isIssearchablepdfhidetextlayer() {
        return issearchablepdfhidetextlayer;
    }

    public void setIssearchablepdfhidetextlayer(boolean issearchablepdfhidetextlayer) {
        this.issearchablepdfhidetextlayer = issearchablepdfhidetextlayer;
    }

    public boolean isTable() {
        return isTable;
    }

    public void setTable(boolean table) {
        isTable = table;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
}
