/**
 * Description:<b></b>
 * @author LKL
 * @since 2021-9-28 
 */
package endless.overlook.webfluxsupplier.concurrent.util;

import endless.overlook.webfluxsupplier.concurrent.service.ConcurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Component
public class ConcurrentTestUtil {

    /**
     * THREAD_CORE_POOL_SIZE 核心线程数
     */
    private static final int THREAD_POOL_CORE_POOL_SIZE = 30;

    /**
     * THREAD_MAX_POOL_SIZE 最大线程数
     */
    private static final int THREAD_POOL_MAX_POOL_SIZE = 30;

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
    private ConcurrentService concurrentService;

    public String test1() {
        List<Future> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<String> future = IMPORTTASTEXECUTOR.submit(
                    () -> concurrentService.test1());
            result.add(future);
        }

        for (Future<Map<String, Object>> future : result) {
            try {
                Map<String, Object> map = future.get(3000L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        return "util-done";
    }
}