package leon.patmore.protobuf

import leon.patmore.protobuf.model.QueueModel

fun interface Producer {

    fun produce(message: QueueModel.QueueMessage)

}
