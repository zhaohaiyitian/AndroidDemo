package com.wj.wjnews;

import com.wj.wjnews.net.service.WjApiProvider;
import com.wj.wjnews.net.service.WjRequest;
import com.wj.wjnews.net.service.WjResponse;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

//        OkHttpClient client=new OkHttpClient();
//
//        OkHttpRequest request=new OkHttpRequest(client, HttpMethod.GET,"http://www.imooc.com");
//        HttpResponse response = request.execute();
//        String content=null;
//        BufferedReader reader=new BufferedReader(new InputStreamReader(response.getBody()));
//        while ((content=reader.readLine())!=null) {
//            System.out.println(content);
//        }
//        response.close();

    }
}