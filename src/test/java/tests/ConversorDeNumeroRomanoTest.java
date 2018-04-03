package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import domain.ConversorDeNumeroRomano;
import execeptions.NumerosRepetidosMaiorQue3Exception;

class ConversorDeNumeroRomanoTest {

	private static  ConversorDeNumeroRomano romano;

	static {

		romano = new ConversorDeNumeroRomano();
	}

	@Test
	void deveEntenderOSimboloI() {

		int numero01 = romano.converte("I");

		assertEquals(1, numero01);
	}

	@Test
	public void deveEntenderOSimboloV() {

		int numero = romano.converte("V");
		assertEquals(5, numero);
	}

	@Test
	public void deveEntenderDoisSimbolosComoII() {

		int numero = romano.converte("II");

		assertEquals(2, numero);
	}

	@Test
	public void deveEntender4SimbolosQualquer() {
		
		NumerosRepetidosMaiorQue3Exception exception = assertThrows(NumerosRepetidosMaiorQue3Exception.class, () ->romano.converte("IIII"));
		
		assertEquals("ExistemMaisde3AlgarismosIguaisJuntos", exception.getMessage());
		
	}	

	@Test 
	public void deveEntenderDoisSimbolosComoVV() {

		int numero = romano.converte("VV");

		assertEquals(10, numero);
	}
}
