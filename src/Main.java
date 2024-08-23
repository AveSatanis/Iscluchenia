import Excteptions.*;

import java.io.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d+");
    private static final Pattern GENDER_PATTERN = Pattern.compile("[fm]");

    public static void main(String[] args) throws Exception {
        String[] result = InputData();
        if (result.length < 6) {
            throw new LessDataHasBeenEntered();
        } else if (result.length > 6) {
            throw new MoreDataHasBeenEntered();
        }
        try {
            String lastName = result[0];
            String firstName = result[1];
            String middleName = result[2];
            String birthDate = result[3];
            String phoneNumber = result[4];
            String gender = result[5];

            CheckLastName(lastName);
            CheckFirstName(firstName);
            CheckMiddleName(middleName);
            CheckBirthDate(birthDate);
            CheckGender(gender);
            CheckPhoneNumber(phoneNumber);

            String fileName = lastName + ".txt";
            writeToFile(fileName, lastName, firstName, middleName, birthDate, phoneNumber, gender);
            System.out.println("Данные успешно записаны в файл " + fileName);
            readToFile(fileName);
            System.out.println("Файл успешно прочитан!");
        } catch (WrongLastName e){
            throw new WrongLastName();
        } catch (WrongFirstName e){
            throw new WrongFirstName();
        } catch (IncorrectPatronymic e){
            throw new IncorrectPatronymic();
        } catch (BirthDayException e){
            throw new BirthDayException();
        } catch (NumberFormatException e){
            throw new NumberFormatException();
        } catch (GenderException e){
            throw new GenderException();
        } catch (IOException e){
            throw new IOException("Ошибка записи или чтения файла "+ e.getMessage());
        }


    }

    private static String[] InputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Формат ввода данных: \n" +
                "Фамилия, Имя, Отчество - кирилицей \n" +
                "Дата рождения - дд.мм.гггг \n" +
                "Номер телефона - цифрами без пробелов \n" +
                "Пол - одной буквой f или m.");
        System.out.println("Введите данные пользователя через пробел!");
        String vvod = reader.readLine();
        String[] data = vvod.split(" ");
        System.out.println(vvod);
        return data;
    }

    private static void CheckLastName(String lastName) throws WrongLastName {
        String alphaRegex = ".*[А-Я].*";
        if (lastName.matches(alphaRegex)){
            throw new WrongLastName();
        }
    }
    private static void CheckFirstName(String lastName) throws WrongFirstName {
        String alphaRegex = ".*[А-Я].*";
        if (!lastName.matches(alphaRegex)){
            throw new WrongFirstName();
        }
    }
    private static void CheckMiddleName(String lastName) throws IncorrectPatronymic {
        String alphaRegex = ".*[А-Я].*";
        if (!lastName.matches(alphaRegex)){
            throw new IncorrectPatronymic();
        }
    }
    private static void CheckBirthDate(String date) throws BirthDayException {
        Matcher matcher = DATE_PATTERN.matcher(date);
        if (!matcher.matches()) {
            throw new BirthDayException();
        }
    }
    private static void CheckGender(String gender) throws GenderException {
        Matcher matcher = GENDER_PATTERN.matcher(gender);
        if (!matcher.matches()) {
            throw new GenderException();
        }
    }

    private static void writeToFile(String fileName, String lastName, String firstName, String middleName, String dateOfBirth, String phoneNumber, String gender) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(String.format("%s %s %s %s %s %s", lastName, firstName, middleName, dateOfBirth, phoneNumber, gender));
            writer.newLine();
        }
    }

    private static void readToFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        reader.close();
    }
    private static void CheckPhoneNumber(String phoneNumber) throws NumberFormatException {
        Matcher matcher = PHONE_PATTERN.matcher(phoneNumber);
        if (!matcher.matches()) {
            throw new NumberFormatException();
        }

    }}