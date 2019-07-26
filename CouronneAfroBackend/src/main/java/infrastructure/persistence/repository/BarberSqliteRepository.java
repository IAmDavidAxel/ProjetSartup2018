package infrastructure.persistence.repository;

import domain.user.barber.Barber;
import domain.user.barber.BarberRepository;
import infrastructure.persistence.assembler.BarberAssembler;
import infrastructure.persistence.dao.BarberDao;
import infrastructure.persistence.dto.BarberDto;
import infrastructure.persistence.entitymanager.sqlite.EntityManagerException;
import infrastructure.persistence.entitymanager.sqlite.SqliteEntityManager;
import infrastructure.persistence.exception.DaoInternalException;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BarberSqliteRepository implements BarberRepository {


	private  BarberAssembler barberAssembler;
	private  BarberDao barberDao;
	private SqliteEntityManager sqliteEntityManager;

	public BarberSqliteRepository(BarberAssembler barberAssembler, BarberDao barberDao, SqliteEntityManager sqliteEntityManager) {

		this.barberAssembler = barberAssembler;
		this.barberDao = barberDao;
		this.sqliteEntityManager = sqliteEntityManager;
	}

	@Override
	public void save(Barber barber) throws PersistenceInternalException {

		BarberDto barberDto = barberAssembler.assemble(barber);



		try{


			sqliteEntityManager.beginTransaction();
			barberDao.save(barberDto);

			sqliteEntityManager.endTransaction();

		}catch (EntityManagerException| DaoInternalException e){
			sqliteEntityManager.rollBack();
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
			throw  new PersistenceInternalException();
		}



	}
}
