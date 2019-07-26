package domain.user.manager;


import infrastructure.persistence.exception.PersistenceInternalException;

public interface ManagerRepository  {

	void save(Manager manager) throws PersistenceInternalException;

}
