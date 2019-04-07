package com.github.kevin.universal_interface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.kevin.universal_interface.adapter.MyAdapter;
import com.github.kevin.universal_interface.bean.User;
import com.github.kevin.universal_interface.fragment.FragmentOne;
import com.github.kevin.universal_interface.fragment.FragmentThree;
import com.github.kevin.universal_interface.fragment.FragmentTwo;
import com.github.kevin.universal_interface.function.FunctionHasParamHasResult;
import com.github.kevin.universal_interface.function.FunctionHasParamNoResult;
import com.github.kevin.universal_interface.function.FunctionManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments.add(new FragmentOne());
        fragments.add(new FragmentTwo());
        fragments.add(new FragmentThree());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), fragments));

        initFunction();
    }

    //FragmentThree中执行
    private void initFunction() {
        //注册有参数没有返回值的方法
        FunctionManager.getInstance().addFunction(new FunctionHasParamNoResult<String>("hasParamNoResult") {
            @Override
            public void function(String s) {
                Log.e("==> MainActivity：", "无返回值有参数方法被调用，参数为：" + s);
            }
        });
        //注册有参数有返回值的方法
        FunctionManager.getInstance().addFunction(new FunctionHasParamHasResult<User, User>("hasParamHasResult") {
            @Override
            public User function(User user) {
                Log.e("==> MainActivity：", "有返回值有参数方法被调用，参数为：" + user.toString());

                return new User("王老师", "123321");
            }
        });
    }

}
