package com.expendedora.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.expendedora.exception.RefrescoException;

public class MaquinaExpendedoraTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void reponerTest() throws RefrescoException {
		Refresco r1 = new Refresco("Naranja", 150, 200, 10);
		ListaRefresco refrescos = new ListaRefresco();
		refrescos.addRefresco(r1);
		MaquinaExpendedora m = new MaquinaExpendedora(refrescos, 500);
		m.reponer(1);
		
		if(m.getRefresco(0).getStock() != 11) {
			fail("El stock del refresco deberia ser 11");
		}
	}
	
	

}
