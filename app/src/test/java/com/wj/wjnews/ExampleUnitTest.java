package com.wj.wjnews;

import com.wj.wjnews.net.HttpRequestProvider;
import com.wj.wjnews.net.http.HttpCall;
import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.http.Request;
import com.wj.wjnews.net.http.Response;
import com.wj.wjnews.net.http.client.CallBack;
import com.wj.wjnews.net.service.WjApiProvider;
import com.wj.wjnews.net.service.WjRequest;
import com.wj.wjnews.net.service.WjResponse;
import com.wj.wjnews.net.service.convert.Convert;
import com.wj.wjnews.net.service.convert.JsonConvert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

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



    }
}