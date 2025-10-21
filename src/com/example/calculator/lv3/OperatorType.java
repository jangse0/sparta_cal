package com.example.calculator.lv3;

public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private char value;
    private OperatorType(char value) {
        this.value = value;
    }
    public char getValue() {
        return value;
    }

    public static OperatorType valueOf(char value) {
        for (OperatorType type : OperatorType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("올바른 연산자(+, -, *, /)를 입력해주세요.");
    }
}
