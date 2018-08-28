# spring-cloud-demo
   * spring-config-server 版本库(svn、git)云端配置服务，提供对外的项目配置接口,后期会添加消息总线支持(spring-config-bus)
   * spring-eureka-server 注册中心（consul会更好一些，但配置相对会复杂一些，需要启动conusl服务）
   * spring-cloud-zuul 网关转发、ZuulFilter拦截处理等
   * saas-server-provider 应用服务提供者
   * saas-lib-comsumer 服务消费者,添加Hystrix断路器,实现服务降级