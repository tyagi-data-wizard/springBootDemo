package com.Ujjwal.springBootDemo.error;

public class DepartmentNotFoundException extends Exception{
    /**
     *
     */
     public DepartmentNotFoundException() {
        super();
    }

    /**
     * @param message
     */
    public DepartmentNotFoundException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
