package leon.patmore.protobuf

import com.google.protobuf.kotlin.unpack
import leon.patmore.protobuf.model.QueueModel.ExampleDomain
import leon.patmore.protobuf.model.QueueModel.QueueMessageExtended
import org.springframework.stereotype.Component
import java.util.*

@Component
class ExampleConsumer : Consumer {

    override fun process(message: String) {
        val queueMessage = QueueMessageExtended.parseFrom(Base64.getDecoder().decode(message))
        println(queueMessage.newField)
        val exampleDomain = queueMessage.content.unpack<ExampleDomain>()
        println(exampleDomain.status)
    }

}
