package infrastructure.persistence.repository;

import domain.user.barber.Barber;
import infrastructure.persistence.assembler.BarberAssembler;
import infrastructure.persistence.dao.BarberDao;
import infrastructure.persistence.dto.BarberDto;
import infrastructure.persistence.entitymanager.sqlite.SqliteEntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberSqliteRepositoryTest {

	private BarberSqliteRepository barberSqliteRepository;

	@Mock
	private BarberAssembler barberAssembler;
	@Mock
	private BarberDao barberDao;
	@Mock
	private SqliteEntityManager sqliteEntityManager;

	private BarberDto barberDto;
	private Barber barber;

	@Before
	public void setUp(){
		barberSqliteRepository = new BarberSqliteRepository(barberAssembler,barberDao,sqliteEntityManager);


	}

	@Test
	public void whenSaving_thenDelegateToAssember()throws Exception{

		barberSqliteRepository.save(barber);

		verify(barberAssembler).assemble(barber);
	}

	@Test
	public void whenSaving_thenDelegateToTheDao()throws Exception{
		willReturn(barberDto).given(barberAssembler).assemble(barber);

		barberSqliteRepository.save(barber);

		verify(barberDao).save(barberDto);
	}



}
