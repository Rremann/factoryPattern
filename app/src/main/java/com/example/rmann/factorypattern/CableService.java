package com.example.rmann.factorypattern;

/**
 * Created by rmann on 12/2/15.
 */
public interface CableService {

    StringBuilder message = new StringBuilder("Playing ");
    StringBuilder error = new StringBuilder("Unable to play ");

    String watch(String movie);

}
