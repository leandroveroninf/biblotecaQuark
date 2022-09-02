package com.example.biblotecaQuark;

import com.example.biblotecaQuark.Modelo.FactorySocios.*;
import com.example.biblotecaQuark.Modelo.Singleton.Ejemplar;
import com.example.biblotecaQuark.Modelo.Libro.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;


public class BiblotecaQuarkApplication {

	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		Integer opc = 0;
		List<Libro> libroList = new ArrayList<>();
		List<ISocio> socioList = new ArrayList<>();


		do {

			 opc = menu();


			switch (opc) {
				case 1 -> {
					libroList.addAll(dataLibro());
				}
				case 2 -> {
					System.out.println("Seleccione el IBNS que quieres crear su ejemplar");
					libroList.forEach(libro -> System.out.println(libro.getIBNS()));
					sc.nextLine();
					String ibns = sc.nextLine();

					Libro libroSel =libroList.stream().filter(libro -> Objects.equals(libro.getIBNS(), ibns)).toList().get(0);

					if(libroSel != null){

						System.out.println("Ingrese la cantidad de ejemplares que quieres agregar");
						int cant = sc.nextInt();
						List<Ejemplar> ejemplarList = libroSel.getEjemplarList();
						int ulNumEd = ejemplarList.get(libroSel.getEjemplarList().size()-1).getNumEdition();

						for (int i = 0; i < cant; i++){
							ejemplarList.add(new Ejemplar(libroSel, ++ulNumEd));
						}

						libroSel.setEjemplarList(ejemplarList);

					}

				}
				case 3 -> {
					socioList.addAll(dataSocio());
					socioList.forEach(socio -> System.out.println(socio.toString()));
				}
				case 4 -> {
					libroList.forEach(libro -> System.out.println(libro.toString()));
				}
				case 5 -> {
					System.out.println("Seleccionar socio para presar");
					System.out.println("1 -> Socio comun");
					System.out.println("2 -> Socio VIP");
					int opcSc = sc.nextInt();
					System.out.println("Seleccione un id");
					if(opcSc == 1){

						List<ISocio> sociComun = socioList.stream().filter(socio -> socio instanceof Socio).toList();

						System.out.println("Socios comunes");
						soscioSelcPrestar(sociComun, libroList);

					}else{
						List<ISocio> socioVIO = socioList.stream().filter(socioVIP -> socioVIP instanceof SocioVIP).toList();
						System.out.println("Socio VIP");
						soscioSelcPrestar(socioVIO, libroList);
					}



				}
				case 6 -> {
					System.out.println("Seleccionar socio que devolvera el libro");
					System.out.println("1 -> Socio comun");
					System.out.println("2 -> Socio VIP");
					int opcSc = sc.nextInt();
					System.out.println("Seleccione un id");
					if(opcSc == 1){

						List<ISocio> sociComun = socioList.stream().filter(socio -> socio instanceof Socio).toList();

						System.out.println("Socios comunes");
						socioSelcDevolver(sociComun, libroList);

					}else{
						List<ISocio> socioVIO = socioList.stream().filter(socioVIP -> socioVIP instanceof SocioVIP).toList();
						System.out.println("Socio VIP");
						socioSelcDevolver(socioVIO, libroList);
					}

				}
				case 7 -> {
					System.out.println("Seleccionar socio para presar");
					System.out.println("1 -> Socio comun");
					System.out.println("2 -> Socio VIP");
					int opcSc = sc.nextInt();
					System.out.println("Seleccione un id");
					if(opcSc == 1){

						List<ISocio> sociComun = socioList.stream().filter(socio -> socio instanceof Socio).toList();
						System.out.println("Socios comunes");
						sociComun.forEach(socio -> System.out.println(socio.toString()));

					}else{
						List<ISocio> socioVIO = socioList.stream().filter(socioVIP -> socioVIP instanceof SocioVIP).toList();
						System.out.println("Socio VIP");
						socioVIO.forEach(socio -> System.out.println(socio.toString()));
					}
				}
			}

		}while (opc != 10);

	}

	public static void socioSelcDevolver(List<ISocio> socioList, List<Libro> libroList){
		socioList.forEach(socio -> {
			System.out.println("id -> "+ socio.getId());
			System.out.println("Full name -> "+socio.getName()+", "+socio.getLasName());
		});

		int opSocId = sc.nextInt();

		socioList.forEach(socio -> {
			if(socio.getId() == opSocId){

				if(socio instanceof SocioVIP) {
					System.out.println("Seleccione el IBNS del ejemplar a devolver");
					socio.getEjemplaresRetirados().forEach(ejemplar -> System.out.println(ejemplar.getLibro().getIBNS()));
					sc.nextLine();
					String ibnsSel = sc.nextLine();


					libroList.forEach(libro -> {
						if(Objects.equals(libro.getIBNS(), ibnsSel)){
							libro.registrar(socio.devolverEjemplar(ibnsSel), socio);
						}
					});

				}else{
					SocioProxy socioProxy = new SocioProxy(socio);
					libroList.forEach(libro -> libro.registrar(socioProxy.devolverEjemplar(), socio));
				}

			}
		});

	}
	public static void soscioSelcPrestar(List<ISocio> socioStream, List<Libro> libroList){
		socioStream.forEach(socio -> {
			System.out.println("id -> "+ socio.getId());
			System.out.println("Full name -> "+socio.getName()+", "+socio.getLasName());
		});

		int opSocId = sc.nextInt();
		System.out.println("Seleccione el libro a prestar");
		libroList.forEach(libro -> {
			System.out.println("libri ->"+libro.getIBNS());

		});
		sc.nextLine();
		String opcLibro = sc.nextLine();

		socioStream.forEach(socio -> {
			if(socio.getId() == opSocId){
				Stream<Libro> libroStream = libroList.stream().filter(libro -> libro.getIBNS().equalsIgnoreCase(opcLibro));
				socio.pedirEjemplar(libroStream.findAny().get().prestar(socio));
			}
		});

	}
	public static List<Libro> dataLibro(){


		List<Libro> libros = new ArrayList<>();
		System.out.println("-> ** Libro **");
		System.out.println("Cantidad de libros");
		int cantLicbos = 1;
		cantLicbos = sc.nextInt();

		for(int n = 0; n < cantLicbos; n++) {
			System.out.println("Libro ----");
			sc.nextLine();
			System.out.println("-> name");
			String nombre = sc.nextLine();
			System.out.println("-> autor");
			String autor = sc.nextLine();
			System.out.println("-> IBNS");
			String ibns = sc.nextLine();
			System.out.println("Cantidad de ejemlates");
			Integer cantEjm = sc.nextInt();

			Libro libro = new Libro(nombre, autor);
			boolean atISBN = libro.crearISBN(ibns);
			while(!atISBN){
				System.out.println("-> IBNS");
				sc.nextLine();
				ibns = sc.nextLine();
				atISBN = libro.crearISBN(ibns);
			}

			libro.setCantEjemplar(cantEjm);


			List<Ejemplar> ejemplarList = new ArrayList<>();

			for (int i = 0; i < libro.getCantEjemplar(); i++) {
				ejemplarList.add(new Ejemplar(libro, (i+1)));

			}

			libro.setEjemplarList(ejemplarList);

			libros.add(libro);
		}
		return libros;
	}

	public static List<ISocio> dataSocio(){
		List<ISocio> socioList = new ArrayList<>();
		System.out.println("********SOCIO*********");
		System.out.println("Cantidad de socio");
		int cant = sc.nextInt();
		ICreatorSocio creatorSocio;

		for (int i = 0; i < cant; i++){
			System.out.println("1 -> Socio comun");
			System.out.println("2 -> Socio VIP");
			int opc = sc.nextInt();
			if(opc == 1){
				creatorSocio = new CreateSocio();
			}else{
				creatorSocio = new CreateSocioVIP();
			}
			sc.nextLine();
			System.out.println("nombre");
			String nombre = sc.nextLine();
			System.out.println("apellido");
			String apellido = sc.nextLine();

			socioList.add(creatorSocio.createSocio(nombre, apellido));

		}


		return socioList;
	}


	private static Integer menu(){
		Integer opSelec = 0;
		System.out.println("****** Menu ******");
		System.out.println("1 -> Crear libro");
		System.out.println("2 -> Crear ejemplar");
		System.out.println("3 -> Crear Socio");
		System.out.println("4 -> Libros Creados");
		System.out.println("5 -> Prestar libro");
		System.out.println("6 -> Devolver libro");
		System.out.println("7 -> Mostrar Socios");
		opSelec = sc.nextInt();

		return opSelec;
	}

}
