package com.github.kevin.universal_interface.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.kevin.universal_interface.R;
import com.github.kevin.universal_interface.bean.User;
import com.github.kevin.universal_interface.function.FunctionManager;

public class FragmentThree extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, null);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeFunction();
            }
        });

        return view;
    }

    //FragmentThree与MainActivity之间的通信
    private void invokeFunction() {
        //执行有参数无返回的方法
        FunctionManager.getInstance().invokeFunction("hasParamNoResult", "Hello from the FragmentOne");
        //执行有参数有返回的方法
        User user = FunctionManager.getInstance().invokeFunction("hasParamHasResult",
                new User("张三", "11111"), User.class);
        Log.e("==> FragmentThree：", user.toString());
    }
}
