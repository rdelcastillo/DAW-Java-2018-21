package org.iesgrancapitan.PROGR.ejemplos.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Prueba Caja Negra JUnit5 de Calculadora 
 * 
 * @author Jaime Rabasco
 * 
 */

class TestCalculadora {

	private Calculadora calculadora=new Calculadora();

	/** Este método se ejecuta para cada prueba ANTES de invocar el código de cada prueba */
	@BeforeEach
	public void testStart() {
	// Para este ejemplo no hacemos nada, pero exponemos el método por
	// motivos didácticos exclusivamente
	}
	
	/** Este método se ejecuta para cada prueba DESPUÉS de invocar el código de cada prueba */
	@AfterEach
	public void testEnd() {
	// Para este ejemplo no hacemos nada, pero exponemos el método por
	// motivos didacticos exclusivamente
	}
	
	
	/** Verificamos que si sumamos 5 a 0 nos da correctamente 5 */
	@Test
	public void testSumar() {
		Assertions.assertEquals(5, calculadora.sumar(5));
	}

	/** Verificamos que si restamos 2 a 0 nos da correctamente -2 */
	@Test
	public void testRestar1() {
		Assertions.assertEquals(-2, calculadora.restar(2));
	}
	
	/** Verificamos que si restamos 1 a 0 nos da correctamente -1 */
	@Test
	public void testRestar2() {
		Assertions.assertEquals(-1, calculadora.restar(1));
	}
	
	/** Verificamos que si sumamos 5 y restamos 3 nos da correctamente 2 */
	@Test
	public final void testGetResultado() {
		calculadora.sumar(5);
		calculadora.restar(3);
		Assertions.assertEquals(2, calculadora.getResultado());
	}

}

