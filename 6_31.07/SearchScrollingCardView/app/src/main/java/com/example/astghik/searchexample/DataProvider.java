package com.example.astghik.searchexample;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static List<User> users = new ArrayList<>();

    public static void fillUsers() {
        String url_Gevorg = "https://3.bp.blogspot.com/-9Iu3-Xnvtig/Wntv1F6CKII/AAAAAAAAAR0/CvCLy-jFSUIfM9vjj6UdjZigK7LKBnSPgCLcBGAs/s1600/2.jpg";
        String url_Astghik = "https://as.ftcdn.net/r/v1/pics/ea2e0032c156b2d3b52fa9a05fe30dedcb0c47e3/landing/images_photos.jpg";

        users.add(new User(url_Astghik, "Astghik", "Junior developer", "astghik@gmail.com", "069770500",5F));
        users.add(new User(url_Gevorg, "Gevorg", "Lav tgha", "gevorg94@gmail.com", "069900500",5F));
        users.add(new User(url_Gevorg, "Gevorg", "Lav tgha", "gevorg94@gmail.com", "069900500",5F));
        users.add(new User(url_Gevorg, "Gevorg", "Lav tgha", "gevorg94@gmail.com", "069900500",5F));
        users.add(new User(url_Gevorg, "Gevorg", "Lav tgha", "gevorg94@gmail.com", "069900500",5F));
        users.add(new User(url_Gevorg, "Gevorg", "Lav tgha", "gevorg94@gmail.com", "069900500",5F));
    }
}
