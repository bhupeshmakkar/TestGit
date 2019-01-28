package com.DairyFarm.utility;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareImpl implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	public ApplicationContextAwareImpl() {}
	public ApplicationContextAwareImpl(ApplicationContext applicationContext) {
		super();
		this.applicationContext = applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
