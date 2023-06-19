package org.geoserver.security.oauth2.services;

import java.util.Map;
import org.geoserver.security.oauth2.GeoServerAccessTokenConverter;
import org.geoserver.security.oauth2.GeoServerOAuthRemoteTokenServices;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class OpenStreetMapTokenServices extends GeoServerOAuthRemoteTokenServices {

    public OpenStreetMapTokenServices() {
        super(new GeoServerAccessTokenConverter());
    }

    @Override
    protected Map<String, Object> checkToken(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getAuthorizationHeader(accessToken));
        ParameterizedTypeReference<Map<String, Object>> map =
                new ParameterizedTypeReference<Map<String, Object>>() {};
        return restTemplate
                .exchange(checkTokenEndpointUrl, HttpMethod.GET, new HttpEntity<>(headers), map)
                .getBody();
    }

    @Override
    protected void transformNonStandardValuesToStandardValues(Map<String, Object> map) {
        LOGGER.debug("Original map = " + map);
        map.put("user_name", map.get("username")); // OpenStreetMap sends 'client_id' as 'issued_to'
        LOGGER.debug("Transformed = " + map);
    }
}
