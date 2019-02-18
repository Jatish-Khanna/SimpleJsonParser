interface Resource extends AutoCloseable {

	Optional<InputStreamReader> streamedResource();
}
