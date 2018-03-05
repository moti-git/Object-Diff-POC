package com.charter.poc.service;

import org.javers.core.diff.Diff;
import org.springframework.stereotype.Service;

import com.charter.poc.util.DSComparisonUtil;



@Service("objectService")
public class ObjectServiceImpl<T> implements ObjectService<T>{

	@Override
	public Diff getDeviceObjDiffComparisionVal(T t1, T t2) {
		return DSComparisonUtil.getObjectDiffComparisionVal(t1, t2);
	}
	
	
	
}
