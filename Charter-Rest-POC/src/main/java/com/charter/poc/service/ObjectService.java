package com.charter.poc.service;


import org.javers.core.diff.Diff;

public interface ObjectService<T> {
	

	public Diff getDeviceObjDiffComparisionVal(T t1, T t2);
			
	
}
