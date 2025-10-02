Feature: Login

  Scenario Outline: Login Data Driven
  Given User Launch Chrome browser
  When User opens URL "https://admin-demo.nopcommerce.com/login"
  And User enters email as "<email>" and Password as "<password>"
  And Click on Login
  Then Page Title should be "Dashboard / nopCommerce administration"
  When User click on Log out link
  Then Close browser

Examples:
  | email                | password  |
  | admin@yourstore.com | admin     |
  | admin1@yourstore.com| admin123  |
  