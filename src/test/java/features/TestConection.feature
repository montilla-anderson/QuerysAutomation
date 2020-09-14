@DBTesting
Feature: Postgres DB Testing
  Scenario: Test Connection on DB
    Given Connect to postgres DB Server
  @Ignore
  Scenario: Run Query to Add New Users
    Given Runnig Query Add new Users, user="neo2", password="password", firstname= "test", lastname = "test", email= "test@equifax.com", systemcode = "systemtronik", clientcode = "megatronik", role = "login"
  @Ignore
  Scenario: Run Query to reset password
    Given Run Query Reset Password
  @Ignore
  Scenario: Add rol on Users
    Given adding rol on Users user = "neo2", clientcode="megatronik",systemcode = "systemtronik", rol="Analyst"
  @Ignore
  Scenario: Remove Rol on Users
    Given Remove rol on Users user = "neo2", clientcode="megatronik",systemcode = "systemtronik", rol="Analyst"
  @Ignore
  Scenario: Add Group Rol on Users
    Given Adding Group Rol on User IdGroup="2163499",clientcode="megatronik",systemcode = "systemtronik", user = "neo2"
  @Ignore
  Scenario: Remove Group Rols on Users
    Given Remove Group Rol on User IdGroup="2163499",clientcode="megatronik",systemcode = "systemtronik", user = "neo2"
