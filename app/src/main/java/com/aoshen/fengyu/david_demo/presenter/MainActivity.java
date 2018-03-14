package com.aoshen.fengyu.david_demo.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aoshen.fengyu.david_demo.R;
import com.aoshen.fengyu.david_demo.di.AppComponent;
import com.aoshen.fengyu.david_demo.di.AppModule;
import com.aoshen.fengyu.david_demo.di.DaggerAppComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private AppComponent component;

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
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        component.inject(this);
    }
}
