package com.aoshen.fengyu.david_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injection();
        presenter.startWorking();
    }

    private void injection() {
        AppComponent component = DaggerAppComponent.create();

        component.inject(this);
    }
}
