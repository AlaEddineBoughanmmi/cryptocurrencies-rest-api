package api.v1.services;

import api.v1.configuration.AppConfigProperties;
import api.v1.models.Coin;
import api.v1.models.HistoricalPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder url  = new StringBuilder()
                .append(appConfigProperties.apiHistoricalPriceUrl())
                .append("/")
                .append(symbol)
                .append("USD?apikey=")
                .append(appConfigProperties.apiKey());

        HistoricalPrice response = restTemplate.getForObject(url.toString(), HistoricalPrice.class);
        List<Coin> coinList = response.getHistorical().stream().filter(e -> {
            try {
                Date date = dateFormat.parse(e.getDate());
                return date.after(fromDate) || date.equals(fromDate);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }).limit(limit).collect(Collectors.toList());

        response.setHistorical(coinList);
        return response;
    }
}
