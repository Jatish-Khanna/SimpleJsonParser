import java.io.OutputStreamWriter;

public interface WriterResource extends AutoCloseable {
	Optional<OutputStreamWriter> streamedResourceWriter();
}
