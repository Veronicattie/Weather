package com.example.weather2;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather2.activity.BaseActivity;
import com.example.weather2.adapter.WeatherAdapter;
import com.example.weather2.module.User;
import com.example.weather2.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;
    @BindView(R.id.btn_three)
    Button btnThree;
    @BindView(R.id.drawer)
    LinearLayout drawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<User> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        init();
    }

    private void init(){
        //recyclerview init
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        WeatherAdapter weatherAdapter = new WeatherAdapter(data);
        recyclerView.setAdapter(weatherAdapter);

       //toolbar init
        toolbar.inflateMenu(R.menu.main);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //沉浸式标题
        //StatusBarUtil.setSystemStatusColor(this,Color.TRANSPARENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void initData(){
        data = new ArrayList<User>();
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
        data.add(new User("张三"));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    //    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three})
//    public void onViewClicked(View view) {
//
//        switch (view.getId()) {
//            case R.id.btn_one:
//                break;
//            case R.id.btn_two:
//                break;
//            case R.id.btn_three:
//                break;
//        }
//    }


}
