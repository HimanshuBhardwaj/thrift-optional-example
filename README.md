thrift-optional-example
=======================

A usage example of the Option type flag. The example is not runnable, but
shows what the java syntax looks like.

The classes User and UserService are generated with this command:
> thrift --gen java:beans,option_type -out . UserService.thrift

Because the "option_type" flag is set, the getBorn() method returns
an Option type. This means that an "isset/null/exists"-check is enforced
by the compiler (so the programmer doesn't have to remember).

The implementation of the Option type can be found here:
https://github.com/eirslett/thrift/blob/add-optional-types/lib/java/src/org/apache/thrift/Option.java