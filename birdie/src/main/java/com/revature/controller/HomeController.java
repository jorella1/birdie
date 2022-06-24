package com.revature.controller;

import io.javalin.http.Handler;

public class HomeController {
    public static Handler homePageEntered = ctx ->{
        ctx.redirect("index.html");
    };
}
