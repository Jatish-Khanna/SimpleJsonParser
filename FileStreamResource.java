import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileStreamResource implements ReaderResource {
	String resourceLocation;
	InputStreamReader streamReader;
	Logger logger = Logger.getLogger(this.getClass().getName());

	FileStreamResource(String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	@Override
	public Optional<InputStreamReader> streamedResource() {
		try {
			FileInputStream fisReader = new FileInputStream(resourceLocation);
			streamReader = new InputStreamReader(fisReader);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return Optional.ofNullable(streamReader);
	}

	@Override
	public void close() throws Exception {
		streamReader.close();
	}
}
