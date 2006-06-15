/**
 *
 * Copyright 2005-2006 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.broker.jmx;

import java.util.Map;

import javax.jms.InvalidSelectorException;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.TabularData;


public interface DestinationViewMBean {
    
    /**
     * Returns the name of this destination
     */
    public String getName();
    
	/**
	 * Resets the managment counters.
	 */
    public void resetStatistics();

    /**
     * @return The number of messages that have been sent to the destination.
     */
    public long getEnqueueCount();

    /**
     * @return The number of messages that have been received from the destination.
     */
    public long getDequeueCount();

    /**
     * @return The number of consmers subscribed to messages from this destination.
     */
    public long getConsumerCount();

    /**
     * @return The number of messages being buffered by this destination
     */
    public long getQueueSize();
    
    /**
     * @return An array of all the messages in the destination's queue.
     */
    public CompositeData[] browse() throws OpenDataException;
    
    /**
     * @return A list of all the messages in the destination's queue.
     */
    public TabularData browseAsTable() throws OpenDataException;

    /**
     * @return An array of all the messages in the destination's queue.
     * @throws InvalidSelectorException 
     */
    public CompositeData[] browse(String selector) throws OpenDataException, InvalidSelectorException;
    
    /**
     * @return A list of all the messages in the destination's queue.
     * @throws InvalidSelectorException 
     */
    public TabularData browseAsTable(String selector) throws OpenDataException, InvalidSelectorException;

    /**
     * Sends a TextMesage to the destination.
     * @param body the text to send
     * @return the message id of the message sent.
     * @throws Exception
     */
    public String sendTextMessage(String body) throws Exception;

    /**
     * Sends a TextMesage to the destination.
     * @param headers the message headers and properties to set.  Can only container Strings maped to primitive types.
     * @param body the text to send
     * @return the message id of the message sent.
     * @throws Exception
     */
    public String sendTextMessage(Map headers, String body) throws Exception;

    public int getMemoryPercentageUsed();
    public long getMemoryLimit();
    public void setMemoryLimit(long limit);

}