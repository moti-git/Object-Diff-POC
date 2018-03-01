package com.charter.poc.service;


import java.util.Map;

import org.javers.core.diff.Diff;

import com.spectrum.tos.model.device.Device;

public interface DeviceService {
	
	public Map<String, Map<Object, Object>> getDeviceComparision(Device device1, Device device2) 
			throws IllegalArgumentException, IllegalAccessException;
	
	public Diff getObjectDiffComparisionVal(Device device1, Device device2);
			
	
}
