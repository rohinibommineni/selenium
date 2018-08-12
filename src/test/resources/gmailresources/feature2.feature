Feature: Gmail login
Scenario Outline: validate password
Given launch gmail site
When enter userid with "rohini9949" value
And click next button
And enter password with "<p>" criteria
And click password next button
Then validate password with "<pc>" criteria
And close site
Examples:
|       p         |        pc       |
|    bommineni    |     valid       |
|     bommineni1  |    invalid      |
|                 |     blank       |
