/**
 * Description:<b></b>
 * @author LKL
 * @since
 */
package endless.overlook.webfluxsupplier.concurrent;

import endless.overlook.webfluxsupplier.concurrent.util.ConcurrentTestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class ConcurrentController {

    /**
     * THREAD_CORE_POOL_SIZE 核心线程数
     */
    private static final int THREAD_POOL_CORE_POOL_SIZE = 1;

    /**
     * THREAD_MAX_POOL_SIZE 最大线程数
     */
    private static final int THREAD_POOL_MAX_POOL_SIZE = 1;

    /**
     * THREAD_POOL_KEEP_ALIVE_SECONDS keepAliveTime
     */
    private static final long THREAD_POOL_KEEP_ALIVE_SECONDS = 20;

    /**
     * 线程池
     */
    private static final ThreadPoolExecutor IMPORTTASTEXECUTOR = new ThreadPoolExecutor(
            THREAD_POOL_CORE_POOL_SIZE, THREAD_POOL_MAX_POOL_SIZE,
            THREAD_POOL_KEEP_ALIVE_SECONDS, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    @Autowired
    private ConcurrentTestUtil concurrentTestUtil;

    @RequestMapping("/api/v1/concurrent")
    public String test1() {
        IMPORTTASTEXECUTOR.submit(() -> {
            String result = concurrentTestUtil.test1();
            return result;
        });
        return "controller-done";
    }
}