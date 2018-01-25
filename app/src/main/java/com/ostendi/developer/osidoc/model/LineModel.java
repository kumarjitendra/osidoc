package com.ostendi.developer.osidoc.model;

/**
 * Created by jitendra on 24/01/2018.
 */

public class LineModel {
    private String value;
    private static boolean selected;

    public LineModel(String value_) {
        value = value_;
    }

    public static void setSelected(boolean selected) {
        LineModel.selected = selected;
    }

    public static boolean getSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
