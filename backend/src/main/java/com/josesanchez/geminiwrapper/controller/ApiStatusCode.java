package com.josesanchez.geminiwrapper.controller;

/**
 * This is a convenience class that provides that HTTP Status codes as integers rather than the
 * Spring enum HttpStatus for use with @ApiResponse annotations
 */
public final class ApiStatusCode {

    /**
     * {@code 100 Continue}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.2.1">HTTP/1.1:
     * Semantics and Content, section 6.2.1</a>
     */
    public static final String CONTINUE = "100";
    /**
     * {@code 101 Switching Protocols}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.2.2">HTTP/1.1:
     * Semantics and Content, section 6.2.2</a>
     */
    public static final String SWITCHING_PROTOCOLS = "101";
    /**
     * {@code 102 Processing}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2518#section-10.1">WebDAV</a>
     */
    public static final String PROCESSING = "102";
    /**
     * {@code 103 Checkpoint}.
     *
     * @see <a href=
     * "https://code.google.com/p/gears/wiki/ResumableHttpRequestsProposal">A
     * proposal for supporting resumable POST/PUT HTTP requests in HTTP/1.0</a>
     */
    public static final String CHECKPOINT = "103";

    // 2xx Success

    /**
     * {@code 200 OK}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.3.1">HTTP/1.1:
     * Semantics and Content, section 6.3.1</a>
     */
    public static final String OK = "200";
    /**
     * {@code 201 Created}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.3.2">HTTP/1.1:
     * Semantics and Content, section 6.3.2</a>
     */
    public static final String CREATED = "201";
    /**
     * {@code 202 Accepted}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.3.3">HTTP/1.1:
     * Semantics and Content, section 6.3.3</a>
     */
    public static final String ACCEPTED = "202";
    /**
     * {@code 203 Non-Authoritative Information}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.3.4">HTTP/1.1:
     * Semantics and Content, section 6.3.4</a>
     */
    public static final String NON_AUTHORITATIVE_INFORMATION = "203";
    /**
     * {@code 204 No Content}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.3.5">HTTP/1.1:
     * Semantics and Content, section 6.3.5</a>
     */
    public static final String NO_CONTENT = "204";
    /**
     * {@code 205 Reset Content}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.3.6">HTTP/1.1:
     * Semantics and Content, section 6.3.6</a>
     */
    public static final String RESET_CONTENT = "205";
    /**
     * {@code 206 Partial Content}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7233#section-4.1">HTTP/1.1:
     * Range Requests, section 4.1</a>
     */
    public static final String PARTIAL_CONTENT = "206";
    /**
     * {@code 207 Multi-Status}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc4918#section-13">WebDAV</a>
     */
    public static final String MULTI_STATUS = "207";
    /**
     * {@code 208 Already Reported}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc5842#section-7.1">WebDAV Binding
     * Extensions</a>
     */
    public static final String ALREADY_REPORTED = "208";
    /**
     * {@code 226 IM Used}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc3229#section-10.4.1">Delta
     * encoding in HTTP</a>
     */
    public static final String IM_USED = "226";

    // 3xx Redirection

    /**
     * {@code 300 Multiple Choices}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.4.1">HTTP/1.1:
     * Semantics and Content, section 6.4.1</a>
     */
    public static final String MULTIPLE_CHOICES = "300";
    /**
     * {@code 301 Moved Permanently}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.4.2">HTTP/1.1:
     * Semantics and Content, section 6.4.2</a>
     */
    public static final String MOVED_PERMANENTLY = "301";
    /**
     * {@code 302 Found}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.4.3">HTTP/1.1:
     * Semantics and Content, section 6.4.3</a>
     */
    public static final String FOUND = "302";
    /**
     * {@code 302 Moved Temporarily}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc1945#section-9.3">HTTP/1.0,
     * section 9.3</a>
     * @deprecated in favor of {@link #FOUND} which will be returned from
     * {@code HttpStatus.valueOf(302)}
     */
    @Deprecated
    public static final String MOVED_TEMPORARILY = "302";
    /**
     * {@code 303 See Other}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.4.4">HTTP/1.1:
     * Semantics and Content, section 6.4.4</a>
     */
    public static final String SEE_OTHER = "303";
    /**
     * {@code 304 Not Modified}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7232#section-4.1">HTTP/1.1:
     * Conditional Requests, section 4.1</a>
     */
    public static final String NOT_MODIFIED = "304";
    /**
     * {@code 305 Use Proxy}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.4.5">HTTP/1.1:
     * Semantics and Content, section 6.4.5</a>
     * @deprecated due to security concerns regarding in-band configuration of a
     * proxy
     */
    @Deprecated
    public static final String USE_PROXY = "305";
    /**
     * {@code 307 Temporary Redirect}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.4.7">HTTP/1.1:
     * Semantics and Content, section 6.4.7</a>
     */
    public static final String TEMPORARY_REDIRECT = "307";
    /**
     * {@code 308 Permanent Redirect}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7238">RFC 7238</a>
     */
    public static final String PERMANENT_REDIRECT = "308";

