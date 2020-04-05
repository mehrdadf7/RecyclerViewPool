package com.github.mehrdadf7.recyclerviewpool;

public class SubItem {

    private int subItemImage;
    private String sunItemTitle;
    private String sunItemDescription;

    public SubItem(int subItemImage, String sunItemTitle, String sunItemDescription) {
        this.subItemImage = subItemImage;
        this.sunItemTitle = sunItemTitle;
        this.sunItemDescription = sunItemDescription;
    }

    public int getSubItemImage() {
        return subItemImage;
    }

    public void setSubItemImage(int subItemImage) {
        this.subItemImage = subItemImage;
    }

    public String getSunItemTitle() {
        return sunItemTitle;
    }

    public void setSunItemTitle(String sunItemTitle) {
        this.sunItemTitle = sunItemTitle;
    }

    public String getSunItemDescription() {
        return sunItemDescription;
    }

    public void setSunItemDescription(String sunItemDescription) {
        this.sunItemDescription = sunItemDescription;
    }
}
