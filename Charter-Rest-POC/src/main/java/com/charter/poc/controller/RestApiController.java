package com.charter.poc.controller;

import java.util.List;
import java.util.Map;

import org.javers.core.diff.Diff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charter.poc.service.DeviceService;
import com.spectrum.tos.model.device.Device;


@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	 
	@Autowired
	DeviceService deviceService;//Service which will do all data retrieval/manipulation work

	
	@RequestMapping(value="/deviceComparison/", method = RequestMethod.POST)
	public Map<String, Map<Object, Object>> getDeviceComparision(@RequestBody List<Device> deviceList) {
		logger.info("Fetching Difference");
		
		try {
			return deviceService.getDeviceComparision(deviceList.get(0), deviceList.get(1));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping(value="/objectComparison/", method = RequestMethod.POST)
	public Diff getObjectComparisionVal(@RequestBody List<Device> deviceList) {
		logger.info("Fetching Object Difference");
			
	  return deviceService.getObjectDiffComparisionVal(deviceList.get(0), deviceList.get(1));
		
		
	}

}