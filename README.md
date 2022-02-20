Sample Automation Tests
====================

Libraries used:
1. Cucumber
2. Serenity
3. Rest Assured 

mvn commands to run the test
#### Leaderboard API tests  - 
    mvn  post-integration-test -Dcucumber.filter.tags=@Leaderboard 

#### User API tests  -
    mvn  post-integration-test -Dcucumber.filter.tags=@RegisterUser

#### UI Tests- 
    mvn post-integration-test -Dcucumber.filter.tags=@CreateUser 
    
#### All Tests- 
    mvn post-integration-test -Dcucumber.filter.tags=@AllTests 

After execution serenity test report will be available to view in 
\target\site\serenity\index.html
