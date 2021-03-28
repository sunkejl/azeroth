import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

public class HttpTest {
    public static void main(String[] args) {
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        String res = HttpClientUtil.getData("http://localhost:8801", nameValuePairList);
        System.out.println(res);
    }
}
