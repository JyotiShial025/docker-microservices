limits-service : 8080
spring-cloud-config-server : 8888
currency-exchange-service : 8001,8002
currency-conversion-service : 8100,8200
eureka-naming-server : 8761
api-gateway : 8765
zipkin server(Distributed tracing) :9411



URI
http://localhost:8888/limits-service/default
http://localhost:8080/limits

currency-exchange-service
http://localhost:8000/currency-exchange/from/USD/to/INR

currency-conversion-service
http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000
http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/1000

api-gateway
- http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion-service/currency-converter/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10

with custom route
- http://localhost:8765/currency-converter-feign/from/USD/to/INR/quantity/10
http://localhost:8765/currency-converter-new/from/USD/to/INR/quantity/10