import Watcher.FileWatcherService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Wellcome to ConcurFS Navigator :(");
        FileWatcherService fileWatcherService = new FileWatcherService();
        Thread thread = new Thread(fileWatcherService);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}