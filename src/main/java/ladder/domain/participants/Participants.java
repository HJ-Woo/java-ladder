package ladder.domain.participants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private static final String SEPARATOR = ",";

    private final List<Person> participants;

    private Participants(String nameOfPerson) {
        this.participants = Arrays.stream(nameOfPerson.split(SEPARATOR))
                .map(name -> Person.of(name.trim()))
                .collect(Collectors.toList());
    }

    public static Participants valueOf(String nameOfPerson) {
        return new Participants(nameOfPerson);
    }

    public int size() {
        return participants.size();
    }

    public Person getPerson(int personIndex) {
        return participants.get(personIndex);
    }

    public String tellPersonName(int personIndex) {
        return participants.get(personIndex).getName();
    }
}