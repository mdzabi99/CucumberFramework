Feature: Login

Scenario: Successful Login with Valid Credentials
  Given User launch Chrome browser
  When User opens URL "https://admin-demo.nopcommerce.com/login"
  And User enters email as "admin@yourstore.com" and password as "admin"
  And Click on Login
  Then Page Title should be "Dashboard / nopCommerce administration"
  When User click on Log out link
  Then Close browser
 