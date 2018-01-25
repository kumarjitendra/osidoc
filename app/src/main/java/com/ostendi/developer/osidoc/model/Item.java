package com.ostendi.developer.osidoc.model;

/**
 * Created by jitendra on 24/01/2018.
 */

public class Item {
    private String value;
    private static boolean selected;

    public Item(String label) {
        value = label;
    }

    public static void setSelected(boolean selected) {
        Item.selected = selected;
    }

    public static boolean getSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
