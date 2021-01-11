package endless.overlook.webfluxsupplier.reactivestream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 1/4/21 8:20 PM
 **/
public class ReactiveDemo01 {

    public static void main(String[] args) {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        Flow.Subscriber subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            /**
             * Method invoked prior to invoking any other Subscriber
             * methods for the given Subscription. If this method throws
             * an exception, resulting behavior is not guaranteed, but may
             * cause the Subscription not to be established or to be cancelled.
             *
             * <p>Typically, implementations of this method invoke {@code
             * subscription.request} to enable receiving items.
             *
             * @param subscription a new subscription
             */
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("建立订阅关系，第一次调用");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            /**
             * Method invoked with a Subscription's next item.  If this
             * method throws an exception, resulting behavior is not
             * guaranteed, but may cause the Subscription to be cancelled.
             *
             * @param item the item
             */
            @Override
            public void onNext(Object item) {
                System.out.println("接收数据: " + item);
                this.subscription.request(100);
            }

            /**
             * Method invoked upon an unrecoverable error encountered by a
             * Publisher or Subscription, after which no other Subscriber
             * methods are invoked by the Subscription.  If this method
             * itself throws an exception, resulting behavior is
             * undefined.
             *
             * @param throwable the exception
             */
            @Override
            public void onError(Throwable throwable) {
                System.out.println("出错了");
            }

            /**
             * Method invoked when it is known that no additional
             * Subscriber method invocations will occur for a Subscription
             * that is not already terminated by error, after which no
             * other Subscriber methods are invoked by the Subscription.
             * If this method throws an exception, resulting behavior is
             * undefined.
             */
            @Override
            public void onComplete() {
                System.out.println("数据接收完成");
            }
        };
        publisher.subscribe(subscriber);
        try {
            for (int i = 0; i < 300; i++) {
                publisher.submit("webflux" + i);
            }
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            publisher.close();
        }
    }
}
