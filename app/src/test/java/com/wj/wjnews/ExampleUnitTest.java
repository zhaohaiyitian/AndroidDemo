package com.wj.wjnews;

import com.wj.wjnews.net.OkHttpRequest;
import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.http.HttpResponse;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import okhttp3.OkHttpClient;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        OkHttpClient client=new OkHttpClient();

        OkHttpRequest request=new OkHttpRequest(client, HttpMethod.GET,"http://www.imooc.com");
        HttpResponse response = request.execute();
        String content=null;
        BufferedReader reader=new BufferedReader(new InputStreamReader(response.getBody()));
        while ((content=reader.readLine())!=null) {
            System.out.println(content);
        }
        response.close();
    }
}