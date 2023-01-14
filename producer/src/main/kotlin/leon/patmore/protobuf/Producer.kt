package leon.patmore.protobuf

import leon.patmore.protobuf.model.QueueModel
import java.util.Base64


class Producer(private val encoder: Base64.Encoder) {

    fun produce(message: QueueModel.QueueMessage) : String {
        return encoder.encodeToString(message.toByteArray())
    }

}
