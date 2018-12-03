package com.netcracker.lab;

import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.util.UUID;

/** Класс служит для описания объектов com.netcracker.lab.Human со свойствами
 * <b>id</b>,  <b>lastName</b>, <b>fistName</b>, <b>patronymic</b>, <b>sex</b>, <b>dateOfBirth</b>, <b>age</b>.
 * @author Tochilin Dmitry
 * @version 1.0
 */

public class Human {
    /** Свойство - идентифкационный номер.
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

    /**
     * Создает объект с заданными значениями. Возраст считается на основе заданной даты рождения
     * @param lastName - фамилия.
     * @param firstName - имя.
     * @param patronymic - отчество.
     * @param sex - пол.
     * @param dateOfBirth - дата рождения
     *
     * @see Human#countAge(LocalDate)
     */
  public Human(String lastName, String firstName, String patronymic, Sex sex, String dateOfBirth) {
      this.lastName = lastName;
      this.firstName = firstName;
      this.patronymic = patronymic;
      this.sex = sex;
      this.dateOfBirth = parseStringToLocalDate(dateOfBirth);
      this.age = countAge(this.dateOfBirth);
  }

    /** Функция для получения значения поля {@link Human#id}
     * @return Возвращает идентификационный номер человека
     */
    public String getId() {
        return id;
    }

    /** Функция для получения значения поля {@link Human#getLastName()}
     * @return Возвращает фамилию человека
     */
    public String getLastName() {
        return lastName;
    }

    /** Функция для указания значения поля {@link Human#getLastName()}
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Функция для получения значения поля {@link Human#getFirstName()}
     * @return Возвращает имя человека
     */
    public String getFirstName() {
        return firstName;
    }

    /** Функция для указания значения поля {@link Human#setFirstName(String)}
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Функция для получения значения поля {@link Human#getPatronymic()}
     * @return Возвращает отчество человека
     */
    public String getPatronymic() {
        return patronymic;
    }

    /** Функция для указания значения поля {@link Human#setPatronymic(String)}
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /** Функция для получения значения поля {@link Human#getSex()}
     * @return Возвращает пол человека
     */
    public Sex getSex() {
        return sex;
    }

    /** Функция для указания значения поля {@link Human#setSex(Sex)}
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /** Функция для получения значения поля {@link Human#getDateOfBirth()}
     * @return Возвращает Дату Рождения человека
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /** Функция для получения значения поля {@link Human#setDateOfBirth(String)}
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = parseStringToLocalDate(dateOfBirth);
    }

    /** Функция для получения значения поля {@link Human#getAge()}
     * @return Возвращает возраст человека
     */
    public int getAge() {
        return age;
    }

    /** Функция для перевода класса в строку {@link Human#toString()}
     * @return указанную дату классом {@link LocalDate}
     */
    @Override
    public String toString() {
        return "com.netcracker.lab.Human{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }

    /** Функция для конвертации данных {@link Human#parseStringToLocalDate(String)}
     * @return указанную дату классом {@link LocalDate}
     */
    private LocalDate parseStringToLocalDate(String localDate) {
      return  LocalDate.parse(localDate);
  }

    /** Функция для подсчета возраста {@link Human#countAge(LocalDate)}
     * @return количество лет человеку
     */
    private int countAge(LocalDate dateOfBirth) {
       LocalDate now = new LocalDate();
       Period period = new Period(dateOfBirth, now);
       return period.getYears();
   }
}
