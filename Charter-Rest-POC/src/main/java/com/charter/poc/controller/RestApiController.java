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
import com.charter.poc.service.ObjectService;
import com.spectrum.tos.model.account.Service;
import com.spectrum.tos.model.device.Device;


@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	 
	@Autowired
	DeviceService deviceService;//Service which will do Device object comparison

	@Autowired
	ObjectService <Device>deviceObjectService; //Service which will do all object comparison
	
	@Autowired
	ObjectService <Service>serviceObjectService; //Service which will do all object comparison
	
	@RequestMapping(value="/comparison/", method = RequestMethod.POST)
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
	
	@RequestMapping(value="/deviceComparison/", method = RequestMethod.POST)
	public Diff getDeviceComparisionVal(@RequestBody List<Device> deviceList) {
		logger.info("Fetching Object Difference");
			
	  return deviceService.getDeviceObjDiffComparisionVal(deviceList.get(0), deviceList.get(1));
		
		
	}
	
	@RequestMapping(value="/deepDeviceComparison/", method = RequestMethod.POST)
	public Diff getDeviceObjectComparisionVal(@RequestBody List<Device> deviceList) {
		logger.info("Fetching Object Difference");
			
		 if(!deviceList.isEmpty() && deviceList.size() == 2)	
		return deviceObjectService.getDeviceObjDiffComparisionVal(deviceList.get(0), deviceList.get(1));
		return null;
		
	}
	
	@RequestMapping(value="/deepServiceComparison/", method = RequestMethod.POST)
	public Diff getServiceObjectComparisionVal(@RequestBody List<Service> serviceList) {
		logger.info("Fetching Object Difference");
	  
	 if(!serviceList.isEmpty() && serviceList.size() == 2)	
	  return serviceObjectService.getDeviceObjDiffComparisionVal(serviceList.get(0), serviceList.get(1));
	  return null;	
		
	}
	
	

}