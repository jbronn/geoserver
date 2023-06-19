package org.geoserver.security.oauth2;

import org.geoserver.config.util.XStreamPersister;
import org.geoserver.security.GeoServerSecurityManager;
import org.geoserver.security.config.SecurityNamedServiceConfig;
import org.geoserver.security.filter.GeoServerSecurityFilter;

public class OpenStreetMapOAuth2AuthenticationProvider
        extends GeoServerOAuthAuthenticationProvider {

    public OpenStreetMapOAuth2AuthenticationProvider(
            GeoServerSecurityManager securityManager,
            String tokenServices,
            String oauth2SecurityConfiguration,
            String geoServerOauth2RestTemplate) {
        super(
                securityManager,
                tokenServices,
                oauth2SecurityConfiguration,
                geoServerOauth2RestTemplate);
    }

    @Override
    public void configure(XStreamPersister xp) {
        xp.getXStream()
                .alias("openStreetMapOauth2Authentication", OpenStreetMapOAuth2FilterConfig.class);
    }

    @Override
    public Class<? extends GeoServerSecurityFilter> getFilterClass() {
        return OpenStreetMapOAuthAuthenticationFilter.class;
    }

    @Override
    public GeoServerSecurityFilter createFilter(SecurityNamedServiceConfig config) {
        return new OpenStreetMapOAuthAuthenticationFilter(
                config, tokenServices, oauth2SecurityConfiguration, geoServerOauth2RestTemplate);
    }
}
