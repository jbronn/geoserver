package org.geoserver.web.security.oauth2;

import org.apache.wicket.model.Model;
import org.geoserver.security.oauth2.OpenStreetMapOAuth2FilterConfig;
import org.geoserver.web.GeoServerWicketTestSupport;
import org.junit.Test;

public class OpenStreetMapAuthProviderPanelTest extends GeoServerWicketTestSupport {

    @Test
    public void smokeTest() {
        Model<OpenStreetMapOAuth2FilterConfig> model =
                new Model<>(new OpenStreetMapOAuth2FilterConfig());
        tester.startComponentInPage(
                new OpenStreetMapOAuth2AuthProviderPanel("openstreetmap", model));
    }
}
