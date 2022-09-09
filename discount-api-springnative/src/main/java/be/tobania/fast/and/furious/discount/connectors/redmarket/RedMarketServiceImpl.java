package be.tobania.fast.and.furious.discount.connectors.redmarket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class RedMarketServiceImpl implements RedMarketService {

    Logger logger = LoggerFactory.getLogger(RedMarketServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    private String redPriceServiceURL;

    @Autowired
    public void setRedPriceServiceURL(@Value("${redprice.service.url}") String url) {
        redPriceServiceURL = url;
    }

    public RedPrice getRedPrice(String productCode) {
        try {
            ResponseEntity<RedPrice> entity = restTemplate.getForEntity(redPriceServiceURL + "/" + productCode, RedPrice.class);

            return entity.getBody();
        } catch (HttpClientErrorException.NotFound notFoundException) {
            logger.debug(productCode + " not found");
            return null;
        }
    }
}