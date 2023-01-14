package leon.patmore.protobuf

import leon.patmore.protobuf.model.QueueModel
import java.util.Base64


class Producer(private val encoder: Base64.Encoder) {

    fun produce(message: QueueModel.QueueMessage) {
        val a = QueueModel.QueueMessage.newBuilder().setId("abc").build()
        println(encoder.encode(a.toByteArray()))
    }

}
