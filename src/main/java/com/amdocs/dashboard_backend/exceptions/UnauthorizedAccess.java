package com.amdocs.dashboard_backend.exceptions;

public class UnauthorizedAccess extends RuntimeException{
    public UnauthorizedAccess(String message){
        super(message);
    }
}
