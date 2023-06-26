package com.example.studentcleanarch.adapter.out.api;

import com.example.studentcleanarch.adapter.in.rest.dto.response.ApiResponse;
import com.example.studentcleanarch.adapter.out.api.exception.ApiCallException;
import com.example.studentcleanarch.common.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiCallService<Request, Response> {
    private final RestTemplate restTemplate;

    @TrackApi
    public ApiResponse<Response> post(
            String serviceUrl, Request request, HttpHeaders headers, Class<Response> responseType) {
        try {

            ResponseEntity<Response> httpResp =
                    post(serviceUrl, buildHttpEntity(JsonUtils.toJson(request), headers), responseType);
            return isSuccess(httpResp.getStatusCode())
                    ? ApiResponse.success(httpResp.getBody())
                    : ApiResponse.failure(httpResp.getStatusCodeValue());
        } catch (Exception ex) {
            log.error("ApiCallException with msg: {}", ex.getMessage(), ex);
            throw new ApiCallException();
        }
    }

    @TrackApi
    public ApiResponse<Response> post(
            String serviceUrl,
            Request request,
            HttpHeaders headers,
            ParameterizedTypeReference<ApiResponse<Response>> typeReference) {
        try {
            ResponseEntity<ApiResponse<Response>> httpResp =
                    post(serviceUrl, buildHttpEntity(JsonUtils.toJson(request), headers), typeReference);
            return httpResp.getBody();
        } catch (Exception ex) {
            log.error("ApiCallException with msg: {}", ex.getMessage(), ex);
            throw new ApiCallException();
        }
    }

    private boolean isSuccess(HttpStatus statusCode) {
        return HttpStatus.OK == statusCode;
    }

    private HttpEntity<String> buildHttpEntity(String body, HttpHeaders headers) {
        if (CollectionUtils.isEmpty(headers)) {
            headers = new HttpHeaders();
            headers.add(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        }

        return new HttpEntity<>(body, headers);
    }

    private ResponseEntity<Response> post(String url, HttpEntity<String> requestBody, Class<Response> responseType) {
        return restTemplate.exchange(
                url, HttpMethod.POST, requestBody, ParameterizedTypeReference.forType(responseType));
    }

    private ResponseEntity<ApiResponse<Response>> post(
            String url,
            HttpEntity<String> requestBody,
            ParameterizedTypeReference<ApiResponse<Response>> typeReference) {
        return restTemplate.exchange(url, HttpMethod.POST, requestBody, typeReference);
    }
}
