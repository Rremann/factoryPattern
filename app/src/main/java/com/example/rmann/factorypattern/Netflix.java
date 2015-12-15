package com.example.rmann.factorypattern;

/**
 * Created by rmann on 12/2/15.
 */
public class Netflix implements CableService {

    @Override
    public String watch(String movie){
        switch(movie){
            case "Cabin Fever":message.append("Cabin Fever");
                break;
            case "The Taking of Deborah Logan": message.append("The Taking of Deborah Logan");
                break;
            default: return error.toString();
        }
        return message.toString();
    }

}
