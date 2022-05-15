package api.v1.controller;



import api.v1.model.CryptoQuote;
import api.v1.service.LatestPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CryptoQuote>> getLatestPrice(@RequestParam(defaultValue = "100") int  limit) {
        return new ResponseEntity<>(latestPricesService.getLatestPrices(limit), HttpStatus.OK);
    }

}
