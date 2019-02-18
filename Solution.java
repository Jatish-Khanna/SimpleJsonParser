import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonIOException;


class Solution {

	static Logger logger = Logger.getLogger(Solution.class.getName());

	public static void main(String[] args) {
		Optional<Employee> employee = Optional.empty(); // = employeeDeserialization.parseEmployeeResource();
		try (ReaderResource reader = new FileStreamResource("stats_json")) {
			EmployeeGSONDeserialization employeeDeserialization = new EmployeeGSONDeserialization(reader);
			employee = employeeDeserialization.parseEmployeeResource();
			if (employee.isPresent()) {
				System.out.println(employee.get());
			} else {
				throw new JsonIOException("Employee resource has not been parsed(employee is Optional.empty)");
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		if (employee.isPresent()) {
			try (WriterResource writer = new FileStreamResourceWriter("serialized_json")) {
				EmployeeGSONSerialization serializeEmployee = new EmployeeGSONSerialization(writer, employee.get());
				serializeEmployee.serializeEmployeeResource();
			} catch (Exception e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}
}
