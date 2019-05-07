1、下载后台管理jar
   访问：https://github.com/alibaba/Sentinel/releases 下载 sentinel-dashboard-1.6.0.jar
2、启动后台管理
   java -Dserver.port=8082 -jar sentinel-dashboard-1.6.0.jar
3、访问  localhost:8082
   默认登录用户:sentinel
          pwd:sentinel

4、客户端项目添加pom依赖
   <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
      <version>0.2.0.RELEASE</version>
   </dependency>
6、properties添加配置
  server.port=8081
  spring.application.name=sentine
  # sentinel-dashboard-1.6.0 的访问路径 ，启动方式java -jar sentinel-dashboard-1.6.0.jar
  spring.cloud.sentinel.transport.dashboard=localhost:8080
  #取消Sentinel控制台懒加载
  spring.cloud.sentinel.eager=true
7、添加controller测试限流
    /**
     * @Auther: willow
     * @Date: 2019/5/7 17:42
     * @Description:
     */
    @Controller
    public class SentinelController {
        @RequestMapping("/sentinel")
        @ResponseBody
        public String sentinel(){
            return "sentinel ....";
        }
    }

7、访问项目路径 http://localhost:8081/sentinel
8、localhost:8082
   点击  簇点链路 ->选择(/sentinel)->流控->输入单机阈值（QPS）