    // --- 4xx Client Error ---

    /**
     * {@code 400 Bad Request}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.1">HTTP/1.1:
     * Semantics and Content, section 6.5.1</a>
     */
    public static final String BAD_REQUEST = "400";
    /**
     * {@code 401 Unauthorized}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7235#section-3.1">HTTP/1.1:
     * Authentication, section 3.1</a>
     */
    public static final String UNAUTHORIZED = "401";
    /**
     * {@code 402 Payment Required}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.2">HTTP/1.1:
     * Semantics and Content, section 6.5.2</a>
     */
    public static final String PAYMENT_REQUIRED = "402";
    /**
     * {@code 403 Forbidden}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.3">HTTP/1.1:
     * Semantics and Content, section 6.5.3</a>
     */
    public static final String FORBIDDEN = "403";
    /**
     * {@code 404 Not Found}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.4">HTTP/1.1:
     * Semantics and Content, section 6.5.4</a>
     */
    public static final String NOT_FOUND = "404";
    /**
     * {@code 405 Method Not Allowed}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.5">HTTP/1.1:
     * Semantics and Content, section 6.5.5</a>
     */
    public static final String METHOD_NOT_ALLOWED = "405";
    /**
     * {@code 406 Not Acceptable}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.6">HTTP/1.1:
     * Semantics and Content, section 6.5.6</a>
     */
    public static final String NOT_ACCEPTABLE = "406";
    /**
     * {@code 407 Proxy Authentication Required}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7235#section-3.2">HTTP/1.1:
     * Authentication, section 3.2</a>
     */
    public static final String PROXY_AUTHENTICATION_REQUIRED = "407";
    /**
     * {@code 408 Request Timeout}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.7">HTTP/1.1:
     * Semantics and Content, section 6.5.7</a>
     */
    public static final String REQUEST_TIMEOUT = "408";
    /**
     * {@code 409 Conflict}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.8">HTTP/1.1:
     * Semantics and Content, section 6.5.8</a>
     */
    public static final String CONFLICT = "409";
    /**
     * {@code 410 Gone}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.9"> HTTP/1.1:
     * Semantics and Content, section 6.5.9</a>
     */
    public static final String GONE = "410";
    /**
     * {@code 411 Length Required}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.10"> HTTP/1.1:
     * Semantics and Content, section 6.5.10</a>
     */
    public static final String LENGTH_REQUIRED = "411";
    /**
     * {@code 412 Precondition failed}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7232#section-4.2"> HTTP/1.1:
     * Conditional Requests, section 4.2</a>
     */
    public static final String PRECONDITION_FAILED = "412";
    /**
     * {@code 413 Payload Too Large}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.11"> HTTP/1.1:
     * Semantics and Content, section 6.5.11</a>
     * @since 4.1
     */
    public static final String PAYLOAD_TOO_LARGE = "413";
    /**
     * {@code 413 Request Entity Too Large}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2616#section-10.4.14">HTTP/1.1,
     * section 10.4.14</a>
     * @deprecated in favor of {@link #PAYLOAD_TOO_LARGE} which will be returned
     * from {@code HttpStatus.valueOf(413)}
     */
    @Deprecated
    public static final String REQUEST_ENTITY_TOO_LARGE = "413";
    /**
     * {@code 414 URI Too Long}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.12"> HTTP/1.1:
     * Semantics and Content, section 6.5.12</a>
     * @since 4.1
     */
    public static final String URI_TOO_LONG = "414";
    /**
     * {@code 414 Request-URI Too Long}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2616#section-10.4.15">HTTP/1.1,
     * section 10.4.15</a>
     * @deprecated in favor of {@link #URI_TOO_LONG} which will be returned from
     * {@code HttpStatus.valueOf(414)}
     */
    @Deprecated
    public static final String REQUEST_URI_TOO_LONG = "414";
    /**
     * {@code 415 Unsupported Media Type}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.13"> HTTP/1.1:
     * Semantics and Content, section 6.5.13</a>
     */
    public static final String UNSUPPORTED_MEDIA_TYPE = "415";
    /**
     * {@code 416 Requested Range Not Satisfiable}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7233#section-4.4">HTTP/1.1:
     * Range Requests, section 4.4</a>
     */
    public static final String REQUESTED_RANGE_NOT_SATISFIABLE = "416";
    /**
     * {@code 417 Expectation Failed}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.5.14"> HTTP/1.1:
     * Semantics and Content, section 6.5.14</a>
     */
    public static final String EXPECTATION_FAILED = "417";
    /**
     * {@code 418 I'm a teapot}.
     *
     * @see <a href=
     * "https://tools.ietf.org/html/rfc2324#section-2.3.2">HTCPCP/1.0</a>
     */
    public static final String I_AM_A_TEAPOT = "418";
    /**
     * @deprecated See <a href=
     * "https://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">
     * WebDAV Draft Changes</a>
     */
    @Deprecated
    public static final String INSUFFICIENT_SPACE_ON_RESOURCE = "419";
    /**
     * @deprecated See <a href=
     * "https://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">
     * WebDAV Draft Changes</a>
     */
    @Deprecated
    public static final String METHOD_FAILURE = "420";
    /**
     * @deprecated See <a href=
     * "https://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">
     * WebDAV Draft Changes</a>
     */
    @Deprecated
    public static final String DESTINATION_LOCKED = "421";
    /**
     * {@code 422 Unprocessable Entity}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc4918#section-11.2">WebDAV</a>
     */
    public static final String UNPROCESSABLE_ENTITY = "422";
    /**
     * {@code 423 Locked}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc4918#section-11.3">WebDAV</a>
     */
    public static final String LOCKED = "423";
    /**
     * {@code 424 Failed Dependency}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc4918#section-11.4">WebDAV</a>
     */
    public static final String FAILED_DEPENDENCY = "424";
    /**
     * {@code 425 Too Early}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc8470">RFC 8470</a>
     * @since 5.2
     */
    public static final String TOO_EARLY = "425";
    /**
     * {@code 426 Upgrade Required}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2817#section-6">Upgrading to TLS
     * Within HTTP/1.1</a>
     */
    public static final String UPGRADE_REQUIRED = "426";
    /**
     * {@code 428 Precondition Required}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6585#section-3">Additional HTTP
     * Status Codes</a>
     */
    public static final String PRECONDITION_REQUIRED = "428";
    /**
     * {@code 429 Too Many Requests}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6585#section-4">Additional HTTP
     * Status Codes</a>
     */
    public static final String TOO_MANY_REQUESTS = "429";
    /**
     * {@code 431 Request Header Fields Too Large}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6585#section-5">Additional HTTP
     * Status Codes</a>
     */
    public static final String REQUEST_HEADER_FIELDS_TOO_LARGE = "431";
    /**
     * {@code 451 Unavailable For Legal Reasons}.
     *
     * @see <a href=
     * "https://tools.ietf.org/html/draft-ietf-httpbis-legally-restricted-status-04">
     * An HTTP Status Code to Report Legal Obstacles</a>
     * @since 4.3
     */
    public static final String UNAVAILABLE_FOR_LEGAL_REASONS = "451";

