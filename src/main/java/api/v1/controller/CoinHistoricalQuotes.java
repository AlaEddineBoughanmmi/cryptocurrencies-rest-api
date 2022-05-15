package api.v1.controller;

import api.v1.model.HistoricalPrice;
import api.v1.service.HistoricalQuoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api(tags = "Coin historical Qutoes")
@RequestMapping("/api/v1/cryptocurrencies/historical")
public class CoinHistoricalQuotes {

    @Autowired
    HistoricalQuoteService historicalQuoteService;

    @ApiOperation("Get historical price for given symbol")
    @GetMapping("/{symbol}")
    public ResponseEntity<HistoricalPrice> getAllPrices(@PathVariable("symbol") String symbol,
                                                       @RequestParam(defaultValue = "100") int  limit,
                                                       @RequestParam(defaultValue = "2009-01-03") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate) {
        return new ResponseEntity<>(historicalQuoteService.getHistoricalQuote(symbol, limit, fromDate), HttpStatus.OK);
    }
}
