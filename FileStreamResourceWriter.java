import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileStreamResourceWriter implements WriterResource {

	OutputStreamWriter streamWriter;
	String resourceLocation;
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public FileStreamResourceWriter(String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	@Override
	public Optional<OutputStreamWriter> streamedResourceWriter() {
		try {
			FileOutputStream fosWriter = new FileOutputStream(resourceLocation);
			streamWriter = new OutputStreamWriter(fosWriter);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return Optional.ofNullable(streamWriter);
	}

	@Override
	public void close() throws Exception {
		streamWriter.close();
	}
}
