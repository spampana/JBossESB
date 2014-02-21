package com.cbeyond.service;

import org.jboss.soa.esb.client.ServiceInvoker;
import org.jboss.soa.esb.couriers.FaultMessageException;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;
import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.message.format.MessageFactory;
import org.jboss.soa.esb.services.registry.RegistryException;

public class DemoServiceImpl implements DemoService {
	
	private String esbServiceCategory = "DemoService";

	@Override
	public String getHelloString(String name) {
		return getMessage(name,"HelloWorldService");
	}

	@Override
	public String getGreeetingString(String name) {
		return getMessage(name,"GoodMorningService");
	}
	
	private String getMessage(String name, String esbServiceName){
		String _retValue = "";
		try {
			Message esbMessage = MessageFactory.getInstance().getMessage();
			ServiceInvoker si = new ServiceInvoker(esbServiceCategory,esbServiceName);
			esbMessage.getBody().add("name", name);
			esbMessage = si.deliverSync(esbMessage, 10000L);	
			if(esbMessage.getBody().get("message") != null){
				_retValue = (String) esbMessage.getBody().get("message");
			}
		} catch (MessageDeliverException e) {
			
		} catch (FaultMessageException e) {
			
		} catch (RegistryException e) {
			
		}
		
		return _retValue;
	}
}
