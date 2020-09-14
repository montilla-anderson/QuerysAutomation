$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/TestConection.feature");
formatter.feature({
  "name": "Postgres DB Testing",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DBTesting"
    }
  ]
});
formatter.scenario({
  "name": "Test Connection on DB",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DBTesting"
    }
  ]
});
formatter.step({
  "name": "Connect to postgres DB Server",
  "keyword": "Given "
});
formatter.match({
  "location": "DBConnectionAndQueryDB.connect_to_postgres_DB_Server()"
});
formatter.result({
  "status": "passed"
});
});