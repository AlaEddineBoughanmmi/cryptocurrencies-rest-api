package api.v1.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tiers")
public record AppConfigProperties(String apiKey,
                                  String apiQuoteUrl,
                                  String apiHistoricalPriceUrl) {
}
