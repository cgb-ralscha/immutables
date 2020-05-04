package ch.rasc.immutables;

import org.immutables.criteria.backend.Backend;
import org.immutables.criteria.inmemory.InMemoryBackend;

public class App {
	public static void main(String[] args) {

		// instantiate a backend
		Backend backend = new InMemoryBackend();

		// attach repository to the backend
		PersonRepository repository = new PersonRepository(backend);

		// insert some documents
		repository.insert(ImmutablePerson.builder().id("id1").fullName("John").build());
		repository.insert(ImmutablePerson.builder().id("id2").fullName("Mary").build());

		// query
		Person john = repository.find(PersonCriteria.person.fullName.is("John")).fetch()
				.get(0);
		Person mary = repository.find(PersonCriteria.person.fullName.isNot("John"))
				.fetch().get(0);
		System.out.println(john);
		System.out.println(mary);
	}
}
