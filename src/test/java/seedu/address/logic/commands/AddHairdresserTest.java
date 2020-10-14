package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.hairdresser.AddHairdresserCommand;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.client.Client;
import seedu.address.model.person.hairdresser.Hairdresser;
import seedu.address.testutil.HairdresserBuilder;

public class AddHairdresserTest {

    @Test
    public void constructor_nullHairdresser_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddHairdresserCommand(null));
    }

    @Test
    public void execute_hairdresserAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingHairdresserAdded modelStub = new ModelStubAcceptingHairdresserAdded();
        Hairdresser validHairdresser = new HairdresserBuilder().build();

        CommandResult commandResult = new AddHairdresserCommand(validHairdresser).execute(modelStub);

        assertEquals(String.format(AddHairdresserCommand.MESSAGE_SUCCESS, validHairdresser),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validHairdresser), modelStub.hairdressersAdded);
    }

    @Test
    public void execute_duplicateHairdresser_throwsCommandException() {
        Hairdresser validHairdresser = new HairdresserBuilder().build();
        AddHairdresserCommand addCommand = new AddHairdresserCommand(validHairdresser);
        ModelStub modelStub = new ModelStubWithHairdresser(validHairdresser);

        assertThrows(CommandException.class, AddHairdresserCommand.MESSAGE_DUPLICATE_HAIRDRESSER, ()
            -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Hairdresser alice = new HairdresserBuilder().withName("Alice").build();
        Hairdresser bob = new HairdresserBuilder().withName("Bob").build();
        AddHairdresserCommand addAliceCommand = new AddHairdresserCommand(alice);
        AddHairdresserCommand addBobCommand = new AddHairdresserCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddHairdresserCommand addAliceCommandCopy = new AddHairdresserCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different hairdresser -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addHairdresser(Hairdresser hairdresser) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasClient(Client client) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteClient(Client client) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addClient(Client client) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setClient(Client target, Client editedClient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Client> getFilteredClientList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredClientList(Predicate<Client> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasHairdresser(Hairdresser hairdresser) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteHairdresser(Hairdresser target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setHairdresser(Hairdresser target, Hairdresser editedHairdresser) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Hairdresser> getFilteredHairdresserList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredHairdresserList(Predicate<Hairdresser> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single hairdresser.
     */
    private class ModelStubWithHairdresser extends ModelStub {
        private final Hairdresser hairdresser;

        ModelStubWithHairdresser(Hairdresser hairdresser) {
            requireNonNull(hairdresser);
            this.hairdresser = hairdresser;
        }

        @Override
        public boolean hasHairdresser(Hairdresser hairdresser) {
            requireNonNull(hairdresser);
            return this.hairdresser.isSameHairdresser(hairdresser);
        }
    }

    /**
     * A Model stub that always accept the hairdresser being added.
     */
    private class ModelStubAcceptingHairdresserAdded extends ModelStub {
        final ArrayList<Hairdresser> hairdressersAdded = new ArrayList<>();

        @Override
        public boolean hasHairdresser(Hairdresser hairdresser) {
            requireNonNull(hairdresser);
            return hairdressersAdded.stream().anyMatch(hairdresser::isSameHairdresser);
        }

        @Override
        public void addHairdresser(Hairdresser hairdresser) {
            requireNonNull(hairdresser);
            hairdressersAdded.add(hairdresser);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
