import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ResultAggregator {
    public static CompletableFuture<List<String>> aggregateResults(List<CompletableFuture<String>> futures) {
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }
}