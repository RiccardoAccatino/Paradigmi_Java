package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import rubrica.Rubrica;

class RubricaTest {

	@Test 
	void testCreazione() 
	{ 
		Rubrica.crea();
		assertTrue(Rubrica.numEl()==0);
	}

}
