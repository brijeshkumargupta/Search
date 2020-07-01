package com.birjulabsinc.search.Program.Program;

public class Program {
    private String Title;
    private String Image;
    private String Desc;
    private String Name;

    public Program() {
    }

    public Program(String title, String image, String desc, String name) {
        Title = title;
        Image = image;
        Desc = desc;
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
