package com.lpu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.lpu","com.lpu.enitity","com.lpu.dao","com.lpu.service","com.lpu.controller"}) 
@Configuration
public class MyConfig { 
	
}