package io.stephen.core.properties;

/**
 * @author 10447
 * @since 2017/11/20
 */
public class SocialProperties {

    private QQProperties qqProperties = new QQProperties();

    private String filterProcessesUrl = "/auth";


    public QQProperties getQqProperties() {
        return qqProperties;
    }

    public void setQqProperties(QQProperties qqProperties) {
        this.qqProperties = qqProperties;
    }


    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }
}
