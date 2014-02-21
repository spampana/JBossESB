package com.cbeyond.inerface.service.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.soa.esb.actions.AbstractActionPipelineProcessor;
import org.jboss.soa.esb.actions.ActionProcessingException;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class CustomAction extends AbstractActionPipelineProcessor{
	
	private static final Log LOG = LogFactory.getLog(CustomAction.class);
	
	public CustomAction(ConfigTree config){}

	@Override
	public Message process(Message message) throws ActionProcessingException {
		String name = (String) message.getBody().get("name");
		String messageStr = "Hello, "+name;
		 message.getBody().add("message",messageStr);
		LOG.info(messageStr);	
		return message;
	}
	
	public Message greeting(Message message) throws ActionProcessingException {
		String name = (String) message.getBody().get("name");
		String messageStr = "Good Morning, "+name;
		 message.getBody().add("message",messageStr);
		LOG.info(messageStr);	
		return message;
	}


}
