package leon.patmore.protobuf.simple

import leon.patmore.protobuf.Consumer
import leon.patmore.protobuf.Producer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.Base64

@Configuration
class SimpleConfiguration {

    @Bean
    fun simpleProducer(consumer: Consumer) : Producer = SimpleProducer(Base64.getEncoder(), consumer)

}
