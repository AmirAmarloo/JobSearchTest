# JobSearchTest
I would like to describe about the application. It's contain tow groups of API
1. Application Controller
2.Job Controller

1-1 GET/ getById 
1-2 POST/add addApplication
1-3 GET/all getAllApplication
1-4 GET/delete deleteApplication
1-5 POST/update updateApplication
 
2-1 POST/addjob addJob
2-2 GET/alljob getAllJob
2-3 GET/chechuuid checkUuidValidation
2-4 GET/deletejob deleteJob
2-5 GET/jobbyid getById
2-6 GET/searchjob searchJob
2-7 GET/searchlocation searchLocation
2-8 POST/updatejob updateApplication


I used swagger . whenever user add an application system generate an UUID as a API key and store in the application table.
whenever user wants to use search the job (2-6) user have to provide UUID by check UUID (2-3). If the entered UUID valid in the database, the search job can worked otherwise system generate an exception and search location (2-7) worke as well this way.
