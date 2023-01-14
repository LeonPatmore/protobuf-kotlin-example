package protobuf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProtobufApplication

fun main(args: Array<String>) {
	runApplication<ProtobufApplication>(*args)
}
