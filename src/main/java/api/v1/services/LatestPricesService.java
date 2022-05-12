package api.v1.services;

import api.v1.models.CryptoQuote;

import java.util.List;

public interface LatestPricesService {
    List<CryptoQuote> getLatestPrices(int limit);
}
