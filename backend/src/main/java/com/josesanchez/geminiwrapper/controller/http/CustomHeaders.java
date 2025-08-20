/*
 *  ItemClassificationsControllerTest.java
 * Copyright 2022 AutoZone, Inc.
 * Content is confidential to and proprietary information of AutoZone, Inc., its
 *  subsidiaries and affiliates.
 */
package com.josesanchez.geminiwrapper.controller.http;

/**
 * A collection of commonly used custom header names
 */
public class CustomHeaders {

    /**
     * Resource id for a newly created resource
     */
    public static final String RESOURCE_ID_HEADER = "Resource-Id";

    /**
     * Error message for a failed request
     */
    public static final String ERROR_MESSAGE_HEADER = "Error-Message";

    /**
     * Request Id for relating call logs physical service boundaries
     */
    public static final String REQUEST_ID_HEADER = "Request-Id";

    private CustomHeaders() {
    }
}