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

public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeFunction();
            }
        });
        return view;
    }

    //FragmentOne和FragmentTwo之间的通信
    private void invokeFunction() {
        //执行无参数无返回的方法
        FunctionManager.getInstance().invokeFunction("noParamNoResult");
        //执行无参数有返回的方法
        String content = FunctionManager.getInstance().invokeFunction("noParamHasResult", String.class);
        Log.e("==> FragmentTwo返回值", content);
    }


}
