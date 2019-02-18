import java.io.InputStreamReader;
import java.util.Optional;

import com.google.gson.Gson;

public class EmployeeGSONDeserialization {
	Resource reader;
	Employee employee;

	public EmployeeGSONDeserialization(Resource reader) {
		this.reader = reader;
	}

	public Optional<Employee> parseEmployeeResource() {
		Optional<InputStreamReader> resourceStream = reader.streamedResource();

		if (resourceStream.isPresent()) {
			Gson gson = new Gson();
			employee = gson.fromJson(resourceStream.get(), Employee.class);
		}
		return Optional.ofNullable(employee);
	}
}
