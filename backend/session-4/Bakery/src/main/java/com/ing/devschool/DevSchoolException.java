package com.ing.devschool;

public class DevSchoolException extends Exception {

    public DevSchoolException() {
        super();
    }

    public DevSchoolException(String s) {
        super(s);
    }

    public DevSchoolException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DevSchoolException(Throwable throwable) {
        super(throwable);
    }
}
