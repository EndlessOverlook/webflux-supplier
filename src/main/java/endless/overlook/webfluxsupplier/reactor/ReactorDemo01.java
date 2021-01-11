package endless.overlook.webfluxsupplier.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 1/4/21 8:55 PM
 **/
public class ReactorDemo01 {
    public static void main(String[] args) {
        Flux.just("tom").map(s -> {
            System.out.println(
                    "[map] Thread name: " + Thread.currentThread().getName());
            return s.concat("@mail.com");
        }).publishOn(Schedulers.newBoundedElastic(10, 10, "thread-publishOn"))
                .filter(s -> {
                    System.out.println(
                            "[filter] Thread name: " + Thread.currentThread()
                                    .getName());
                    return s.startsWith("t");
                }).subscribeOn(
                Schedulers.newBoundedElastic(10, 10, "thread-subscribeOn"))
                .subscribe(s -> {
                    System.out.println(
                            "[subscribe] Thread name: " + Thread.currentThread()
                                    .getName());
                    System.out.println(s);
                });

    }
}
