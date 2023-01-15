package leon.patmore.protobuf

import com.google.protobuf.Any
import leon.patmore.protobuf.model.QueueModel.ExampleDomain
import leon.patmore.protobuf.model.QueueModel.QueueMessage
import leon.patmore.protobuf.simple.SimpleConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [ProtobufApplication::class, SimpleConfiguration::class])
internal class ProducerTest {

    @Autowired
    private lateinit var producer: Producer

    @Test
    internal fun name() {
        producer.produce(QueueMessage.newBuilder()
                .setId("myId")
                .setTtlMs(10000)
                .setContent(Any.pack(ExampleDomain.newBuilder().setStatus("hello").build()))
                .build())
    }

}
