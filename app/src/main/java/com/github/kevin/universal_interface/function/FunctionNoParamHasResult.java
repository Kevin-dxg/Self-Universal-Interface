package com.github.kevin.universal_interface.function;

public abstract class FunctionNoParamHasResult<T> extends Function{

    public FunctionNoParamHasResult(String functionName) {
        super(functionName);
    }

    public abstract T function();

}
