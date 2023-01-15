package leon.patmore.protobuf

import com.google.protobuf.kotlin.unpack
import leon.patmore.protobuf.model.QueueModel.ExampleDomain
import leon.patmore.protobuf.model.QueueModel.QueueMessage
import org.springframework.stereotype.Component
import java.util.Base64

@Component
class ExampleConsumer : Consumer {

    override fun process(message: String) {
        val queueMessage = QueueMessage.parseFrom(Base64.getDecoder().decode(message))
        val exampleDomain = queueMessage.content.unpack<ExampleDomain>()
        println(exampleDomain.status)
    }

}
