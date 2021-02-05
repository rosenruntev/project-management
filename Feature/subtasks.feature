Feature: Добавяне на подзадача
  Scenario Outline: Добавяне на подзадача
    Given Потребителя отваря екрана за добавяне на подзадача
    When Въвежда име на подзадачата "<name>"
    And Въвежда описание на подзадачата "<description>"
    And Въвежда името на главната задача "<parentTask>"
    And Въвежда името на разработчика за подзадачата "<developer>"
    And Натиска бутона за добавяне на подзадачата
    Then Вижда съобщението на екрана "<expectedMessage>"

    Examples:
      |name|description|parentTask|developer|expectedMessage|
      |sample task|sample description|Test|Ivan Georgiev|Успешно добавихте подзадачата|
      |sample task|sample description|Testt|Ivan Georgiev|Задачата не е намерена      |
      |sample task|sample description|Test |             |Успешно добавихте подзадачата|
      |sample task|sample description|Test |I G          |Разработчика не е намерен    |
      |           |sample description|Test |Ivan Georgiev|Моля въведете име на подзадачата|
      |sample task|                  |Test |Ivan Georgiev|Моля въведете описание на подзадачата|
      |sample task|sample description|     |Ivan Georgiev|Моля въведете името на главната задача|