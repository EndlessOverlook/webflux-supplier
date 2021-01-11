package endless.overlook.webfluxsupplier.reactor;

import reactor.core.publisher.Flux;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 1/7/21 11:21 PM
 **/
public class ReactorDemo02 {

    public static void main(String[] args) {

        //Flux<String> flux0 = Flux
        //        .just("bole1", "bole2", "bole3", "bole4", "bole5");

        //Mono<Long> mono0 = flux0.count();
        //mono0.subscribe(System.out::println);

        //flux0.limitRate(2)
        //        .doOnSubscribe(i -> System.out.println("OnSubscribe--->:" + i))
        //        .doOnRequest(i -> System.out.println("OnRequest--->:" + i))
        //        .subscribe(i -> System.out.println("Subscribe--->:" + i));

        //flux0.doOnSubscribe(i -> {
        //    System.out.println("sub:" + i);
        //    i.request(3);
        //}).doOnNext(i -> {
        //    System.out.println("next:" + i);
        //}).doOnComplete(() -> {
        //    System.out.println("Complete");
        //}).subscribe();

        //Flux<String> flux1 = Flux.generate(() -> 0, (state, sink) -> {
        //        //    sink.next("3 x " + state + " = " + 3 * state);
        //        //    if (state == 10)
        //        //        sink.complete();
        //        //    return state + 1;
        //        //});
        //        //flux1.subscribe(System.out::println);

        //Flux<String> flux2 = Flux.generate(AtomicLong::new, (state, sink) -> {
        //    long i = state.getAndIncrement();
        //    sink.next("3 x " + i + " = " + 3 * i);
        //    if (i == 10)
        //        sink.complete();
        //    return state;
        //}, (state) -> System.out.println("state: " + state));
        //flux2.subscribe(System.out::println);

        Flux.just(1, 2, 3, 4, 5, 3, 1).collectMap(n -> n, n -> n + 100)
                .subscribe(System.out::println);
    }
}
