thrift-optional-example
=======================

A usage example of the Option type flag. The example is not runnable, but
shows what the java syntax looks like.

The classes User and UserService are generated with this command:
> thrift --gen java:beans,option_type -out . UserService.thrift

Because the "option_type" flag is set, the getBorn() method returns
an Option type. This means that an "isset/null/exists"-check is enforced
by the compiler (so the programmer doesn't have to remember).