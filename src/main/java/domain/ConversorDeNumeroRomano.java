package domain;

import java.util.HashMap;
import java.util.Map;

import execeptions.NumerosRepetidosMaiorQue3Exception;

public class ConversorDeNumeroRomano {

	private static Map<Character, Integer> tabela =

	new HashMap<Character, Integer>() {
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);

		}};
		public int converte(String numerosRomanos) {

			int contRepetido = 0;

			int acumulador = 0;

			Character anterior = null;

			Character  numeroRomano;

			for(int i = 0; i < numerosRomanos.length(); i++) {

				numeroRomano = numerosRomanos.charAt(i); 

				if(numeroRomano == anterior) {

					++contRepetido;
				}

				if(contRepetido == 3){


					throw new NumerosRepetidosMaiorQue3Exception();
				}

				acumulador+= tabela.get(numerosRomanos.charAt(i));

				anterior = numeroRomano;
			}

			return acumulador;
		}
}