package contoller;

import dao.BetDao;
import dao.PersonDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.Person;

public class ConsoleHandler {
    private static final int BET_RISK = 1;
    private static final int BET_VALUE = 0;
    private static final int PERSON_NAME = 0;
    private static final int PERSON_AGE = 1;
    private static final String EXIT_KEY = "q";
    private static final String BET_PROMPT_MESSAGE = "Please enter your bet and risk";
    private static final String SPLITTER = " ";
    private static final String PERSON_PROMPT_MESSAGE = "Please enter persons' name and age";
    private static final String PERSON_INVALID_FORMAT_MESSAGE = "Please enter both name and age";
    private static final String ONE_ARGUMENT_MESSAGE = "Please enter valid name and age";
    private static final String BET_INVALID_FORMAT_MESSAGE = "Please enter valid value and risk";
    private static final String ONE_INPUT_ARGUMENT_MESSAGE = "Please enter both bet and risk";
    private static final String EMPTY_DATA_MESSAGE = "No data";
    @Inject
    private BetDao betDao;
    @Inject
    private PersonDao personDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PERSON_PROMPT_MESSAGE);
        boolean isWaitingForPersonInput = true;
        while (isWaitingForPersonInput) {
            String personInput = scanner.nextLine();
            if (personInput.equalsIgnoreCase(EXIT_KEY)) {
                return;
            }
            Person newPerson = null;
            try {
                String[] personData = personInput.split(SPLITTER);
                String personName = personData[PERSON_NAME];
                int personAge = Integer.parseInt(personData[PERSON_AGE]);
                newPerson = new Person(personName, personAge);
            } catch (NumberFormatException nfe) {
                System.out.println(PERSON_INVALID_FORMAT_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(ONE_ARGUMENT_MESSAGE);
            }
            if (newPerson != null) {
                personDao.add(newPerson);
                isWaitingForPersonInput = false;
            }
            System.out.println(newPerson == null ? EMPTY_DATA_MESSAGE : newPerson.toString());
        }
        System.out.println(BET_PROMPT_MESSAGE);
        while (true) {
            String betInput = scanner.nextLine();
            if (betInput.equalsIgnoreCase(EXIT_KEY)) {
                return;
            }
            Bet newBet = null;
            try {
                String[] betData = betInput.split(SPLITTER);
                int betValue = Integer.parseInt(betData[BET_VALUE]);
                double betRisk = Double.parseDouble(betData[BET_RISK]);
                newBet = new Bet(betValue, betRisk);
            } catch (NumberFormatException nfe) {
                System.out.println(BET_INVALID_FORMAT_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(ONE_INPUT_ARGUMENT_MESSAGE);
            }
            if (newBet != null) {
                betDao.add(newBet);
            }
            System.out.println(newBet == null ? EMPTY_DATA_MESSAGE : newBet.toString());
        }
    }
}
