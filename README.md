# java-spring-web-server-mysql


dockerホスト側のブラウザからアクセス

- http://172.17.0.2:8080/index

dockerコンテナ側のブラウザからアクセス

- http://localhost:8080/index

ポータブル

```
$ cp /home/aine/nnn/payroll/target/payroll-0.0.1-SNAPSHOT.jar $HOME/


$ cd $HOME

$ java -jar payroll-0.0.1-SNAPSHOT.jar 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.3.RELEASE)

2020-08-22 08:48:38.191  INFO 5739 --- [           main] payroll.PayrollApplication               : Starting PayrollApplication v0.0.1-SNAPSHOT on doc-ubuntu-20-04-vim with PID 5739 (/home/aine/payroll-0.0.1-SNAPSHOT.jar started by aine in /home/aine)
2020-08-22 08:48:38.193  INFO 5739 --- [           main] payroll.PayrollApplication               : No active profile set, falling back to default profiles: default
2020-08-22 08:48:38.844  INFO 5739 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-08-22 08:48:38.853  INFO 5739 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-08-22 08:48:38.853  INFO 5739 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.37]
2020-08-22 08:48:38.904  INFO 5739 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-08-22 08:48:38.904  INFO 5739 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 668 ms
2020-08-22 08:48:39.021  INFO 5739 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-08-22 08:48:39.070  INFO 5739 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2020-08-22 08:48:39.143  INFO 5739 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-08-22 08:48:39.154  INFO 5739 --- [           main] payroll.PayrollApplication               : Started PayrollApplication in 1.247 seconds (JVM running for 1.547)
2020-08-22 08:48:48.992  INFO 5739 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2020-08-22 08:48:48.992  INFO 5739 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2020-08-22 08:48:48.996  INFO 5739 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 4 ms


^C2020-08-22 08:48:53.296  INFO 5739 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
```
