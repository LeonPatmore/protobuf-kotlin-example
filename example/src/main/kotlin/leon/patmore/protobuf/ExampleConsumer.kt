package leon.patmore.protobuf

import leon.patmore.protobuf.model.QueueModel.QueueMessage
import org.springframework.stereotype.Component
import java.util.Base64

@Component
class ExampleConsumer : Consumer {

    override fun process(message: String) {
        val queueMessage = QueueMessage.parseFrom(Base64.getDecoder().decode(message))
        println(queueMessage.content.toStringUtf8())
    }

}
