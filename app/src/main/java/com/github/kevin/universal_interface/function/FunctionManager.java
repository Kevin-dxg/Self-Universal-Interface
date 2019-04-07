package com.github.kevin.universal_interface.function;

import android.text.TextUtils;

import com.github.kevin.universal_interface.bean.User;

import java.util.HashMap;
import java.util.Map;

public class FunctionManager {
    private static volatile FunctionManager instance;
    private Map<String, FunctionNoParamNoResult> noParamNoResultMap;
    private Map<String, FunctionNoParamHasResult> noParamHasResultMap;
    private Map<String, FunctionHasParamNoResult> hasParamNoResultMap;
    private Map<String, FunctionHasParamHasResult> hasParamHasResultMap;

    private FunctionManager() {
        noParamNoResultMap = new HashMap<>();
        noParamHasResultMap = new HashMap<>();
        hasParamNoResultMap = new HashMap<>();
        hasParamHasResultMap = new HashMap<>();
    }

    public static FunctionManager getInstance() {
        if (instance == null) {
            synchronized (FunctionManager.class) {
                if (instance == null) {
                    instance = new FunctionManager();
                }
            }
        }
        return instance;
    }

    //添加没有参数也没有返回值的方法
    public void addFunction(FunctionNoParamNoResult function) {
        noParamNoResultMap.put(function.getFunctionName(), function);
    }

    public void addFunction(FunctionNoParamHasResult function) {
        noParamHasResultMap.put(function.getFunctionName(), function);
    }

    public void addFunction(FunctionHasParamNoResult function) {
        hasParamNoResultMap.put(function.getFunctionName(), function);
    }

    public void addFunction(FunctionHasParamHasResult function) {
        hasParamHasResultMap.put(function.getFunctionName(), function);
    }

    //执行没有参数也没有返回值的方法
    public void invokeFunction(String functionName) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        if (noParamNoResultMap != null && noParamNoResultMap.size() > 0) {
            FunctionNoParamNoResult function = noParamNoResultMap.get(functionName);
            if (function != null) {
                function.function();
            } else {
                throw new RuntimeException("has no this function：" + functionName);
            }
        }
    }

    //执行没有参数有返回值的方法
    public <T> T invokeFunction(String functionName, Class<T> t) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        if (noParamHasResultMap != null && noParamHasResultMap.size() > 0) {
            FunctionNoParamHasResult function = noParamHasResultMap.get(functionName);
            if (function != null) {
                return t.cast(function.function());
            } else {
                throw new RuntimeException("has no this function：" + functionName);
            }
        }
        return null;
    }

    //执行有参数没有返回值的方法
    public <P> void invokeFunction(String functionName, P p) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        if (hasParamNoResultMap != null && hasParamNoResultMap.size() > 0) {
            FunctionHasParamNoResult function = hasParamNoResultMap.get(functionName);
            if (function != null) {
                function.function(p);
            } else {
                throw new RuntimeException("has no this function：" + functionName);
            }
        }
    }

    //执行有参数有返回值的方法
    public <T, P> T invokeFunction(String functionName, P p, Class<T> t) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        if (hasParamHasResultMap != null && hasParamHasResultMap.size() > 0) {
            FunctionHasParamHasResult function = hasParamHasResultMap.get(functionName);
            if (function != null && t != null) {
                return t.cast(function.function(p));
            } else {
                throw new RuntimeException("has no this function：" + functionName);
            }
        }
        return null;
    }


}
