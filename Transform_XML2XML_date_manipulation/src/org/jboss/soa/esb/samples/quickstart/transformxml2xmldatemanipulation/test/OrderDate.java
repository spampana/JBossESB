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

package org.jboss.soa.esb.samples.quickstart.transformxml2xmldatemanipulation.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Sample bean for orderDate manipulation Using Java.  This type of thing is a
 * real pain in XSLT!!
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class OrderDate {
	
	private Date orderDate;
	
	/**
	 * Formatters for encoding the date in the transformation.
	 * N.B. These are not thread safe.
	 * 
	 * TimeZone information has been removed to allow for consistent testing.
	 */
	private static SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
	private static SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
	
	public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public String getDay() {
		return dayFormat.format(orderDate.getTime());
	}
	public String getTime() {
		return timeFormat.format(orderDate.getTime());
	}
	public String getMonth() {
		return monthFormat.format(orderDate.getTime());
	}
	public String getYear() {
		return yearFormat.format(orderDate.getTime());
	}
}
