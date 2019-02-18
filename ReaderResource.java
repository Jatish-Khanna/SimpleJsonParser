public interface ReaderResource extends AutoCloseable {

	Optional<InputStreamReader> streamedResource();
}
