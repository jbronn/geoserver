package org.geoserver.web.security.oauth2;

import org.apache.wicket.model.IModel;
import org.geoserver.security.oauth2.OpenStreetMapOAuth2FilterConfig;

public class OpenStreetMapOAuth2AuthProviderPanel
        extends GeoServerOAuth2AuthProviderPanel<OpenStreetMapOAuth2FilterConfig> {

    public OpenStreetMapOAuth2AuthProviderPanel(
            String id, IModel<OpenStreetMapOAuth2FilterConfig> model) {
        super(id, model);
    }
}
