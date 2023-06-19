package org.geoserver.web.security.oauth2;

import org.geoserver.security.oauth2.OpenStreetMapOAuth2FilterConfig;
import org.geoserver.security.oauth2.OpenStreetMapOAuthAuthenticationFilter;
import org.geoserver.security.web.auth.AuthenticationFilterPanelInfo;

public class OpenStreetMapOAuth2AuthProviderPanelInfo
        extends AuthenticationFilterPanelInfo<
                OpenStreetMapOAuth2FilterConfig, OpenStreetMapOAuth2AuthProviderPanel> {

    /** serialVersionUID */
    private static final long serialVersionUID = 3891569684646256094L;

    public OpenStreetMapOAuth2AuthProviderPanelInfo() {
        setComponentClass(OpenStreetMapOAuth2AuthProviderPanel.class);
        setServiceClass(OpenStreetMapOAuthAuthenticationFilter.class);
        setServiceConfigClass(OpenStreetMapOAuth2FilterConfig.class);
    }
}
