package com.sun.service;

import java.util.List;

import com.sun.entity.Demo;

public interface IDemoService {
	boolean batchInsert(List<Demo> demo);
}
