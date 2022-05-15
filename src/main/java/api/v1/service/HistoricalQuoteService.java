package api.v1.service;

import api.v1.model.HistoricalPrice;

import java.util.Date;

public interface HistoricalQuoteService {
    HistoricalPrice getHistoricalQuote(String symbol, int limit, Date fromDate);
}
