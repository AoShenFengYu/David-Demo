package com.aoshen.fengyu.david_demo;

import javax.inject.Inject;

/**
 * Created by kika-david on 2018/3/6.
 */

public class Presenter {

    private Model model;

    @Inject
    public Presenter(Model model) {
        this.model = model;
    }
}
