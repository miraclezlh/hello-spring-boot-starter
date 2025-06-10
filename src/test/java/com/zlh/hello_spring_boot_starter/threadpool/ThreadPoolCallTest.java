package com.zlh.hello_spring_boot_starter.threadpool;

import com.zlh.hello_spring_boot_starter.controller.HelloController;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 线程池测试接口，工具类
 * @author 70635
 */
@SpringBootTest
public class ThreadPoolCallTest {
    private static final OkHttpClient client = new OkHttpClient();

    @Autowired
    private HelloController helloController;

    @Test
    void testOne() {
        for(int i=0;i<10;i++) {
            ThreadPoolUtils.getThreadPoolConst().submit(() -> helloController.home());
        }
//        Request request = new Request.Builder()
//                .url("http://127.0.0.1:8088/hello/demo")
//                .build();
//
//        for(int i=0;i<10;i++) {
//            ThreadPoolUtils.getThreadPoolConst().submit(new Runnable() {
//                @Override
//                public void run() {
//                    client.newCall(request).enqueue(new Callback() {
//                        @Override
//                        public void onFailure(Call call, IOException e) {
//                            e.printStackTrace();
//                        }
//
//                        @Override
//                        public void onResponse(Call call, Response response) throws IOException {
//                            if (response.isSuccessful()) {
//                                assert response.body() != null;
//                                String responseData = response.body().string();
//                                // 处理响应数据
//
//                            } else {
//                                // 处理错误情况
//                            }
//                        }
//                    });
//                }
//            });
//        }
    }
}
