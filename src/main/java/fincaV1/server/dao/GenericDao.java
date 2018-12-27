package fincaV1.server.dao;

public interface GenericDao {

	public <T> T getAll(final Class<T> type);

	public <T> T get(final Class<T> type, final Long id);

	public <T> void saveOrUpdate(final T o);

	public <T> T save(final T o);

	public void delete(final Object object);

}