    // --- 5xx Server Error ---

    /**
     * {@code 500 Internal Server Error}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.6.1">HTTP/1.1:
     * Semantics and Content, section 6.6.1</a>
     */
    public static final String INTERNAL_SERVER_ERROR = "500";
    /**
     * {@code 501 Not Implemented}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.6.2">HTTP/1.1:
     * Semantics and Content, section 6.6.2</a>
     */
    public static final String NOT_IMPLEMENTED = "501";
    /**
     * {@code 502 Bad Gateway}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.6.3">HTTP/1.1:
     * Semantics and Content, section 6.6.3</a>
     */
    public static final String BAD_GATEWAY = "502";
    /**
     * {@code 503 Service Unavailable}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.6.4">HTTP/1.1:
     * Semantics and Content, section 6.6.4</a>
     */
    public static final String SERVICE_UNAVAILABLE = "503";
    /**
     * {@code 504 Gateway Timeout}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.6.5">HTTP/1.1:
     * Semantics and Content, section 6.6.5</a>
     */
    public static final String GATEWAY_TIMEOUT = "504";
    /**
     * {@code 505 HTTP Version Not Supported}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-6.6.6">HTTP/1.1:
     * Semantics and Content, section 6.6.6</a>
     */
    public static final String HTTP_VERSION_NOT_SUPPORTED = "505";
    /**
     * {@code 506 Variant Also Negotiates}
     *
     * @see <a href="https://tools.ietf.org/html/rfc2295#section-8.1">Transparent
     * Content Negotiation</a>
     */
    public static final String VARIANT_ALSO_NEGOTIATES = "506";
    /**
     * {@code 507 Insufficient Storage}
     *
     * @see <a href="https://tools.ietf.org/html/rfc4918#section-11.5">WebDAV</a>
     */
    public static final String INSUFFICIENT_STORAGE = "507";
    /**
     * {@code 508 Loop Detected}
     *
     * @see <a href="https://tools.ietf.org/html/rfc5842#section-7.2">WebDAV Binding
     * Extensions</a>
     */
    public static final String LOOP_DETECTED = "508";
    /**
     * {@code 509 Bandwidth Limit Exceeded}
     */
    public static final String BANDWIDTH_LIMIT_EXCEEDED = "509";
    /**
     * {@code 510 Not Extended}
     *
     * @see <a href="https://tools.ietf.org/html/rfc2774#section-7">HTTP Extension
     * Framework</a>
     */
    public static final String NOT_EXTENDED = "510";
    /**
     * {@code 511 Network Authentication Required}.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6585#section-6">Additional HTTP
     * Status Codes</a>
     */
    public static final String NETWORK_AUTHENTICATION_REQUIRED = "511";
}
