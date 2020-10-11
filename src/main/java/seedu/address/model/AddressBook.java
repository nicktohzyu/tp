package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Objects;

import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniqueClientList;
import seedu.address.model.person.UniqueHairdresserList;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.person.client.Client;
import seedu.address.model.person.hairdresser.Hairdresser;


/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniquePersonList persons;
    private final UniqueClientList clients;

    private final UniqueHairdresserList hairdressers;


    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();

        clients = new UniqueClientList();

        hairdressers = new UniqueHairdresserList();

    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Person> persons) {
        this.persons.setPersons(persons);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);
        setHairdressers(newData.getHairdresserList());
        setClients(newData.getClientList());
        setPersons(newData.getPersonList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return persons.contains(person);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addPerson(Person p) {
        persons.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setPerson(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        persons.setPerson(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Person key) {
        persons.remove(key);
    }

    //// hairdresser-level operations

    /**
     * Returns true if a hairdresser with the same identity as {@code hairdresser} exists in the address book.
     */
    public boolean hasHairdresser(Hairdresser hairdresser) {
        requireNonNull(hairdresser);
        return hairdressers.contains(hairdresser);
    }

    /**
     * Adds a hairdresser to the address book.
     * The hairdresser must not already exist in the address book.
     */
    public void addHairdresser(Hairdresser p) {
        hairdressers.add(p);
    }

    /**
     * Replaces the given hairdresser {@code target} in the list with {@code editedHairdresser}.
     * {@code target} must exist in the address book.
     * The hairdresser identity of {@code editedHairdresser} must not be the same as
     * another existing hairdresser in the address book.
     */
    public void setHairdresser(Hairdresser target, Hairdresser editedHairdresser) {
        requireNonNull(editedHairdresser);

        hairdressers.setHairdresser(target, editedHairdresser);
    }

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setHairdressers(List<Hairdresser> hairdressers) {
        this.hairdressers.setHairdressers(hairdressers);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeHairdresser(Hairdresser key) {
        hairdressers.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Person> getPersonList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Hairdresser> getHairdresserList() {
        return hairdressers.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && persons.equals(((AddressBook) other).persons))
                && clients.equals(((AddressBook) other).clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons, clients);
    }

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setClients(List<Client> clients) {
        this.clients.setClients(clients);
    }


    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasClient(Client client) {
        requireNonNull(client);
        return clients.contains(client);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addClient(Client p) {
        clients.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setClient(Client target, Client editedClient) {
        requireNonNull(editedClient);

        persons.setPerson(target, editedClient);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeClient(Client key) {
        clients.remove(key);
    }

    //// util methods


    @Override
    public ObservableList<Client> getClientList() {
        return clients.asUnmodifiableObservableList();
    }


}
