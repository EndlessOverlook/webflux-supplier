/**
 * Description:<b></b>
 * @author LKL
 * @since
 */
package endless.overlook.webfluxsupplier.concurrent.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ConcurrentService {

    /**
     * 执行线程
     */
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public String test1() {
        executorService.submit(() -> "LKL");
        return "service-done";
    }

}