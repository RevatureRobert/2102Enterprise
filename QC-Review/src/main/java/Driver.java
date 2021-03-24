import java.util.concurrent.*;

public class Driver {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //TODO: implement interrupt, wait and notify
        Callable<String> callable = () -> {
            System.out.println("Wait for it.....");
            Thread.sleep(2500);
            System.out.println("...");
            Thread.sleep(2500);
            return "Blamo!";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        System.out.println("Something");
        System.out.println(future.get());
        System.out.println("Else");
//        Thread[] threadPool =

    }
}
