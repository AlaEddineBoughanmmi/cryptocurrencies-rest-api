package api.v1.services;

import api.v1.models.HistoricalPrice;

import java.util.Date;

public interface HistoricalQuoteService {
    HistoricalPrice getHistoricalQuote(String symbol, int limit, Date fromDate);
}
