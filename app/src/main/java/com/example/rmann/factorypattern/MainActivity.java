package com.example.rmann.factorypattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ServiceFactory sFactory;
    private CableService cService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sFactory = new ServiceFactory(this);
        findViewById(R.id.search_movie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }

        });

        findViewById(R.id.hulu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectProvider((TextView) v);
            }

        });

        findViewById(R.id.netflix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectProvider((TextView) v);
            }

        });

    }


    public void selectProvider(TextView v) {
        if (v.getText().equals("Netflix")) {
            findViewById(R.id.hulu).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.netflix).setVisibility(View.INVISIBLE);
        }
        cService = sFactory.selectProvider(ServiceFactory.Provider.from(v.getText().toString()));
    }

    public void search() {
        if (findViewById(R.id.netflix).getVisibility() == View.VISIBLE && findViewById(R.id.hulu).getVisibility() == View.VISIBLE) {
            ((TextView) findViewById(R.id.returnMessage)).setText("Please select a provider");
        } else if (((TextView) findViewById(R.id.search)).getText().equals(null)) {
            ((TextView) findViewById(R.id.returnMessage)).setText("Please enter a movie");

        }else{
            ((TextView) findViewById(R.id.returnMessage))
                    .setText(cService.watch(((TextView) findViewById(R.id.search)).getText().toString()));

        }


    }


}
