package org.geoserver.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * OpenStreetMap specific REST templates for OAuth2 protocol.
 *
 * <p>First of all the user must create an OAuth2 Application throught the OpenStreetMap Admin GUI
 * <br>
 * See: <string>OpenStreetMap docs: Admin Tutorial</strong>
 *
 * <p>The procedure will provide a new <b>Client ID</b> and <b>Client Secret</b>
 *
 * <p>Also the user must specify the <b>Authorized redirect URIs</b> pointing to the GeoServer
 * instances <br>
 * Example:
 *
 * <ul>
 *   <li>http://localhost:8080/geoserver
 *   <li>http://localhost:8080/geoserver/
 * </ul>
 *
 * <p>The OpenStreetMap OAuth2 Filter Endpoint will automatically redirect the users to an URL like
 * the following one at first login <br>
 *
 * <p>Typically a correct configuration for the OpenStreetMap OAuth2 Provider is like the following
 * one:
 *
 * <ul>
 *   <li>Client Id: <b>my_client_id</b>
 *   <li>Client Secret: <b>my_client_secret</b>
 *   <li>Access Token URI: <b>https://www.openstreetmap.org/o/token/</b>
 *   <li>User Authorization URI: <b>https://www.openstreetmap.org/o/authorize/</b>
 *   <li>Redirect URI: <b>http://localhost:8080/geoserver</b>
 *   <li>Check Token Endpoint URL: <b>https://www.openstreetmap.org_port/api/o/v4/tokeninfo/</b>
 *   <li>Logout URI: <b>https://www.openstreetmap.org/account/logout/</b>
 *   <li>Scopes: <b>read,write,groups</b>
 * </ul>
 */
@Configuration(value = "openStreetMapOAuth2SecurityConfiguration")
@EnableOAuth2Client
class OpenStreetMapOAuth2SecurityConfiguration extends GeoServerOAuth2SecurityConfiguration {

    @Override
    @Bean(name = "openStreetMapOAuth2Resource")
    public OAuth2ProtectedResourceDetails geoServerOAuth2Resource() {
        return super.geoServerOAuth2Resource();
    }

    @Override
    protected String getDetailsId() {
        return "openstreetmap-oauth2-client";
    }

    /** Must have "session" scope */
    @Override
    @Bean(name = "openStreetMapOauth2RestTemplate")
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public OAuth2RestTemplate geoServerOauth2RestTemplate() {
        return super.geoServerOauth2RestTemplate();
    }
}
