# bd
BD is easy to use extension for java BigDecimal. The same as BigDecimal it is immutable.

## Install
```
git clone https://github.com/awronski/bd.git
cd bd
mvn install
```

# What is the diffrence between BD and BigDecimal?

1. It adds methods for operating on primitive types
```java
    new BigDecimal(2).multiply(new BigDecimal(3.0)).subtract(new BigDecimal(4f));
    new BD(2).multiply(3.0).subtract(4f);
```

2. It operates only on Strings
```java
    new BigDecimal(0.1).multiply(new BigDecimal(1)))  //0.1000000000000000055511151231..
    new BD(0.1).multiply(1));                         //0.1
```

3. It propegates MathContext
```java
    MathContext mc = new MathContext(34, RoundingMode.HALF_UP);
    new BigDecimal("3.112", mc).divide(new BigDecimal("2")).setScale(2) //ArithmeticException
    new BD("3.112", mc).divide("2").setScale(2)                         //1.56
```

You can even omit the MathContext and the BD will use default one for you (34, HALF_UP)
```java
    new BD("3.112").divide("2").setScale(2)
```

# Other methods
```java
    new BD(1.999).ceil(2);                      //2.00
    new BD(1.999).floor(2);                     //1.99
    new BD(1.455).doubleValue(2);               //1.46
    new BD(-1.455).setScale(2).floatValue();    //-1.46
    new BD(122).net(22).doubleValue(2);        //100.0
    new BD(100).gross(22).doubleValue(2);      //122.0
    new BD(122).tax(22).doubleValue(2);        //22.0
```

License
=======

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.