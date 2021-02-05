Feature: Промяна на статуса на задачата
  Scenario Outline: Промяна на статуса на задачата
    Given Потребителя отваря екрана за промяна на статуса на задачата
    When Въвежда име на задачата която ще бъде променена "<name>"
    And Въвежда статуса на задачата "<status>"
    And Въвежда съобщение "<message>"
    And Въвежда разработчик за задачата "<developer>"
    And Натиска бутона за промяна на статуса на задачата
    Then Вижда съобщението за статуса на екрана "<expectedMessage>"

    Examples:
    |name|status|message|developer|expectedMessage|
    |Test|InProgress|Ready for development|Ivan Georgiev|Успешно променихте статуса на задачата|
    |    |InProgress|Ready for development|Ivan Georgiev|Моля въведете име на задачата         |
    |Test|          |Ready for development|Ivan Georgiev|Моля въведете статус на задачата|
    |Test|InProgress|                     |Ivan Georgiev|Моля въведете съобщение при смяна на статуса на задачата|
    |T   |InProgress|Ready for development|Ivan Georgiev|Задачата не е намерена                                  |
    |Test2|InProgress|Ready for development|Ivan Georgiev|Не може да се промени статуса на завършена задача      |
    |Test3|InProgress|Ready for development|             |Не може да се започне работа по задачата без разработчик|
    |Test |InProgress|Ready for development|Ivan G       |Успешно променихте статуса на задачата                  |