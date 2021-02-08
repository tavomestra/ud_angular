package StreamPrueba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrueba {
	
	private static List<User> users;
	
	public static void main(String arg[]) {
		setUpUser();
		Stream stream = Stream.of(users);
		users.stream();
		
		//ForEach
		users.stream().forEach(e->e.setNombre(e.getNombre() + " Apellido"));
		imprimirLista();
		//Map y Collectors.toList
		List<String> lista = users.stream().map(e->e.getNombre()).collect(Collectors.toList());
		lista.stream().forEach(e->System.out.println(e));
		//Filter
		System.out.println("------------------------Filters-------------------------");
		setUpUser();
		List<User> usersFilter=users.stream()
				.filter(e->e.getNombre()!="Alberto")
				.filter(e->e.getId()<3)
				.collect(Collectors.toList());
		usersFilter.stream().forEach(e->System.out.println(e.getId() + " " + e.getNombre()));
		//FindFirst
		System.out.println("------------------------Find First-------------------------");
		setUpUser();
		User user = users.stream()
				.filter(e->e.getNombre().equals("Alberto"))
				.findFirst()
				.orElse(null);
		System.out.println(user.getId() + " " + user.getNombre());
		//flatMap
		System.out.println("-----------------------flatMap-------------------------");
		List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
				Arrays.asList(
						new ArrayList<String>(Arrays.asList("Alberto", "Maria", "Pedro")),
						new ArrayList<String>(Arrays.asList("Monica", "Pablo"))));
		
		List<String> nombresUnicaLista = nombresVariasListas.stream()
				.flatMap(e->e.stream())
				.collect(Collectors.toList());
		
		nombresUnicaLista.stream().forEach(e -> System.out.println(e));
		//Peek
		System.out.println("-----------------------Peek-------------------------");
		setUpUser();
		List<User> user2 = users.stream()
				.peek(e -> e.setNombre(e.getNombre() + " Apellido")).collect(Collectors.toList());
		user2.stream().forEach(e->System.out.println(e.getNombre()));
		//Count
		System.out.println("-----------------------Count-------------------------");
		setUpUser();
		long numeroFiltrado = users.stream()
				.filter(e->e.getId()<3)
				.count();
		System.out.println(numeroFiltrado);
		//Skip y Limit
		System.out.println("-----------------------Skip y Limit-------------------------");
		String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		List<String> abcFilter = Arrays.stream(abc)
				.skip(2)
				.limit(4)
				.collect(Collectors.toList());
		abcFilter.stream().forEach(e->System.out.println(e));
		//Sorted
		System.out.println("-----------------------Sorted-------------------------");
		setUpUser();
		users = users.stream()
		.sorted(Comparator.comparing(User::getNombre))
		.collect(Collectors.toList());
		imprimirLista();
		//Min y Max
		System.out.println("-----------------------Min y Max-------------------------");
		setUpUser();
		User userMin = users.stream()
				.min(Comparator.comparing(User::getId))
				.orElse(null);
		System.out.println(userMin.getId());
		User userMax = users.stream()
				.max(Comparator.comparing(User::getId))
				.orElse(null);
		System.out.println(userMax.getId());
		//distinct
		System.out.println("-----------------------Distinct-------------------------");
		String[] abc1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "a", "c"};
		List<String> abcFilter1 = Arrays.stream(abc1)
				.distinct().collect(Collectors.toList());
		abcFilter1.stream().forEach(e->System.out.println(e));
		//allMatch, anyMatch, nonematch
		System.out.println("-----------------------allMatch, anyMatch, nonematch-------------------------");
		List<Integer> listaNumeros = Arrays.asList(100,300,900,5000);
		
		boolean allMatch = listaNumeros.stream().allMatch(e->e>301);
		System.out.println(allMatch);
		
		boolean anyMatch = listaNumeros.stream().anyMatch(e->e>301);
		System.out.println(anyMatch);
		
		boolean noneMatch = listaNumeros.stream().noneMatch(e->e>4000);
		System.out.println(noneMatch);
		
		//Sum Avarege range
		System.out.println("-----------------------Sum Average range-------------------------");
		setUpUser();
		double result = users.stream()
				.mapToInt(User::getId)
				.average()
				.orElse(0);
		System.out.println(result);
		
		result = users.stream()
				.mapToInt(User::getId)
				.sum();
		System.out.println(result);
		System.out.println(IntStream.range(0, 100).sum());
		
		//Reduce
		System.out.println("-----------------------Reduce-------------------------");
		setUpUser();
		int numero = users.stream()
				.map(User::getId)
				.reduce(100, Integer::sum);
		System.out.println(numero);
		//Joining
		System.out.println("-----------------------joining-------------------------");
		setUpUser();
		String names = users.stream()
				.map(User::getNombre)
				.collect(Collectors.joining(" - "))
				.toString();
		System.out.println(names);
		//toSet
		System.out.println("-----------------------toSet-------------------------");
		setUpUser();
		Set<String> setNames = users.stream()
				.map(User::getNombre)
				.collect(Collectors.toSet());
		setNames.stream().forEach(e->System.out.println(e));
		//summarizingDouble
		System.out.println("-----------------------summarizingDouble-------------------------");
		setUpUser();
		DoubleSummaryStatistics statistics = users.stream()
				.collect(Collectors.summarizingDouble(User::getId));
		System.out.println(statistics.getAverage() + " " + statistics.getMax() + " "
				+ statistics.getMin() + " " + statistics.getCount() + " " + statistics.getSum());
			
		DoubleSummaryStatistics statistics1 = users.stream()
				.mapToDouble(User::getId)
				.summaryStatistics();
		System.out.println(statistics1.getAverage() + " " + statistics1.getMax() + " "
				+ statistics1.getMin() + " " + statistics1.getCount() + " " + statistics1.getSum());
		
		//partitioningBy
		System.out.println("-----------------------partitioningBy-------------------------");
		setUpUser();
		List<Integer> numeros = Arrays.asList(5,7,34,56,2,3,67,4,98);
		Map<Boolean, List<Integer>> esMayor = numeros.stream()
				.collect(Collectors.partitioningBy(e->e>10));
		esMayor.get(true).stream().forEach(e->System.out.println(e));
		esMayor.get(false).stream().forEach(e->System.out.println(e));
		//groupingBy
		System.out.println("-----------------------groupingBy-------------------------");
		setUpUser();
		Map<Character, List<User>> grupoAlfabetico = users.stream()
				.collect(Collectors.groupingBy(e->new Character(e.getNombre().charAt(0))));
		grupoAlfabetico.get('A').stream().forEach(e->System.out.println(e.getNombre()));
		grupoAlfabetico.get('M').stream().forEach(e->System.out.println(e.getNombre()));
		grupoAlfabetico.get('P').stream().forEach(e->System.out.println(e.getNombre()));
		//mapping
		System.out.println("-----------------------mapping-------------------------");
		setUpUser();
		List<String> personas = users.stream()
				.collect(Collectors.mapping(User::getNombre, Collectors.toList()));
		personas.stream().forEach(e->System.out.println(e));
		System.out.println("-----------------------Stream Paralelo-------------------------");
		setUpUser();
		long tiempo1 = System.currentTimeMillis();
		lista.stream().forEach(e->convertirAMayusculas(e));
		long tiempo2 = System.currentTimeMillis();
		System.out.println("Normal: " + (tiempo2-tiempo1));
		tiempo1 = System.currentTimeMillis();
		lista.parallelStream().forEach(e->convertirAMayusculas(e));
		tiempo2 = System.currentTimeMillis();
		System.out.println("Paralelo: " + (tiempo2-tiempo1));

		
	}
	
	private static String convertirAMayusculas(String nombre) {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
	
	private static void setUpUser() {
		users = new ArrayList<>();
		users.add(new User(1, "Alberto"));
		users.add(new User(2, "Marta"));
		users.add(new User(3, "Maria"));
		users.add(new User(4, "Pablo"));
		users.add(new User(5, "Adolfo"));
		users.add(new User(6, "Alberto"));
	}
	
	private static void imprimirLista() {
		users.stream().forEach(e->System.out.println(e.getId() + " " + e.getNombre()));
	}

}
