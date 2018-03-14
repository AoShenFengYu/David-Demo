package com.aoshen.fengyu.david_demo.view;

import com.aoshen.fengyu.david_demo.presenter.IPresenter;
import com.aoshen.fengyu.david_demo.presenter.MainActivity;

/**
 * Created by kika-david on 2018/3/13.
 */

public class View implements IView {

    private IPresenter presenter;
    private MainActivity mainActivity;

    public View(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }
}
