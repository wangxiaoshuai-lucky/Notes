## spring框架的理解
* IOC和DI的原理和源码分析
* AOP的实现原理
* Autowired的注入过程

## springMvc的实现原理
* 接口地址和方法的映射过程
* @ResponseBody的处理
* @RequestMapping的处理
* spring管理的bean的模式，默认原型
* spring如何管理bean、bean的生命周期
[spring框架的学习](https://github.com/1510460325/springframework/blob/master/README.md)
## Mybatis
* sql语句和方法的映射原理
* \#｛｝ 和 \$｛｝的区别
### 拦截器、过滤器
过滤器使用场景：过滤字符集  
拦截器使用场景：实现权限验证，日志记录  
Filter需要在web.xml中配置，依赖于Servlet；  
Interceptor需要在SpringMVC中配置，依赖于框架，基于java反射的AOP思想；  
所以Filter比Interceptor先执行  