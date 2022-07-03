package in.ashokit.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import in.ashokit.bindings.User;
import in.ashokit.constants.AppConstants;
import in.ashokit.entities.CountryEntity;
import in.ashokit.entities.UserEntity;
import in.ashokit.props.AppProperties;
import in.ashokit.repositories.CityRepository;
import in.ashokit.repositories.CountryRepository;
import in.ashokit.repositories.StateRepository;
import in.ashokit.repositories.UserRepository;
import in.ashokit.service.RegistrationServiceImpl;
import in.ashokit.util.EmailUtils;

@SpringBootTest
public class RegistrationServiceImplTest {

	@Mock
	private UserRepository userRepo;

	@Mock
	private CountryRepository countryRepo;

	@Mock
	private StateRepository stateRepo;

	@Mock
	private CityRepository cityRepo;

	@Mock
	private EmailUtils emailUtils;

	@Mock
	private AppProperties appProps;

	@InjectMocks
	private RegistrationServiceImpl service;

	@Test
	public void uniqueEmailTest() {
		when(userRepo.findByUserEmail("ashok@gmail.com")).thenReturn(new UserEntity());
		boolean uniqueEmail = service.uniqueEmail("ashok@gmail.com");
		assertFalse(uniqueEmail);
	}
	
	@Test
	public void getCountriesTest() {
		
		CountryEntity entity = new CountryEntity();
		entity.setCountryId(1);
		entity.setCountryName("INDIA");
		List<CountryEntity> list = List.of(entity);
		
		when(countryRepo.findAll()).thenReturn(list);
		
		Map<Integer,String> map = service.getCountries();
		
		Map<Integer, String> expectedMap = new HashMap<>();
		expectedMap.put(1, "INDIA");
		
		assertEquals(expectedMap, map);
		
		System.out.println(map);	
	}
	
	@Test
	public void registerUserTest() {
		
		User user = new User();
		user.setUserId(1);
		user.setUserEmail("ashok@gmail.com");
		user.setUserFname("Ashok");
		//user.setUserPwd("abc");
		//user.setUserAccStatus(AppConstants.LOCKED);
		
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		
		when(userRepo.save(entity)).thenReturn(entity);
		//when(service.sendRegEmail(user)).thenReturn(true);
		
		//boolean bool = service.registerUser(user);
		
		//assertEquals(true, bool);

	}
	

	@Test
	public void generateTempPwdTest() {
		String actualPwd = service.generateTempPwd();
		assertNotNull(actualPwd);
		System.out.println(actualPwd);	
	}
	


}


