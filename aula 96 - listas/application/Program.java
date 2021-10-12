/* Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
   N funcionários. Não deve haver repetição de id.
   Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
   Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
   mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
   conforme exemplos.
   Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
   ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
   aumento por porcentagem dada.
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int quantity = input.nextInt();

		for (int i = 0; i < quantity; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1) + ":");

			System.out.print("ID: ");
			Integer id = input.nextInt();

			while (hasId(list, id)) {
				System.out.print("Id already taken! Try again: ");
				id = input.nextInt();
			}

			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();

			System.out.print("Salary: ");
			Double salary = input.nextDouble();

			/*
			 * Opcionalmente eu poderia instanciar o objeto primeiramente e depois inseri-lo
			 * na lista, como em: Employee emp = new Employee(id, name, salary);
			 * list.add(emp);
			 */

			list.add(new Employee(id, name, salary));
		}
		System.out.println();

		System.out.print("Enter the employee id that will have salary increase: ");
		int id = input.nextInt();

		/*
		 * Uma outra maneira de fazer a busca para verificar se o ID existe é através do
		 * comando:
		 * 
		 * Employee emp = list.stream().filter(x -> x.getId() ==
		 * id).findFirst().orElse(null);
		 */

		Integer result = position(list, id);

		if (result == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			Double percent = input.nextDouble();
			list.get(result).increaseSalary(percent);
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Employee emp : list) {
			System.out.print(emp);
		}

		input.close();
	}

	public static Integer position(List<Employee> lista, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	public static boolean hasId(List<Employee> lista, int id) {
		Employee emp = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
