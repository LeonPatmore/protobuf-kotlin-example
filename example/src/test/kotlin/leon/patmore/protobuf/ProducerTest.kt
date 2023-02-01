package leon.patmore.protobuf

import com.google.protobuf.Any
import io.kotest.matchers.shouldBe
import leon.patmore.protobuf.model.QueueModel
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
    internal fun `test producer`() {
        producer.produce(QueueMessage.newBuilder()
                .setId("myId")
                .setTtlMs(10000)
                .setContent(Any.pack(ExampleDomain.newBuilder().setStatus("hello").build()))
                .build())
    }

    @Test
    internal fun `test when a full object is parsed to a sub-object and then serialized, it keeps information about the full object`() {
        val fullObject = QueueModel.QueueMessageExtended.newBuilder()
                .setId("id")
                .setNewField("some-value")
                .build()

        val fullArray = fullObject.toByteArray()

        val subObject = QueueMessage.parseFrom(fullArray)
        subObject.id shouldBe "id"

        val subObjectBytes = subObject.toByteArray()
        val fullObject2 = QueueModel.QueueMessageExtended.parseFrom(subObjectBytes)
        fullObject2.id shouldBe "id"
        fullObject2.newField shouldBe "some-value"

        fullObject2 shouldBe fullObject
    }

}
