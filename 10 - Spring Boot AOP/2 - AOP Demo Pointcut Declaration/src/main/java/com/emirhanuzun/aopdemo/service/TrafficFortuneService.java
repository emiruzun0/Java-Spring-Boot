package com.emirhanuzun.aopdemo.service;

import org.springframework.stereotype.Service;


public interface TrafficFortuneService {

    String getFortune();

    String getFortune(boolean tripWire);
}
