# employeeservice
employee service using spring boot and cassandra

### API Documentation 
http://localhost:8080/swagger-ui.html


### InSights 
- API models should be different than DAO and Business Models. Business model and DAO can be same as it is not exposed to external users.
- Need API versioning strategy from start.
- Need to calculate API load using requests per seconds per api.
- Need exception mapping to error codes and messages to external user so that they can take meaningful action.
- Need validation on fields so that external user do not exploit system with garbage data.
- Need have global threadpool per application so that there are no large number of threadpools proliferated in code
- while checking in code auto-checks for formatting and potential errors. It should reject commits in that case.
- API documentation is must so that users can understand and use them.
- Public APIs can be rest while internal APIs should be RPC or gRPC.
- There is need of autheication between internal services.
- Public APIS should be auhenticated using OAuth.
- Request Id is needed for request tracing 
- Need visibility in all apis (internal and external) for following metrics
    - Fault rate (4XX) per [window 1 sec to 1 day] with sum/avg/max/min
    - Error Rate (5XX) per [window 1 sec to 1 day]
    - Latency (P90, P99, P99.99) to check slowest requests in system per [window 1 sec to 1 day] with sum/avg/max/min
    - Syetem level metrics per node for memory/cpu/network usage
 - Need health check API 
 - Need user level throttling to avoid attack on system 
 - Need log aggregation system like ELK stack to search request based on user id or requestId, it should also generate request chain of all services from source to destination. Search fields should have minimum 
   - UserId
   - RequestId
   - Exception Type
   - Error code 
   - Exception message
   
- Need strategy to mock external apis are integration testing 
- Environments for dev/beta/pre-prod should be  simillar may differ in capacity though.
- Need for feature management - like experiment new feature with selected user pools  and make GA and feature retirement.
- Micro-service should not be just wrapper over data store it should have some logic. Always need to make balance between number of fine grained micro-services and functionality. If not there could be very large number of micro-services.

   
    
