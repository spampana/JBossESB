/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated 
 * by the @authors tag. All rights reserved. 
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors. 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 * 
 * (C) 2005-2006,
 * @author JBoss Inc.
 */
package org.jboss.soa.esb.samples.quickstart.transformxml2pojo;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.addressing.Call;
import org.jboss.soa.esb.addressing.EPR;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Body;
import org.jboss.soa.esb.message.Header;
import org.jboss.soa.esb.message.Message;

public class MyJMSListenerAction extends AbstractActionLifecycle {

    protected ConfigTree _config;

    public MyJMSListenerAction(ConfigTree config) {
        _config = config;
    }

    public Message noOperation(Message message) {
        return message;
    }

    public Message displayMessage(Message message) throws Exception {
        logHeader();
        System.out.println(message.getBody().get());
        logFooter();
        return message;
    }

    public Message playWithMessage(Message message) throws Exception {
        Header msgHeader = message.getHeader();
        Body msgBody = message.getBody();
        Call theCall = msgHeader.getCall();
        EPR theEpr = theCall.getFrom();
        String contents = (String) msgBody.get();
        StringBuffer sb = new StringBuffer();
        sb.append("BEFORE\n");
        sb.append(contents);
        sb.append("\nAFTER");
        msgBody.add(sb.toString());
        return message;
    }

    public void exceptionHandler(Message message, Throwable exception) {
        logHeader();
        System.out.println("!ERROR!");
        System.out.println(exception.getMessage());
        System.out.println("For Message: ");
        System.out.println(message.getBody().get());
        logFooter();
    }

    public Message sendResponse(Message message) {
        try {
            logHeader();
            logFooter();
            ReturnJMSMessage.sendMessage(message, "quickstart_simple_transformation_Response", _config);
        } catch (Exception e) {
            logHeader();
            System.out.println(e.getMessage());
            logFooter();
        }
        return message; //nothing was done to this but action methods must return a Message
    }

    // This makes it easier to read on the console
    private void logHeader() {
        System.out.println("\n&&&&&&&&&&&&&&&&&&&& MyJMSListenerAction &&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    private void logFooter() {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&& MyJMSListenerAction &&&&&&&&&&&&&&&&&&&&&&&&&&\n");
    }


}
