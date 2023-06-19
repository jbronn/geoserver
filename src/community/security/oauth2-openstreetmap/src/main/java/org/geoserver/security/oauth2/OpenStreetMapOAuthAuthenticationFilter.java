package org.geoserver.security.oauth2;

import org.geoserver.security.config.SecurityNamedServiceConfig;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

public class OpenStreetMapOAuthAuthenticationFilter extends GeoServerOAuthAuthenticationFilter {

    public OpenStreetMapOAuthAuthenticationFilter(
            SecurityNamedServiceConfig config,
            RemoteTokenServices tokenServices,
            GeoServerOAuth2SecurityConfiguration oauth2SecurityConfiguration,
            OAuth2RestOperations oauth2RestTemplate) {
        super(config, tokenServices, oauth2SecurityConfiguration, oauth2RestTemplate);
    }
}
