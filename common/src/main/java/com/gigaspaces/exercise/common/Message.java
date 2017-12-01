/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gigaspaces.exercise.common;

import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;

/**
 * A simple object used to work with the Space.
 */
public class Message {

    private Long id;
    private City city;
    private Boolean processed = false;
    private Boolean eligible = false;

    /**
     * Necessary Default constructor
     */
    public Message() {
    }

    /**
     * Constructs a new Message with the given id and info and info.
     */
    public Message(Long id,City city) {
        this.id = id;
        this.city = city;
    }

    /**
     * The id of this message. We will use this attribute to route the message objects when they are
     * written to the space, defined in the Message.gs.xml file.
     */
    @SpaceId
    @SpaceRouting
    public Long getId() {
        return id;
    }

    /**
     * The id of this message.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getEligible() {
        return eligible;
    }

    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }
}
