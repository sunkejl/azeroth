package gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HttpClientUtil {

    private static CloseableHttpClient httpClient;


    static {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(5_000)
                .setConnectionRequestTimeout(1_000)
                .setSocketTimeout(5_000)
                .build();
        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .setMaxConnPerRoute(200)
                .setMaxConnTotal(400)
                .evictIdleConnections(60, TimeUnit.SECONDS).build();
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    try {
                        httpClient.close();
                    } catch (IOException e) {
                    }
                })
        );
    }


    public static String getData(String uri, List<NameValuePair> parameters) {
        String responseBody = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.addParameters(parameters);
            HttpGet httpGet = new HttpGet(uriBuilder.build());

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            try {
                responseBody = httpClient.execute(httpGet, responseHandler);
            } catch (IOException e) {
//                log.warn("exception:[{}]",e.getMessage());
            }
        } catch (URISyntaxException e) {
//            log.warn("exception:[{}]",e.getMessage());
        }
        return responseBody;
    }

}
