package api.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoQuote {
    private String id;
    private String symbol;
    private String name;
    private String image;
    @JsonProperty("current_price")
    private String currentPrice;
    @JsonProperty("market_cap")
    private String marketCap;
    @JsonProperty("market_cap_rank")
    private String marketCapRank;
    @JsonProperty("total_volume")
    private String totalVolume;
    @JsonProperty("high_24h")
    private String high24h;
    @JsonProperty("low_24h")
    private String low24h;
    @JsonProperty("total_supply")
    private String totalSupply;
    @JsonProperty("price_change_24h")
    private String priceChange24h;
}
