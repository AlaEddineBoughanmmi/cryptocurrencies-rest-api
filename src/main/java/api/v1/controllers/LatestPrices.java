package api.v1.controllers;



import api.v1.models.CryptoQuote;
import api.v1.services.LatestPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cryptocurrencies/latest")
public class LatestPrices {

    @Autowired
    LatestPricesService latestPricesService;

    @GetMapping
    public List<CryptoQuote> getLatestPrice( @RequestParam(defaultValue = "100") int  limit) {
        return latestPricesService.getLatestPrices(limit);
    }

}
