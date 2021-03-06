Feature: Добавяне на подпроект
  Scenario: Добавяне на подпроект към съществуващ проект
    Given Потребителя отваря екрана за добавяне на подпроекти
    When Въвежда името на подпроекта "Test2"
    And Въвежда името на мениджъра "Ivan Ivanov"
    And Въвежда списък с разработчици за подпроекта
      | Ivan Georgiev | Georgi Georgiev |
    And Въвежда името на главния проект "Test"
    And Натиска бутона за добавяне на подпроекта
    Then Вижда съобщението "Успешно добавихте подпроекта"

  Scenario: Добавяне на подпроект към несъществуващ проект
    Given Потребителя отваря екрана за добавяне на подпроекти
    When Въвежда името на подпроекта "Test2"
    And Въвежда името на мениджъра "Ivan Ivanov"
    And Въвежда списък с разработчици за подпроекта
      | Ivan Georgiev | Georgi Georgiev |
    And Въвежда името на главния проект "T"
    And Натиска бутона за добавяне на подпроекта
    Then Вижда съобщението "Проекта не съществува"

  Scenario: Добавяне на подпроект без име на главния проект
    Given Потребителя отваря екрана за добавяне на подпроекти
    When Въвежда името на подпроекта "Test2"
    And Въвежда името на мениджъра "Ivan Ivanov"
    And Въвежда списък с разработчици за подпроекта
      | Ivan Georgiev | Georgi Georgiev |
    And Натиска бутона за добавяне на подпроекта
    Then Вижда съобщението "Моля въведете име на главния проект"

  Scenario: Добавяне на подпроект без име на подпроекта
    Given Потребителя отваря екрана за добавяне на подпроекти
    When Въвежда името на мениджъра "Ivan Ivanov"
    And Въвежда списък с разработчици за подпроекта
      | Ivan Georgiev | Georgi Georgiev |
    And Натиска бутона за добавяне на подпроекта
    Then Вижда съобщението "Моля въведете име на проекта"

  Scenario: Добавяне на подпроект с несъществуващ мениджър
    Given Потребителя отваря екрана за добавяне на подпроекти
    When Въвежда името на подпроекта "Test2"
    And Въвежда името на мениджъра "I I"
    And Въвежда списък с разработчици за подпроекта
      | Ivan Georgiev | Georgi Georgiev |
    And Въвежда името на главния проект "Test"
    And Натиска бутона за добавяне на подпроекта
    Then Вижда съобщението "Мениджъра не съществува"

  Scenario: Добавяне на подпроект без разработчици
    Given Потребителя отваря екрана за добавяне на подпроекти
    When Въвежда името на подпроекта "Test2"
    And Въвежда името на мениджъра "Ivan Ivanov"
    And Въвежда името на главния проект "Test"
    And Натиска бутона за добавяне на подпроекта
    Then Вижда съобщението "Моля въведете разработчици за проекта"