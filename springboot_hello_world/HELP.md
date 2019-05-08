# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

个人见解：
    springboot使用了“约定由于配置”的思想，将配置项都默认为了国际惯例配置，即传统的spring开发，
即使不会用到很多配置，也要去写。springboot将所有的配置都默认，如果需要修改某个配置，再去修改即可，
也就是从之前的用户加法操作变成了用户减法操作，有效的减少了客户端程序员的工作量，使得我们能花更多的时间
和精力更加的专注于业务。


**有个疑问？？？？ springboot约定由于配置，那配置到哪了？？怎么没有看到国际惯例配置都是啥呢？怎么修改呢？
springboot使用抽象思维，及既然是国际配置，那就是配置习惯就是大家默认的，都一样的，直接抽象出来配置一个，
其他的再去继承就可以得到相同的配置了。 这就是pom中看到的parent节点，这个指明了当前项目的父项目。也就是
国际惯例配置都在父项目里面配置了。

修改的时候，springboot提供了修改方式，例如可以在application.yml文件中修改，具体可以查看官方配置文档。
