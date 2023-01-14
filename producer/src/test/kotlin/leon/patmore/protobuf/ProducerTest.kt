package leon.patmore.protobuf

import io.kotest.matchers.shouldBe
import leon.patmore.protobuf.model.QueueModel.QueueMessage
import org.junit.jupiter.api.Test
import java.util.*

internal class ProducerTest {

    @Test
    internal fun name() {
        val producer = Producer(Base64.getEncoder())

        val encodedString = producer.produce(QueueMessage.newBuilder().setId("myId").build())

        val message = QueueMessage.parseFrom(Base64.getDecoder().decode(encodedString))

        message.id shouldBe "myId"
    }

}
