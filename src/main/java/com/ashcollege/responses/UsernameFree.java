package com.ashcollege.responses;

import java.util.List;

public class UsernameFree extends BasicResponse{
    private boolean free;
    public UsernameFree(){

    }

    public UsernameFree(boolean free) {
        this.free = free;
    }

    public UsernameFree(boolean success, Integer errorCode, boolean free) {
        super(success, errorCode);
        this.free = free;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
