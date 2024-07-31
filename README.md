# gft-test

## test URL (GET Method)

http://localhost:8080/price?date=2020-06-14T17:32:28Z&productId=35455&brandId=1 should return id 2

http://localhost:8080/price?date=2020-06-14T09:32:28Z&productId=35455&brandId=1 should return id 1

http://localhost:8080/price?date=2020-06-15T02:32:28Z&productId=35455&brandId=1 should return id 3

http://localhost:8080/price?date=2020-06-15T12:32:28Z&productId=35455&brandId=1 should return id 1

http://localhost:8080/price?date=2020-06-15T19:32:28Z&productId=35455&brandId=1 should return id 4