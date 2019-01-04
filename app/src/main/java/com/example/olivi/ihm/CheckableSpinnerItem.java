package com.example.olivi.ihm;

// Adapted from https://stackoverflow.com/questions/38417984/android-spinner-dropdown-checkbox
public class CheckableSpinnerItem {

    private String title;
    private boolean selected;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public CheckableSpinnerItem(String title) {
        setTitle(title);
        setSelected(false);
    }
    public CheckableSpinnerItem(String title, boolean selected) {
        setTitle(title);
        setSelected(selected);
    }
}
