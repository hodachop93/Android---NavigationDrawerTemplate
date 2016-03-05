package com.hodachop93.hohoda.model;

/**
 * Created by Hop on 04/03/2016.
 */
public class NavigationDrawerItem {
    private String title;
    private int iconResourceId;
    private boolean showDivider;

    public NavigationDrawerItem(String title, int iconResourceId, boolean showDivider) {
        this.title = title;
        this.iconResourceId = iconResourceId;
        this.showDivider = showDivider;
    }

    public boolean isShowDivider() {
        return showDivider;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public String getTitle() {
        return title;
    }
}
