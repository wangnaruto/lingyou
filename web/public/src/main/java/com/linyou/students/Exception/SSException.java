package com.linyou.students.Exception;

/**
 * Created by shuli on 16/2/4.
 */
public class SSException extends RuntimeException {

    public SSException(){
        super();
    }

    public SSException(Exception e){
        super(e.getCause());
    }
}
