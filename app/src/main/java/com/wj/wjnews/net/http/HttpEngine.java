package com.wj.wjnews.net.http;

import java.io.IOException;

/**
 * Created by wj on 18-5-7.
 */

public interface HttpEngine {

    HttpResponse execute() throws IOException;
}
