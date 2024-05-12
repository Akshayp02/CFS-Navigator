package Watcher;

import java.io.IOException;
import java.nio.file.*;

public class FileWatcherService implements Runnable {

    // TODO: Implement a file watcher service that listens for file changes in a directory and
    //  prints the event kind and the file affected.
    @Override
    public void run() {
        try {
            WatchService watcherService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("D:\\JAVA\\Java Projects\\CFSN Demo");

            path.register(
                    watcherService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY
            );

            WatchKey key;
            while ((key = watcherService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println("Event kind: " + event.kind() + ". File affected: " + event.context() + ".");
                    // event.notify(); check if this works or not for notifying the event
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
