package com.github.kevin.universal_interface.function;

public abstract class Function {
    private String functionName;

    public Function(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

}
