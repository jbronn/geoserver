package org.geoserver.security.oauth2;

public class OpenStreetMapOAuth2FilterConfig extends GeoServerOAuth2FilterConfig {

    public OpenStreetMapOAuth2FilterConfig() {
        // default values
        this.accessTokenUri = "https://www.openstreetmap.org/oauth2/token";
        this.userAuthorizationUri = "https://www.openstreetmap.org/oauth2/authorize";
        this.checkTokenEndpointUrl = "https://www.openstreetmap.org/api/0.6/user/details.json";
        this.logoutUri = "https://www.openstreetmap.org/logout";
        this.scopes = "read_prefs";
        this.enableRedirectAuthenticationEntryPoint = false;
        this.forceAccessTokenUriHttps = false;
        this.forceUserAuthorizationUriHttps = false;
        this.loginEndpoint = "/j_spring_oauth2_openstreetmap_login";
        this.logoutEndpoint = "/j_spring_oauth2_openstreetmap_logout";
    }
}
