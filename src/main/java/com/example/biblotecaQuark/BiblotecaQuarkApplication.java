package com.example.biblotecaQuark;

import com.example.biblotecaQuark.Modelo.FactorySocios.*;
import com.example.biblotecaQuark.Modelo.Libro.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;
import com.example.biblotecaQuark.Vista.CahinOfRepository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;


public class BiblotecaQuarkApplication {

	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {

		MenuOpciones opcLibro = new OpcLibro();
		MenuOpciones opcEjemp = new OpcEjemplares();
		MenuOpciones opcSocio = new OpcSocio();


		opcLibro.agregarSigOpc(opcSocio);
		opcSocio.agregarSigOpc(opcEjemp);
		int opc = 0;
		do {
			System.out.println("******************");
			System.out.println("****** Menu ******");
			System.out.println("*********+********");
			System.out.println("1 -> Libro");
			System.out.println("2 -> Socio");
			System.out.println("3 -> Ejemplar");
			System.out.println("4 -> Salir");

			opc = sc.nextInt();

			opcLibro.opcion(opc);
		}while (opc != 4);


	}


}
