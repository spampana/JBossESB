package org.jboss.soa.esb.samples.quickstart.helloworld;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class MyJMSListenerAction extends AbstractActionLifecycle
{

    protected ConfigTree    _config;

    public MyJMSListenerAction(ConfigTree config) {
        _config = config;
    }

    public Message displayMessage(Message message) throws Exception{

        System.out.println("Body: " +message.getBody().get());          
        return message;

    }


}