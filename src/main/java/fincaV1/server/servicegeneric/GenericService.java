package fincaV1.server.servicegeneric;

public interface GenericService {

	public <T> T getAll(final Class<T> type);

	public <T> T get(final Class<T> type, final Long id);

	public <T> String saveOrUpdate(final T o);

	public <T> String delete(final T o);
}
