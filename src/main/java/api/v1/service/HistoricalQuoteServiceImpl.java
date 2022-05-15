package api.v1.service;

import api.v1.configuration.AppConfigProperties;
import api.v1.model.Coin;
import api.v1.model.HistoricalPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricalQuoteServiceImpl implements HistoricalQuoteService{
    @Autowired
    private RestTemplate restTemplate;
    private final AppConfigProperties appConfigProperties;

    public HistoricalQuoteServiceImpl(AppConfigProperties appConfigProperties) {
        this.appConfigProperties = appConfigProperties;
    }

    @Override
    public HistoricalPrice getHistoricalQuote(String symbol, int limit, Date fromDate)  {
        StringBuilder url  = new StringBuilder()
                .append(appConfigProperties.apiHistoricalPriceUrl())
                .append("/")
                .append(symbol.toUpperCase())
                .append("USD?apikey=")
                .append(appConfigProperties.apiKey());

        HistoricalPrice response = restTemplate.getForObject(url.toString(), HistoricalPrice.class);
        List<Coin> coinList = response.getHistorical().stream().filter(e -> e.getDate().after(fromDate) || e.getDate().equals(fromDate))
                                                               .limit(limit)
                                                               .collect(Collectors.toList());
        response.setHistorical(coinList);
        return response;
    }
}
