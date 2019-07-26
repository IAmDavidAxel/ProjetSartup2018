package infrastructure.persistence.repository;

import domain.user.manager.Manager;
import domain.user.manager.ManagerRepository;
import infrastructure.persistence.assembler.ManagerAssembler;
import infrastructure.persistence.dao.ManagerDao;
import infrastructure.persistence.dto.ManagerDto;
import infrastructure.persistence.exception.DaoInternalException;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteManagerRepository  implements ManagerRepository {
	private  ManagerAssembler managerAssembler;
	private  ManagerDao managerDao;

	public SqliteManagerRepository(ManagerAssembler managerAssembler, ManagerDao managerDao) {

		this.managerAssembler = managerAssembler;
		this.managerDao = managerDao;
	}

	@Override
	public void save(Manager manager) throws PersistenceInternalException {
		ManagerDto managerDto = managerAssembler.assemble(manager);
		try{
			managerDao.save(managerDto);
		}catch (DaoInternalException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
			throw new PersistenceInternalException();
		}
	}
}
