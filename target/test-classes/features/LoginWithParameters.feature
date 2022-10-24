Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts. And dashboard should be displayed.

  Accounts are: librarian and student

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the Library Login page

  Scenario: Login as librarian
    When user enters librarian username "librarian1@library"
    And user enters librarian password "rs4BNN9G"
    Then user should see the title "Library"

  Scenario: Login as student
    When user enters student username "student1@library"
    And user enters student password "i2A9TgXa"
    Then user should see the the title "Library"

  Scenario: Login as librarian same line
    When I login using "librarian1@library" and "rs4BNN9G"
    And dashboard should be displayed
    Then there should be 173 users

  Scenario: Login as librarian in the same line
    When librarian enter below credentials
      | username | librarian1@library |
      | password | rs4BNN9G           |
    Then user should see the the title is "Library"

  Scenario: Login as student in the same line
    When student enter below credentials
      | username         | student1@library |
      | password         | i2A9TgXa         |
    Then user should see the the title is "Library"