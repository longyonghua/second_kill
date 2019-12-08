package com.longge.exception;

/**
 * @author longge
 * @create 2019-11-27 下午4:00
 */
//秒杀相关业务异常
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
