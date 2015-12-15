package com.example.rmann.factorypattern;

/**
 * Created by rmann on 12/2/15.
 */
public class Hulu implements CableService{

    @Override
    public String watch(String movie){
        switch(movie){
            case "Wonderland":message.append("Alice In Wonderland");
                break;
            case "Peter Pan": message.append("Peter Pan");
                break;
            default: return error.toString();
        }
        return message.toString();
    }
}
