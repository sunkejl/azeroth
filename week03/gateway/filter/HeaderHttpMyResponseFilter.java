package gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HeaderHttpMyResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("X-homework","my-homework");
    }
}
