package leon.patmore.protobuf.simple

import leon.patmore.protobuf.Consumer
import leon.patmore.protobuf.Producer
import leon.patmore.protobuf.model.QueueModel
import java.util.*

class SimpleProducer(private val encoder: Base64.Encoder,
                     private val consumer: Consumer) : Producer {

    override fun produce(message: QueueModel.QueueMessage) {
        return consumer.process(encoder.encodeToString(message.toByteArray()))
    }

}
