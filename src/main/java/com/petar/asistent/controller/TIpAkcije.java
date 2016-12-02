package com.petar.asistent.controller;

public enum TIpAkcije {
    
    LIST("list"),
    ADD("add"),
    EDIT("edit"),
    DELETE("delete");
    
    private final String action;

    private TIpAkcije(String action) {
        this.action = action;
    }
    
    public static TIpAkcije getForAction(String action){
        for(TIpAkcije tipAkcije : values()){
            if(tipAkcije.action.equals(action)){
                return tipAkcije;
            }
        }
        return LIST;
    }
    
}
