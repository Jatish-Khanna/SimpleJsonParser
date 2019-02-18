import java.io.OutputStreamWriter;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;



class EmployeeGSONSerialization {

	WriterResource writer;
	Employee employee;
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public EmployeeGSONSerialization(WriterResource writer, Employee employee) {
		this.writer = writer;
		this.employee = employee;
	}

	public boolean serializeEmployeeResource() {
		Optional<OutputStreamWriter> resourceStream = writer.streamedResourceWriter();

		try {
			if (resourceStream.isPresent()) {
				Gson gson = new Gson();
				resourceStream.get().write(gson.toJson(employee));
			} else {
				throw new JsonIOException("Error! while writing object to resource");
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return true;
	}
}
