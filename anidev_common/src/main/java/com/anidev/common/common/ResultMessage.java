package com.anidev.common.common;

import lombok.Data;

/**
 * @author suzhengang
 * @create 2023-05-17
 */
@Data
public class ResultMessage {
    private int code;
    private String message;
    private Object data;

    public ResultMessage() {
    }

    public ResultMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultMessage(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResultMessage(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
