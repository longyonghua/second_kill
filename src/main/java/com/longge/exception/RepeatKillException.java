package com.longge.exception;

/**
 * @author longge
 * @create 2019-11-27 下午3:56
 */
//重复秒杀异常
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
