package api.v1.service;

import api.v1.model.CryptoQuote;

import java.util.List;

public interface LatestPricesService {
    List<CryptoQuote> getLatestPrices(int limit);
}
