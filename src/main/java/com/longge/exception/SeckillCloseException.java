package com.longge.exception;

/**
 * @author longge
 * @create 2019-11-27 下午3:59
 */
//秒杀关闭异常
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
