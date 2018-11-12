import org.joda.time.LocalDate;
import java.util.UUID;

/** Класс служит для описания объектов Human со свойствами
 * <b>id</b>,  <b>lastName</b>, <b>fistName</b>, <b>patronymic</b>, <b>sex</b>, <b>dateOfBirth</b>, <b>age</b>.
 * @autor Tochilin Dmitry
 * @version 1.0
 */

public class Human {
    /** Свойство - идентификационный номер.
     * Уникальный номер объекта создается средствами класса UUID
     * @see UUID*/
  private String id = UUID.randomUUID().toString();

    /**Свойство - фамилия.
     */
  private String lastName;

    /**Свойство - имя.
     */
  private String firstName;

    /**Свойство - отчество.
     */
  private String patronymic;

    /**Свойство - пол.
     * @see Sex
     */
  private Sex sex;

    /**Свойство - Дата Рождения.
     * Исользуется класс LocalDate библиотеки JodaTime
     * @see LocalDate
     */
  private LocalDate dateOfBirth;

    /**Свойство - Количество лет.
     * Считается на основе полученной информации о дате рождения
     * @see Human
     */
  private int age;

  Human(String lastName, String firstName, String patronymic, Sex sex, String dateOfBirth) {
      this.lastName = lastName;
      this.firstName = firstName;
      this.patronymic = patronymic;
      this.sex = sex;
      this.dateOfBirth = parseStringToLocalDate(dateOfBirth);
      this.age = countAge(this.dateOfBirth);
  }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = parseStringToLocalDate(dateOfBirth);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }

    private LocalDate parseStringToLocalDate(String localDate) {
      return  LocalDate.parse(localDate);
  }

    private int countAge(LocalDate dateOfBirth) {
       LocalDate now = new LocalDate();
       int yearNow = now.getYear();
       int yearOfBirth = dateOfBirth.getYear();
       int age = yearNow - yearOfBirth;
       return age;
   }
}
