package com.github.kevin.universal_interface.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.kevin.library.FunctionManager;
import com.github.kevin.universal_interface.R;
import com.github.kevin.library.function.FunctionNoParamHasResult;
import com.github.kevin.library.function.FunctionNoParamNoResult;

public class FragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        initFunction();
        return view;
    }

    //FragmentTwo中执行
    private void initFunction() {
        //注册没有参数没有返回值的方法
        FunctionManager.getInstance().addFunction(new FunctionNoParamNoResult("noParamNoResult") {
            @Override
            public void function() {
                Log.e("==> FragmentOne：", "function: 无返回值，无参数");
            }
        });
        //注册没有参数有返回值的方法
        FunctionManager.getInstance().addFunction(new FunctionNoParamHasResult<String>("noParamHasResult") {
            @Override
            public String function() {
                Log.e("==> FragmentOne：", "function: 有返回值，无参数");
                return "hello from FragmentOne";
            }
        });
    }

}
