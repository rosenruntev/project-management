Feature: Добавяне на задача
  Scenario Outline: Добавяне на задача
    Given Потребителя отваря екрана за добавяне на задача
    When Въвежда име на задачата "<name>"
    And Въвежда описание на задачата "<description>"
    And Въвежда името на проекта "<projectName>"
    And Натиска бутона за добавяне на задача
    Then Вижда съобщение на екрана "<expectedMessage>"

    Examples:
      |name|description|projectName|expectedMessage|
      |sample task|sample description|Test|Успешно добавихте задачата|
      |sample task|sample description|T   |Проекта не съществува|
      |           |sample description|Test|Моля въведете име на задачата|
      |sample task|                  |Test|Моля въведете описание на задачата|
      |sample task|sample description|    |Моля въведете име на проекта|
