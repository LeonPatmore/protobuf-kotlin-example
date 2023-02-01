# Protobuf Kotlin Example

The main purpose of this project is to demonstrate the following:

When a Protobuf object is serialized, and deserialized to a sub-object,
and the sub-object is serialized, and this is deserialized back to the
full object, then the final full object is equal to the original Protobuf object,
even if the sub-object does not contain some fields of the full object.

To run tests: `./gradlew test`
