/*
 * Copyright (c) 2020 Andrsuh INC.
 * All Rights Reserved
 *
 * This software contains the intellectual property of Andrsuh INC or is
 * licensed to Dell EMC from third parties. Use of this software and the
 * intellectual property contained therein is expressly limited to the terms and
 * conditions of the License Agreement under which it is provided by or on behalf
 * of Andrsuh INC.
 */
package com.wine.to.up.notification.service.api.feign;

import com.wine.to.up.notification.service.api.dto.NotificationServiceMessage;
import com.wine.to.up.notification.service.api.service.NotificationService;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

/**
 * Defines the parameters and paths of REST API of Kafka Service
 * <p>
 * Java feign client will be generated based on this declaration.
 * <p>
 * Docker swarm's load balancing will resolve
 * the name of the service and request will be redirected to the particular instance.
 */
public interface NotificationServiceClient extends NotificationService {
    /**
     * {@inheritDoc}
     */
    @RequestLine(value = "POST /kafka/send")
    @Headers("Content-Type: application/json")
    void sendMessage(String message);

    /**
     * {@inheritDoc}
     */
    @RequestLine(value = "POST /kafka/send/headers")
    @Headers("Content-Type: application/json")
    void sendMessageWithHeaders(NotificationServiceMessage messageWithHeaders);

    /**
     * {@inheritDoc}
     */
    @RequestLine(value = "GET /message")
    List<String> getSentMessages();
}
