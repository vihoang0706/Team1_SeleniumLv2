package com.logigear.training.models;

public class Page {
    public void addPage(Info info) {
        if(info.pageName==null) {
        }
    }
    public static class Info {
        private String pageName;
        private String parentPage;
        private String numberOfColumns;
        private String displayAfter;
        private String isPublic;

        public Info() {
        }
    }
}
