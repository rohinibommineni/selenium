Feature: Gmail login
Scenario: validate title
Given launch gmail site
Then title is "Gmail" value
And close site

Scenario Outline:validate userid
Given launch gmail site
When enter userid with "<x>" value
And click next button
Then validate Userid field with "<y>" criteria
And close site
Examples:
|   x               |      y        |
|  rohini9949       |    valid      |
|   rohini99491     |   invalid     |
|                   |    blank      |

