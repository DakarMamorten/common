package com.wsh.domain;

import lombok.Data;

/**
 * @author "Vladyslav Paun"
 */
@Data
public class Calculator {

    private double value1;
    private double value2;
    private Operation operation;

    public double calc() {
        double res = 0;
        switch (operation) {
            case ADD:
                res = value1 + value2;
                break;
            case SUBTRACT:
                res = value1 - value2;
                break;
            case MULTIPLY:
                res = value1 * value2;
                break;
            case DIVIDE:
                if (value2 == 0) {
                    res = 0;
                } else {
                    res = value1 / value2;
                }
                break;
            default:
        }
        return res;
    }

}

