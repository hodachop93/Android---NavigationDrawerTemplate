package com.hodachop93.hohoda.model;

public class MenuItem {

    private boolean showDivider;
    private int badges;
    private int iconResourceId;
    private String title;

    public MenuItem(String title, int iconResourceId, boolean showDivider) {
        this.title = title;
        this.iconResourceId = iconResourceId;
        this.showDivider = showDivider;
    }

    public boolean isShowDivider() {
        return showDivider;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public String getTitle() {
        return title;
    }
}
