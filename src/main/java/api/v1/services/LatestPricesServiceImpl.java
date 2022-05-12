package api.v1.services;

import api.v1.configuration.AppConfigProperties;
import api.v1.models.CryptoQuote;
import api.v1.models.HistoricalPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LatestPricesServiceImpl implements LatestPricesService{
    @Autowired
    private RestTemplate restTemplate;
    private final AppConfigProperties appConfigProperties;

    public LatestPricesServiceImpl(AppConfigProperties appConfigProperties) {
        this.appConfigProperties = appConfigProperties;
    }
    @Override
    public List<CryptoQuote> getLatestPrices(int limit) {
        CryptoQuote[] response = restTemplate.getForObject(appConfigProperties.apiQuoteUrl(), CryptoQuote[].class);
        return Arrays.stream(response).limit(limit).collect(Collectors.toList());
    }
}
