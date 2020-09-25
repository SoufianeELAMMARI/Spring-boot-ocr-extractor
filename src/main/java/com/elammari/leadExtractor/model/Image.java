package com.elammari.leadExtractor.model;


public class Image{
    private String name;
    private String email;
    private String phone;
    private String webSite;

    public Image() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image(String name, String email, String phone, String webSite) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.webSite = webSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}

