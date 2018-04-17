hadesPro-discovery 是服务注册中心，主要注册平台服务
hadesPro-config 是配置中心，主要存储应用层服务的配置文件
hadesPro-gateway 是网关和路由，主要过滤和转发请求
hadesPro-hystrix 是hystrix服务，主要监控需要监控的服务
hadesPro-turbine 与hystrix一起配合，用于集群的监控
hadesPro-zipkin  主要用于链路跟踪
hades-service-app 业务app服务
hades-service-base 业务base服务,里边主要配了rabbitmq的接收
hades-service-platform 等同于业务app，也是应用服务

注意：服务启动顺序就是上边所列顺序